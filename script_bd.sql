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
select *  from Entrega;
SELECT e.id AS entrega_id,
       e.data_saida,
       e.data_entrega,
       e.status,
       p.id AS pedido_id,
       p.data_pedido,
	   c.nome AS cliente_nome,
       m.nome AS motorista_nome
FROM Entrega e
JOIN Pedido p ON e.pedido_id = p.id
JOIN Cliente c  ON p.cliente_id = c.id
JOIN Motorista m ON e.motorista_id = m.id;

CREATE TABLE HistoricoEntrega (
    id INT AUTO_INCREMENT PRIMARY KEY,
    entrega_id INT NOT NULL,
    data_evento DATETIME NOT NULL,
    descricao VARCHAR(255),
    FOREIGN KEY (entrega_id) REFERENCES Entrega(id) ON DELETE CASCADE
);
select * from HistoricoEntrega;


DELIMITER //

-- Trigger para registrar novas entregas
CREATE TRIGGER after_insert_entrega
AFTER INSERT ON Entrega
FOR EACH ROW
BEGIN
    INSERT INTO HistoricoEntrega (entrega_id, data_evento, descricao)
    VALUES (NEW.id, NOW(), CONCAT('Entrega criada. Status inicial: ', NEW.status));
END;
//

-- Trigger para registrar mudanças no status ou dados da entrega
CREATE TRIGGER after_update_entrega
AFTER UPDATE ON Entrega
FOR EACH ROW
BEGIN
    INSERT INTO HistoricoEntrega (entrega_id, data_evento, descricao)
    VALUES (NEW.id, NOW(), CONCAT('Entrega atualizada. Status anterior: ', OLD.status, ', Status atual: ', NEW.status));
END;
//

-- Trigger para registrar exclusões de entregas
CREATE TRIGGER before_delete_entrega
BEFORE DELETE ON Entrega
FOR EACH ROW
BEGIN
    INSERT INTO HistoricoEntrega (entrega_id, data_evento, descricao)
    VALUES (OLD.id, NOW(), CONCAT('Entrega excluída. Status final: ', OLD.status));
END;
//

DELIMITER ;

-- Ativa o agendador de eventos (se não tiver ativado ainda)
SET GLOBAL event_scheduler = ON;

-- Cria evento que roda todo dia à meia-noite
CREATE EVENT atualizar_entregas_atrasadas
ON SCHEDULE EVERY 1 DAY
STARTS CURRENT_TIMESTAMP
DO
    UPDATE Entrega
    SET status = 'ATRASADA'
    WHERE status = 'EM_ROTA'
      AND data_entrega < CURDATE();


