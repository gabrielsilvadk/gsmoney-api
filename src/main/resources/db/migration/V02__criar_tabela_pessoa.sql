CREATE TABLE pessoa(
    codigo BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(100) NOT NULL, 
    ativo BOOLEAN,
    logradouro VARCHAR(200),
    numero VARCHAR(20),
    complemento VARCHAR(100),
    bairro VARCHAR(50),
    cep VARCHAR(10), 
    cidade VARCHAR(50), 
    estado VARCHAR(50)   
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


INSERT INTO pessoa(nome, ativo, logradouro, numero, complemento, bairro, cep, cidade, estado) 
VALUES('Gabriel', TRUE, 'rua teste', '123', 'em frente ao spa', 'sao jose', '06010-000', 'Osasco', 'São Paulo');

INSERT INTO pessoa(nome, ativo, logradouro, numero, complemento, bairro, cep, cidade, estado) 
VALUES('Jose', TRUE, 'rua teste2', '1234', 'em frente ao spa2', 'sao joao', '05123-456', 'São Paulo', 'São Paulo');

INSERT INTO pessoa(nome, ativo, logradouro, numero, complemento, bairro, cep, cidade, estado) 
VALUES('Flavio', TRUE, 'rua teste3', '12345', 'em frente ao spa3', 'copacabana', '22050-000', 'Rio de Janeiro', 'Rio de Janeiro');