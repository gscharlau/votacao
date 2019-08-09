package br.com.ntconsult.votacao.entities;

import org.hibernate.id.enhanced.SequenceStyleGenerator;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name ="pauta")
public class Pauta implements Serializable {

    private Long id;
    private String titulo;

    public Pauta() {
    }

    public Pauta(String titulo) {
        this.titulo = titulo;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "titulo", nullable = false)
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public static final class PautaBuilder {
        private Long id;
        private String titulo;

        private PautaBuilder() {
        }

        public static PautaBuilder aPauta() {
            return new PautaBuilder();
        }

        public PautaBuilder withId(Long id) {
            this.id = id;
            return this;
        }

        public PautaBuilder withTitulo(String titulo) {
            this.titulo = titulo;
            return this;
        }

        public Pauta build() {
            Pauta pauta = new Pauta();
            pauta.setId(id);
            pauta.setTitulo(titulo);
            return pauta;
        }
    }
}
