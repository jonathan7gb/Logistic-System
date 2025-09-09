package org.transportadora.view.Registrations;

import org.transportadora.model.Cliente;
import org.transportadora.view.menus.ClienteMenus;

public class ClienteRegister {

    public static Cliente registerCliente(){
        String nome = ClienteMenus.nomeClienteInput();
        String cpf_cnpj = ClienteMenus.cpfCnpjClienteInput();
        String endereco = ClienteMenus.enderecoClienteInput();
        String cidade = ClienteMenus.cidadeClienteInput();
        var estado = ClienteMenus.estadoClienteInput();

        return new Cliente(nome, cpf_cnpj, endereco, cidade, estado);
    }
}
