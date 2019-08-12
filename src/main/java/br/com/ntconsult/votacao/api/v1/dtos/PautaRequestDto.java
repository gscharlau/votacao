package br.com.ntconsult.votacao.api.v1.dtos;

import br.com.ntconsult.votacao.api.v1.dtos.base.RequestDto;

import javax.validation.constraints.NotEmpty;

public class PautaRequestDto extends RequestDto {

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
