package br.com.ntconsult.votacao.client.cooperado.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

public class CooperadoDto {

    private Data data;

    public CooperadoDto() {
    }

    public CooperadoDto(Data data) {
        this.data = data;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public static class Data{
        String status;

        public Data() {
        }

        public Data(String status) {
            this.status = status;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }
    }
}
