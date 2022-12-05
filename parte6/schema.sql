CREATE TABLE IF NOT EXISTS autor
(
    id integer serial,
    nome character varying(100)  NOT NULL,
    datanascimento date NOT NULL,
    CONSTRAINT autor_pkey PRIMARY KEY (id)
)

CREATE TABLE IF NOT EXISTS ideia
(   id integer serial,
    titulo character varying(100)  NOT NULL,
    descricao text ,
    urgencia integer NOT NULL,
    CONSTRAINT ideia_pkey PRIMARY KEY (id),
    CONSTRAINT ideia_urgencia_check CHECK (urgencia >= 1 AND urgencia <= 5)
)

CREATE TABLE IF NOT EXISTS autorideia
(   idideia integer NOT NULL,
    idautor integer NOT NULL,
    CONSTRAINT autorideia_pkey PRIMARY KEY (idideia, idautor),
    CONSTRAINT autorideia_idautor_fkey FOREIGN KEY (idautor)
        REFERENCES public.autor (id), 
    CONSTRAINT autorideia_idideia_fkey FOREIGN KEY (idideia)
        REFERENCES public.ideia (id) 
)

CREATE TABLE IF NOT EXISTS etapa
(   id integer serial),
    nome character varying(100) ,
    idideia integer NOT NULL,
    CONSTRAINT etapa_pkey PRIMARY KEY (id),
    CONSTRAINT etapa_idideia_fkey FOREIGN KEY (idideia)
        REFERENCES public.ideia (id)
)
