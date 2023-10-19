
-- Tabela de Clientes
CREATE TABLE IF NOT EXISTS clientes (
    id_cliente INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(255),
    sobrenome VARCHAR(255),
    endereco VARCHAR(255),
    email VARCHAR(255),
    telefone VARCHAR(20),
    outras_informacoes TEXT
);

---- Tabela de Consultores
--CREATE TABLE IF NOT EXISTS consultores (
--    id_consultor INT AUTO_INCREMENT PRIMARY KEY,
--    nome VARCHAR(255),
--    sobrenome VARCHAR(255),
--    especializacao VARCHAR(255),
--    email VARCHAR(255),
--    telefone VARCHAR(20),
--    outras_informacoes TEXT
--);
--
---- Tabela de Tipos de Consultoria
--CREATE TABLE IF NOT EXISTS tipos_consultoria (
--    id_tipo_consultoria INT AUTO_INCREMENT PRIMARY KEY,
--    nome_tipo_consultoria VARCHAR(255),
--    descricao TEXT,
--    taxa_por_hora DECIMAL(10,2)
--);
--
---- Tabela de Agendamentos
--CREATE TABLE IF NOT EXISTS agendamentos (
--    id_agendamento INT AUTO_INCREMENT PRIMARY KEY,
--    id_cliente INT,
--    id_consultor INT,
--    id_tipo_consultoria INT,
--    id_projeto INT,
--    data_hora DATETIME,
--    observacoes TEXT,
--    status_agendamento VARCHAR(255),
--    FOREIGN KEY (id_cliente) REFERENCES clientes(id_cliente),
--    FOREIGN KEY (id_consultor) REFERENCES consultores(id_consultor),
--    FOREIGN KEY (id_tipo_consultoria) REFERENCES tipos_consultoria(id_tipo_consultoria)
--);
--
---- Tabela de Pagamentos
--CREATE TABLE IF NOT EXISTS pagamentos (
--    id_pagamento INT AUTO_INCREMENT PRIMARY KEY,
--    id_agendamento INT,
--    valor_pago DECIMAL(10,2),
--    data_pagamento DATE,
--    metodo_pagamento VARCHAR(255),
--    FOREIGN KEY (id_agendamento) REFERENCES agendamentos(id_agendamento)
--);
--
---- Tabela de Projetos
--CREATE TABLE IF NOT EXISTS projetos (
--    id_projeto INT AUTO_INCREMENT PRIMARY KEY,
--    nome_projeto VARCHAR(255),
--    descricao_projeto TEXT,
--    id_gerente_responsavel INT,
--    FOREIGN KEY (id_gerente_responsavel) REFERENCES gerentes(id_gerente)
--);
--
---- Tabela de Gerentes
--CREATE TABLE IF NOT EXISTS gerentes (
--    id_gerente INT AUTO_INCREMENT PRIMARY KEY,
--    nome VARCHAR(255),
--    sobrenome VARCHAR(255),
--    email VARCHAR(255),
--    telefone VARCHAR(20),
--    outras_informacoes TEXT
--);
--
---- Tabela de Produtos
--CREATE TABLE IF NOT EXISTS produtos (
--    id_produto INT AUTO_INCREMENT PRIMARY KEY,
--    nome_produto VARCHAR(255),
--    descricao_produto TEXT,
--    outras_informacoes TEXT
--);
--
---- Tabela de Produtos Aptos
--CREATE TABLE IF NOT EXISTS produtos_aptos (
--    id_relacionamento INT AUTO_INCREMENT PRIMARY KEY,
--    id_consultor INT,
--    id_produto INT,
--    FOREIGN KEY (id_consultor) REFERENCES consultores(id_consultor),
--    FOREIGN KEY (id_produto) REFERENCES produtos(id_produto)
--);
