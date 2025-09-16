package org.transportadora.view.Motorista;

import org.transportadora.exceptions.InvalidCnhException;
import org.transportadora.model.domain.CnhValidate;
import org.transportadora.view.InputHelper;

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

    public static String nomeMotoristaInput(){
        String nome = InputHelper.inputString("|| Digite o nome do motorista: ", sc);
        return nome;
    }

    public static String cnhMotoristaInput(){
        while(true) {
            String cnh = InputHelper.inputString("|| Digite a CNH do motorista: ", sc);

            try {
                boolean cnhValido = CnhValidate.validate(cnh);
                if (cnhValido) {
                    return cnh;
                }
            } catch (InvalidCnhException e) {
                System.out.println("\n|| ==> Erro: " + e.getMessage() + "\n");
            }
        }

    }

    public static String veiculoMotoristaInput(){
        String veiculo = InputHelper.inputString("|| Digite o veículo motorista: ", sc);
        return veiculo;
    }

    public static String cidadeBaseMotoristaInput(){
        String cidade_base = InputHelper.inputString("|| Digite a cidade base do motorista: ", sc);
        return cidade_base;
    }

    public static int idMotoristaInput() {
        int id = InputHelper.inputInteger("|| Digite o ID do motorista: ", sc);
        return id;
    }
}
