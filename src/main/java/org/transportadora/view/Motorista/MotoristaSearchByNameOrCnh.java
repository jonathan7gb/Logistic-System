package org.transportadora.view.Motorista;

import org.transportadora.view.InputHelper;

import java.util.Scanner;

public class MotoristaSearchByNameOrCnh {

    static Scanner scanner = new Scanner(System.in);
    static Scanner scannerInt = new Scanner(System.in);

    public static String MotoristaNameOrCnh(){
        String nameOrCnh = InputHelper.inputString("|| - Insira o nome ou CNH do motorista: ", scanner);
        System.out.println();
        return nameOrCnh;
    }
}
