package br.com.ntconsult.votacao.services;

import br.com.ntconsult.votacao.entities.Sessao;
import br.com.ntconsult.votacao.entities.Votacao;
import br.com.ntconsult.votacao.repositories.VotacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VotacaoService {

    private VotacaoRepository votacaoRepository;

    @Autowired
    public VotacaoService(VotacaoRepository votacaoRepository) {
        this.votacaoRepository = votacaoRepository;
    }

    public Votacao registrarVoto(Votacao votacao){
        return votacaoRepository.save(votacao);
    }

    public List<Votacao> obterVotacao(Sessao sessao){
        return votacaoRepository.findBySessao(sessao);
    }
}
