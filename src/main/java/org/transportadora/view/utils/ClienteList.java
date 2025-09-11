package org.transportadora.view.utils;

import org.transportadora.model.Cliente;

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
            System.out.println("\n|| <=== ERRO AO LISTAR OS USUÁRIOS ===> ||");
        }
    }
}
