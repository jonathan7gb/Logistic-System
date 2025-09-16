package org.transportadora.service;

import org.transportadora.dao.ClienteDAO;
import org.transportadora.model.Cliente;
import org.transportadora.view.MessagesHelper;
import org.transportadora.view.menus.ClienteMenus;
import org.transportadora.view.utils.ClientSearchByNameOrCpf;
import org.transportadora.view.utils.ClienteRegister;
import org.transportadora.view.utils.ClienteList;

import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.List;

public class ClienteService {
    ClienteDAO clienteDAO =  new ClienteDAO();
    ClienteList clienteList = new ClienteList();

    public void registerCliente(){
        boolean cadastroConcluido = false;
        while(!cadastroConcluido){
            Cliente cliente = ClienteRegister.registerCliente();

            try{
                clienteDAO.clienteRegister(cliente);
                MessagesHelper.success("CLIENTE CADASTRADO COM SUCESSO!");
                cadastroConcluido = true;
            }catch (SQLIntegrityConstraintViolationException e) {
                System.err.print("Cliente já cadastrado com esse CPF/CNPJ. Vamos recomeçar o cadastro. Insira o nome: ");
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
    }

    public void getAllClientes(){
        List<Cliente> clientes = new ArrayList<>();

        try{
            clientes = clienteDAO.getAllClientes();

            if(clientes.isEmpty()){
                MessagesHelper.error("Nenhum cliente cadastrado no sistema.");
            }else{
                clienteList.PrintClienteList(clientes);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void getClienteByCpfCnpjOrName(){
        List<Cliente> clientes = new ArrayList<>();

        try{
            String nameOrCpf = ClientSearchByNameOrCpf.ClienteNameOrCpf();

            clientes = clienteDAO.getClienteByCpfCnpjOrName(nameOrCpf);

            if (clientes.isEmpty()){
                MessagesHelper.error("Nenhum cliente encontrado com esse nome ou CPF/CNPJ.");
            }else{
                System.out.println();
                clienteList.PrintClienteList(clientes);
            }
        }catch (SQLException e){
            MessagesHelper.error("Erro ao buscar o cliente no sistema.");
        }
    }

    public void deleteCliente(){
        try{
            String cpfCnpj = ClienteMenus.cpfCnpjClienteInput();
            boolean confirmDelete = ClientSearchByNameOrCpf.confirmDelete();
            if(confirmDelete){
                boolean excluido = clienteDAO.deleteCliente(cpfCnpj);

                if(excluido){
                    MessagesHelper.success("CLIENTE EXCLUÍDO COM SUCESSO!");
                }else{
                    MessagesHelper.error("NENHUM CLIENTE ENCONTRADO COM ESSE CPF/CNPJ.");
                }
            }else{
                MessagesHelper.error("EXCLUSÃO CANCELADA PELO USUÁRIO");
            }

        }catch (SQLException e ){
            MessagesHelper.error("Erro ao excluir cliente no sistema.");
        }
    }

    public Cliente verifyIfExistsCliente(int id){
        Cliente cliente = null;
        try{
            List<Cliente> clientes = clienteDAO.getAllClientes();
            for(Cliente c : clientes){
                if(c.getId() == id){
                    cliente = c;
                    cliente = new Cliente(c.getId(), c.getNome(), c.getCpf_cnpj(), c.getEndereco(), c.getCidade(), c.getEstado());
                    break;
                }
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return cliente;
    }
}
