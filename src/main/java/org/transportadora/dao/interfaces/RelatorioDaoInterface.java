package org.transportadora.dao.interfaces;

import org.transportadora.model.Cliente;
import org.transportadora.model.Pedido;
import org.transportadora.model.enums.Estado;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public interface RelatorioDaoInterface {

    int totalEntregasPorMotorista(int MotoristaId) throws SQLException;
    List<Map.Entry<Cliente, Double>> clientesComMaiorVolumeEntrega() throws SQLException;
    Map<Estado, Integer> totalPedidosPendentePorEstado() throws SQLException;
//    Map<String, Integer> totalEntregasAtrasadasPorCidade() throws SQLException;

}
