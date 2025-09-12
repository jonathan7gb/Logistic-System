package org.transportadora.service;

import org.transportadora.dao.PedidoDAO;
import org.transportadora.model.Pedido;
import org.transportadora.model.Pedido;
import org.transportadora.view.utils.PedidoList;
import org.transportadora.view.utils.PedidoRegister;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PedidoService {
    PedidoDAO pedidoDAO =  new PedidoDAO();
    PedidoList pedidoList = new PedidoList();

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

    public void getAllPedidos(){
        List<Pedido> pedidos = new ArrayList<>();

        try{
            pedidos = pedidoDAO.getAllPedidos();

            if(pedidos.isEmpty()){
                System.out.println("\n|| ==== Nenhum pedido cadastrado no sistema. ==== ||");
            }else{
                pedidoList.PrintPedidoList(pedidos);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
