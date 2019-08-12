package br.com.ntconsult.votacao.services.impl;

import br.com.ntconsult.votacao.entities.Sessao;
import br.com.ntconsult.votacao.entities.Votacao;
import br.com.ntconsult.votacao.repositories.VotacaoRepository;
import br.com.ntconsult.votacao.services.VotacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VotacaoServiceImpl implements VotacaoService {

    private VotacaoRepository votacaoRepository;

    @Autowired
    public VotacaoServiceImpl(VotacaoRepository votacaoRepository) {
        this.votacaoRepository = votacaoRepository;
    }

    @Override
    public Votacao registrarVoto(Votacao votacao) {
        return votacaoRepository.save(votacao);
    }

    @Override
    public Optional<Votacao> obterVotacao(Long idVotacao) {
        return votacaoRepository.findById(idVotacao);
    }

    @Override
    public Optional<Votacao> verificarCooperadoVotou(Sessao sessao, String cpf) {
        return Optional.ofNullable(votacaoRepository.findBySessaoAndCpf(sessao, cpf));
    }

    @Override
    public Optional<Votacao> verificarExisteSessao(Sessao sessao) {
        return Optional.ofNullable(votacaoRepository.findBySessao(sessao));
    }

    @Override
    public List<Votacao> obterTodosVotos(Long idSessao) {
        return votacaoRepository.findBySessaoId(idSessao);
    }
}
