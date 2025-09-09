package org.transportadora.view.menus;

import org.transportadora.view.Inputs;

import java.util.Scanner;

public class ClienteMenus {

    static Scanner sc = new Scanner(System.in);

    public static int menuCliente(){
        System.out.print("""
                || ==================== MENU CLIENTE ==================== ||
                || 1 - CADASTRAR CLIENTE
                || 2 - LISTAR CLIENTES
                || 3 - BUSCAR CLIENTES
                || 4 - EXCLUIR CLIENTE
                || 0 - VOLTAR AO MENU PRINCIPAL
                || =====================================================
                """);
        int opcao = Inputs.inputInteger("|| Escolha uma opção: ", sc);
        return opcao;
    }
}
