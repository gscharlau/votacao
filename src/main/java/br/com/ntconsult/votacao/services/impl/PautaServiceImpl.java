package br.com.ntconsult.votacao.services.impl;

import br.com.ntconsult.votacao.entities.Pauta;
import br.com.ntconsult.votacao.repositories.PautaRepository;
import br.com.ntconsult.votacao.services.PautaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PautaServiceImpl implements PautaService {

    private PautaRepository pautaRepository;

    @Autowired
    public PautaServiceImpl(PautaRepository pautaRepository) {
        this.pautaRepository = pautaRepository;
    }

    @Override
    public Pauta salvarPauta(Pauta pauta){
        return pautaRepository.save(pauta);
    }

    @Override
    public List<Pauta> obterTodasPautas() {
        return pautaRepository.findAll();
    }

    @Override
    public Optional<Pauta> obterPautaPorId(Long id) {
        return (Optional<Pauta>) pautaRepository.findById(id);
    }

}
