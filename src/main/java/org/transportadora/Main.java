package org.transportadora;

import org.transportadora.controller.SystemController;

public class Main {
    public static void main(String[] args) {

        SystemController systemController = new SystemController();
        systemController.startSystem();
    }
}