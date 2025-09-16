package org.transportadora.dao;

import org.transportadora.dao.interfaces.ClienteDaoInterface;
import org.transportadora.model.Cliente;
import org.transportadora.model.enums.Estado;
import org.transportadora.repository.ConnectDatabase;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class ClienteDAO implements ClienteDaoInterface {


    //REGISTRAR CLIENTE
    public void clienteRegister(Cliente cliente) throws SQLException{
        String sqlComand = "INSERT INTO Cliente (nome, cpf_cnpj, endereco, cidade, estado) VALUES (?, ?, ?, ?, ?)";

        try(Connection conn = ConnectDatabase.connect(); PreparedStatement stmt = conn.prepareStatement(sqlComand)) {
            stmt.setString(1, cliente.getNome());
            stmt.setString(2, cliente.getCpf_cnpj());
            stmt.setString(3, cliente.getEndereco());
            stmt.setString(4, cliente.getCidade());
            stmt.setString(5, String.valueOf(cliente.getEstado()));
            stmt.executeUpdate();
        }
    }


    //========================================================================================


    //LISTAR CLIENTES
    public List<Cliente> getAllClientes() throws SQLException{
        List<Cliente> lista_clientes = new ArrayList<>();

        String sqlComand = "SELECT id, nome, cpf_cnpj, endereco, cidade, estado FROM Cliente";

        try(Connection conn = ConnectDatabase.connect(); PreparedStatement stmt = conn.prepareStatement(sqlComand)) {
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                int id = rs.getInt("id");
                String nome = rs.getString("nome");
                String cpf_cnpj = rs.getString("cpf_cnpj");
                String endereco = rs.getString("endereco");
                String cidade = rs.getString("cidade");
                String estado = rs.getString("estado");

                Cliente cliente = new Cliente(id, nome, cpf_cnpj, endereco, cidade, Estado.valueOf(estado));
                lista_clientes.add(cliente);
            }
        }
        return lista_clientes;
    }


    //========================================================================================


    //VER SE O CLIENTE EXISTE NO BANCO
    public Cliente getClienteById(int id) throws SQLException {
        String sql = "SELECT id, nome, cpf_cnpj, endereco, cidade, estado FROM Cliente WHERE id = ?";
        try (Connection conn = ConnectDatabase.connect();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    Estado estado = Estado.valueOf(rs.getString("estado"));
                    return new Cliente(
                            rs.getInt("id"),
                            rs.getString("nome"),
                            rs.getString("cpf_cnpj"),
                            rs.getString("endereco"),
                            rs.getString("cidade"),
                            estado
                    );
                }
            }
        }
        return null;
    }


    //========================================================================================


    //BUSCAR CLIENTE POR CPF/CNPJ OU NOME
    public List<Cliente> getClienteByCpfCnpjOrName(String cpfOrName)  throws SQLException {
        List<Cliente> lista_clientes = new ArrayList<>();

        String sqlComand = "SELECT id, nome, cpf_cnpj, endereco, cidade, estado FROM Cliente WHERE cpf_cnpj = ? OR nome LIKE ?";

        try (Connection conn = ConnectDatabase.connect(); PreparedStatement stmt = conn.prepareStatement(sqlComand)) {
            stmt.setString(1, cpfOrName);
            stmt.setString(2, "%" + cpfOrName + "%");

            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String nome = rs.getString("nome");
                String cpf_cnpj = rs.getString("cpf_cnpj");
                String endereco = rs.getString("endereco");
                String cidade = rs.getString("cidade");
                String estado = rs.getString("estado");

                Cliente cliente = new Cliente(id, nome, cpf_cnpj, endereco, cidade, Estado.valueOf(estado));
                lista_clientes.add(cliente);
            }
        }
        return lista_clientes;
    }


    //========================================================================================


    //DELETAR CLIENTE
    public boolean deleteCliente(String cpfCnpj)  throws SQLException{
        String sqlComand = "DELETE FROM Cliente WHERE cpf_cnpj = ?";
        boolean excluido = false;

        try (Connection conn = ConnectDatabase.connect(); PreparedStatement stmt = conn.prepareStatement(sqlComand)) {
            stmt.setString(1, cpfCnpj);
            stmt.executeUpdate();
            excluido = true;
        }
        return excluido;
    }

}

