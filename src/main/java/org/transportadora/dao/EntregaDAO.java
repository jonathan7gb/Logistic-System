package org.transportadora.dao;

import org.transportadora.dao.interfaces.EntregaDaoInterface;
import org.transportadora.model.*;
import org.transportadora.model.enums.StatusEntrega;
import org.transportadora.model.enums.StatusPedido;
import org.transportadora.repository.ConnectDatabase;
import org.transportadora.service.MotoristaService;
import org.transportadora.service.PedidoService;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EntregaDAO implements EntregaDaoInterface {

    PedidoService pedidoService = new PedidoService();
    MotoristaService motoristaService = new MotoristaService();

    //========================================================================================

    //REGISTRAR ENTREGA
    public void entregaRegister(Entrega entrega) throws SQLException {
        String sqlComand = "INSERT INTO Entrega (pedido_id, motorista_id, data_saida, data_entrega, status) VALUES (?, ?, ?, ?, ?)";

        try(Connection conn = ConnectDatabase.connect(); PreparedStatement stmt = conn.prepareStatement(sqlComand)) {
            stmt.setInt(1, entrega.getPedido().getId());
            stmt.setDouble(2, entrega.getMotorista().getId());
            stmt.setDate(3, new java.sql.Date(entrega.getDataSaida().getTime()));
            stmt.setDate(4, new java.sql.Date(entrega.getDataEntrega().getTime()));
            stmt.setString(5, entrega.getStatus().name());
            stmt.executeUpdate();
        }
    }


    //========================================================================================


    //ATUALIZAR STATUS DA ENTREGA PARA ENTREGUE
    public boolean updateEntregaStatus(int idEntrega) throws SQLException{
        String sqlComand = "UPDATE Entrega SET status = 'ENTREGUE' WHERE id = ?";
        boolean atualizado = false;

        try (Connection conn = ConnectDatabase.connect(); PreparedStatement stmt = conn.prepareStatement(sqlComand)) {
            stmt.setInt(1, idEntrega);
            stmt.executeUpdate();
            atualizado = true;
        }
        return atualizado;
    }


    //========================================================================================


    //LISTAR ENTREGA POR ID
    public List<Entrega> getEntregaById(int idEntrega)  throws SQLException{
        List<Entrega> lista_entregas = new ArrayList<>();

        String sqlComand = "SELECT id, pedido_id, motorista_id, data_saida, data_entrega, status FROM Entrega WHERE id = ?";

        try(Connection conn = ConnectDatabase.connect(); PreparedStatement stmt = conn.prepareStatement(sqlComand)) {
            stmt.setInt(1, idEntrega);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                int id = rs.getInt("id");
                int pedido_id = rs.getInt("pedido_id");
                int motorista_id = rs.getInt("motorista_id");
                Date data_saida = rs.getDate("data_saida");
                Date data_entrega = rs.getDate("data_entrega");
                String status = rs.getString("status");

                Pedido pedido = pedidoService.verifyIfExistsPedido(pedido_id);
                Motorista motorista = motoristaService.verifyIfExistsMotorista(motorista_id);
                if(pedido == null) {
                    System.out.println("Pedido com ID " + pedido_id + " não encontrado. Pulando este entrega.");
                    continue;
                }else if(motorista == null){
                    System.out.println("Motorista com ID " + motorista_id + " não encontrado. Pulando este entrega.");
                    continue;
                }else{
                    Entrega entrega = new Entrega(id, pedido, motorista, data_saida, data_entrega, StatusEntrega.valueOf(status));
                    lista_entregas.add(entrega);
                }
            }
        }
        return lista_entregas;
    }


    //========================================================================================


    //LISTAR TODAS AS ENTREGAS
    public List<Entrega> getAllEntregas() throws SQLException{
        List<Entrega> lista_entregas = new ArrayList<>();

        String sqlComand = "SELECT id, pedido_id, motorista_id, data_saida, data_entrega, status FROM Entrega";

        try(Connection conn = ConnectDatabase.connect(); PreparedStatement stmt = conn.prepareStatement(sqlComand)) {
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                int id = rs.getInt("id");
                int pedido_id = rs.getInt("pedido_id");
                int motorista_id = rs.getInt("motorista_id");
                Date data_saida = rs.getDate("data_saida");
                Date data_entrega = rs.getDate("data_entrega");
                String status = rs.getString("status");

                Pedido pedido = pedidoService.verifyIfExistsPedido(pedido_id);
                Motorista motorista = motoristaService.verifyIfExistsMotorista(motorista_id);
                if(pedido == null) {
                    System.out.println("Pedido com ID " + pedido_id + " não encontrado. Pulando este entrega.");
                    continue;
                }else if(motorista == null){
                    System.out.println("Motorista com ID " + motorista_id + " não encontrado. Pulando este entrega.");
                    continue;
                }else{
                    Entrega entrega = new Entrega(id, pedido, motorista, data_saida, data_entrega, StatusEntrega.valueOf(status));
                    lista_entregas.add(entrega);
                }

            }
        }
        return lista_entregas;
    }



    //========================================================================================


    //DELETAR ENTREGA
    public boolean deleteEntrega(int idEntrega)  throws SQLException{
        String sqlComand = "DELETE FROM Entrega WHERE id = ?";
        boolean excluido = false;

        try (Connection conn = ConnectDatabase.connect(); PreparedStatement stmt = conn.prepareStatement(sqlComand)) {
            stmt.setInt(1, idEntrega);
            stmt.executeUpdate();
            excluido = true;
        }
        return excluido;
    }



    //========================================================================================


    //REGISTRAR EVENTO DE ENTREGA
    public void eventoEntregaRegister(HistoricoEntrega historicoEntrega) throws SQLException{
        String sqlComand = "INSERT INTO HistoricoEntrega (entrega_id, data_evento, descricao) VALUES (?, ?, ?)";
        try(Connection conn = ConnectDatabase.connect(); PreparedStatement stmt = conn.prepareStatement(sqlComand)) {
            stmt.setInt(1, historicoEntrega.getEntrega().getId());
            stmt.setDate(2, new java.sql.Date(historicoEntrega.getDataAtualizacao().getTime()));
            stmt.setString(3, historicoEntrega.getDescricao());
            stmt.executeUpdate();
        }
    }

}
