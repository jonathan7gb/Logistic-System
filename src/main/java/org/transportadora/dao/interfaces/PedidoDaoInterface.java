package org.transportadora.dao.interfaces;

import org.transportadora.model.Pedido;

import java.sql.SQLException;
import java.util.List;

public interface PedidoDaoInterface {

    void pedidoRegister(Pedido pedido)  throws SQLException;
    List<Pedido> getAllPedidos()  throws SQLException;
    List<Pedido> getPedidoByCpfCnpjOrNameCliente(String cpfOrName)  throws SQLException;
    boolean deliverPedido(int idPedido)  throws SQLException;
    boolean cancelPedido(int idPedido)  throws SQLException;
    boolean deletePedido(int idPedido)  throws SQLException;
}
