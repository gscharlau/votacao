TravisCI: [![Build Status](https://travis-ci.org/gscharlau/votacao.svg?branch=master)](https://travis-ci.org/gscharlau/votacao)

# Votação Cooperado
Sistema de Votação em Assembléia de Cooperados

Este repositório engloba o desafio principal solicitado mais a integração com sistemas externos e documentação/versionamento da API (Tasks bônus 1 e 4).

CPFs habilitados para a votação (CPF verificado no serviço hospedado na nuvem):
```
  07262076167 : Cooperado 001
  51066194165 : Cooperado 002
  95746638501 : Cooperado 003
  23302747772 : Cooperado 004
  24481361573 : Cooperado 005
  99131576257 : Cooperado 006
  11775765890 : Cooperado 007
  35573415778 : Cooperado 008
  51343483409 : Cooperado 009
  41449059422 : Cooperado 010
``` 
## Sistema Externo
O sistema externo que valida o CPF está neste repositório: https://github.com/gscharlau/cooperados-api (Estrutura da API, testes unitários, com carga inicial com os CPFs listados acima.) Hospedado no Heroku, os CPFs podem ser consultados (GET) como o exemplo: `https://cooperados-api.herokuapp.com/users/07262076167`
 
## Versionamento
Versionamento através de implementações de interfaces nomeadas como "V1", "V2", etc... preservando assim os contratos já disponibilizados para os Clients, possibilitando implementar melhorias em novos endpoints e marcando as versões antigas como Deprecated, mantendo assim a compatibilidade, sem impedir as melhorias.
 
## Documentação
Utilizado o Swagger para mapear os endpoints, descrições, retornos, etc...

## Base de Dados
Utilizado uma base PostgreSQL em instância local para realizar a persistência dos dados.
