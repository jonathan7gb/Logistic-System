package org.transportadora.controller;

import org.transportadora.service.MotoristaService;
import org.transportadora.view.MessagesHelper;
import org.transportadora.view.Motorista.MotoristaMenus;

public class MotoristaController {

    public static void motoristaController() {
        int option = -1;
        MotoristaService motoristaService = new MotoristaService();

        do {
            option = MotoristaMenus.MotoristaMenu();

            switch (option) {
                case 1 -> {
                    motoristaService.registerMotorista();
                } //BREAK CASE 1 DO SWITCH OPCAO - CADASTRAR MOTORISTA

                case 2 -> {
                    motoristaService.getAllMotoristas();
                }//BREAK CASE 2 DO SWITCH OPCAO - LISTAR MOTORISTAS

                case 3 -> {
                    motoristaService.getMotoristaByCnhOrName();
                }//BREAK CASE 3 DO SWITCH OPCAO - BUSCAR MOTORISTAS

                case 4 -> {
                    motoristaService.deleteMotorista();
                }//BREAK CASE 4 DO SWITCH OPCAO - EXCLUIR MOTORISTA

                case 0 -> {
                    return;
                }//BREAK CASE 0 DO SWITCH OPCAO - SAIR DO MENU MOTORISTA

                default -> {
                    MessagesHelper.error(" Opção inválida! Tente novamente.\n");
                } //BREAK DEFAULT DO SWITCH OPCAO - OPÇÃO INVÁLIDA
            }
        }while(true);

    }
}
