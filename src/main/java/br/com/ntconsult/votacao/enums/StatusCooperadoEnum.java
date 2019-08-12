package br.com.ntconsult.votacao.enums;

import java.util.Arrays;

public enum StatusCooperadoEnum {
    HABILITADO_PARA_VOTAR("ABLE_TO_VOTE"),
    DESABILITADO_PARA_VOTAR("UNABLE_TO_VOTE");

    private String codigo;

    StatusCooperadoEnum(String codigo) {
        this.codigo = codigo;
    }

    public Boolean habilitadoParaVotar() {
        return this.equals(HABILITADO_PARA_VOTAR);
    }

    public static StatusCooperadoEnum get(String codigo) {
        return Arrays.stream(values())
                .filter(status -> status.codigo.equals(codigo))
                .findFirst()
                .orElseThrow(NoSuchFieldError::new);
    }

    public String getCodigo() {
        return codigo;
    }
}