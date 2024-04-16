import client.controller.MainController;
import client.frame.MainView;
import server.controller.UserController;
import client.controller.FrontController;

public class Main {
    public static void main(String[] args) {

        // server
        new UserController();

        // client
        new MainController();
    }
}