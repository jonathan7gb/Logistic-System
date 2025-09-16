package org.transportadora.view.Entrega;

import org.transportadora.view.InputHelper;

import java.util.Scanner;

public class EntregaDeleteConfim {

    static Scanner scannerInt = new Scanner(System.in);

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
