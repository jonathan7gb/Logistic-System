package org.transportadora.view;

public class SystemEnd {

    public static void systemEnd() {
        System.out.println("\n|| ==========================================");
        try{
            Thread.sleep(300);
            System.out.print("|");
            Thread.sleep(300);
            System.out.print("|     ");
            Thread.sleep(300);
            System.out.print("   1 ");
            Thread.sleep(300);
            System.out.print("2 ");
            Thread.sleep(300);
            System.out.print("3");
            Thread.sleep(300);
            System.out.print(".");
            Thread.sleep(300);
            System.out.print(".");
            Thread.sleep(300);
            System.out.print(".");
            Thread.sleep(600);
            System.out.print(" Sistema ");
            Thread.sleep(400);
            System.out.print("encerrado");
            Thread.sleep(400);
            System.out.println(".  ");
            Thread.sleep(400);
        }catch (InterruptedException e){
            MessagesHelper.error("O sistema foi encerrado inesperadamente.");
        }
        System.out.println("|| ==========================================");
    }
}
