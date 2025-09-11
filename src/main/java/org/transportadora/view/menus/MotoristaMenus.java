package org.transportadora.view.menus;

import org.transportadora.exceptions.InvalidCnhException;
import org.transportadora.exceptions.InvalidCpfCnpjException;
import org.transportadora.model.domain.CnhValidate;
import org.transportadora.model.domain.CpfCnpjValidate;
import org.transportadora.model.enums.Estado;
import org.transportadora.view.Inputs;

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
        int opcao = Inputs.inputInteger("|| Escolha uma opção: ", sc);
        System.out.println();
        return opcao;
    }

    public static String nomeMotoristaInput(){
        String nome = Inputs.inputString("|| Digite o nome do motorista: ", sc);
        return nome;
    }

    public static String cnhMotoristaInput(){
        while(true) {
            String cnh = Inputs.inputString("|| Digite a CNH do motorista: ", sc);

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
        String veiculo = Inputs.inputString("|| Digite o veículo motorista: ", sc);
        return veiculo;
    }

    public static String cidadeBaseMotoristaInput(){
        String cidade_base = Inputs.inputString("|| Digite a cidade base do motorista: ", sc);
        return cidade_base;
    }

}
