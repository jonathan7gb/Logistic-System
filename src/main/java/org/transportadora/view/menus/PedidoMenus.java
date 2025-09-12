package org.transportadora.view.menus;

import org.transportadora.model.enums.StatusPedido;
import org.transportadora.view.InputHelper;

import java.util.Date;
import java.util.Scanner;

public class PedidoMenus {

    static Scanner sc = new Scanner(System.in);

    public static int PedidoMenu(){
        System.out.print("""
                \n|| ==================== MENU PEDIDO ==================== ||
                || 1 - CRIAR PEDIDO
                || 2 - LISTAR PEDIDOS
                || 3 - BUSCAR PEDIDO POR CPF/CNPJ DO CLIENTE
                || 4 - SETAR PEDIDO COMO ENTREGUE
                || 5 - CANCELAR PEDIDO
                || 6 - EXCLUIR PEDIDO
                || 0 - VOLTAR AO MENU PRINCIPAL
                || =====================================================
                """);
        int opcao = InputHelper.inputInteger("|| Escolha uma opção: ", sc);
        System.out.println();
        return opcao;
    }

    public static Date dataPedidoInput(){
        Date dataPedido = InputHelper.inputDate("|| Digite a data do pedido (dd/mm/aaaa): ", sc);
        return dataPedido;
    }

    public static double volumeM3PedidoInput(){
        double volume = InputHelper.inputDouble("|| Digite o volume em m³ do pedido: ", sc);
        return volume;
    }
    public static double pesoKGPedidoInput(){
        double peso = InputHelper.inputDouble("|| Digite o peso em KG do volume: ", sc);
        return peso;
    }

    public static StatusPedido statusPedido(){
        StatusPedido statusEnum = StatusPedido.PENDENTE; // Valor padrão

        return statusEnum;
    }

    public static int idPedidoInput(){
        int idPedido = InputHelper.inputInteger("|| Digite o ID do pedido: ", sc);
        return idPedido;
    }

}
