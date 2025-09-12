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
                } //BREAK CASE 1 DO SWITCH OPCAO - CRIAR PEDIDO

                case 2 -> {
                    pedidoService.getAllPedidos();
                }//BREAK CASE 2 DO SWITCH OPCAO - LISTAR PEDIDOS

                case 3 -> {
                    pedidoService.getPedidoByCpfCnpjOrName();
                }//BREAK CASE 3 DO SWITCH OPCAO - BUSCAR PEDIDOS

                case 4 -> {
                    //pedidoService.deliverPedido();
                }//BREAK CASE 4 DO SWITCH OPCAO - ENTREGAR PEDIDO

                case 5 -> {
//                    pedidoService.cancelPedido();
                }//BREAK CASE 5 DO SWITCH OPCAO - CANCELAR PEDIDO

                case 6 -> {
                    pedidoService.deletePedido();
                }//BREAK CASE 6 DO SWITCH OPCAO - EXCLUIR PEDIDO

                case 0 -> {
                    return;
                }//BREAK CASE 0 DO SWITCH OPCAO - SAIR DO MENU PEDIDO

                default -> {
                    Errors.invalidOption();
                } //BREAK DEFAULT DO SWITCH OPCAO - OPÇÃO INVÁLIDA
            }
        }while(true);

    }
}
