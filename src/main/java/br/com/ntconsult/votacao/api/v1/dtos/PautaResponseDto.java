package br.com.ntconsult.votacao.api.v1.dtos;

public class PautaResponseDto {

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
