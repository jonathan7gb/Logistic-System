package org.transportadora.view.Cliente;

import org.transportadora.model.Cliente;
import org.transportadora.view.MessagesHelper;

import java.util.List;

public class ClienteList {

    public void PrintClienteList(List<Cliente> lista_clientes){
        System.out.println("|| ================== LISTA DE CLIENTES ================== ||");
        try{
        for(Cliente c : lista_clientes){
            Thread.sleep(300);
            System.out.println(c);
            System.out.println("-------------------------------------------------------------");
        }
        }catch (InterruptedException e){
            MessagesHelper.error("ERRO AO LISTAR OS CLIENTES");
        }
    }
}
