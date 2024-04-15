import client.frame.MainView;
import server.controller.UserController;

public class Main {
    public static void main(String[] args) {

        new UserController();

        MainView gameView = new MainView();
    }
}