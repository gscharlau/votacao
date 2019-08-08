package br.com.ntconsult.votacao.services;

import br.com.ntconsult.votacao.entities.Pauta;
import br.com.ntconsult.votacao.repositories.PautaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PautaService {

    private PautaRepository pautaRepository;

    @Autowired
    public PautaService(PautaRepository pautaRepository) {
        this.pautaRepository = pautaRepository;
    }

    public Pauta salvarPauta(Pauta pauta){
        return pautaRepository.save(pauta);
    }
}
