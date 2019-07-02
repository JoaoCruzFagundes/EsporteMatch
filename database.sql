CREATE DATABASE projeto;
USE projeto;
CREATE TABLE posicao (
id_pos BIGINT UNIQUE NOT NULL AUTO_INCREMENT,

pos_pri VARCHAR(20) NOT NULL,

peso_1 SMALLINT NOT NULL,

pos_sec VARCHAR(20) NOT NULL,

peso_2 SMALLINT NOT NULL,

PRIMARY KEY (id_pos)
);
----------------------------------------------------------------------
CREATE TABLE clube(

id_clube BIGINT UNIQUE NOT NULL AUTO_INCREMENT,

nome VARCHAR(255) UNIQUE NOT NULL,

PRIMARY KEY (id_clube)


);
----------------------------------------------------------------
CREATE TABLE usuario (

id_usuario BIGINT UNIQUE NOT NULL AUTO_INCREMENT,

nome VARCHAR(100) NOT NULL,

login VARCHAR(15) UNIQUE NOT NULL,

senha VARCHAR (16) NOT NULL,

email VARCHAR(100) UNIQUE NOT NULL,

cpf VARCHAR(15) UNIQUE NOT NULL,

telefone VARCHAR(11) UNIQUE NOT NULL,

id_clube BIGINT,
PRIMARY KEY (id_usuario),

FOREIGN KEY (id_clube) REFERENCES clube (id_clube)

);
--------------------------------------------------------------
CREATE TABLE avaliacao(

id_aval BIGINT UNIQUE NOT NULL AUTO_INCREMENT,

aval_cond BIGINT NOT NULL,

aval_desemp BIGINT NOT NULL,

descricao VARCHAR(255),

id_usuario BIGINT NOT NULL,

id_clube BIGINT NOT NULL,

PRIMARY KEY (id_aval),
FOREIGN KEY (id_usuario) REFERENCES usuario (id_usuario),
FOREIGN KEY (id_clube) REFERENCES clube (id_clube)
);
--------------------------------------------------------------------
CREATE TABLE esporte(

id_esporte BIGINT NOT NULL UNIQUE AUTO_INCREMENT,

nome VARCHAR(20),

PRIMARY KEY (id_esporte)
);

INSERT INTO esporte (id_esporte, nome) values (null, "Futsal");
INSERT INTO esporte (id_esporte, nome) values (null, "Volei");
INSERT INTO esporte (id_esporte, nome) values (null, "Futebol");
INSERT INTO esporte (id_esporte, nome) values (null, "Basquete");
---------------------------------------------------------------
CREATE TABLE partida(

id_partida BIGINT UNIQUE NOT NULL AUTO_INCREMENT,

faltas INT,

data_hora VARCHAR(12) NOT NULL,

endereco VARCHAR(255) NOT NULL,

status_partida INT NOT NULL,

id_clube BIGINT NOT NULL,

id_esporte BIGINT NOT NULL,

PRIMARY KEY (id_partida),

FOREIGN KEY (id_clube) REFERENCES clube (id_clube)ON DELETE CASCADE,
FOREIGN KEY (id_esporte) REFERENCES esporte (id_esporte)
);
----------------------------------------------------------
CREATE TABLE participa(

id_participa BIGINT UNIQUE NOT NULL AUTO_INCREMENT,

id_usuario BIGINT,

id_partida BIGINT,

id_pos BIGINT,


PRIMARY KEY(id_participa),

FOREIGN KEY (id_usuario) REFERENCES usuario (id_usuario) ON DELETE CASCADE,
FOREIGN KEY (id_partida) REFERENCES partida (id_partida),
FOREIGN KEY (id_pos) REFERENCES posicao (id_pos)
);
------------------------------------------------------------------------------------------
CREATE TABLE escolhe(

id_escolhe BIGINT UNIQUE NOT NULL AUTO_INCREMENT,

id_usuario BIGINT NOT NULL,

id_esporte BIGINT NOT NULL,


PRIMARY KEY (id_escolhe),

FOREIGN KEY (id_usuario) REFERENCES usuario (id_usuario),
FOREIGN KEY (id_esporte) REFERENCES esporte (id_esporte)
);
