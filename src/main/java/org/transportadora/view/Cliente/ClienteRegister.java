package org.transportadora.view.Cliente;

import org.transportadora.model.Cliente;

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
