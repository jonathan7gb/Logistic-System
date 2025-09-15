package org.transportadora.view.utils;

import org.transportadora.model.Entrega;
import org.transportadora.view.MessagesHelper;

import java.util.List;

public class EntregaList {

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
}

