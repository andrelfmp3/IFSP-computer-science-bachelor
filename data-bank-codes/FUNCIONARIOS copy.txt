
USE TEST;

CREATE TABLE FUNCIONARIO
(
ID_FUNCIONARIO INTEGER NOT NULL,
NOME VARCHAR(30) NOT NULL,
CARGO VARCHAR(30) NOT NULL,
DEPARTAMENTO VARCHAR(30) NOT NULL,
SALARIO FLOAT NOT NULL,
PRIMARY KEY (ID_FUNCIONARIO)
);

INSERT INTO FUNCIONARIO (ID_FUNCIONARIO,NOME,CARGO,DEPARTAMENTO,SALARIO) VALUES 
(1,'Abel','Auxiliar comercial','Comercial',1695),
(2,'Abelardo','Auxiliar comercial','Comercial',1260),
(3,'Abílio','Auxiliar comercial','Comercial',1695),
(4,'Abraão','Estagiário','Comercial',500),
(5,'Ada','Supervisor','Comercial',1875),
(6,'Adalberto','Supervisor','Comercial',1945),
(7,'Adalgisa','Assistente','Pesquisa',660),
(8,'Adão','Assistente','Pesquisa',640),
(9,'Babette','Assistente','Pesquisa',640),
(10,'Balbina','Estagiário','Pesquisa',640),
(37,'Roberta','Estagiário','Pesquisa',640),
(11,'Baltazar','Supervisor','Pesquisa',2230),
(12,'Bárbara','Assistente','Pesquisa',685),
(13,'Bartolomeu','Assistente','Pesquisa',635),
(14,'Caetano','Assistente','Pesquisa',680),
(15,'Caio','Assistente','Pesquisa',750),
(16,'Camile','Assistente','Pesquisa',680),
(17,'Daiana','Assistente','Pesquisa',680),
(18,'Dalton','Coordenador','Pesquisa',1600),
(19,'Dalva','Assistente','Pesquisa',750),
(20,'Éder','Atendente','Atendimento ao cliente',1000),
(21,'Edgar','Atendente','Atendimento ao cliente',790),
(22,'Edmundo','Supervisor','Atendimento ao cliente',1875),
(23,'Edna','Atendente','TI',700),
(24,'Édson','Supervisor','TI',1945),
(25,'Eduardo','Programador Júnior','TI',1500),
(26,'Elaine','Programador Sênior','TI',2500),
(38,'Pedro','Estagiário','TI',900),
(39,'José','Estagiário','TI',900),
(27,'Fábia','Programador Pleno','TI',2000),
(28,'Fabiana','Auxiliar administrativo','Administração',1166),
(29,'Fabiano','Estagiário','Administração',655),
(30,'Fábio','Supervisor','RH',1700),
(31,'Fabíola','Assistente','RH',890),
(32,'Fabrícia','Assistente','RH',650),
(33,'Fabrício','Gerente','RH',2800),
(34,'Fátima','Sócio-proprietário','Diretoria',2500),
(35,'João','Sócio-proprietário','Diretoria',2500),
(36,'Maria','Diretor Comercial','Diretoria',14200);



CREATE TABLE FUNCIONARIO_BACKUP
(
ID_FUNCIONARIO INTEGER NOT NULL,
NOME VARCHAR(30) NOT NULL,
CARGO VARCHAR(30) NOT NULL,
DEPARTAMENTO VARCHAR(30) NOT NULL,
SALARIO FLOAT NOT NULL,
PRIMARY KEY (ID_FUNCIONARIO)
);

INSERT INTO FUNCIONARIO_BACKUP (ID_FUNCIONARIO,NOME,CARGO,DEPARTAMENTO,SALARIO) VALUES 
(1,'Abel','Auxiliar comercial','Comercial',1695),
(2,'Abelardo','Auxiliar comercial','Comercial',1260),
(3,'Abílio','Auxiliar comercial','Comercial',1695),
(4,'Abraão','Estagiário','Comercial',500),
(5,'Ada','Supervisor','Comercial',1875),
(6,'Adalberto','Supervisor','Comercial',1945),
(7,'Adalgisa','Assistente','Pesquisa',660),
(8,'Adão','Assistente','Pesquisa',635),
(9,'Babette','Estagiário','Pesquisa',640),
(10,'Balbina','Estagiário','Pesquisa',640),
(11,'Baltazar','Supervisor','Pesquisa',2230),
(12,'Bárbara','Assistente','Pesquisa',685),
(13,'Bartolomeu','Assistente','Pesquisa',635),
(14,'Caetano','Assistente','Pesquisa',680),
(15,'Caio','Assistente','Pesquisa',750),
(16,'Camile','Assistente','Pesquisa',680),
(17,'Daiana','Assistente','Pesquisa',680),
(18,'Dalton','Coordenador','Pesquisa',1600),
(19,'Dalva','Assistente','Pesquisa',750),
(20,'Éder','Atendente','Atendimento ao cliente',1000),
(21,'Edgar','Atendente','Atendimento ao cliente',790),
(22,'Edmundo','Supervisor','Atendimento ao cliente',1875),
(23,'Edna','Atendente','TI',700),
(24,'Édson','Supervisor','TI',1945),
(25,'Eduardo','Programador','TI',1470),
(26,'Elaine','Programador','TI',1575),
(27,'Fábia','Programador','TI',1470),
(28,'Fabiana','Auxiliar administrativo','Administração',1166),
(29,'Fabiano','Estagiário','Administração',655),
(30,'Fábio','Assistente','RH',910),
(31,'Fabíola','Assistente','RH',890),
(32,'Fabrícia','Assistente','RH',650),
(33,'Fabrício','Supervisor','RH',1875),
(34,'Fátima','Sócio-proprietário','Diretoria',2396),
(35,'João','Sócio-proprietário','Diretoria',2396),
(36,'Maria','Diretor Comercial','Diretoria',14175);

SELECT * FROM FUNCIONARIO_BACKUP;

SELECT * FROM FUNCIONARIO;