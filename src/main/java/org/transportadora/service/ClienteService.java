package org.transportadora.service;

import org.transportadora.dao.ClienteDAO;
import org.transportadora.model.Cliente;
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
                System.out.println("\n|| ==== Nenhum cliente cadastrado no sistema. ==== ||");
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
                System.out.println("\n|| ==== Nenhum cliente encontrado com esse nome ou CPF/CNPJ. ==== ||");
            }else{
                clienteList.PrintClienteList(clientes);
            }
        }catch (SQLException e){
            System.out.println("\n|| ==== Erro ao buscar o cliente no sistema. ==== ||");
        }
    }

    public void deleteCliente(){
        try{
            String cpfCnpj = ClienteMenus.cpfCnpjClienteInput();
            boolean confirmDelete = ClientSearchByNameOrCpf.confirmDelete();
            if(confirmDelete){
                boolean excluido = clienteDAO.deleteCliente(cpfCnpj);

                if(excluido){
                    System.out.println("\n|| ====== CLIENTE EXCLUÍDO COM SUCESSO! ====== ||");
                }else{
                    System.out.println("\n|| ==== NENHUM CLIENTE ENCONTRADO COM ESSE CPF/CNPJ. ==== ||");
                }
            }else{
                System.out.println("\n|| ==== EXCLUSÃO CANCELADA PELO USUÁRIO ==== ||");
            }

        }catch (SQLException e ){
            System.out.println("\n|| ==== Erro ao excluir cliente no sistema. ==== ||");
        }
    }
}
