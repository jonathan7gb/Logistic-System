package org.transportadora.view.utils;

import org.transportadora.model.Cliente;
import org.transportadora.model.Pedido;

import java.util.List;

public class PedidoList {

    public void PrintPedidoList(List<Pedido> lista_pedidos){
        System.out.println("|| ======================== LISTA DE PEDIDOS ======================== ||");
        try{
        for(Pedido p : lista_pedidos){
            Thread.sleep(300);
            System.out.println(p);
            System.out.println("-----------------------------------------------------------------------");
        }
        }catch (InterruptedException e){
            System.out.println("\n|| <=== ERRO AO LISTAR OS PEDIDOS ===> ||");
        }
    }
}
