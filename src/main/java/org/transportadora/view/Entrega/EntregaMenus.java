package org.transportadora.view.Entrega;

import org.transportadora.model.enums.StatusEntrega;
import org.transportadora.view.InputHelper;

import java.util.Date;
import java.util.Scanner;

public class EntregaMenus {

    static Scanner sc = new Scanner(System.in);

    public static int EntregaMenu(){
        System.out.print("""
                \n|| ==================== MENU ENTREGA ==================== ||
                || 1 - GERAR ENTREGA (ATRIBUIR A UM MOTORISTA)
                || 2 - LISTAR TODAS ENTREGAS DE CLIENTE E MOTORISTA
                || 3 - LISTAR TODAS AS ENTREGAS
                || 4 - BUSCAR ENTREGA POR ID
                || 5 - REGISTRAR EVENTO DE ENTREGA
                || 6 - ATUALIZAR STATUS DE ENTREGA PARA ENTREGUE
                || 7 - EXCLUIR ENTREGA
                || 0 - VOLTAR AO MENU PRINCIPAL
                || =====================================================
                """);
        int opcao = InputHelper.inputInteger("|| Escolha uma opção: ", sc);
        System.out.println();
        return opcao;
    }

    public static int idEntregaInput(){
        return InputHelper.inputInteger("|| Digite o ID da entrega: ", sc);
    }

    public static String CnhOuCpfCnpjInput(){
        return InputHelper.inputString("|| Digite a CNH do motorista ou o CPF/CNPJ do cliente: ", sc);
    }


    public static Date dataSaidaInput(){
        return InputHelper.inputDate("|| Digite a data de saída (dd/mm/aaaa): ", sc);
    }

    public static Date dataEntregaInput(){
        return InputHelper.inputDate("|| Digite a data de entrega (dd/mm/aaaa): ", sc);
    }

    public static StatusEntrega StatusEntrega(){
        StatusEntrega statusEnum = StatusEntrega.EM_ROTA; // Valor padrão
        return statusEnum;
    }

    public static Date dataAtualizacaoInput() {
        return InputHelper.inputDate("|| Digite a data do evento (dd/mm/aaaa): ", sc);
    }

    public static String descricaoInput() {
        return InputHelper.inputString("|| Descreva o evento ocorrido na entrega: ", sc);
    }
}
