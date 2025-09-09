package org.transportadora.view.menus;

import org.transportadora.exceptions.InvalidCpfCnpjException;
import org.transportadora.model.domain.CpfCnpjValidate;
import org.transportadora.model.enums.Estado;
import org.transportadora.view.Inputs;

import java.util.Scanner;

public class ClienteMenus {

    static Scanner sc = new Scanner(System.in);

    public static int menuCliente(){
        System.out.print("""
                \n|| ==================== MENU CLIENTE ==================== ||
                || 1 - CADASTRAR CLIENTE
                || 2 - LISTAR CLIENTES
                || 3 - BUSCAR CLIENTES
                || 4 - EXCLUIR CLIENTE
                || 0 - VOLTAR AO MENU PRINCIPAL
                || =====================================================
                """);
        int opcao = Inputs.inputInteger("|| Escolha uma opção: ", sc);
        System.out.println();
        return opcao;
    }

    public static String nomeClienteInput(){
        String nome = Inputs.inputString("|| Digite o nome do cliente: ", sc);
        return nome;
    }

    public static String cpfCnpjClienteInput(){
        while(true) {
            String cpf_cnpj = Inputs.inputString("|| Digite o CPF/CNPJ do cliente: ", sc);

            try {
                boolean cpfCnpjValido = CpfCnpjValidate.validate(cpf_cnpj);
                if (cpfCnpjValido) {
                    return cpf_cnpj;
                }
            } catch (InvalidCpfCnpjException e) {
                System.out.println("\n|| ==> Erro: " + e.getMessage() + "\n");
            }
        }

    }

    public static String enderecoClienteInput(){
        String endereco = Inputs.inputString("|| Digite o endereço do cliente (Bairro, rua, nº da residência/local): ", sc);
        return endereco;
    }

    public static String cidadeClienteInput(){
        String cidade = Inputs.inputString("|| Digite a cidade do cliente: ", sc);
        return cidade;
    }

    public static Estado estadoClienteInput(){
        String estado = Inputs.inputString("|| Digite o estado do cliente: ", sc);
        Estado estadoEnum = Estado.fromString(estado);

        return estadoEnum;
    }


}
