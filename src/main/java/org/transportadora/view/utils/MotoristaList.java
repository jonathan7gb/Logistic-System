package org.transportadora.view.utils;

import org.transportadora.model.Motorista;

import java.util.List;

public class MotoristaList {

    public void PrintMotoristaList(List<Motorista> lista_motoristas){
        System.out.println("|| ================== LISTA DE MOTORISTAS ================== ||");
        try{
        for(Motorista m : lista_motoristas){
            Thread.sleep(300);
            System.out.println(m);
            System.out.println("-------------------------------------------------------------");
        }
        }catch (InterruptedException e){
            System.out.println("\n|| <=== ERRO AO LISTAR OS MOTORISTAS ===> ||");
        }
    }
}
