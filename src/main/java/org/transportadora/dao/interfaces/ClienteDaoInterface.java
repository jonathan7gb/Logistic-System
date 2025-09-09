package org.transportadora.dao.interfaces;

import org.transportadora.model.Cliente;

import java.sql.SQLException;
import java.util.List;

public interface ClienteDaoInterface {

    void clienteRegister(Cliente cliente)  throws SQLException;
//    List<Cliente> getAllClientes();
//    Cliente getClienteByCpfCnpj(String cpfCnpj);
//    void deleteCliente(String cpfCnpj);

}
