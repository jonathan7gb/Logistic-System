package org.transportadora.service;

import org.transportadora.dao.PedidoDAO;
import org.transportadora.model.Pedido;
import org.transportadora.view.MessagesHelper;
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
                MessagesHelper.success("PEDIDO CADASTRADO COM SUCESSO!");
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
                MessagesHelper.error("Nenhum pedido cadastrado no sistema.");
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
                MessagesHelper.error("Nenhum pedido encontrado com esse nome ou CPF/CNPJ.");
            }else{
                pedidoList.PrintPedidoList(pedidos);
            }
        }catch (SQLException e){
            MessagesHelper.error("Erro ao buscar o pedido no sistema.");
        }
    }

    public void deliverPedido(){
        try{
            int idPedido = PedidoMenus.idPedidoInput();
            boolean atualizado = pedidoDAO.deliverPedido(idPedido);

            if(atualizado){
                MessagesHelper.success("PEDIDO ENTREGUE COM SUCESSO!");
            }else{
                MessagesHelper.error("NÃO ENCONTRADO OU ATUALIZAÇÃO NÃO AUTORIZADA");
            }
        }catch (SQLException e ){
            MessagesHelper.error("Erro ao entregar o pedido no sistema.");
        }
    }

    public void cancelPedido(){
        try{
            int idPedido = PedidoMenus.idPedidoInput();
            boolean atualizado = pedidoDAO.cancelPedido(idPedido);

            if(atualizado){
                MessagesHelper.success("PEDIDO CANCELADO COM SUCESSO!");
            }else{
                MessagesHelper.error("NÃO ENCONTRADO OU ATUALIZAÇÃO NÃO AUTORIZADA");
            }
        }catch (SQLException e ){
            MessagesHelper.error("Erro ao cancelar o pedido no sistema.");
        }
    }

    public void deletePedido(){
        try{
            int idPedido = PedidoMenus.idPedidoInput();
            boolean confirmDelete = PedidoList.confirmDelete();
            if(confirmDelete){
                boolean excluido = pedidoDAO.deletePedido(idPedido);

                if(excluido){
                    MessagesHelper.success("PEDIDO EXCLUÍDO COM SUCESSO!");
                }else{
                    MessagesHelper.error("NENHUM PEDIDO ENCONTRADO COM ESSE ID");
                }
            }else{
                MessagesHelper.error("EXCLUSÃO CANCELADA PELO USUÁRIO");
            }

        }catch (SQLException e ){
            MessagesHelper.error("Erro ao excluir pedido no sistema.");
        }
    }

    public Pedido verifyIfExistsPedido(int id){
        Pedido pedido = null;
        try{
            List<Pedido> pedidos = pedidoDAO.getAllPedidos();
            for(Pedido p : pedidos){
                if(p.getId() == id){
                    pedido = p;
                    pedido = new Pedido(p.getId(), p.getCliente(), p.getDataPedido(), p.getVolume_m3(), p.getPeso_kg(), p.getStatus());
                    break;
                }
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return pedido;
    }
}
