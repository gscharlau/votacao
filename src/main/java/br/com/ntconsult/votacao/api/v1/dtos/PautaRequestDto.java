package br.com.ntconsult.votacao.api.v1.dtos;

import javax.validation.constraints.NotEmpty;

public class PautaRequestDto {

    private String titulo;

    public PautaRequestDto() {
    }

    public PautaRequestDto(String titulo) {
        this.titulo = titulo;
    }

    @NotEmpty
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
}
