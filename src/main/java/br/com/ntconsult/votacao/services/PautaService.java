package br.com.ntconsult.votacao.services;

import br.com.ntconsult.votacao.entities.Pauta;

import java.util.List;
import java.util.Optional;

public interface PautaService {

    Pauta salvarPauta(Pauta pauta);
    List<Pauta> obterTodasPautas();
    Optional<Pauta> obterPautaPorId(Long id);
}
