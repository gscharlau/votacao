package br.com.ntconsult.votacao.api.v1.dtos;

import br.com.ntconsult.votacao.api.v1.dtos.base.RequestDto;

public class PautaResponseDto extends RequestDto {

    private Long id;
    private String titulo;

    public PautaResponseDto() { }

    public PautaResponseDto(Long id, String titulo) {
        this.id = id;
        this.titulo = titulo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
}
