package org.transportadora.service;

import org.transportadora.dao.MotoristaDAO;
import org.transportadora.model.Motorista;
import org.transportadora.view.MessagesHelper;
import org.transportadora.view.menus.MotoristaMenus;
import org.transportadora.view.utils.MotoristaList;
import org.transportadora.view.utils.MotoristaRegister;
import org.transportadora.view.utils.MotoristaSearchByNameOrCnh;

import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.List;

public class MotoristaService {
    MotoristaDAO motoristaDAO =  new MotoristaDAO();
    MotoristaList motoristaList = new MotoristaList();

    public void registerMotorista(){
        boolean cadastroConcluido = false;
        while(!cadastroConcluido){
            Motorista motorista = MotoristaRegister.registerMotorista();

            try{
                motoristaDAO.motoristaRegister(motorista);
                MessagesHelper.success("MOTORISTA CADASTRADO COM SUCESSO!");
                cadastroConcluido = true;
            }catch (SQLIntegrityConstraintViolationException e) {
                System.err.print("Motorista já cadastrado com esse CNH. Vamos recomeçar o cadastro. Insira o nome: ");
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
    }

    public void getAllMotoristas(){
        List<Motorista> motoristas = new ArrayList<>();

        try{
            motoristas = motoristaDAO.getAllMotoristas();

            if(motoristas.isEmpty()){
                MessagesHelper.error("Nenhum motorista cadastrado no sistema.");
            }else{
                motoristaList.PrintMotoristaList(motoristas);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void getMotoristaByCnhOrName(){
        List<Motorista> motoristas = new ArrayList<>();

        try{
            String nameOrCnh = MotoristaSearchByNameOrCnh.MotoristaNameOrCnh();

            motoristas = motoristaDAO.getMotoristaByCnhOrName(nameOrCnh);

            if (motoristas.isEmpty()){
                MessagesHelper.error("Nenhum motorista encontrado com esse nome ou CNH.");
            }else{
                motoristaList.PrintMotoristaList(motoristas);
            }
        }catch (SQLException e){
            MessagesHelper.error("Erro ao buscar o motorista no sistema.");
        }
    }

    public void deleteMotorista(){
        try{
            String cnh = MotoristaMenus.cnhMotoristaInput();
            boolean confirmDelete = MotoristaSearchByNameOrCnh.confirmDelete();
            if(confirmDelete){
                boolean excluido = motoristaDAO.deleteMotorista(cnh);

                if(excluido){
                    MessagesHelper.success("MOTORISTA EXCLUÍDO COM SUCESSO!");
                }else{
                    MessagesHelper.error("NENHUM MOTORISTA ENCONTRADO COM ESSE CNH.");
                }
            }else{
                MessagesHelper.error("EXCLUSÃO CANCELADA PELO USUÁRIO");
            }

        }catch (SQLException e ){
            MessagesHelper.error("Erro ao excluir motorista no sistema.");
        }
    }

    public Motorista verifyIfExistsMotorista(int motoristaId) {
        Motorista motorista = null;
        List<Motorista> motoristas = new ArrayList<>();
        try {
            motoristas = motoristaDAO.getAllMotoristas();
            for(Motorista m : motoristas){
                if(m.getId() == motoristaId ){
                    motorista =  new Motorista(m.getId(), m.getNome(), m.getCnh(), m.getVeiculo(), m.getCidade_base());
                    return motorista;
                }
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return motorista;
    }
}
