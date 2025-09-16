package org.transportadora.view.Motorista;

import org.transportadora.exceptions.InvalidCnhException;
import org.transportadora.model.domain.CnhValidate;
import org.transportadora.view.InputHelper;
import org.transportadora.view.MessagesHelper;

import java.util.Scanner;

public class MotoristaMenus {

    static Scanner sc = new Scanner(System.in);

    public static int MotoristaMenu(){
        System.out.print("""
                \n|| ==================== MENU MOTORISTA ==================== ||
                || 1 - CADASTRAR MOTORISTA
                || 2 - LISTAR MOTORISTAS
                || 3 - BUSCAR MOTORISTAS
                || 4 - EXCLUIR MOTORISTA
                || 0 - VOLTAR AO MENU PRINCIPAL
                || =====================================================
                """);
        int opcao = InputHelper.inputInteger("|| Escolha uma opção: ", sc);
        System.out.println();
        return opcao;
    }

    public static String nomeMotoristaInput() {
        return InputHelper.inputString("|| Digite o nome do motorista: ", sc);
    }

    public static String cnhMotoristaInput() {
        while (true) {
            String cnh = InputHelper.inputString("|| Digite a CNH do motorista: ", sc);

            try {
                if (CnhValidate.validate(cnh)) {
                    return cnh;
                }
            } catch (InvalidCnhException e) {
                MessagesHelper.error(e.getMessage()); // usar helper padronizado
            }
        }
    }

    public static String veiculoMotoristaInput(){
        return InputHelper.inputString("|| Digite o veículo motorista: ", sc);
    }

    public static String cidadeBaseMotoristaInput(){
        return InputHelper.inputString("|| Digite a cidade base do motorista: ", sc);
    }

    public static int idMotoristaInput() {
        return InputHelper.inputInteger("|| Digite o ID do motorista: ", sc);
    }
}
