package org.transportadora.controller;

import org.transportadora.dao.ClienteDAO;
import org.transportadora.exceptions.InvalidCpfCnpjException;
import org.transportadora.model.Cliente;
import org.transportadora.view.Errors;
import org.transportadora.view.registrations.ClienteRegister;
import org.transportadora.view.menus.ClienteMenus;

import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.List;

public class ClienteController {

    public static void clienteController() {
        int opcao = -1;
        ClienteDAO clienteDAO = new ClienteDAO();

        do {
            opcao = ClienteMenus.menuCliente();

            switch (opcao) {
                case 1 -> {
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

                } //BREAK CASE 1 DO SWITCH OPCAO - CADASTRAR CLIENTE

                case 2 -> {
                    List<Cliente> clientes = new ArrayList<>();

                    try{
                        clientes = clienteDAO.getAllClientes();

                        if(clientes.isEmpty()){
                            System.out.println("\n|| ==== Nenhum cliente cadastrado no sistema. ==== ||");
                        }else{
                            for(Cliente c : clientes){
                                Thread.sleep(300);
                                System.out.println(c);
                                System.out.println("---------------------------------------------------------");
                            }
                        }
                    }catch (SQLException e){
                        e.printStackTrace();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }

                }//BREAK CASE 2 DO SWITCH OPCAO - LISTAR CLIENTES

                case 3 -> {
                }//BREAK CASE 1 DO SWITCH OPCAO - BUSCAR CLIENTES

                case 4 -> {
                }//BREAK CASE 1 DO SWITCH OPCAO - EXCLUIR CLIENTE

                case 0 -> {
                    return;
                }//BREAK CASE 0 DO SWITCH OPCAO - SAIR DO MENU CLIENTE

                default -> {
                    Errors.invalidOption();
                } //BREAK DEFAULT DO SWITCH OPCAO - OPÇÃO INVÁLIDA
            }
        }while(true);

    }
}
