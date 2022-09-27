CREATE TABLE ideia(
	id serial,
	titulo varchar(100) NOT NULL,
	descricao text,
	urgencia int NOT NULL,
	PRIMARY KEY (id),
	CHECK (urgencia BETWEEN 1 AND 5));
	


