package org.transportadora.view.utils;

import org.transportadora.model.Cliente;
import org.transportadora.model.Motorista;
import org.transportadora.view.menus.ClienteMenus;
import org.transportadora.view.menus.MotoristaMenus;

public class MotoristaRegister {

    public static Motorista registerMotorista(){
        String nome = MotoristaMenus.nomeMotoristaInput();
        String cnh = MotoristaMenus.cnhMotoristaInput();
        String veiculo = MotoristaMenus.veiculoMotoristaInput();
        String cidade_base = MotoristaMenus.cidadeBaseMotoristaInput();

        return new Motorista(nome, cnh, veiculo, cidade_base);
    }
}
