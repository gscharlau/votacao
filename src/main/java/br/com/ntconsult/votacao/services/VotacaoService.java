package br.com.ntconsult.votacao.services;

import br.com.ntconsult.votacao.entities.Sessao;
import br.com.ntconsult.votacao.entities.Votacao;

import java.util.List;

public interface VotacaoService {
    Votacao registrarVoto(Votacao votacao);
    List<Votacao> obterVotacao(Sessao sessao);
}
