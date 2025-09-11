package org.transportadora.controller;

import org.transportadora.service.ClienteService;
import org.transportadora.view.Errors;
import org.transportadora.view.menus.ClienteMenus;

public class ClienteController {

    public static void clienteController() {
        int option = -1;
        ClienteService clienteService = new ClienteService();

        do {
            option = ClienteMenus.ClienteMenu();

            switch (option) {
                case 1 -> {
                    clienteService.registerCliente();
                } //BREAK CASE 1 DO SWITCH OPCAO - CADASTRAR CLIENTE

                case 2 -> {
                    clienteService.getAllClientes();
                }//BREAK CASE 2 DO SWITCH OPCAO - LISTAR CLIENTES

                case 3 -> {
                    clienteService.getClienteByCpfCnpjOrName();
                }//BREAK CASE 3 DO SWITCH OPCAO - BUSCAR CLIENTES

                case 4 -> {
                    clienteService.deleteCliente();
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
