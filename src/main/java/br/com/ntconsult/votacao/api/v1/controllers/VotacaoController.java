package br.com.ntconsult.votacao.api.v1.controllers;

import br.com.ntconsult.votacao.api.v1.V1;
import br.com.ntconsult.votacao.api.v1.dtos.ContagemVotosDto;
import br.com.ntconsult.votacao.api.v1.dtos.VotacaoRequestDto;
import br.com.ntconsult.votacao.api.v1.dtos.VotacaoResponseDto;
import br.com.ntconsult.votacao.client.cooperado.CooperadoClient;
import br.com.ntconsult.votacao.dtos.Response;
import br.com.ntconsult.votacao.entities.Pauta;
import br.com.ntconsult.votacao.entities.Sessao;
import br.com.ntconsult.votacao.entities.Votacao;
import br.com.ntconsult.votacao.enums.StatusCooperadoEnum;
import br.com.ntconsult.votacao.services.SessaoService;
import br.com.ntconsult.votacao.services.VotacaoService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.websocket.server.PathParam;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

@RestController(value = "/votacao")
@CrossOrigin(origins = "*")
public class VotacaoController implements V1 {

    private VotacaoService votacaoService;
    private CooperadoClient cooperadoClient;
    private SessaoService sessaoService;
    private static final Logger log = LoggerFactory.getLogger(VotacaoController.class);

    @Autowired
    public VotacaoController(VotacaoService votacaoService, SessaoService sessaoService, @Qualifier("restClient") CooperadoClient cooperadoClient) {
        this.votacaoService = votacaoService;
        this.cooperadoClient = cooperadoClient;
        this.sessaoService = sessaoService;
    }

    @PostMapping(value = "/votar")
    @ApiOperation(value = "Endpoint para registrar um voto", notes = "Realiza um voto.")
    @ApiResponses(value = {
            @ApiResponse(code = 401, message = "Problemas nas validações", response = VotacaoResponseDto.class),
            @ApiResponse(code = 201, message = "Sem pautas cadastradas", response = Pauta.class),
            @ApiResponse(code = 500, message = "Falha ao listar pauta", response = VotacaoResponseDto.class)
    })
    public ResponseEntity<?> registrarVoto(@Valid @RequestBody VotacaoRequestDto request) {
        Response<VotacaoResponseDto> votacaoResponseDto = new Response<>();
        try {
            StatusCooperadoEnum statusCooperadoEnum = cooperadoClient.validarCpf(request.getCpfCooperado());
            Optional<Sessao> sessao = sessaoService.obterSessao(request.getIdSessaoVotacao());

            if (validate(request, votacaoResponseDto, statusCooperadoEnum, sessao, votacaoService))
                return ResponseEntity.status(HttpStatus.METHOD_NOT_ALLOWED).body(votacaoResponseDto);

            Votacao voto = Votacao.VotacaoBuilder.aVotacao()
                    .withSessao(sessao.get())
                    .withCpf(request.getCpfCooperado())
                    .withVoto(request.getVoto())
                    .build();

            return ResponseEntity.status(HttpStatus.CREATED).body(votacaoService.registrarVoto(voto));

        } catch (Exception e) {
            votacaoResponseDto.getErrors().add("Falha ao registrar voto");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(votacaoResponseDto);
        }

    }

    @GetMapping(value = "/resultado/{idVotacao}")
    @ApiOperation(value = "Endpoint para contabilizar os votos", notes = "Lista o resultado.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Exibe resultado da votação", response = ContagemVotosDto.class),
            @ApiResponse(code = 500, message = "Falha ao contabilizar a votação", response = ContagemVotosDto.class)
    })
    public ResponseEntity<?> contabilizarVotos(
            @NotNull(message = "ID Votação Obrigatório") @PathVariable("idVotacao") Long idVotacao) {

        try {

            List<Votacao> resultado = votacaoService.obterTodosVotos(idVotacao);

            Long votoSim = resultado.stream()
                    .filter(votacao -> votacao.getVoto().equals(Boolean.TRUE))
                    .count();

            Long votoNao = resultado.stream()
                    .filter(votacao -> votacao.getVoto().equals(Boolean.FALSE))
                    .count();

            ContagemVotosDto contagemVotosDto = ContagemVotosDto.ContagemVotosDtoBuilder.aContagemVotosDto()
                    .withVotosSim(votoSim)
                    .withVotosNao(votoNao)
                    .withTotalVotos(votoSim + votoNao)
                    .build();

            return ResponseEntity.status(HttpStatus.OK).body(contagemVotosDto);

        } catch (Exception e) {
            Response<ContagemVotosDto> response = new Response<>();
            response.getErrors().add("Não foi possível obter o resultado");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }


    }

    private boolean validate(VotacaoRequestDto request, Response<VotacaoResponseDto> votacaoResponseDto,
                             StatusCooperadoEnum statusCooperadoEnum,
                             Optional<Sessao> sessao,
                             VotacaoService votacaoService) {
        if (StatusCooperadoEnum.DESABILITADO_PARA_VOTAR.equals(statusCooperadoEnum)) {
            votacaoResponseDto.getErrors().add("Cooperado não habilitado para votar");
            return true;
        }

        if (!sessao.isPresent()) {
            votacaoResponseDto.getErrors().add("Sessão não existe. Inicie uma sessão para abrir a votação");
            return true;
        }

        if (sessao.get().getDataExpiracao().isBefore(LocalDateTime.now())) {
            votacaoResponseDto.getErrors().add("Prazo para votar já encerrado");
            return true;
        }

        Optional<Votacao> votacao = votacaoService.verificarCooperadoVotou(sessao.get(), request.getCpfCooperado());

        if (votacao.isPresent()) {
            votacaoResponseDto.getErrors().add("Cooperado já votou nesta sessão");
            return true;
        }
        return false;
    }


}
