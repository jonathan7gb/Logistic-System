package org.transportadora.view.utils;

import org.transportadora.model.Entrega;
import org.transportadora.model.HistoricoEntrega;
import org.transportadora.model.Motorista;
import org.transportadora.model.Pedido;
import org.transportadora.model.enums.StatusEntrega;
import org.transportadora.view.MessagesHelper;
import org.transportadora.view.menus.EntregaMenus;

import java.util.Date;

public class HistoricoEntregaRegister {

    public static HistoricoEntrega registerHistoricoEntrega(){

       Entrega entrega = EntregaRegister.searchEntrega();
        if(entrega == null) {
            MessagesHelper.error("Entrega não encontrado. Por favor, verifique os dados do entrega.");
            return null;
        }else{
            Date dataAtualizacao = EntregaMenus.dataAtualizacaoInput();
            if(dataAtualizacao == null){
                MessagesHelper.error("Data inválida. Por favor, verifique os dados inseridos.");
                return null;
            }else{

                String descricao = EntregaMenus.descricaoInput();

                return new HistoricoEntrega(entrega, dataAtualizacao, descricao);
            }
        }

    }
}
