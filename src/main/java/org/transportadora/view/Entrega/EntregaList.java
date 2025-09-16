package org.transportadora.view.Entrega;

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

    public void PrintEntregaListClienteAndMotorista(List<Entrega> lista_entregas){
        System.out.println("|| ================== LISTA DE ENTREGAS ================== ||");
        try{
            for(Entrega e : lista_entregas){
                Thread.sleep(300);
                System.out.println("|| Entrega ID: " + e.getId() + " | Status: " + e.getStatus());
                System.out.println("|| Cliente: " + e.getPedido().getCliente().getNome() + " | Motorista: " + e.getMotorista().getNome());
                System.out.println("-------------------------------------------------------------");
            }
        }catch (InterruptedException e){
            MessagesHelper.error("ERRO AO LISTAR AS ENTREGAS");
        }
    }
}

