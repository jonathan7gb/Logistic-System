package org.transportadora.view.menus;

import org.transportadora.exceptions.InvalidCpfCnpjException;
import org.transportadora.model.domain.CpfCnpjValidate;
import org.transportadora.model.enums.Estado;
import org.transportadora.model.enums.StatusPedido;
import org.transportadora.view.Inputs;

import java.util.Date;
import java.util.Scanner;

public class PedidoMenus {

    static Scanner sc = new Scanner(System.in);

    public static int ClienteMenu(){
        System.out.print("""
                \n|| ==================== MENU PEDIDO ==================== ||
                || 1 - CRIAR PEDIDO
                || 2 - LISTAR PEDIDOS
                || 3 - BUSCAR PEDIDO POR CPF/CNPJ DO CLIENTE
                || 4 - CANCELAR PEDIDO
                || 0 - VOLTAR AO MENU PRINCIPAL
                || =====================================================
                """);
        int opcao = Inputs.inputInteger("|| Escolha uma opção: ", sc);
        System.out.println();
        return opcao;
    }


    public static Date dataPedidoInput(){
        Date dataPedido = Inputs.inputDate("|| Digite a data do pedido (dd/mm/aaaa): ", sc);
        return dataPedido;
    }

    public static double volumeM3PedidoInput(){
        double volume = Inputs.inputDouble("|| Digite o volume em m³ do pedido: ", sc);
        return volume;
    }
    public static double pesoKGPedidoInput(){
        double peso = Inputs.inputDouble("|| Digite o peso em KG do volume: ", sc);
        return peso;
    }

    public static StatusPedido statusPedidoInput(){
        StatusPedido statusEnum = StatusPedido.PENDENTE; // Valor padrão

        System.out.println("""
                || Escolha o status do pedido:
                || 1 - PENDENTE
                || 2 - ENTREGUE
                || 3 - CANCELADO
                """);
        int status = Inputs.inputInteger("|| Digite o status do pedido", sc);

        if(status == 1){
            statusEnum = StatusPedido.PENDENTE;
        } else if (status == 2) {
            statusEnum = StatusPedido.ENTREGUE;
        } else if (status == 3) {
            statusEnum = StatusPedido.CANCELADO;
        } else {
            System.out.println("|| Opção inválida. O status será definido como PENDENTE por padrão.");
        }


        return statusEnum;
    }


}
