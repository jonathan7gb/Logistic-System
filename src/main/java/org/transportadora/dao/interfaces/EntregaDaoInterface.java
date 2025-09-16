package org.transportadora.dao.interfaces;

import org.transportadora.model.Entrega;
import org.transportadora.model.HistoricoEntrega;
import org.transportadora.view.utils.HistoricoEntregaRegister;

import java.sql.SQLException;
import java.util.List;

public interface EntregaDaoInterface {

    void entregaRegister(Entrega entrega)  throws SQLException;
    List<Entrega> getAllEntregas()  throws SQLException;
    boolean deleteEntrega(int idEntrega)  throws SQLException;

    List<Entrega> getEntregaById(int idEntrega)  throws SQLException;

    boolean updateEntregaStatus(int idEntrega) throws SQLException;

    void historicoEntregaRegister(HistoricoEntrega historicoEntrega) throws SQLException;
}
