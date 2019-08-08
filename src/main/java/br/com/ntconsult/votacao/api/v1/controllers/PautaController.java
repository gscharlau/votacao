package br.com.ntconsult.votacao.api.v1.controllers;

import br.com.ntconsult.votacao.api.v1.V1;
import br.com.ntconsult.votacao.services.PautaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PautaController implements V1 {

    PautaService pautaService;
    private static final Logger log = LoggerFactory.getLogger(PautaController.class);

    @Autowired
    public PautaController(PautaService pautaService) {
        this.pautaService = pautaService;
    }

    //public ResponseEntity<?> incluirPauta();


}
