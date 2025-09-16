package org.transportadora.controller;

import org.transportadora.service.EntregaService;
import org.transportadora.view.MessagesHelper;
import org.transportadora.view.Entrega.EntregaMenus;

public class EntregaController {

    public static void entregaController() {
        int option = -1;
        EntregaService entregaService = new EntregaService();

        do {
            option = EntregaMenus.EntregaMenu();

            switch (option) {
                case 1 -> {
                    entregaService.registerEntrega();
                } //BREAK CASE 1 DO SWITCH OPCAO - GERAR ENTREGA

                case 2 -> {
                    entregaService.listEntregaByCpfCnpjOrCnh();
                }//BREAK CASE 2 DO SWITCH OPCAO - LISTAR ENTREGAS DE CLIENTE E MOTORISTA

                case 3 -> {
                    entregaService.getAllEntregas();
                }//BREAK CASE 3 DO SWITCH OPCAO - LISTAR TODAS AS ENTREGAS

                case 4 -> {
                    entregaService.searchEntregaById();
                }//BREAK CASE 4 DO SWITCH OPCAO - BUSCAR ENTREGA POR ID

                case 5 -> {
                    entregaService.addEventoEntrega();
                }//BREAK CASE 5 DO SWITCH OPCAO - REGISTRAR EVENTO DE ENTREGA

                case 6 -> {
                    entregaService.updateEntregaStatus();
                }//BREAK CASE 6 DO SWITCH OPCAO - ATUALIZAR STATUS DE ENTREGA PARA ENTREGUE

                case 7 -> {
                    entregaService.deleteEntrega();
                }//BREAK CASE 7 DO SWITCH OPCAO - EXCLUIR ENTREGA

                case 0 -> {
                    return;
                }//BREAK CASE 0 DO SWITCH OPCAO - SAIR DO MENU ENTREGA

                default -> {
                    MessagesHelper.error(" Opção inválida! Tente novamente.\n");
                } //BREAK DEFAULT DO SWITCH OPCAO - OPÇÃO INVÁLIDA
            }
        }while(true);

    }
}
