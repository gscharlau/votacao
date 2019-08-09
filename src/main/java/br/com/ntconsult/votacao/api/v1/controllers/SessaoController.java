package br.com.ntconsult.votacao.api.v1.controllers;

import br.com.ntconsult.votacao.api.v1.V1;
import br.com.ntconsult.votacao.api.v1.dtos.SessaoRequestDto;
import br.com.ntconsult.votacao.dtos.Response;
import br.com.ntconsult.votacao.entities.Pauta;
import br.com.ntconsult.votacao.entities.Sessao;
import br.com.ntconsult.votacao.services.PautaService;
import br.com.ntconsult.votacao.services.SessaoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.Optional;

@RestController
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
    public ResponseEntity<?> abrirNovaSessao(@Valid @RequestBody SessaoRequestDto sessaoRequestDto){

        try {
            Optional<Pauta> pauta = pautaService.obterPautaPorId(sessaoRequestDto.getIdPauta());
            if (!pauta.isPresent()) {
                Response<Sessao> response = new Response<>();
                response.getErrors().add("Pauta não existente");
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
            }

            if (!Optional.ofNullable(sessaoRequestDto.getDuracao()).isPresent()) {
                sessaoRequestDto.setDuracao(1);
            }

            Response<Sessao> response = new Response<>();

            response.setData(sessaoService.criarSessao(Sessao.SessaoBuilder.aSessao()
                    .withAbertura(LocalDateTime.now())
                    .withPauta(pauta.get())
                    .withDuracao(sessaoRequestDto.getDuracao())
                    .build()));

            return ResponseEntity.status(HttpStatus.OK).body(response);
        } catch (Exception e){
            Response<?> response = new Response<>();
            response.getErrors().add("Falha ao criar sessão");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }
}
