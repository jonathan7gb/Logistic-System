package org.transportadora.view.utils;

import org.transportadora.view.Inputs;

import java.util.Scanner;

public class ClientSearchByNameOrCpf {

    static Scanner scanner = new Scanner(System.in);
    static Scanner scannerInt = new Scanner(System.in);

    public static String ClienteNameOrCpf(){
        String nameOrCpf = Inputs.inputString("|| - Insira o nome ou CPF/CNPJ do cliente: ", scanner);
        System.out.println();
        return nameOrCpf;
    }


    public static boolean confirmDelete(){
        System.out.println("\n|| - Tem certeza que deseja excluir esse cliente?\n|| - Os pedidos e entregas vinculadas a ele também serão excluídos!!\n|| - Essa ação é irreversível!");
        System.out.println("|| =====================================================");
        System.out.println("|| 1 - SIM\n|| 2 - NÃO");
        int escolha = Inputs.inputInteger("|| Escolha uma opção: ", scannerInt);

        if(escolha == 1){
            return true;
        } else {
            return false;
        }
    }
}
