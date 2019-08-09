package br.com.ntconsult.votacao.services.impl;

import br.com.ntconsult.votacao.entities.Sessao;
import br.com.ntconsult.votacao.repositories.SessaoRepository;
import br.com.ntconsult.votacao.services.SessaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SessaoServiceImpl implements SessaoService {

    private SessaoRepository sessaoRepository;

    @Autowired
    public SessaoServiceImpl(SessaoRepository sessaoRepository) {
        this.sessaoRepository = sessaoRepository;
    }

    @Override
    public Sessao criarSessao(Sessao sessao){
        return sessaoRepository.save(sessao);
    }

    @Override
    public Sessao fecharSessao(Sessao sessao){
        return sessaoRepository.save(sessao);
    }

    @Override
    public Optional<Sessao> obterSessao(Long id) {
        return sessaoRepository.findById(id);
    }
}
