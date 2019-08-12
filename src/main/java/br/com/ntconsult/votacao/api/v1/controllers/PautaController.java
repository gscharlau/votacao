package br.com.ntconsult.votacao.api.v1.controllers;

import br.com.ntconsult.votacao.api.v1.V1;
import br.com.ntconsult.votacao.api.v1.dtos.PautaRequestDto;
import br.com.ntconsult.votacao.dtos.Response;
import br.com.ntconsult.votacao.entities.Pauta;
import br.com.ntconsult.votacao.services.PautaService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*")
public class PautaController implements V1 {

    private PautaService pautaService;
    private static final Logger log = LoggerFactory.getLogger(PautaController.class);

    @Autowired
    public PautaController(PautaService pautaService) {
        this.pautaService = pautaService;
    }

    @PostMapping(value = "/pauta")
    @ApiOperation(value = "Endpoint para inclusão de pautas", notes = "Faz a inclusão de uma pauta.")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Inclusão da pauta realizada com sucesso", response = Pauta.class),
            @ApiResponse(code = 500, message = "Falha ao criar pauta")
    })
    public ResponseEntity<?> incluirPauta(@Valid @RequestBody PautaRequestDto pautaRequestDto){
        log.info("Criação de Pauta");

        try {
            Response<Pauta> response = new Response<>();
            response.setData(pautaService.salvarPauta(Pauta.PautaBuilder.aPauta().withTitulo(pautaRequestDto.getTitulo()).build()));

            return ResponseEntity.status(HttpStatus.CREATED).body(response);

        } catch (Exception e){
            Response<?> response = new Response<>();
            response.getErrors().add("Falha ao criar pauta");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);

        }
    }

    @GetMapping(value = "/pautas")
    @ApiOperation(value = "Endpoint para listagem de pautas", notes = "Lista todas as pautas.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Pautas listadas com sucesso", response = Pauta.class),
            @ApiResponse(code = 201, message = "Sem pautas cadastradas", response = Pauta.class),
            @ApiResponse(code = 500, message = "Falha ao listar pauta")
    })
    public ResponseEntity<?> listarPautas(){
        log.info("buscando todas as pautas");

        try{
            List<Pauta> response = pautaService.obterTodasPautas();
            if(response.isEmpty()){
                return ResponseEntity.status(HttpStatus.NO_CONTENT).body(response);
            } else {
                return ResponseEntity.status(HttpStatus.OK).body(response);
            }
        } catch (Exception e){
            Response<?> response = new Response<>();
            response.getErrors().add("Falha ao obter pautas");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }

    }

    @GetMapping(value = "/pauta/{id}")
    @ApiOperation(value = "Endpoint lista pauta específica", notes = "Lista uma pauta.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Pautas listadas com sucesso", response = Pauta.class),
            @ApiResponse(code = 201, message = "Sem pautas cadastradas", response = Pauta.class),
            @ApiResponse(code = 500, message = "Falha ao listar pauta")
    })
    public ResponseEntity<?> listarPauta(@PathVariable Long id){
        log.info("buscando a pauta {}", id);

        try{
            Optional<Pauta> response = pautaService.obterPautaPorId(id);
            if(!response.isPresent()){
                return ResponseEntity.status(HttpStatus.NO_CONTENT).body(response);
            } else {
                return ResponseEntity.status(HttpStatus.OK).body(response);
            }
        } catch (Exception e){
            Response<?> response = new Response<>();
            response.getErrors().add("Falha ao obter pautas");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }

    }


}
