package org.transportadora.view;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class InputHelper {

    //MÉTODO PARA LER E VALIDAR NÚMEROS INTEIROS
    public static int inputInteger(String mensagem, Scanner sc){
        int leitura = -1;
        do{
            System.out.print(mensagem);
            String leituraStr = sc.nextLine();
            try{
                leitura = Integer.parseInt(leituraStr);
                break;
            } catch (NumberFormatException e) {
                MessagesHelper.invalidIntInput();
                continue;
            }
        }while(true);
        return leitura;
    }

    //=============================================================================

    //MÉTODO PARA LER E VALIDAR NÚMEROS DECIMAIS
    public static double inputDouble(String mensagem, Scanner sc){

        double leitura = -1;
        do{
            System.out.print(mensagem);
            String leituraStr = sc.nextLine();
            try{
                leitura = Double.parseDouble(leituraStr);
                break;
            } catch (NumberFormatException e) {
                MessagesHelper.invalidIntInput();
                continue;
            }
        }while(true);
        return leitura;
    }

    //=============================================================================

    //MÉTODO PARA E VALIDAR LER STRINGS
    public static String inputString(String mensagem, Scanner sc){
        System.out.print(mensagem);
        String leitura = sc.nextLine();
        return leitura;
    }

    //=============================================================================

    //MÉTODO PARA LER E VALIDAR DATAS
    public static Date inputDate(String mensagem, Scanner sc) {
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        formato.setLenient(false); // evita datas tipo 32/01/2020

        while (true) {
            System.out.print(mensagem);
            String input = sc.nextLine();

            try {
                Date data = formato.parse(input);

                // pega dia, mês e ano
                Calendar cal = Calendar.getInstance();
                cal.setTime(data);
                int dia = cal.get(Calendar.DAY_OF_MONTH);
                int mes = cal.get(Calendar.MONTH) + 1; // janeiro = 0
                int ano = cal.get(Calendar.YEAR);

                if (dia < 1 || dia > 31) {
                    MessagesHelper.error("Dia inválido. Deve estar entre 01 e 31.");
                    continue;
                }
                if (mes < 1 || mes > 12) {
                    MessagesHelper.error("Mês inválido. Deve estar entre 01 e 12.");
                    continue;
                }
                if (ano < 1900 || ano > 2026) { // limite máximo 2026
                    MessagesHelper.error("Ano inválido. Deve estar entre 1900 e 2026.");
                    continue;
                }

                return data;

            } catch (ParseException e) {
                MessagesHelper.error("Data inválida. Use o formato dd/mm/yyyy.");
            }
        }
    }
}
