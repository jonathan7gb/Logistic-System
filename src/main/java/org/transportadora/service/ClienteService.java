package org.transportadora.service;

import org.transportadora.dao.ClienteDAO;
import org.transportadora.model.Cliente;
import org.transportadora.view.registrations.ClienteRegister;

import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.List;

public class ClienteService {
    ClienteDAO clienteDAO =  new ClienteDAO();

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
                System.out.println("|| ================== LISTA DE CLIENTES ================== ||");
                for(Cliente c : clientes){
                    Thread.sleep(300);
                    System.out.println(c);
                    System.out.println("-------------------------------------------------------------");
                }
            }
        }catch (SQLException e){
            e.printStackTrace();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
