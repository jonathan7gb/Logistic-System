package org.transportadora.view.utils;

import org.transportadora.dao.ClienteDAO;
import org.transportadora.model.Cliente;
import org.transportadora.model.Pedido;
import org.transportadora.model.enums.StatusPedido;
import org.transportadora.view.menus.ClienteMenus;
import org.transportadora.view.menus.PedidoMenus;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PedidoRegister {

    static ClienteDAO clienteDAO = new ClienteDAO();

    public static Cliente clientePedido(){
        String clienteCpf = ClienteMenus.cpfCnpjClienteInput();
        Cliente cliente = null;
        List<Cliente> clientes = new ArrayList<>();
        try {
            clientes = clienteDAO.getAllClientes();
            for(Cliente c : clientes){
                if(c.getCpf_cnpj().equals(clienteCpf)){
                    cliente =  new Cliente(c.getId(), c.getNome(), c.getCpf_cnpj(), c.getEndereco(), c.getCidade(), c.getEstado());
                    return  cliente;
                }
            }
        }catch (SQLException e){
            e.printStackTrace();
        }

        return cliente;
    }

    public static Pedido registerPedido(){

        Cliente cliente = clientePedido();
        if(cliente == null){
            System.out.println("\n|| ==== Cliente não encontrado. Por favor, verifique os dados do cliente. ==== ||");
            return null;
        }else{
            Date data = PedidoMenus.dataPedidoInput();
            double volume = PedidoMenus.volumeM3PedidoInput();
            double peso = PedidoMenus.pesoKGPedidoInput();
            StatusPedido status = PedidoMenus.statusPedidoInput();

            return new Pedido(cliente, data, volume, peso, status);
        }
    }
}
