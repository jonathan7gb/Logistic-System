package org.transportadora.view.utils;

import org.transportadora.dao.MotoristaDAO;
import org.transportadora.dao.PedidoDAO;
import org.transportadora.model.Entrega;
import org.transportadora.model.Motorista;
import org.transportadora.model.Pedido;
import org.transportadora.model.enums.StatusEntrega;
import org.transportadora.model.enums.StatusPedido;
import org.transportadora.view.MessagesHelper;
import org.transportadora.view.menus.EntregaMenus;
import org.transportadora.view.menus.MotoristaMenus;
import org.transportadora.view.menus.PedidoMenus;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class EntregaRegister {

    static PedidoDAO pedidoDAO = new PedidoDAO();
    static MotoristaDAO motoristaDAO = new MotoristaDAO();

    public static Pedido pedidoEntrega(){
        int pedidoID = PedidoMenus.idPedidoInput();
        Pedido pedido = null;
        List<Pedido> pedidos = new ArrayList<>();
        try {
            pedidos = pedidoDAO.getAllPedidos();
            for(Pedido p : pedidos){
                if(p.getId() == pedidoID){
                    pedido =  new Pedido(p.getId(), p.getCliente(), p.getDataPedido(), p.getVolume_m3(), p.getPeso_kg(), p.getStatus());
                    return pedido;
                }
            }
        }catch (SQLException e){
            e.printStackTrace();
        }

        return pedido;
    }

    public static Motorista motoristaEntrega(){
        String motoristaCNH = MotoristaMenus.cnhMotoristaInput();
        Motorista motorista = null;
        List<Motorista> motoristas = new ArrayList<>();
        try {
            motoristas = motoristaDAO.getAllMotoristas();
            for(Motorista m : motoristas){
                if(m.getCnh().equals((motoristaCNH)) ){
                    motorista =  new Motorista(m.getId(), m.getNome(), m.getCnh(), m.getVeiculo(), m.getCidade_base());
                    return motorista;
                }
            }
        }catch (SQLException e){
            e.printStackTrace();
        }

        return motorista;
    }


    public static Entrega registerEntrega(){

        Pedido pedido = pedidoEntrega();
        if(pedido == null) {
            MessagesHelper.error("Pedido não encontrado. Por favor, verifique os dados do pedido.");
            return null;
        }else{
            Motorista motorista = motoristaEntrega();
            if(motorista == null){
                MessagesHelper.error("Motorista não encontrado. Por favor, verifique os dados do motorista.");
                return null;
            }else{
                Date dataSaida = EntregaMenus.dataSaidaInput();
                Date dataEntrega = EntregaMenus.dataEntregaInput();
                StatusEntrega status = EntregaMenus.StatusEntrega();

                return new Entrega(pedido, motorista, dataSaida, dataEntrega, status);
            }
        }
    }
}
