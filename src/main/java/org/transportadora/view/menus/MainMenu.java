package org.transportadora.view.menus;

import org.transportadora.view.InputHelper;

import java.util.Scanner;

public class MainMenu {

    InputHelper inputHelper = new InputHelper();
    Scanner sc = new Scanner(System.in);

    public int mainMenu(){
        System.out.print("""
                || ========= SISTEMA DE TRANSPORTADORA ========
                || 1 - GERENCIAR CLIENTES
                || 2 - GERENCIAR MOTORISTAS
                || 3 - GERENCIAR PEDIDOS
                || 4 - GERENCIAR ENTREGAS
                || 5 - RELATÓRIOS
                || 0 - SAIR DO SISTEMA
                || ============================================
                """);
            int option = inputHelper.inputInteger("|| Escolha uma opção: ", sc);
            return option;
    }
}
