package org.transportadora.service;

import org.transportadora.dao.EntregaDAO;
import org.transportadora.model.Entrega;
import org.transportadora.model.HistoricoEntrega;
import org.transportadora.view.MessagesHelper;
import org.transportadora.view.menus.EntregaMenus;
import org.transportadora.view.utils.EntregaList;
import org.transportadora.view.utils.EntregaRegister;
import org.transportadora.view.utils.HistoricoEntregaRegister;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EntregaService {

   EntregaDAO entregaDAO =  new EntregaDAO();
   EntregaList entregaList = new EntregaList();

    //========================================================================================

    //REGISTRAR ENTREGA
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


    //========================================================================================


    //ATUALIZAR STATUS DA ENTREGA
    public void updateEntregaStatus(){
        try{
            int idEntrega = EntregaMenus.idEntregaInput();

            boolean atualizado = entregaDAO.updateEntregaStatus(idEntrega);

            if(atualizado){
                MessagesHelper.success("STATUS DA ENTREGA ATUALIZADO COM SUCESSO!");
            }else{
                MessagesHelper.error("NENHUMA ENTREGA ENCONTRADA COM ESSE ID");
            }
        }catch (SQLException e ){
            MessagesHelper.error("Erro ao atualizar status da entrega no sistema.");
        }
    }


    //========================================================================================


    //LISTAR ENTREGAS POR CPF/CNPJ/CNH
    public void listEntregaByCpfCnpjOrCnh(){
        List<Entrega> entregas = new ArrayList<>();

        try{
            entregas = entregaDAO.getAllEntregas();

            if(entregas.isEmpty()){
                MessagesHelper.error("Nenhum entrega cadastrado no sistema.");
            }else{
                entregaList.PrintEntregaListClienteAndMotorista(entregas);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
    }


    //========================================================================================


    //BUSCAR ENTREGA POR ID
    public void searchEntregaById(){
        List<Entrega> entregas = new ArrayList<>();

        try{
            int idEntrega = EntregaMenus.idEntregaInput();
            entregas = entregaDAO.getEntregaById(idEntrega);

            if (entregas.isEmpty()){
                MessagesHelper.error("Nenhuma entrega encontrada com esse ID.");
            }else{
                System.out.println();
                entregaList.PrintEntregaList(entregas);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
    }


    //========================================================================================


    //ADICIONAR EVENTO DE ENTREGA
    public void addEventoEntrega(){
        boolean cadastroConcluido = false;
        while(!cadastroConcluido){
            HistoricoEntrega historicoEntrega = HistoricoEntregaRegister.registerEventoEntrega();
            try{
                assert historicoEntrega != null;
                entregaDAO.eventoEntregaRegister(historicoEntrega);
                MessagesHelper.success("EVENTO DE ENTREGA GERADA COM SUCESSO!");
                cadastroConcluido = true;
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
    }


    //========================================================================================


    //LISTAR TODAS ENTREGAS
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


    //========================================================================================


    //DELETAR ENTREGA
    public void deleteEntrega(){
        try{
            int idEntrega = EntregaMenus.idEntregaInput();
            boolean confirmDelete = EntregaList.confirmDelete();
            if(confirmDelete){
                boolean excluido = entregaDAO.deleteEntrega(idEntrega);

                if(excluido){
                    MessagesHelper.success("ENTREGA EXCLUÍDA COM SUCESSO!");
                }else{
                    MessagesHelper.error("NENHUMA ENTREGA ENCONTRADA COM ESSE ID");
                }
            }else{
                MessagesHelper.error("EXCLUSÃO CANCELADA PELO USUÁRIO");
            }

        }catch (SQLException e ){
            MessagesHelper.error("Erro ao excluir entrega no sistema.");
        }
    }
}
