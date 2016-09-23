DROP DATABASE IF EXISTS xyv;
CREATE DATABASE xyv DEFAULT CHARACTER SET utf8 COLLATE utf8_unicode_ci;
USE xyv;

INSERT INTO titulacao (nome_titulo) VALUES
	('Mestre'),
    ('Doutor');
 
INSERT INTO pessoa (id, cpf, nome, sexo) VALUES
	(1, '11111111111', 'Alfredo', 'M'),
    (2, '22222222222', 'Bianca', 'F'),
    (3, '33333333333', 'Carlos', 'M'),
    (4, '23232323232', 'Fagner', 'M'),
    (5, '32132132165', 'Walber', 'M'),
    (6, '54689798798', 'Bruna', 'F'),
    (7, '56312315668', 'Paulo', 'M'),
    (8, '12312312356', 'Andrews', 'M');

INSERT INTO professor (data_admissao, instituicao, pessoa_id, titulacao_id) VALUES
	('2015-01-03', 'UFPE', 1, 1),
    ('2016-03-09', 'UFPB', 2, 2),
    ('2016-05-20', 'UFPE', 3, 1);

INSERT INTO aluno (matricula, pessoa_id, professor_id) VALUES
	(1000, 4, 3),
    (1100, 5, 1),
    (1200, 6, 3),
    (1300, 7, 2),
    (1400, 8, 3);

INSERT INTO endereco (bairro, cidade, logradouro, numero, uf, pessoa_id) VALUES
	('Centro', 'Recife', 'Rua X', 90, 'Pernambuco', 1),
    ('Casa Forte', 'Recife', 'Rua R', 100, 'Pernambuco', 2),
    ('Centro', 'Abreu e Lima', 'Rua T', 23, 'Pernambuco', 3),
    ('Caxangá', 'Recife', 'Rua D', 45, 'Pernambuco', 4),
    ('Torre', 'Recife', 'Rua W', 89, 'Pernambuco', 5),
    ('Ouro Preto', 'Olinda', 'Rua ABC', 546, 'Pernambuco', 6),
    ('Caxangá', 'Recife', 'Rua POO', 23, 'Pernambuco', 7),
    ('Torre', 'Recife', 'Rua DAO', 56, 'Pernambuco', 8),
    ('Sé', 'Olinda', 'Rua JEE', 345, 'Pernambuco', 8);

INSERT INTO telefone (ddd, numero, pessoa_id) VALUES
	(081, 131316497, 1),
    (083, 654654698, 1),
    (081, 464983213, 2),
    (081, 132165356, 3),
    (081, 494321319, 4),
    (081, 456131674, 4),
    (081, 319876513, 5),
    (081, 134198231, 6),
    (081, 349432132, 7),
    (081, 318974132, 8);

INSERT INTO meio_comunicacao (descricao) VALUES
	('Smartphone'),
    ('Tablet'),
    ('Revista'),
    ('Jornal');

INSERT INTO publicacao (descricao, titulo, aluno_id, meio_comunicacao_id, professor_id) VALUES
    ('P1', 'T1', 4, 1, 3),
    ('P2', 'T2', 5, 2, 1),
    ('P3', 'T3', 6, 3, 3),
    ('P4', 'T4', 7, 2, 2),
    ('P5', 'T5', 8, 2, 3);