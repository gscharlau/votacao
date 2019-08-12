package br.com.ntconsult.votacao.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "sessao")
public class Sessao implements Serializable {

    private Long id;
    private Pauta pauta;
    private LocalDateTime dataExpiracao;

    public Sessao() {
    }

    public Sessao(Long id) {
        this.id = id;
    }

    public Sessao(Long id, Pauta pauta, LocalDateTime dataExpiracao) {
        this.id = id;
        this.pauta = pauta;
        this.dataExpiracao = dataExpiracao;
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
    @JoinColumn(name = "id_pauta")
    public Pauta getPauta() {
        return pauta;
    }

    public void setPauta(Pauta pauta) {
        this.pauta = pauta;
    }

    @Column(name = "data_expiracao")
    public LocalDateTime getDataExpiracao() {
        return dataExpiracao;
    }

    public void setDataExpiracao(LocalDateTime dataExpiracao) {
        this.dataExpiracao = dataExpiracao;
    }

    public static final class SessaoBuilder {
        private Long id;
        private Pauta pauta;
        private LocalDateTime dataExpiracao;

        private SessaoBuilder() {
        }

        public static SessaoBuilder aSessao() {
            return new SessaoBuilder();
        }

        public SessaoBuilder withId(Long id) {
            this.id = id;
            return this;
        }

        public SessaoBuilder withPauta(Pauta pauta) {
            this.pauta = pauta;
            return this;
        }

        public SessaoBuilder withDataExpiracao(LocalDateTime dataExpiracao) {
            this.dataExpiracao = dataExpiracao;
            return this;
        }

        public Sessao build() {
            Sessao sessao = new Sessao();
            sessao.setId(id);
            sessao.setPauta(pauta);
            sessao.setDataExpiracao(dataExpiracao);
            return sessao;
        }
    }
}
