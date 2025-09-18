package org.transportadora.service;

import org.transportadora.dao.MotoristaDAO;
import org.transportadora.model.Motorista;
import org.transportadora.view.MessagesHelper;
import org.transportadora.view.Motorista.*;

import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.List;

public class MotoristaService {
    MotoristaDAO motoristaDAO =  new MotoristaDAO();
    MotoristaList motoristaList = new MotoristaList();

    //========================================================================================

    //REGISTAR MOTORISTA
    public void registerMotorista(){
        boolean cadastroConcluido = false;
        while(!cadastroConcluido){
            Motorista motorista = MotoristaRegister.registerMotorista();

            try{
                motoristaDAO.motoristaRegister(motorista);
                MessagesHelper.success("MOTORISTA CADASTRADO COM SUCESSO!");
                cadastroConcluido = true;
            }catch (SQLIntegrityConstraintViolationException e) {
                MessagesHelper.error("Motorista já cadastrado com esse CNH. Vamos recomeçar o cadastro. Insira o nome: ");
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
    }


    //========================================================================================


    //LISTAR TODOS OS MOTORISTAS
    public void getAllMotoristas() {
        try {
            List<Motorista> motoristas = motoristaDAO.getAllMotoristas();
            if (motoristas.isEmpty()) {
                MessagesHelper.error("Nenhum motorista cadastrado no sistema.");
            } else {
                motoristaList.PrintMotoristaList(motoristas);
            }
        } catch (SQLException e) {
            MessagesHelper.error("Erro ao listar motoristas.");
            e.printStackTrace();
        }
    }


    //========================================================================================


    //BUSCAR MOTORISTAS PELA CNH OU NOME
    public void getMotoristaByCnhOrName() {
        try {
            String input = MotoristaSearchByNameOrCnh.MotoristaNameOrCnh();
            if (input == null || input.trim().isEmpty()) {
                MessagesHelper.error("Entrada inválida.");
                return;
            }

            List<Motorista> motoristas = motoristaDAO.getMotoristaByCnhOrName(input);
            if (motoristas.isEmpty()) {
                MessagesHelper.error("Nenhum motorista encontrado com esse nome ou CNH.");
            } else {
                motoristaList.PrintMotoristaList(motoristas);
            }
        } catch (SQLException e) {
            MessagesHelper.error("Erro ao buscar motorista.");
            e.printStackTrace();
        }
    }


    //========================================================================================


    //DELETAR MOTORISTA
    public void deleteMotorista() {
        try {
            String cnh = MotoristaMenus.cnhMotoristaInput();
            if (!MotoristaDeleteConfim.confirmDelete()) {
                MessagesHelper.info("EXCLUSÃO CANCELADA PELO USUÁRIO");
                return;
            }

            boolean excluido = motoristaDAO.deleteMotorista(cnh);
            if (excluido) {
                MessagesHelper.success("MOTORISTA EXCLUÍDO COM SUCESSO!");
            } else {
                MessagesHelper.error("Nenhum motorista encontrado com esse CNH.");
            }

        } catch (SQLException e) {
            MessagesHelper.error("Erro ao excluir motorista no sistema.");
            e.printStackTrace();
        }
    }


    //========================================================================================


    //VERIFICAR SE O MOTORISTA EXISTE PELO ID E RETORNA ELE
    public Motorista verifyIfExistsMotorista(int id) {
        try {
            return motoristaDAO.getMotoristaById(id);
        } catch (SQLException e) {
            MessagesHelper.error("Erro ao buscar motorista pelo ID.");
            return null;
        }
    }
}
