package br.com.ntconsult.votacao.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "votacao")
public class Votacao implements Serializable {

    private Long id;
    private Sessao sessao;
    private String cpf;
    private String voto;

    public Votacao() {
    }

    public Votacao(Sessao sessao, String cpf, String voto) {
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
    public String getVoto() {
        return voto;
    }

    public void setVoto(String voto) {
        this.voto = voto;
    }
}
