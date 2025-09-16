package org.transportadora.controller;

import org.transportadora.view.MessagesHelper;
import org.transportadora.view.SystemEnd;
import org.transportadora.view.menus.MainMenu;

public class SystemController {

    MainMenu mainMenu = new MainMenu();

    public void startSystem(){
        int mainMenuOption = -1;

        do{
            mainMenuOption = mainMenu.mainMenu();

            switch (mainMenuOption){

                case 1 -> {
                    ClienteController.clienteController(); // Chama o controlador de clientes
                }

                case 2 -> {
                    MotoristaController.motoristaController(); // Chama o controlador de motoristas
                }

                case 3 -> {
                    PedidoController.pedidoController(); // Chama o controlador de pedidos
                }

                case 4 -> {
                    EntregaController.entregaController(); // Chama o controlador de entregas
                }

                case 5 -> {
                    RelatorioController.relatorioController(); // Chama o controlador de relatórios
                }

                case 0 -> {
                    SystemEnd.systemEnd(); // Mensagem de encerramento do sistema
                    return;
                }
                default -> {
                    MessagesHelper.error("Opção inválida! Tente novamente.\n");
                }
            }
        }while(true);

    }
}
