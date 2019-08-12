package br.com.ntconsult.votacao.api.v1.dtos;

import br.com.ntconsult.votacao.api.v1.dtos.base.RequestDto;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class ContagemVotosDto extends RequestDto {
    private Long totalVotos;
    private Long votosSim;
    private Long votosNao;

    public ContagemVotosDto() {
    }

    public ContagemVotosDto(Long totalVotos, Long votosSim, Long votosNao) {
        this.totalVotos = totalVotos;
        this.votosSim = votosSim;
        this.votosNao = votosNao;
    }

    public Long getTotalVotos() {
        return totalVotos;
    }

    public void setTotalVotos(Long totalVotos) {
        this.totalVotos = totalVotos;
    }

    public Long getVotosSim() {
        return votosSim;
    }

    public void setVotosSim(Long votosSim) {
        this.votosSim = votosSim;
    }

    public Long getVotosNao() {
        return votosNao;
    }

    public void setVotosNao(Long votosNao) {
        this.votosNao = votosNao;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.JSON_STYLE);
    }

    public static final class ContagemVotosDtoBuilder {
        private Long totalVotos;
        private Long votosSim;
        private Long votosNao;

        private ContagemVotosDtoBuilder() {
        }

        public static ContagemVotosDtoBuilder aContagemVotosDto() {
            return new ContagemVotosDtoBuilder();
        }

        public ContagemVotosDtoBuilder withTotalVotos(Long totalVotos) {
            this.totalVotos = totalVotos;
            return this;
        }

        public ContagemVotosDtoBuilder withVotosSim(Long votosSim) {
            this.votosSim = votosSim;
            return this;
        }

        public ContagemVotosDtoBuilder withVotosNao(Long votosNao) {
            this.votosNao = votosNao;
            return this;
        }

        public ContagemVotosDto build() {
            ContagemVotosDto contagemVotosDto = new ContagemVotosDto();
            contagemVotosDto.setTotalVotos(totalVotos);
            contagemVotosDto.setVotosSim(votosSim);
            contagemVotosDto.setVotosNao(votosNao);
            return contagemVotosDto;
        }
    }
}
