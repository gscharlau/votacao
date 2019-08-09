package br.com.ntconsult.votacao.api.v1.controllers;

import br.com.ntconsult.votacao.api.v1.V1;
import br.com.ntconsult.votacao.services.impl.VotacaoServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VotacaoController implements V1 {

    private VotacaoServiceImpl votacaoServiceImpl;
    private static final Logger log = LoggerFactory.getLogger(VotacaoController.class);

}
