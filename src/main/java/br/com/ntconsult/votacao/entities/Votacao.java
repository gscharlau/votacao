package br.com.ntconsult.votacao.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "votacao")
public class Votacao implements Serializable {

    private Long id;
    private Sessao sessao;
    private String cpf;
    private Boolean voto;

    public Votacao() {
    }

    public Votacao(Sessao sessao, String cpf, Boolean voto) {
        this.sessao = sessao;
        this.cpf = cpf;
        this.voto = voto;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_sessao")
    public Sessao getSessao() {
        return sessao;
    }

    public void setSessao(Sessao sessao) {
        this.sessao = sessao;
    }

    @Column(name = "cpf_cooperado")
    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    @Column(name = "voto")
    public Boolean getVoto() {
        return voto;
    }

    public void setVoto(Boolean voto) {
        this.voto = voto;
    }


    public static final class VotacaoBuilder {
        private Long id;
        private Sessao sessao;
        private String cpf;
        private Boolean voto;

        private VotacaoBuilder() {
        }

        public static VotacaoBuilder aVotacao() {
            return new VotacaoBuilder();
        }

        public VotacaoBuilder withId(Long id) {
            this.id = id;
            return this;
        }

        public VotacaoBuilder withSessao(Sessao sessao) {
            this.sessao = sessao;
            return this;
        }

        public VotacaoBuilder withCpf(String cpf) {
            this.cpf = cpf;
            return this;
        }

        public VotacaoBuilder withVoto(Boolean voto) {
            this.voto = voto;
            return this;
        }

        public Votacao build() {
            Votacao votacao = new Votacao();
            votacao.setId(id);
            votacao.setSessao(sessao);
            votacao.setCpf(cpf);
            votacao.setVoto(voto);
            return votacao;
        }
    }
}
