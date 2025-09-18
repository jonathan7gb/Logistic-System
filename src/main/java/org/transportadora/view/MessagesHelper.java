package org.transportadora.view;

public class MessagesHelper {

    public static void invalidIntInput() {
        System.out.println("|| Entrada inválida! Por favor, insira um número inteiro.");
    }

    public static void invalidDoubleInput() {
        System.out.println("|| Entrada inválida! Por favor, insira um número decimal ou inteiro.");
    }

    public static void error(String message) {
        System.out.println("\n\u001B[31m|| <| ERRO |> " + message + "\u001B[0m");
    }

    public static void success(String message) {
        System.out.println("\n\u001B[32m|| <| SUCESSO |> " + message + "\u001B[0m");
    }

    public static void info(String message) {
        System.out.println("\u001B[34m|| <| INFO |> " + message + "\u001B[0m");
    }
}
