package org.transportadora.service;

import org.transportadora.dao.EntregaDAO;
import org.transportadora.model.Entrega;
import org.transportadora.view.MessagesHelper;
import org.transportadora.view.utils.EntregaList;
import org.transportadora.view.utils.EntregaRegister;
import org.transportadora.view.utils.PedidoList;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EntregaService {

   EntregaDAO entregaDAO =  new EntregaDAO();
   EntregaList entregaList = new EntregaList();

    public void registerEntrega(){
        boolean cadastroConcluido = false;
        while(!cadastroConcluido){
            Entrega entrega = EntregaRegister.registerEntrega();

            try{
                assert entrega != null;
                entregaDAO.entregaRegister(entrega);
                MessagesHelper.success("ENTREGA GERADA COM SUCESSO!");
                cadastroConcluido = true;
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
    }

    public void getAllEntregas(){
        List<Entrega> entregas = new ArrayList<>();

        try{
            entregas = entregaDAO.getAllEntregas();

            if(entregas.isEmpty()){
                MessagesHelper.error("Nenhum entrega cadastrado no sistema.");
            }else{
                entregaList.PrintEntregaList(entregas);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
