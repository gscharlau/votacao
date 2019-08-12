package br.com.ntconsult.votacao.client.cooperado;

import br.com.ntconsult.votacao.client.cooperado.dto.CooperadoDto;
import br.com.ntconsult.votacao.enums.StatusCooperadoEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

@Component(value = "restClient")
public class CooperadoRestClient implements CooperadoClient {

    @Value("${url.validacao.cooperado}")
    private String urlValidacaoCooperativado;
    private RestTemplate restTemplate;
    private Logger log = LoggerFactory.getLogger(CooperadoRestClient.class);

    @Autowired
    public CooperadoRestClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public StatusCooperadoEnum validarCpf(String cpf) {

        try {
            String url = formatarUrlValidacaoCooperativado(cpf);
            log.info("[Validação-Cpf] Iniciando validação do cpf através na url {}", url);
            CooperadoDto cooperadoDto = restTemplate.exchange(url, HttpMethod.GET, null, CooperadoDto.class).getBody();
            log.info("[Validação-Cpf] Resultado da validação do cpf {}: {}", cpf, cooperadoDto);
            return StatusCooperadoEnum.get(cooperadoDto.getData().getStatus());
        } catch (HttpClientErrorException e) {
            log.info("[Validação-Cpf] Cpf inválido {}. Detalhe erro {}", cpf, e.getMessage());
            return StatusCooperadoEnum.DESABILITADO_PARA_VOTAR;
        }

    }

    private String formatarUrlValidacaoCooperativado(String cpf) {
        return new StringBuilder()
                .append(urlValidacaoCooperativado)
                .append("/users/")
                .append(cpf)
                .toString();
    }

}
