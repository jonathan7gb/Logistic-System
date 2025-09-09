package org.transportadora.view;

import java.util.Scanner;

public class Inputs {

    public static int inputInteger(String mensagem, Scanner sc){

        int leitura = -1;
        do{
            System.out.print(mensagem);
            String leituraStr = sc.nextLine();
            try{
                leitura = Integer.parseInt(leituraStr);
                break;
            } catch (NumberFormatException e) {
                Errors.invalidIntInput();
                continue;
            }
        }while(true);
        return leitura;
    }

    public static String inputString(String mensagem, Scanner sc){
        System.out.print(mensagem);
        String leitura = sc.nextLine();
        return leitura;
    }
}
