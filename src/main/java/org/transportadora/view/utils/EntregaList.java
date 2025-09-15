package org.transportadora.view.utils;

import org.transportadora.model.Entrega;
import org.transportadora.view.InputHelper;
import org.transportadora.view.MessagesHelper;

import java.util.List;
import java.util.Scanner;

public class EntregaList {

    static Scanner scannerInt = new Scanner(System.in);

    public void PrintEntregaList(List<Entrega> lista_entregas){
        System.out.println("|| ================== LISTA DE ENTREGAS ================== ||");
        try{
            for(Entrega e : lista_entregas){
                Thread.sleep(300);
                System.out.println(e);
                System.out.println("-------------------------------------------------------------");
            }
        }catch (InterruptedException e){
            MessagesHelper.error("ERRO AO LISTAR AS ENTREGAS");
        }
    }


    public static boolean confirmDelete(){
        System.out.println("\n|| - Tem certeza que deseja excluir essa entrega?\n|| - Os eventos de entrega vinculadas a ela também serão excluídas!!\n|| - Essa ação é irreversível!");
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

