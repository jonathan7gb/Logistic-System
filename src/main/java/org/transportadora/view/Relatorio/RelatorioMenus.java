package org.transportadora.view.Relatorio;

import org.transportadora.view.InputHelper;

import java.util.Scanner;

public class RelatorioMenus {

    static Scanner sc = new Scanner(System.in);

    public static int RelatorioMenu(){


        System.out.print("""
                \n|| ==================== MENU RELATÓRIOS ==================== ||
                || 1 - TOTAL DE ENTREGAS POR MOTORISTA
                || 2 - CLIENTES COM MAIOR VOLUME ENTREGUE
                || 3 - PEDIDOS PENDENTES POR ESTADO
                || 4 - ENTREGAS ATRASADAS POR CIDADE
                || 0 - VOLTAR AO MENU PRINCIPAL
                || =====================================================
                """);
        int opcao = InputHelper.inputInteger("|| Escolha uma opção: ", sc);
        System.out.println();
        return opcao;
    }

}
