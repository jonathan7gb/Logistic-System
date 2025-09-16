package org.transportadora.view.Pedido;

import org.transportadora.model.Pedido;
import org.transportadora.view.InputHelper;
import org.transportadora.view.MessagesHelper;

import java.util.List;
import java.util.Scanner;

public class PedidoList {

    static Scanner scannerInt = new Scanner(System.in);

    public void PrintPedidoList(List<Pedido> lista_pedidos){
        System.out.println("|| ======================== LISTA DE PEDIDOS ======================== ||");
        try{
        for(Pedido p : lista_pedidos){
            Thread.sleep(300);
            System.out.println(p);
            System.out.println("-----------------------------------------------------------------------");
        }
        }catch (InterruptedException e){
            MessagesHelper.error("ERRO AO LISTAR OS PEDIDOS");
        }
    }
}
