package org.transportadora.view.menus;

import org.transportadora.exceptions.InvalidCpfCnpjException;
import org.transportadora.model.domain.CpfCnpjValidate;
import org.transportadora.model.enums.Estado;
import org.transportadora.view.InputHelper;
import org.transportadora.view.MessagesHelper;

import java.util.Scanner;

public class ClienteMenus {

    static Scanner sc = new Scanner(System.in);

    public static int ClienteMenu(){
        System.out.print("""
                \n|| ==================== MENU CLIENTE ==================== ||
                || 1 - CADASTRAR CLIENTE
                || 2 - LISTAR CLIENTES
                || 3 - BUSCAR CLIENTES
                || 4 - EXCLUIR CLIENTE
                || 0 - VOLTAR AO MENU PRINCIPAL
                || =====================================================
                """);
        int opcao = InputHelper.inputInteger("|| Escolha uma opção: ", sc);
        System.out.println();
        return opcao;
    }

    public static String nomeClienteInput(){
        String nome = InputHelper.inputString("|| Digite o nome do cliente: ", sc);
        return nome;
    }

    public static String cpfCnpjClienteInput(){
        while(true) {
            String cpf_cnpj = InputHelper.inputString("|| Digite o CPF/CNPJ do cliente: ", sc);

            try {
                boolean cpfCnpjValido = CpfCnpjValidate.validate(cpf_cnpj);
                if (cpfCnpjValido) {
                    return cpf_cnpj;
                }
            } catch (InvalidCpfCnpjException e) {
                MessagesHelper.error(e.getMessage());
            }
        }

    }

    public static String enderecoClienteInput(){
        String endereco = InputHelper.inputString("|| Digite o endereço do cliente (Bairro, rua, nº da residência/local): ", sc);
        return endereco;
    }

    public static String cidadeClienteInput(){
        String cidade = InputHelper.inputString("|| Digite a cidade do cliente: ", sc);
        return cidade;
    }

    public static Estado estadoClienteInput(){
        String estado = InputHelper.inputString("|| Digite o estado do cliente: ", sc);
        Estado estadoEnum = Estado.fromString(estado);

        return estadoEnum;
    }


}
