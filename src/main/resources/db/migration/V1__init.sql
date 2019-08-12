CREATE TABLE public.pauta (
	id bigint NOT NULL GENERATED ALWAYS AS IDENTITY,
	titulo varchar(150) NOT NULL,
	CONSTRAINT pauta_pk PRIMARY KEY (id)
);


CREATE TABLE public.sessao (
	id bigint NOT NULL GENERATED ALWAYS AS IDENTITY,
	id_pauta bigint NOT NULL,
	data_expiracao timestamp NOT NULL,
	CONSTRAINT sessao_pk PRIMARY KEY (id),
	CONSTRAINT sessao_fk FOREIGN KEY (id_pauta) REFERENCES public.pauta(id)
);

CREATE TABLE public.votacao (
	id bigint NOT NULL GENERATED ALWAYS AS IDENTITY,
	id_sessao bigint NOT NULL,
	cpf_cooperado varchar(15) NOT NULL,
	voto bool NOT NULL,
	CONSTRAINT votacao_pk PRIMARY KEY (id),
	CONSTRAINT votacao_un UNIQUE (id_sessao,cpf_cooperado),
	CONSTRAINT votacao_fk FOREIGN KEY (id_sessao) REFERENCES public.sessao(id)
);
