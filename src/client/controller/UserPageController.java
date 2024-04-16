package client.controller;

import server.VO.UserVO;
import server.controller.UserController;

public class UserPageController {
    private UserController userController = new UserController();

    public boolean signUp(String id, String password, String sunfishName) {
        return userController.signUp(id, password, sunfishName);
    }

    public UserVO signIn(String id, String password) {
        return userController.login(id, password);
    }

}
