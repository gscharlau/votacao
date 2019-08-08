package br.com.ntconsult.votacao.services;

import br.com.ntconsult.votacao.entities.Sessao;
import br.com.ntconsult.votacao.repositories.SessaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SessaoService {

    private SessaoRepository sessaoRepository;

    @Autowired
    public SessaoService(SessaoRepository sessaoRepository) {
        this.sessaoRepository = sessaoRepository;
    }

    public Sessao criarSessao(Sessao sessao){
        return sessaoRepository.save(sessao);
    }

    public void fecharSessao(Sessao sessao){

    }
}
