package org.transportadora.controller;

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
                    ClienteController.clienteController();
                }
                case 2 -> {
                    MotoristaController.motoristaController();
                }
                case 3 -> {}
                case 4 -> {}
                case 0 -> {
                    SystemEnd.systemEnd();
                    return;
                }
                default -> {
                    System.out.println("|| Opção inválida! Tente novamente.");
                }

            }
        }while(true);

    }
}
