package org.transportadora.dao;

import org.transportadora.dao.interfaces.PedidoDaoInterface;
import org.transportadora.model.Pedido;
import org.transportadora.model.enums.Estado;
import org.transportadora.model.enums.StatusPedido;
import org.transportadora.repository.ConnectDatabase;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class PedidoDAO implements PedidoDaoInterface {

    public void pedidoRegister(Pedido pedido) throws SQLException{
        String sqlComand = "INSERT INTO Pedido (cliente_id, data_pedido, volume_m3, peso_kg, status) VALUES (?, ?, ?, ?, ?)";


        try(Connection conn = ConnectDatabase.connect(); PreparedStatement stmt = conn.prepareStatement(sqlComand)) {
            stmt.setInt(1, pedido.getCliente().getId());
            stmt.setDate(2, new java.sql.Date(pedido.getDataPedido().getTime()));
            stmt.setDouble(3, pedido.getVolume_m3());
            stmt.setDouble(4, pedido.getPeso_kg());
            stmt.setString(5, String.valueOf(pedido.getStatus()));
            stmt.executeUpdate();
            System.out.println("\n|| ====== PEDIDO CADASTRADO COM SUCESSO! ====== ||");
        }
    }


//    public List<Pedido> getAllPedidos() throws SQLException{
//        List<Pedido> lista_pedidos = new ArrayList<>();
//
//        String sqlComand = """
//                    SELECT p.id, c.nome, p.data_pedido, p.volume_m3, p.peso_kg, p.status
//                    FROM Pedido p
//                    JOIN Cliente c ON p.cliente_id = c.id
//                    """;
//
//        try(Connection conn = ConnectDatabase.connect(); PreparedStatement stmt = conn.prepareStatement(sqlComand)) {
//            ResultSet rs = stmt.executeQuery();
//            while(rs.next()){
//                int id = rs.getInt("p.id");
//                String clienteNome = rs.getString("c.nome");
//                String data_pedido = rs.getString("p.data_pedido");
//                Double volume_m3 = rs.getDouble("p.volume_m3");
//                Double peso_kg = rs.getDouble("p.peso_kg");
//                String status = rs.getString("p.status");
//
//                Pedido pedido = new Pedido(id, cliente_id, data_pedido, volume_m3, peso_kg, StatusPedido.valueOf(status));
//                lista_pedidos.add(pedido);
//            }
//        }
//
//        return lista_pedidos;
//    }


//    public List<Pedido> getPedidoByCpfCnpjOrNameCliente(String cpfOrName)  throws SQLException {
//        List<Pedido> lista_pedidos = new ArrayList<>();
//
//        String sqlComand = """
//               SELECT p.id, p.cliente_id, p.data_pedido, p.volume_m3, p.peso_kg, p.status
//               FROM Pedido p
//               JOIN Cliente c ON p.cliente_id = c.id
//               WHERE c.cpf_cnpj = ?;
//                """;
//
//        try (Connection conn = ConnectDatabase.connect(); PreparedStatement stmt = conn.prepareStatement(sqlComand)) {
//            stmt.setString(1, cpfOrName);
//            stmt.setString(2, "%" + cpfOrName + "%");
//
//            ResultSet rs = stmt.executeQuery();
//            while (rs.next()) {
//                int id = rs.getInt("id");
//                int cliente_id = rs.getInt("cliente_id");
//                String data_pedido = rs.getString("data_pedido");
//                String volume_m3 = rs.getString("volume_m3");
//                String peso_kg = rs.getString("peso_kg");
//                String estado = rs.getString("status");
//
//                Pedido pedido = new Pedido(id, cliente_id, data_pedido, volume_m3, peso_kg, Estado.valueOf(estado));
//                lista_pedidos.add(pedido);
//            }
//        }
//
//        return lista_pedidos;
//    }
//
//
//    public boolean cancelPedido(String cpfCnpj)  throws SQLException{
//        String sqlComand = "DELETE FROM Pedido WHERE data_pedido = ?";
//        boolean excluido = false;
//
//        try (Connection conn = ConnectDatabase.connect(); PreparedStatement stmt = conn.prepareStatement(sqlComand)) {
//            stmt.setString(1, cpfCnpj);
//            stmt.executeUpdate();
//            excluido = true;
//        }
//
//        return excluido;
//    }

}

