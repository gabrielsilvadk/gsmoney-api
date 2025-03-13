CREATE TABLE lancamento (
    codigo BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
    descricao VARCHAR(50) NOT NULL,
    data_vencimento DATE NOT NULL,
    data_pagamento DATE,
    valor DECIMAL(10,2) NOT NULL,
    tipo VARCHAR(20) NOT NULL,
    codigo_categoria BIGINT(20) NOT NULL,
    codigo_pessoa BIGINT(20) NOT NULL,
    FOREIGN KEY (codigo_categoria) REFERENCES categoria(codigo),
    FOREIGN KEY (codigo_pessoa) REFERENCES pessoa(codigo)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO lancamento (descricao, data_vencimento, data_pagamento, valor, tipo, codigo_categoria, codigo_pessoa) VALUES
('Compra de materiais de escritório', '2025-03-01', '2025-03-02', 150.00, 'DESPESA', 1, 4),
('Venda de produtos', '2025-03-05', '2025-03-06', 500.00, 'RECEITA', 2, 2),
('Pagamento de aluguel', '2025-03-10', '2025-03-10', 1200.00, 'DESPESA', 3, 3),
('Serviço de consultoria', '2025-03-15', '2025-03-16', 800.00, 'RECEITA', 4, 4),
('Compra de equipamentos', '2025-03-20', '2025-03-21', 2000.00, 'DESPESA', 5, 5),
('Venda de software', '2025-03-25', '2025-03-26', 3000.00, 'RECEITA', 6, 6),
('Pagamento de salários', '2025-03-30', '2025-03-30', 5000.00, 'DESPESA', 7, 7),
('Recebimento de dividendos', '2025-04-01', '2025-04-02', 1000.00, 'RECEITA', 7, 8),
('Compra de suprimentos', '2025-04-05', '2025-04-06', 250.00, 'DESPESA', 14, 9),
('Venda de serviços', '2025-04-10', '2025-04-11', 1500.00, 'RECEITA', 2, 10),
('Pagamento de impostos', '2025-04-15', '2025-04-15', 750.00, 'DESPESA', 1, 11),
('Recebimento de aluguel', '2025-04-20', '2025-04-21', 2000.00, 'RECEITA', 6, 5),
('Compra de móveis', '2025-04-25', '2025-04-26', 1200.00, 'DESPESA', 13, 4),
('Venda de produtos digitais', '2025-04-30', '2025-05-01', 2500.00, 'RECEITA', 14, 2),
('Pagamento de fornecedores', '2025-05-05', '2025-05-05', 1800.00, 'DESPESA', 1, 7);