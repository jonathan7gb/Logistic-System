package org.transportadora.dao.interfaces;

import org.transportadora.model.Motorista;

import java.sql.SQLException;
import java.util.List;

public interface MotoristaDaoInterface {

    void motoristaRegister(Motorista motorista)  throws SQLException;
    List<Motorista> getAllMotoristas()  throws SQLException;
    List<Motorista> getMotoristaByCnhOrName(String cnhOrName)  throws SQLException;
    boolean deleteMotorista(String cnh)  throws SQLException;
}
