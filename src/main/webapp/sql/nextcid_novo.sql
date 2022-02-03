CREATE DATABASE IF NOT EXISTS Nextcid;

USE Nextcid;

CREATE TABLE IF NOT EXISTS Curso(
	idCurso INT NOT NULL, 
	nmCurso VARCHAR (50) NOT NULL,
	PRIMARY KEY(idCurso)
);

CREATE TABLE IF NOT EXISTS Disciplina(
	iddisciplina INT  NOT NULL, 
	nmDisciplina VARCHAR (50) NOT NULL, 
	idCurso INT NOT NULL,
	PRIMARY KEY(idDisciplina),
	FOREIGN KEY (idCurso) REFERENCES Curso (idCurso) ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS Questao(
	idQuestao INT NOT NULL, 
	anoQuestao VARCHAR (4) NOT NULL, 
	nQuestao VARCHAR (200) NOT NULL, 
	tpquestao VARCHAR (15) NOT NULL, 
    enunciado LONGTEXT NOT NULL, 
    img LONGTEXT,
    altA TEXT, 
    altB TEXT,
    altC TEXT,
    altD TEXT,
    altE TEXT,
    respAlt VARCHAR(2),
    respDiss MEDIUMTEXT,
    iddisciplina1 INT  NOT NULL, 
    iddisciplina2 INT,
    iddisciplina3 INT,
    iddisciplina4 INT,
    
  	PRIMARY KEY(idQuestao),
	FOREIGN KEY (iddisciplina1) REFERENCES Disciplina (iddisciplina) ON DELETE CASCADE,
    FOREIGN KEY (iddisciplina2) REFERENCES Disciplina (iddisciplina) ON DELETE CASCADE,
    FOREIGN KEY (iddisciplina3) REFERENCES Disciplina (iddisciplina) ON DELETE CASCADE,
    FOREIGN KEY (iddisciplina4) REFERENCES Disciplina (iddisciplina) ON DELETE CASCADE
);



INSERT INTO CURSO VALUES
	(1,"Análise e Desenvolvimento de Sistemas"),
    (2, "Medicina Veterinária");

INSERT INTO DISCIPLINA VALUES 
	(1, "Lógica de programação", 1),
    (2, "Matemática", 1),
    (3, "Banco de dados", 1),
    (4, "Biologia", 2),
    (5, "Anatomia", 2);
    
INSERT INTO QUESTAO 
(IDQUESTAO, ANOQUESTAO, NQUESTAO, TPQUESTAO, ENUNCIADO, ALTA, ALTB, ALTC, ALTD, ALTE, RESPALT, IDDISCIPLINA1, IDDISCIPLINA2, IDDISCIPLINA3, IDDISCIPLINA4 ) VALUES 
(7, 2021, 1, "Alternativa", "O que é lógica de programação?","Uma disciplina","Uma batata", "Um animal", "Um objeto","Um suquinho","A", 4, 2, 3, NULL);
    
INSERT INTO QUESTAO 
(IDQUESTAO, ANOQUESTAO, NQUESTAO, TPQUESTAO, ENUNCIADO, ALTA, ALTB, ALTC, ALTD, ALTE, RESPALT, IDDISCIPLINA1, IDDISCIPLINA2, IDDISCIPLINA3, IDDISCIPLINA4 ) VALUES 
(1, 2021, 1, "Alternativa", "O que é lógica de programação?","Uma disciplina","Uma batata", "Um animal", "Um objeto","Um suquinho","A", 1, 2, 3, NULL),
(2, 2021, 2, "Alternativa", "O que é Matemática?","Uma batata", "Um animal", "Uma disciplina", "Um objeto","Um suquinho","C", 1, 2, NULL, NULL),
(3, 2021, 3, "Alternativa", "O que é Modelo de Entidade Relacional?","Uma batata", "Um animal", "Modelo que representa de forma abstrata a estrutura que possuirá o banco de dados da aplicação", "Um objeto","Um suquinho","C", 2, 3, 4, 5),
(4, 2021, 4, "Alternativa", "Para que serve o comando 'Insert' em Banco de Dados?","Uma batata", "Um animal", "Para jogar bola", "Um objeto","Para inserir dados em uma tabela","E", 3, NULL, NULL, NULL),
(5, 2019, 5, "Alternativa", "A qual classe pertence o cachorro","Uma batata", "Um animal", "Mamíferos", "Um objeto","Para inserir dados em uma tabela","C", 1, 2 , 3, 4);

SELECT Q.IDQUESTAO, Q.ANOQUESTAO, Q.TPQUESTAO, Q.NQUESTAO ,Q.ENUNCIADO, Q.IMG, Q.ALTA, Q.ALTB, Q.ALTC, Q.ALTD, Q.ALTE, Q.RESPALT, Q.RESPDISS,  Q.IDDISCIPLINA1,
		D1.NMDISCIPLINA, Q.IDDISCIPLINA2, D2.NMDISCIPLINA, Q.IDDISCIPLINA3, D3.NMDISCIPLINA, Q.IDDISCIPLINA4, D4.NMDISCIPLINA, C.NMCURSO
FROM QUESTAO AS Q 
LEFT JOIN DISCIPLINA AS D1 ON Q.IDDISCIPLINA1 = D1.IDDISCIPLINA 
LEFT JOIN DISCIPLINA AS D2 ON Q.IDDISCIPLINA2 = D2.IDDISCIPLINA 
LEFT JOIN DISCIPLINA AS D3 ON Q.IDDISCIPLINA3 = D3.IDDISCIPLINA 
LEFT JOIN DISCIPLINA AS D4 ON Q.IDDISCIPLINA4 = D4.IDDISCIPLINA 
LEFT JOIN CURSO AS C ON IF(D1.IDCURSO IS NOT NULL, D1.IDCURSO, IF(D2.IDCURSO IS NOT NULL, D2.IDCURSO, IF(D3.IDCURSO IS NOT NULL, D3.IDCURSO, IF(D4.IDCURSO IS NOT NULL, D4.IDCURSO, NULL)))) = C.IDCURSO;