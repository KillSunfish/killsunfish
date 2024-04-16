package client.controller;

import client.components.DeathPageComponent;
import client.frame.HomeScreen;
import client.frame.MainView;
import server.VO.UserVO;

public class FrontController {

    private static FrontController instance = new FrontController();

    private UserPageController userController;

    private MainView mainView;

    private FrontController() {
        this.userController = new UserPageController();
    }

    public static FrontController getInstance() {
        return instance;
    }

    public void setMainView(MainView mainView) {
        this.mainView = mainView;
    }

    public void userSignUp(String id, String password, String sunfishName) {
        if(userController.signUp(id, password, sunfishName)) {
            mainView.switchView("signUpFinished", null);
        }
    }

    public void userSignIn(String id, String password) {
        UserVO userVO = userController.signIn(id, password);
        if(userVO != null) {
            System.out.println("Done");
            mainView.switchView("signInFinished", new HomeScreen(userVO));
        } else {
            System.out.println("Incorrect Input");
        }
    }

    public void sunfishDiesByCode(int code) {
        DeathPageComponent deathPageComponent = new DeathPageComponent(code);
        mainView.setOverlay(deathPageComponent);
    }

    public void returnToMainPage() {
        mainView.switchView("main", null);
    }
}
