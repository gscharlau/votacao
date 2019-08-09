package br.com.ntconsult.votacao.services;

import br.com.ntconsult.votacao.entities.Sessao;

import java.util.Optional;

public interface SessaoService {

    Sessao criarSessao(Sessao sessao);
    Sessao fecharSessao(Sessao sessao);
    Optional<Sessao> obterSessao(Long id);

}
