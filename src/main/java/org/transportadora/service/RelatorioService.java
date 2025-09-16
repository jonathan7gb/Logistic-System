package org.transportadora.service;

import org.transportadora.dao.RelatorioDAO;
import org.transportadora.view.MessagesHelper;
import org.transportadora.view.menus.MotoristaMenus;

import java.sql.SQLException;

public class RelatorioService {

    RelatorioDAO relatorioDAO = new RelatorioDAO();

    public void totalEntregasPorMotorista() {
        int motoristaId = MotoristaMenus.idMotoristaInput();

        try{
            int totalEntregas = relatorioDAO.totalEntregasPorMotorista(motoristaId);
            if(totalEntregas > 0){
                MessagesHelper.info("Total de entregas realizadas pelo motorista ID " + motoristaId + ": " + totalEntregas);
            }else if(totalEntregas == 0){
                MessagesHelper.info("Nenhuma entrega cadastrada a esse motorista.");
            }else{
                    MessagesHelper.info("Motorista com ID " + motoristaId + " não encontrado ou sem entregas.");

            }
        }catch (SQLException e){
            MessagesHelper.error(e.getMessage());
        }
    }

    public void clientesComMaiorVolumeEntregue() {
        // Lógica para gerar o relatório de clientes com mais pedidos
    }

    public void pedidosPendentePorEstado() {
        // Lógica para gerar o relatório de pedidos pendentes por estado
    }

    public void entregasAtrasadasPorCidade() {
        // Lógica para gerar o relatório de entregas atrasadas por cidade
    }

}
