package org.transportadora.controller;

import org.transportadora.service.RelatorioService;
import org.transportadora.view.MessagesHelper;
import org.transportadora.view.menus.RelatorioMenus;

public class RelatorioController {

    public static void relatorioController() {
        int option = -1;
        RelatorioService relatorioService = new RelatorioService();

        do {
            option = RelatorioMenus.RelatorioMenu();

            switch (option) {
                case 1 -> {

                } //BREAK CASE 1 DO SWITCH OPCAO - TOTAL DE ENTREGAS POR MOTORISTA

                case 2 -> {
                }//BREAK CASE 2 DO SWITCH OPCAO - CLIENTES COM MAIOR VOLUME ENTREGUE

                case 3 -> {
                }//BREAK CASE 3 DO SWITCH OPCAO - PEDIDOS PENDENTES POR ESTADO

                case 4 -> {
                }//BREAK CASE 4 DO SWITCH OPCAO - ENTREGAS ATRASADAS POR CIDADE

                case 0 -> {
                    return;
                }//BREAK CASE 0 DO SWITCH OPCAO - SAIR DO MENU RELATÓRIOS

                default -> {
                    MessagesHelper.error(" Opção inválida! Tente novamente.\n");
                } //BREAK DEFAULT DO SWITCH OPCAO - OPÇÃO INVÁLIDA
            }
        }while(true);

    }
}
