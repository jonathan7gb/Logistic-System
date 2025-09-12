CREATE DATABASE IF NOT EXISTS transportadora;
USE transportadora;

CREATE TABLE Cliente (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    cpf_cnpj VARCHAR(20) UNIQUE NOT NULL,
    endereco VARCHAR(150),
    cidade VARCHAR(80),
    estado CHAR(2)
);
select * from Cliente;

CREATE TABLE Motorista (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    cnh VARCHAR(20) UNIQUE NOT NULL,
    veiculo VARCHAR(80),
    cidade_base VARCHAR(80)
);
select * from Motorista;

CREATE TABLE Pedido (
    id INT AUTO_INCREMENT PRIMARY KEY,
    cliente_id INT NOT NULL,
    data_pedido DATE NOT NULL,
    volume_m3 DECIMAL(10,2),
    peso_kg DECIMAL(10,2),
    status ENUM('PENDENTE', 'ENTREGUE', 'CANCELADO') DEFAULT 'PENDENTE',
    FOREIGN KEY (cliente_id) REFERENCES Cliente(id) ON DELETE CASCADE
);
select * from Pedido;

CREATE TABLE Entrega (
    id INT AUTO_INCREMENT PRIMARY KEY,
    pedido_id INT NOT NULL,
    motorista_id INT NOT NULL,
    data_saida DATE,
    data_entrega DATE,
    status ENUM('EM_ROTA', 'ENTREGUE', 'ATRASADA') DEFAULT 'EM_ROTA',
    FOREIGN KEY (pedido_id) REFERENCES Pedido(id) ON DELETE CASCADE,
    FOREIGN KEY (motorista_id) REFERENCES Motorista(id) ON DELETE CASCADE
);

CREATE TABLE HistoricoEntrega (
    id INT AUTO_INCREMENT PRIMARY KEY,
    entrega_id INT NOT NULL,
    data_evento DATETIME NOT NULL,
    descricao VARCHAR(255),
    FOREIGN KEY (entrega_id) REFERENCES Entrega(id) ON DELETE CASCADE
);
