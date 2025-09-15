package org.transportadora.view.menus;

import org.transportadora.model.enums.StatusEntrega;
import org.transportadora.model.enums.StatusPedido;
import org.transportadora.view.InputHelper;

import java.util.Date;
import java.util.Scanner;

public class EntregaMenus {

    static Scanner sc = new Scanner(System.in);

    public static int EntregaMenu(){
        System.out.print("""
                \n|| ==================== MENU ENTREGA ==================== ||
                || 1 - GERAR ENTREGA (ATRIBUIR A UM MOTORISTA)
                || 2 - REGISTRAR EVENTO DE ENTREGA
                || 3 - ATUALIZAR STATUS DE ENTREGA PARA ENTREGUE
                || 4 - LISTAR TODAS ENTREGAS DE CLIENTE E MOTORISTA
                || 5 - BUSCAR ENTREGA POR ID
                || 6 - LISTAR TODAS AS ENTREGAS
                || 7 - EXCLUIR ENTREGA
                || 0 - VOLTAR AO MENU PRINCIPAL
                || =====================================================
                """);
        int opcao = InputHelper.inputInteger("|| Escolha uma opção: ", sc);
        System.out.println();
        return opcao;
    }

    public static int idEntregaInput(){
        int id = InputHelper.inputInteger("|| Digite o ID da entrega: ", sc);
        return id;
    }


    public static Date dataSaidaInput(){
        Date dataSaida = InputHelper.inputDate("|| Digite a data de saída (dd/mm/aaaa): ", sc);
        return dataSaida;
    }

    public static Date dataEntregaInput(){
        Date dataEntrega = InputHelper.inputDate("|| Digite a data de entrega (dd/mm/aaaa): ", sc);
        return dataEntrega;
    }

    public static StatusEntrega StatusEntrega(){
        StatusEntrega statusEnum = StatusEntrega.EM_ROTA; // Valor padrão

        return statusEnum;
    }
}
