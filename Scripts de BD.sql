CREATE DATABASE teste_campanha;
-- GRANT USAGE ON *.* TO root@localhost IDENTIFIED BY 'root'; -- senha � entre aspas mesmo
GRANT ALL PRIVILEGES ON teste_campanha.* TO root@localhost;

-- DROP TABLE teste_campanha.TIME;

CREATE TABLE teste_campanha.TIME(
	IDTIME INTEGER NOT NULL AUTO_INCREMENT COMMENT 'CODIGO SEQUENCIAL QUE DIFERENCIA CADA REGISTRO DA TABELA',
	PRIMARY KEY(IDTIME),
	NOMETIME VARCHAR(255) COMMENT 'NOME DO TIME'
);

INSERT INTO teste_campanha.TIME(NOMETIME) VALUES('Palmeiras');
INSERT INTO teste_campanha.TIME(NOMETIME) VALUES('Corinthans');
INSERT INTO teste_campanha.TIME(NOMETIME) VALUES('Sao Paulo');
INSERT INTO teste_campanha.TIME(NOMETIME) VALUES('Santos');

-- DROP TABLE teste_campanha.CAMPANHA;

CREATE TABLE teste_campanha.CAMPANHA(
	IDCAMPANHA INTEGER NOT NULL AUTO_INCREMENT COMMENT 'CODIGO SEQUENCIAL QUE DIFERENCIA CADA REGISTRO DA TABELA',
	PRIMARY KEY(IDCAMPANHA),
	NOMECAMPANHA VARCHAR(255) COMMENT 'NOME DA CAMPANHA',
	IDTIMECORACAO INTEGER NOT NULL COMMENT 'CODIGO IDENTIFICADOR DO TIME DO CORACAO',
	FOREIGN KEY (IDTIMECORACAO) REFERENCES teste_campanha.TIME(IDTIME),
	DATAVIGENCIA DATE NOT NULL COMMENT 'DATA DA VIGENCIA'
);

INSERT INTO teste_campanha.CAMPANHA(NOMECAMPANHA, IDTIMECORACAO, DATAVIGENCIA) VALUES('campanha1', 1, now());
INSERT INTO teste_campanha.CAMPANHA(NOMECAMPANHA, IDTIMECORACAO, DATAVIGENCIA) VALUES('campanha2', 1, now());
INSERT INTO teste_campanha.CAMPANHA(NOMECAMPANHA, IDTIMECORACAO, DATAVIGENCIA) VALUES('campanha3', 2, now());
INSERT INTO teste_campanha.CAMPANHA(NOMECAMPANHA, IDTIMECORACAO, DATAVIGENCIA) VALUES('campanha4', 3, now());

-- DROP TABLE teste_campanha.USUARIO;

CREATE TABLE teste_campanha.USUARIO(
	IDUSUARIO INTEGER NOT NULL AUTO_INCREMENT COMMENT 'CODIGO SEQUENCIAL QUE DIFERENCIA CADA REGISTRO DA TABELA',
	PRIMARY KEY(IDUSUARIO),
	EMAIL VARCHAR(255) COMMENT 'NOME DA CAMPANHA',
	UNIQUE(EMAIL),
	IDTIMECORACAO INTEGER NOT NULL COMMENT 'CODIGO IDENTIFICADOR DO TIME DO CORACAO',
	FOREIGN KEY (IDTIMECORACAO) REFERENCES teste_campanha.TIME(IDTIME),
	DATANASC DATE NOT NULL COMMENT 'DATA DA VIGENCIA',
	ATIVO VARCHAR(1)
);

INSERT INTO teste_campanha.USUARIO(EMAIL, IDTIMECORACAO, DATANASC, ATIVO) VALUES('TESTE1@', 1, now(), 'I');
INSERT INTO teste_campanha.USUARIO(EMAIL, IDTIMECORACAO, DATANASC, ATIVO) VALUES('TESTE2@', 1, now(), 'A');
INSERT INTO teste_campanha.USUARIO(EMAIL, IDTIMECORACAO, DATANASC, ATIVO) VALUES('TESTE3@', 2, now(), 'A');
INSERT INTO teste_campanha.USUARIO(EMAIL, IDTIMECORACAO, DATANASC, ATIVO) VALUES('TESTE4@', 3, now(), 'A');

CREATE TABLE teste_campanha.CAMPANHAUSUARIO(
	IDCAMPANHAUSUARIO INTEGER NOT NULL AUTO_INCREMENT COMMENT 'CODIGO SEQUENCIAL QUE DIFERENCIA CADA REGISTRO DA TABELA',
	PRIMARY KEY(IDCAMPANHAUSUARIO),
	IDCAMPANHA INTEGER NOT NULL COMMENT 'CODIGO IDENTIFICADOR DA CAMPANHA',
	FOREIGN KEY (IDCAMPANHA) REFERENCES teste_campanha.CAMPANHA(IDCAMPANHA),
	IDUSUARIO INTEGER NOT NULL COMMENT 'CODIGO IDENTIFICADOR DO USUARIO',
	FOREIGN KEY (IDUSUARIO) REFERENCES teste_campanha.USUARIO(IDUSUARIO)
);

UPDATE teste_campanha.CAMPANHA SET DATAVIGENCIA = '2017-07-13';

COMMIT;

SELECT * FROM teste_campanha.TIME;
SELECT * FROM teste_campanha.CAMPANHA;
SELECT * FROM teste_campanha.USUARIO;