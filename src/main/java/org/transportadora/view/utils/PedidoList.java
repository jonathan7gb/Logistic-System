package org.transportadora.view.utils;

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

    public static boolean confirmDelete(){
        System.out.println("\n|| - Tem certeza que deseja excluir esse pedido?\n|| - Os pedidos e entregas vinculadas a ele também serão excluídos!!\n|| - Essa ação é irreversível!");
        System.out.println("|| =====================================================");
        System.out.println("|| 1 - SIM\n|| 2 - NÃO");
        int escolha = InputHelper.inputInteger("|| Escolha uma opção: ", scannerInt);

        if(escolha == 1){
            return true;
        } else {
            return false;
        }
    }
}
