package org.transportadora.controller;

import org.transportadora.view.Errors;
import org.transportadora.view.menus.ClienteMenus;

public class ClienteController {

    public static void clienteController() {
        int opcao = -1;

        do {
            opcao = ClienteMenus.menuCliente();

            switch (opcao) {
                case 1 -> {
                }
                case 2 -> {
                }
                case 3 -> {
                }
                case 4 -> {
                }
                case 0 -> {
                    return;
                }
                default -> {
                    Errors.invalidOption();
                }
            }
        }while(true);

    }
}
