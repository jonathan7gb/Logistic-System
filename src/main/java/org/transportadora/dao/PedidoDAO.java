package org.transportadora.dao;

import org.transportadora.dao.interfaces.PedidoDaoInterface;
import org.transportadora.model.Cliente;
import org.transportadora.model.Pedido;
import org.transportadora.model.enums.StatusPedido;
import org.transportadora.repository.ConnectDatabase;
import org.transportadora.service.ClienteService;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class PedidoDAO implements PedidoDaoInterface {

    ClienteService clienteService = new ClienteService();

    public void pedidoRegister(Pedido pedido) throws SQLException{
        String sqlComand = "INSERT INTO Pedido (cliente_id, data_pedido, volume_m3, peso_kg, status) VALUES (?, ?, ?, ?, ?)";


        try(Connection conn = ConnectDatabase.connect(); PreparedStatement stmt = conn.prepareStatement(sqlComand)) {
            stmt.setInt(1, pedido.getCliente().getId());
            stmt.setDate(2, new java.sql.Date(pedido.getDataPedido().getTime()));
            stmt.setDouble(3, pedido.getVolume_m3());
            stmt.setDouble(4, pedido.getPeso_kg());
            stmt.setString(5, String.valueOf(pedido.getStatus()));
            stmt.executeUpdate();
        }
    }


    public List<Pedido> getAllPedidos() throws SQLException{
        List<Pedido> lista_pedidos = new ArrayList<>();

        String sqlComand = "SELECT id, cliente_id, data_pedido, volume_m3, peso_kg, status FROM Pedido";

        try(Connection conn = ConnectDatabase.connect(); PreparedStatement stmt = conn.prepareStatement(sqlComand)) {
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                int id = rs.getInt("id");
                int cliente_id = rs.getInt("cliente_id");
                Date data_pedido = rs.getDate("data_pedido");
                Double volume_m3 = rs.getDouble("volume_m3");
                Double peso_kg = rs.getDouble("peso_kg");
                String status = rs.getString("status");

                Cliente cliente = clienteService.verifyIfExistsCliente(cliente_id);
                if(cliente == null) {
                    System.out.println("Cliente com ID " + cliente_id + " não encontrado. Pulando este pedido.");
                    continue; // Pula para a próxima iteração do loop
                }else{
                    Pedido pedido = new Pedido(id, cliente, data_pedido, volume_m3, peso_kg, StatusPedido.valueOf(status));
                    lista_pedidos.add(pedido);
                }

            }
        }

        return lista_pedidos;
    }


    public List<Pedido> getPedidoByCpfCnpjOrNameCliente(String cpfOrName)  throws SQLException {
        List<Pedido> lista_pedidos = new ArrayList<>();

        String sqlComand = """
               SELECT p.id, p.cliente_id, c.nome, p.data_pedido, p.volume_m3, p.peso_kg, p.status
               FROM Pedido p
               JOIN Cliente c ON p.cliente_id = c.id
               WHERE c.cpf_cnpj = ? or c.nome LIKE ?;
                """;

        try (Connection conn = ConnectDatabase.connect(); PreparedStatement stmt = conn.prepareStatement(sqlComand)) {
            stmt.setString(1, cpfOrName);
            stmt.setString(2, "%" + cpfOrName + "%");

            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                int cliente_id = rs.getInt("cliente_id");
                Date data_pedido = rs.getDate("data_pedido");
                double volume_m3 = rs.getDouble("volume_m3");
                double peso_kg = rs.getDouble("peso_kg");
                String status = rs.getString("status");

                Cliente cliente = clienteService.verifyIfExistsCliente(cliente_id);
                if(cliente == null) {
                    System.out.println("Cliente com ID " + cliente_id + " não encontrado. Pulando este pedido.");
                    continue; // Pula para a próxima iteração do loop
                }else{
                    Pedido pedido = new Pedido(id, cliente, data_pedido, volume_m3, peso_kg, StatusPedido.valueOf(status));
                    lista_pedidos.add(pedido);
                }
            }
        }

        return lista_pedidos;
    }

    public boolean deliverPedido(int idPedido)  throws SQLException{
        String sqlComand = "UPDATE Pedido SET status = 'ENTREGUE' WHERE id = ? AND status != 'CANCELADO'";

        try (Connection conn = ConnectDatabase.connect(); PreparedStatement stmt = conn.prepareStatement(sqlComand)) {
            stmt.setInt(1, idPedido);
            int rows = stmt.executeUpdate(); // pega quantas linhas foram afetadas
            return rows > 0;
        }

    }

    public boolean cancelPedido(int idPedido)  throws SQLException{
        String sqlComand = "UPDATE Pedido SET status = 'CANCELADO' WHERE id = ? AND status != 'ENTREGUE'";

        try (Connection conn = ConnectDatabase.connect(); PreparedStatement stmt = conn.prepareStatement(sqlComand)) {
            stmt.setInt(1, idPedido);
            int rows = stmt.executeUpdate(); // pega quantas linhas foram afetadas
            return rows > 0;
        }

    }

    public boolean deletePedido(int idPedido)  throws SQLException{
        String sqlComand = "DELETE FROM Pedido WHERE id = ?";
        boolean excluido = false;

        try (Connection conn = ConnectDatabase.connect(); PreparedStatement stmt = conn.prepareStatement(sqlComand)) {
            stmt.setInt(1, idPedido);
            stmt.executeUpdate();
            excluido = true;
        }

        return excluido;
    }

}

