package org.transportadora.dao;

import org.transportadora.dao.interfaces.MotoristaDaoInterface;
import org.transportadora.model.Motorista;
import org.transportadora.model.enums.Estado;
import org.transportadora.repository.ConnectDatabase;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MotoristaDAO implements MotoristaDaoInterface {

    public void motoristaRegister(Motorista motorista) throws SQLException {
        String sqlComand = "INSERT INTO Motorista (nome, cnh, veiculo, cidade_base) VALUES (?, ?, ?, ?)";


        try(Connection conn = ConnectDatabase.connect(); PreparedStatement stmt = conn.prepareStatement(sqlComand)) {
            stmt.setString(1, motorista.getNome());
            stmt.setString(2, motorista.getCnh());
            stmt.setString(3, motorista.getVeiculo());
            stmt.setString(4, motorista.getCidade_base());
            stmt.executeUpdate();
            System.out.println("\n|| ====== MOTORISTA CADASTRADO COM SUCESSO! ====== ||");
        }
    }


    public List<Motorista> getAllMotoristas() throws SQLException{
        List<Motorista> lista_motoristas = new ArrayList<>();

        String sqlComand = "SELECT id, nome, cnh, veiculo, cidade_base FROM Motorista";

        try(Connection conn = ConnectDatabase.connect(); PreparedStatement stmt = conn.prepareStatement(sqlComand)) {
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                int id = rs.getInt("id");
                String nome = rs.getString("nome");
                String cnh = rs.getString("cnh");
                String veiculo = rs.getString("veiculo");
                String cidade_base = rs.getString("cidade_base");

                Motorista motorista = new Motorista(id, nome, cnh, veiculo, cidade_base);
                lista_motoristas.add(motorista);
            }
        }

        return lista_motoristas;
    }


    public List<Motorista> getMotoristaByCnhOrName(String cnh)  throws SQLException {
        List<Motorista> lista_motoristas = new ArrayList<>();

        String sqlComand = "SELECT id, nome, cnh, veiculo, cidade_base FROM Motorista WHERE cnh = ? OR nome LIKE ?";

        try (Connection conn = ConnectDatabase.connect(); PreparedStatement stmt = conn.prepareStatement(sqlComand)) {
            stmt.setString(1, cnh);
            stmt.setString(2, "%" + cnh + "%");

            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String nome = rs.getString("nome");
                String cnhInserir = rs.getString("cnh");
                String veiculo = rs.getString("veiculo");
                String cidade = rs.getString("cidade_base");

                Motorista motorista = new Motorista(id, nome, cnhInserir, veiculo, cidade);
                lista_motoristas.add(motorista);
            }
        }

        return lista_motoristas;
    }


    public boolean deleteMotorista(String cnh)  throws SQLException{
        String sqlComand = "DELETE FROM Motorista WHERE cnh = ?";
        boolean excluido = false;

        try (Connection conn = ConnectDatabase.connect(); PreparedStatement stmt = conn.prepareStatement(sqlComand)) {
            stmt.setString(1, cnh);
            stmt.executeUpdate();
            excluido = true;
        }

        return excluido;
    }
}
