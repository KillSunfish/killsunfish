package client.controller;

import client.frame.MainView;

public class MainController {

    private FrontController frontController = FrontController.getInstance();

    public MainController() {
        frontController.setMainView(new MainView());
    }
}
