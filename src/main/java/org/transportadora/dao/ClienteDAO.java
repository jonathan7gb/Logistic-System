package org.transportadora.dao;

import org.transportadora.dao.interfaces.ClienteDaoInterface;
import org.transportadora.model.Cliente;
import org.transportadora.repository.ConnectDatabase;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class ClienteDAO implements ClienteDaoInterface {

    public void clienteRegister(Cliente cliente) throws SQLException{
        String sqlComand = "INSERT INTO Cliente (nome, cpf_cnpj, endereco, cidade, estado) VALUES (?, ?, ?, ?, ?)";


        try(Connection conn = ConnectDatabase.connect(); PreparedStatement stmt = conn.prepareStatement(sqlComand)) {
            stmt.setString(1, cliente.getNome());
            stmt.setString(2, cliente.getCpf_cnpj());
            stmt.setString(3, cliente.getEndereco());
            stmt.setString(4, cliente.getCidade());
            stmt.setString(5, String.valueOf(cliente.getEstado()));
            stmt.executeUpdate();
            System.out.println("\n|| ====== CLIENTE CADASTRADO COM SUCESSO! ====== ||");
        }
    }

}

