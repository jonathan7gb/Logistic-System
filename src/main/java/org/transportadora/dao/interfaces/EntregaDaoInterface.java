package org.transportadora.dao.interfaces;

import org.transportadora.model.Entrega;

import java.sql.SQLException;
import java.util.List;

public interface EntregaDaoInterface {

    void entregaRegister(Entrega entrega)  throws SQLException;
    List<Entrega> getAllEntregas()  throws SQLException;
    boolean deleteEntrega(int idEntrega)  throws SQLException;

    List<Entrega> getEntregaById(int idEntrega)  throws SQLException;

    boolean updateEntregaStatus(int idEntrega) throws SQLException;

    List<Entrega> getEntregaByCpfCnpjOrCnh(String cpfCnpjOrCnh) throws SQLException;
}
