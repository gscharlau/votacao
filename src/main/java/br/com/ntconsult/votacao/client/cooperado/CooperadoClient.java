package br.com.ntconsult.votacao.client.cooperado;

import br.com.ntconsult.votacao.enums.StatusCooperadoEnum;

public interface CooperadoClient {
    StatusCooperadoEnum validarCpf(String cpf);
}
