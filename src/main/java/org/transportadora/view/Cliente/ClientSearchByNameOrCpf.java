package org.transportadora.view.Cliente;

import org.transportadora.view.InputHelper;

import java.util.Scanner;

public class ClientSearchByNameOrCpf {

    static Scanner scanner = new Scanner(System.in);

    public static String ClienteNameOrCpf(){
        String nameOrCpf = InputHelper.inputString("|| - Insira o nome ou CPF/CNPJ do cliente: ", scanner);
        return nameOrCpf;
    }
}
