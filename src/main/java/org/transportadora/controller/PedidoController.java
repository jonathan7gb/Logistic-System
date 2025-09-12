package org.transportadora.controller;

import org.transportadora.service.PedidoService;
import org.transportadora.view.Errors;
import org.transportadora.view.menus.PedidoMenus;

public class PedidoController {

    public static void pedidoController() {
        int option = -1;
        PedidoService pedidoService = new PedidoService();

        do {
            option = PedidoMenus.PedidoMenu();

            switch (option) {
                case 1 -> {
                    pedidoService.registerPedido();
                } //BREAK CASE 1 DO SWITCH OPCAO - CADASTRAR CLIENTE

                case 2 -> {
                    pedidoService.getAllPedidos();
                }//BREAK CASE 2 DO SWITCH OPCAO - LISTAR CLIENTES

                case 3 -> {
//                    pedidoService.getPedidoByCpfCnpjOrName();
                }//BREAK CASE 3 DO SWITCH OPCAO - BUSCAR CLIENTES

                case 4 -> {
//                    pedidoService.cancelPedido();
                }//BREAK CASE 4 DO SWITCH OPCAO - EXCLUIR CLIENTE

                case 0 -> {
                    return;
                }//BREAK CASE 0 DO SWITCH OPCAO - SAIR DO MENU CLIENTE

                default -> {
                    Errors.invalidOption();
                } //BREAK DEFAULT DO SWITCH OPCAO - OPÇÃO INVÁLIDA
            }
        }while(true);

    }
}
