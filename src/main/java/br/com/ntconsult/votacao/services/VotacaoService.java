package br.com.ntconsult.votacao.services;

import br.com.ntconsult.votacao.entities.Sessao;
import br.com.ntconsult.votacao.entities.Votacao;

import java.util.List;
import java.util.Optional;

public interface VotacaoService {
    Votacao registrarVoto(Votacao votacao);
    Optional<Votacao> obterVotacao(Long idVotacao);
    Optional<Votacao> verificarCooperadoVotou(Sessao sessao, String cpf);
    Optional<Votacao> verificarExisteSessao(Sessao sessao);
    List<Votacao> obterTodosVotos(Long idSessao);
}
