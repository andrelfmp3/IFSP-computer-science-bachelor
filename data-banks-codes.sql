CREATE DATABASE IF NOT EXISTS  LABD24;
USE LABD24;
/*DROP DATABASE IF EXISTS LAB24;*/

CREATE TABLE IF NOT EXISTS SETORES (
	SET_ID integer NOT NULL auto_increment,
    SET_NOME VARCHAR(30) NOT NULL,
    PRIMARY KEY(SET_ID),
    UNIQUE (SET_NOME)
);

CREATE TABLE IF NOT EXISTS ATUACOES (
	ATU_ID INT NOT NULL auto_increment PRIMARY KEY,
    ATU_NOME VARCHAR(30) NOT NULL,
    FK_SETORES_SET_ID INT NOT NULL,
    foreign key(FK_SETORES_SET_ID) REFERENCES SETORES(SET_ID) ON DELETE CASCADE
)

CREATE TABLE IF NOT EXISTS CIDADE (
	CID_ID INT NOT NULL AUTO_INCREMENT,
    CID_ESTADO ENUM('AC', 'AL', 'AP', 'AM', 'BA', 'CE', 'DF', 'ES', 'GO', 'MA', 'MT', 'MS', 'MG', 'PA', 'PB', 'PR', 'PE', 'PI', 'RJ', 'RN', 'RS', 'RO', 'RR', 'SC', 'SP', 'SE', 'TO') NOT NULL,
    CID_NOME VARCHAR(30) NOT NULL,
    PRIMARY KEY(CID_ID)
);

CREATE TABLE IF NOT EXISTS CEPS (
	CEP_ID INT NOT NULL,
    CEP_LOGRADOURO VARCHAR(100) NOT NULL,
    CEP_BAIRRO VARCHAR(30) NOT NULL,
    FK_CIDADES_CID_ID INT NOT NULL,
    PRIMARY KEY(CEP_ID),
    foreign key(FK_CIDADES_CID_ID) references CIDADES(CID_ID),
);

CREATE TABLE IF NOT EXISTS EMPRESAS (
	EMP_NOME_FANTASIA VARCHAR(50) NOT NULL,
    EMP_RAZAO_SOCIAL_ VARCHAR(100) NOT NULL,
    EMP_SITE VARCHAR(100) NULL,
    EMP_EMAIL VARCHAR(100),
    EMP_NUMERO VARCHAR(8) NOT NULL,
    EMP_COMPLEMENTO VARCHAR(20),
    EMP_CNPJ VARCHAR(16) NOT NULL UNIQUE,
    EMP_ID INT NOT NULL AUTO_INCREMENT,
    FK_ATUACOES_ATU_ID INT NOT NULL,
    FK_CEPS_CEP_ID INT NOT NULL,
    PRIMARY KEY(EMP_ID),
    foreign key(FK_ATUACOES_ATU_ID) references ATUACOES (ATU_ID),
    foreign key(FK_CEPS_CEP_ID) references CEPS(CEP_ID)
);




