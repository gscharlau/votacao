package br.com.ntconsult.votacao.api.v1.dtos;

import br.com.ntconsult.votacao.entities.Pauta;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

public class SessaoRequestDto {
    private long idPauta;
    private Integer duracao;

    public SessaoRequestDto() {
    }

    public SessaoRequestDto(long idPauta) {
        this.idPauta = idPauta;
    }

    public SessaoRequestDto(long idPauta, Integer duracao) {
        this.idPauta = idPauta;
        this.duracao = duracao;
    }

    @NotNull(message = "ID pauta é obrigatório")
    public long getIdPauta() {
        return idPauta;
    }

    public void setIdPauta(long idPauta) {
        this.idPauta = idPauta;
    }

    public Integer getDuracao() {
        return duracao;
    }

    public void setDuracao(Integer duracao) {
        this.duracao = duracao;
    }

}
