package org.transportadora.service;

import org.transportadora.dao.ClienteDAO;
import org.transportadora.model.Cliente;
import org.transportadora.view.Cliente.*;
import org.transportadora.view.MessagesHelper;

import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;

public class ClienteService {
    ClienteDAO clienteDAO =  new ClienteDAO();
    ClienteList clienteList = new ClienteList();


    //========================================================================================


    //REGISTRAR CLIENTE
    public void registerCliente(){
        boolean cadastroConcluido = false;
        while(!cadastroConcluido){
            Cliente cliente = ClienteRegister.registerCliente();

            try{
                clienteDAO.clienteRegister(cliente);
                MessagesHelper.success("CLIENTE CADASTRADO COM SUCESSO!");
                cadastroConcluido = true;
            }catch (SQLIntegrityConstraintViolationException e) {
                MessagesHelper.error("Cliente já cadastrado com esse CPF/CNPJ. Vamos recomeçar o cadastro. Insira o nome: ");
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
    }


    //========================================================================================


    //LISTAR TODOS CLIENTES
    public void getAllClientes(){
        try {
            List<Cliente> clientes = clienteDAO.getAllClientes();
            if (clientes.isEmpty()) {
                MessagesHelper.error("Nenhum cliente cadastrado no sistema.");
            } else {
                clienteList.PrintClienteList(clientes);
            }
        } catch (SQLException e) {
            MessagesHelper.error("Erro ao listar clientes.");
        }
    }


    //========================================================================================


    //BUSCAR CLIENTE POR NOME OU CPF/CNPJ
    public void getClienteByCpfCnpjOrName() {
        try {
            String input = ClientSearchByNameOrCpf.ClienteNameOrCpf();
            if (input == null || input.trim().isEmpty()) {
                MessagesHelper.error("Entrada inválida.");
                return;
            }

            List<Cliente> clientes = clienteDAO.getClienteByCpfCnpjOrName(input);
            if (clientes.isEmpty()) {
                MessagesHelper.error("Nenhum cliente encontrado com esse nome ou CPF/CNPJ.");
            } else {
                System.out.println();
                clienteList.PrintClienteList(clientes);
            }

        } catch (SQLException e) {
            MessagesHelper.error("Erro ao buscar o cliente no sistema.");
        }
    }

    //========================================================================================


    //DELETAR CLIENTE
    public void deleteCliente(){
        try{
            String cpfCnpj = ClienteMenus.cpfCnpjClienteInput();
            boolean confirmDelete = ClienteDeleteConfim.confirmDelete();
            if(confirmDelete){
                boolean excluido = clienteDAO.deleteCliente(cpfCnpj);

                if(excluido){
                    MessagesHelper.success("CLIENTE EXCLUÍDO COM SUCESSO!");
                }else{
                    MessagesHelper.error("NENHUM CLIENTE ENCONTRADO COM ESSE CPF/CNPJ.");
                }
            }else{
                MessagesHelper.info("EXCLUSÃO CANCELADA PELO USUÁRIO");
            }

        }catch (SQLException e ){
            MessagesHelper.error("Erro ao excluir cliente no sistema.");
        }
    }


    //========================================================================================


    //VERIFICAR SE CLIENTE EXISTE PELO ID (USADO PARA PEDIDO E ETC) E RETORNA ESSE CLIENTE
    public Cliente verifyIfExistsCliente(int id) {
        try {
            return clienteDAO.getClienteById(id);
        } catch (SQLException e) {
            MessagesHelper.error("Erro ao buscar cliente pelo ID.");
            return null;
        }
    }
}
