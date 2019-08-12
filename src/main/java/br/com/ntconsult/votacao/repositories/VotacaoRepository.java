package br.com.ntconsult.votacao.repositories;

import br.com.ntconsult.votacao.entities.Sessao;
import br.com.ntconsult.votacao.entities.Votacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import java.util.List;

@NamedQueries({
        @NamedQuery(name = "VotacaoRepository.findBySessaoId", query = "SELECT vot FROM VOTACAO vot WHERE vot.sessao.id = :idSessao")
})
public interface VotacaoRepository extends JpaRepository<Votacao, Long> {

    Votacao findBySessao(Sessao sessao);
    Votacao findBySessaoAndCpf(Sessao sessao, String cpf);
    List<Votacao> findBySessaoId(@Param("idSessao") Long idSessao);
}
