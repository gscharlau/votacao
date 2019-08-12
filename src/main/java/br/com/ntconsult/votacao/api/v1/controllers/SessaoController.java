package br.com.ntconsult.votacao.api.v1.controllers;

import br.com.ntconsult.votacao.api.v1.V1;
import br.com.ntconsult.votacao.api.v1.dtos.SessaoRequestDto;
import br.com.ntconsult.votacao.dtos.Response;
import br.com.ntconsult.votacao.entities.Pauta;
import br.com.ntconsult.votacao.entities.Sessao;
import br.com.ntconsult.votacao.services.PautaService;
import br.com.ntconsult.votacao.services.SessaoService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*")
public class SessaoController implements V1 {

    private SessaoService sessaoService;
    private PautaService pautaService;

    private static final Logger log = LoggerFactory.getLogger(SessaoController.class);

    @Autowired
    public SessaoController(SessaoService sessaoService, PautaService pautaService) {
        this.sessaoService = sessaoService;
        this.pautaService = pautaService;
    }

    @PostMapping(value = "/sessao")
    @ApiOperation(value = "Endpoint abrir nova sessão", notes = "Inclusão de nova sessão.")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Sessão incluída com sucesso", response = Sessao.class),
            @ApiResponse(code = 500, message = "Falha ao incluir sessão")
    })
    public ResponseEntity<?> abrirNovaSessao(@Valid @RequestBody SessaoRequestDto request){

        try {
            Optional<Pauta> pauta = pautaService.obterPautaPorId(request.getIdPauta());

            if (!pauta.isPresent()) {
                Response<Sessao> response = new Response<>();
                response.getErrors().add("Pauta não existente");
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
            }

            if (!Optional.ofNullable(request.getDuracao()).isPresent()) {
                request.setDuracao(1);
            }

            Response<Sessao> response = new Response<>();
            LocalDateTime dateTime = LocalDateTime.now().plusMinutes(request.getDuracao());

            Sessao sessao = Sessao.SessaoBuilder.aSessao()
                    .withPauta(pauta.get())
                    .withDataExpiracao(dateTime)
                    .build();

            response.setData(sessaoService.criarSessao(sessao));
            return ResponseEntity.status(HttpStatus.CREATED).body(response);
        } catch (Exception e){
            Response<?> response = new Response<>();
            response.getErrors().add("Falha ao criar sessão");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }
}
