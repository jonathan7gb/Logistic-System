package org.transportadora.dao;

import org.transportadora.dao.interfaces.RelatorioDaoInterface;
import org.transportadora.model.Cliente;
import org.transportadora.model.enums.Estado;
import org.transportadora.repository.ConnectDatabase;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class RelatorioDAO implements RelatorioDaoInterface {

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

//    public List<Cliente> clientesComMaiorVolumeEntrega() throws SQLException{
//        List<Cliente> clientes = new ArrayList<>();
//
//        return clientes;
//    }
//
//    public Map<Estado, Integer> totalEntregasPendentePorEstado() throws SQLException{
//
//    }
//
//    public Map<String, Integer> totalEntregasAtrasadasPorCidade() throws SQLException{
//
//    }


}
