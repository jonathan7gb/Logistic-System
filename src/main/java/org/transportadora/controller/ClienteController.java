package org.transportadora.controller;

import org.transportadora.dao.ClienteDAO;
import org.transportadora.model.Cliente;
import org.transportadora.view.Errors;
import org.transportadora.view.Registrations.ClienteRegister;
import org.transportadora.view.menus.ClienteMenus;

import java.sql.SQLException;

public class ClienteController {

    public static void clienteController() {
        int opcao = -1;
        ClienteDAO clienteDAO = new ClienteDAO();

        do {
            opcao = ClienteMenus.menuCliente();

            switch (opcao) {
                case 1 -> {
                    Cliente cliente = ClienteRegister.registerCliente();

                    try{
                        clienteDAO.clienteRegister(cliente);
                    }catch (SQLException e){
                        e.printStackTrace();
                    }

                } //BREAK CASE 1 DO SWITCH OPCAO

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
