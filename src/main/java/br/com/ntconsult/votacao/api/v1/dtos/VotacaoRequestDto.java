package br.com.ntconsult.votacao.api.v1.dtos;

import br.com.ntconsult.votacao.api.v1.dtos.base.RequestDto;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class VotacaoRequestDto extends RequestDto {
    @NotNull(message = "ID Sessão é obrigatório")
    private Long idSessaoVotacao;

    @NotEmpty(message = "O id do cooperativado é obrigatório")
    private String cpfCooperado;

    @NotNull(message = "O voto é obrigatório")
    private Boolean voto;

    public VotacaoRequestDto() {
    }

    public VotacaoRequestDto(Long idSessaoVotacao, String cpfCooperado, Boolean voto) {
        this.idSessaoVotacao = idSessaoVotacao;
        this.cpfCooperado = cpfCooperado;
        this.voto = voto;
    }

    public Long getIdSessaoVotacao() {
        return idSessaoVotacao;
    }

    public void setIdSessaoVotacao(Long idSessaoVotacao) {
        this.idSessaoVotacao = idSessaoVotacao;
    }

    public String getCpfCooperado() {
        return cpfCooperado;
    }

    public void setCpfCooperado(String cpfCooperado) {
        this.cpfCooperado = cpfCooperado;
    }

    public Boolean getVoto() {
        return voto;
    }

    public void setVoto(Boolean voto) {
        this.voto = voto;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.JSON_STYLE);
    }
}
