package org.transportadora.view.Motorista;

import org.transportadora.view.InputHelper;

public class MotoristaDeleteConfim {

    public static boolean confirmDelete(){
        System.out.println("\n|| - Tem certeza que deseja excluir esse motorista?\n|| - Os pedidos e entregas vinculadas a ele também serão excluídos!!\n|| - Essa ação é irreversível!");
        System.out.println("|| =====================================================");
        System.out.println("|| 1 - SIM\n|| 2 - NÃO");
        int escolha = InputHelper.inputInteger("|| Escolha uma opção: ", scannerInt);

        if(escolha == 1){
            return true;
        } else {
            return false;
        }
    }
}
