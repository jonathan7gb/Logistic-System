package org.transportadora.view.utils;

import org.transportadora.view.InputHelper;

import java.util.Scanner;

public class MotoristaSearchByNameOrCnh {

    static Scanner scanner = new Scanner(System.in);
    static Scanner scannerInt = new Scanner(System.in);

    public static String MotoristaNameOrCnh(){
        String nameOrCnh = InputHelper.inputString("|| - Insira o nome ou CNH do motorista: ", scanner);
        System.out.println();
        return nameOrCnh;
    }


    public static boolean confirmDelete(){
        System.out.println("\n|| - Tem certeza que deseja excluir esse motorista?\n|| - Os pedidos e entregas vinculadas a ele também serão excluídos!!\n|| - Essa ação é irreversível!");
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
