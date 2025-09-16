package org.transportadora.service;

import org.transportadora.dao.RelatorioDAO;
import org.transportadora.model.Cliente;
import org.transportadora.view.MessagesHelper;
import org.transportadora.view.Motorista.MotoristaMenus;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;


public class RelatorioService {

    RelatorioDAO relatorioDAO = new RelatorioDAO();

    //========================================================================================

    //TOTAL DE ENTREGAS POR MOTORISTA
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


    //========================================================================================

    //CLIENTES COM MAIOR VOLUME DE ENTREGA
    public void clientesComMaiorVolumeEntregue() {
        try {
            List<Map.Entry<Cliente, Double>> ranking = relatorioDAO.clientesComMaiorVolumeEntrega();

            if (ranking.isEmpty()) {
                MessagesHelper.error("Nenhum cliente com pedidos entregues.");
                return;
            }

            System.out.println("=== Ranking de Clientes por Volume Entregue ===");
            for (Map.Entry<Cliente, Double> entry : ranking) {
                Cliente cliente = entry.getKey();
                Double volume = entry.getValue();

                System.out.printf("Cliente: %s | CPF/CNPJ: %s | Volume Total: %.2f m³%n",
                        cliente.getNome(),
                        cliente.getCpf_cnpj(),
                        volume);
            }

        } catch (SQLException e) {
            MessagesHelper.error("Erro ao gerar ranking de clientes: " + e.getMessage());
        }
    }


    //========================================================================================


    //PEDIDOS PENDENTES POR ESTADO
    public void pedidosPendentePorEstado() {
        // Lógica para gerar o relatório de pedidos pendentes por estado
    }


    //========================================================================================


    //ENTREGAS ATRASADAS POR CIDADE
    public void entregasAtrasadasPorCidade() {
        // Lógica para gerar o relatório de entregas atrasadas por cidade
    }

}
