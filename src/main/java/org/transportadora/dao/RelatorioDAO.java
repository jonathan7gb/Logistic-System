package org.transportadora.dao;

import org.transportadora.dao.interfaces.RelatorioDaoInterface;
import org.transportadora.model.Cliente;
import org.transportadora.model.Entrega;
import org.transportadora.model.Motorista;
import org.transportadora.model.Pedido;
import org.transportadora.model.enums.Estado;
import org.transportadora.model.enums.StatusEntrega;
import org.transportadora.repository.ConnectDatabase;
import org.transportadora.service.ClienteService;
import org.transportadora.service.MotoristaService;
import org.transportadora.service.PedidoService;
import org.transportadora.view.MessagesHelper;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RelatorioDAO implements RelatorioDaoInterface {

    PedidoService pedidoService = new PedidoService();
    ClienteService clienteService = new ClienteService();

    //========================================================================================

    //TOTAL DE ENTREGAS POR MOTORISTA
    public int totalEntregasPorMotorista(int motoristaId) throws SQLException{
        String sql = "SELECT COUNT(*) FROM Entrega WHERE motorista_id = ?";
        try (Connection conn = ConnectDatabase.connect();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, motoristaId);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt(1);
                }
            }
        }
        return 0;
    }


    //========================================================================================


    //CLIENTES COM MAIOR VOLUME DE ENTREGA
    public List<Map.Entry<Cliente, Double>> clientesComMaiorVolumeEntrega() throws SQLException {
        Map<Cliente, Double> clientesVolume = new HashMap<>();

        String sql = """
            SELECT c.id AS cliente_id, SUM(p.volume_m3) AS total_volume
            FROM Cliente c
            JOIN Pedido p ON p.cliente_id = c.id
            WHERE p.status = 'ENTREGUE'
            GROUP BY c.id
            ORDER BY total_volume DESC
        """;

        try (Connection conn = ConnectDatabase.connect();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                int clienteId = rs.getInt("cliente_id");
                double totalVolume = rs.getDouble("total_volume");

                Cliente cliente = clienteService.verifyIfExistsCliente(clienteId);
                if (cliente != null) {
                    clientesVolume.put(cliente, totalVolume);
                }
            }
        }
        List<Map.Entry<Cliente, Double>> ranking = new ArrayList<>(clientesVolume.entrySet());
        ranking.sort((a, b) -> Double.compare(b.getValue(), a.getValue()));

        return ranking;
    }


    //========================================================================================


    //TOTAL DE PEDIDOS PENDENTES POR ESTADO
    public Map<Estado, Integer> totalPedidosPendentePorEstado() throws SQLException {
        Map<Estado, Integer> pedidosPorEstado = new HashMap<>();

        String sql = """
                SELECT c.estado, COUNT(*) AS total
                   FROM Pedido p
                   JOIN Cliente c ON p.cliente_id = c.id
                   WHERE p.status = 'PENDENTE'
                   GROUP BY c.estado
                """;

        try (Connection conn = ConnectDatabase.connect();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                String estadoStr = rs.getString("estado");
                int total = rs.getInt("total");

                try {
                    Estado estado = Estado.valueOf(estadoStr);
                    pedidosPorEstado.put(estado, total);
                } catch (IllegalArgumentException e) {
                    MessagesHelper.error("Estado inválido encontrado no banco: " + estadoStr);
                }
            }
        }

        return pedidosPorEstado;
    }


    //========================================================================================


    //TOTAL DE ENTREGAS ATRASADAS POR CIDADE
    public Map<String, Integer> totalEntregasAtrasadasPorCidade() throws SQLException{

        Map<String, Integer> entregasAtrasadas = new HashMap<>();

        String sql = """
            SELECT c.cidade, COUNT(*) AS total
            FROM Entrega e
            JOIN Pedido p ON e.pedido_id = p.id
            JOIN Cliente c ON p.cliente_id = c.id
            WHERE e.status = 'ATRASADA'
            GROUP BY c.cidade
           """;

        try (Connection conn = ConnectDatabase.connect();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                String cidade = rs.getString(
                        "cidade");
                int total = rs.getInt("total");

                try {
                    entregasAtrasadas.put(cidade, total);
                } catch (IllegalArgumentException e) {
                    MessagesHelper.error("Cidade inválida encontrada no banco: " + cidade);
                }
            }
        }

        return entregasAtrasadas;
    }


}
