package br.com.ntconsult.votacao.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "sessao")
public class Sessao implements Serializable {

    private Long id;
    private Pauta pauta;
    private Integer duracao;
    private LocalDateTime abertura;

    public Sessao() {
    }

    public Sessao(Pauta pauta, Integer duracao) {
        this.pauta = pauta;
        this.duracao = duracao;
        this.abertura = LocalDateTime.now();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_pauta")
    public Pauta getPauta() {
        return pauta;
    }

    public void setPauta(Pauta pauta) {
        this.pauta = pauta;
    }

    @Column(name = "duracao")
    public Integer getDuracao() {
        return duracao;
    }

    public void setDuracao(Integer duracao) {
        this.duracao = duracao;
    }

    @Column(name = "abertura")
    public LocalDateTime getAbertura() {
        return abertura;
    }

    public void setAbertura(LocalDateTime abertura) {
        this.abertura = abertura;
    }

    public static final class SessaoBuilder {
        private Long id;
        private Pauta pauta;
        private Integer duracao;
        private LocalDateTime abertura;

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

        public SessaoBuilder withDuracao(Integer duracao) {
            this.duracao = duracao;
            return this;
        }

        public SessaoBuilder withAbertura(LocalDateTime abertura) {
            this.abertura = abertura;
            return this;
        }

        public Sessao build() {
            Sessao sessao = new Sessao();
            sessao.setId(id);
            sessao.setPauta(pauta);
            sessao.setDuracao(duracao);
            sessao.setAbertura(abertura);
            return sessao;
        }
    }
}
