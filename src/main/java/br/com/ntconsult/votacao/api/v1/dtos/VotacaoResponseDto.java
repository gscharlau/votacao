package br.com.ntconsult.votacao.api.v1.dtos;

import br.com.ntconsult.votacao.api.v1.dtos.base.RequestDto;

public class VotacaoResponseDto extends RequestDto {
    private Long idVoto;
    private Long idSessaoVotacao;
    private Long idPauta;
    private Boolean voto;

    public VotacaoResponseDto() {
    }

    public VotacaoResponseDto(Long idVoto, Long idSessaoVotacao, Long idPauta, Boolean voto) {
        this.idVoto = idVoto;
        this.idSessaoVotacao = idSessaoVotacao;
        this.idPauta = idPauta;
        this.voto = voto;
    }

    public Long getIdVoto() {
        return idVoto;
    }

    public void setIdVoto(Long idVoto) {
        this.idVoto = idVoto;
    }

    public Long getIdSessaoVotacao() {
        return idSessaoVotacao;
    }

    public void setIdSessaoVotacao(Long idSessaoVotacao) {
        this.idSessaoVotacao = idSessaoVotacao;
    }

    public Long getIdPauta() {
        return idPauta;
    }

    public void setIdPauta(Long idPauta) {
        this.idPauta = idPauta;
    }

    public Boolean getVoto() {
        return voto;
    }

    public void setVoto(Boolean voto) {
        this.voto = voto;
    }

    public static final class VotacaoResponseDtoBuilder {
        private Long idVoto;
        private Long idSessaoVotacao;
        private Long idPauta;
        private Boolean voto;

        private VotacaoResponseDtoBuilder() {
        }

        public static VotacaoResponseDtoBuilder aVotacaoResponseDto() {
            return new VotacaoResponseDtoBuilder();
        }

        public VotacaoResponseDtoBuilder withIdVoto(Long idVoto) {
            this.idVoto = idVoto;
            return this;
        }

        public VotacaoResponseDtoBuilder withIdSessaoVotacao(Long idSessaoVotacao) {
            this.idSessaoVotacao = idSessaoVotacao;
            return this;
        }

        public VotacaoResponseDtoBuilder withIdPauta(Long idPauta) {
            this.idPauta = idPauta;
            return this;
        }

        public VotacaoResponseDtoBuilder withVoto(Boolean voto) {
            this.voto = voto;
            return this;
        }

        public VotacaoResponseDto build() {
            VotacaoResponseDto votacaoResponseDto = new VotacaoResponseDto();
            votacaoResponseDto.setIdVoto(idVoto);
            votacaoResponseDto.setIdSessaoVotacao(idSessaoVotacao);
            votacaoResponseDto.setIdPauta(idPauta);
            votacaoResponseDto.setVoto(voto);
            return votacaoResponseDto;
        }
    }
}
