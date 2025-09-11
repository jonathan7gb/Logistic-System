package org.transportadora.service;

import org.transportadora.dao.PedidoDAO;
import org.transportadora.model.Pedido;
import org.transportadora.view.utils.PedidoRegister;

import java.sql.SQLException;

public class PedidoService {
    PedidoDAO pedidoDAO =  new PedidoDAO();

    public void registerPedido(){
        boolean cadastroConcluido = false;
        while(!cadastroConcluido){
            Pedido pedido = PedidoRegister.registerPedido();

            try{
                pedidoDAO.pedidoRegister(pedido);
                cadastroConcluido = true;
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
    }
}
