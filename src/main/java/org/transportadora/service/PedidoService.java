package org.transportadora.service;

import org.transportadora.dao.PedidoDAO;
import org.transportadora.model.Pedido;
import org.transportadora.model.Pedido;
import org.transportadora.view.menus.ClienteMenus;
import org.transportadora.view.menus.PedidoMenus;
import org.transportadora.view.utils.ClientSearchByNameOrCpf;
import org.transportadora.view.utils.PedidoList;
import org.transportadora.view.utils.PedidoRegister;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PedidoService {
    PedidoDAO pedidoDAO =  new PedidoDAO();
    PedidoList pedidoList = new PedidoList();

    public void registerPedido(){
        boolean cadastroConcluido = false;
        while(!cadastroConcluido){
            Pedido pedido = PedidoRegister.registerPedido();

            try{
                pedidoDAO.pedidoRegister(pedido);
                cadastroConcluido = true;
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
    }

    public void getAllPedidos(){
        List<Pedido> pedidos = new ArrayList<>();

        try{
            pedidos = pedidoDAO.getAllPedidos();

            if(pedidos.isEmpty()){
                System.out.println("\n|| ==== Nenhum pedido cadastrado no sistema. ==== ||");
            }else{
                pedidoList.PrintPedidoList(pedidos);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void getPedidoByCpfCnpjOrName(){
        List<Pedido> pedidos = new ArrayList<>();

        try{
            String nameOrCpf = ClientSearchByNameOrCpf.ClienteNameOrCpf();

            pedidos = pedidoDAO.getPedidoByCpfCnpjOrNameCliente(nameOrCpf);

            if (pedidos.isEmpty()){
                System.out.println("|| ==== Nenhum pedido encontrado com esse nome ou CPF/CNPJ. ==== ||");
            }else{
                pedidoList.PrintPedidoList(pedidos);
            }
        }catch (SQLException e){
            System.out.println("\n|| ==== Erro ao buscar o pedido no sistema. ==== ||");
        }
    }



    public void deletePedido(){
        try{
            int idPedido = PedidoMenus.idPedidoInput();
            boolean confirmDelete = PedidoList.confirmDelete();
            if(confirmDelete){
                boolean excluido = pedidoDAO.deletePedido(idPedido);

                if(excluido){
                    System.out.println("\n|| ====== PEDIDO EXCLUÍDO COM SUCESSO! ====== ||");
                }else{
                    System.out.println("|| ==== NENHUM PEDIDO ENCONTRADO COM ESSE ID ==== ||");
                }
            }else{
                System.out.println("\n|| ==== EXCLUSÃO CANCELADA PELO USUÁRIO ==== ||");
            }

        }catch (SQLException e ){
            System.out.println("\n|| ==== Erro ao excluir pedido no sistema. ==== ||");
        }
    }
}
