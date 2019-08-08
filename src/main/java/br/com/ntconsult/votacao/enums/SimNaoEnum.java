package br.com.ntconsult.votacao.enums;

public enum SimNaoEnum {

    SIM("Sim"),
    NAO("Não");

    private String descricao;

    SimNaoEnum(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
