package br.com.ntconsult.votacao.services.impl;

import br.com.ntconsult.votacao.entities.Sessao;
import br.com.ntconsult.votacao.entities.Votacao;
import br.com.ntconsult.votacao.repositories.VotacaoRepository;
import br.com.ntconsult.votacao.services.VotacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VotacaoServiceImpl implements VotacaoService {

    private VotacaoRepository votacaoRepository;

    @Autowired
    public VotacaoServiceImpl(VotacaoRepository votacaoRepository) {
        this.votacaoRepository = votacaoRepository;
    }

    @Override
    public Votacao registrarVoto(Votacao votacao){
        return votacaoRepository.save(votacao);
    }

    @Override
    public List<Votacao> obterVotacao(Sessao sessao){
        return votacaoRepository.findBySessao(sessao);
    }
}
