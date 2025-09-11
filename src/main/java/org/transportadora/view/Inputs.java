package org.transportadora.view;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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

    public static double inputDouble(String mensagem, Scanner sc){

        double leitura = -1;
        do{
            System.out.print(mensagem);
            String leituraStr = sc.nextLine();
            try{
                leitura = Double.parseDouble(leituraStr);
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

    public static Date inputDate(String mensagem, Scanner sc){
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        formato.setLenient(false); // para validar datas como 32/01/2020 (inválidas)

        while (true) {
            System.out.print(mensagem);
            String input = sc.nextLine();

            try {
                Date data = formato.parse(input);
                return data;
            } catch (ParseException e) {
                System.out.println("Data inválida. Use o formato dd/mm/yyyy.");
            }
        }
    }
}
