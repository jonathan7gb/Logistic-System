package org.transportadora.view;

public class MessagesHelper {

    public static void invalidIntInput() {
        System.out.println("|| Entrada inválida! Por favor, insira um número inteiro.");
    }

    public static void error(String message) {
        System.out.println("\n|| <| ERRO |> " + message);
    }

    public static void success(String message) {
        System.out.println("\n|| <| SUCESSO |> " + message);
    }

    public static void info(String message) {
        System.out.println("\n|| <| INFO |>  " + message);
    }
}
