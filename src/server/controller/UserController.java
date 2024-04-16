package server.controller;
import server.dao.UserDao;
import server.VO.UserVO;

public class UserController {
    private UserDao userDao;

    // Main View
    public UserController() {
        // new CalcView(this);
        // userDao = new UserDao();
    }

    public void signUp(String id, String password, String sunfishName) {
        userDao.signUp(new UserVO(id, password, sunfishName));
    }

    public UserVO login(String id, String password) {
        return userDao.login(id, password);
    }

    public void setWeight(double weight){
        userDao.setWeight(weight);
    }

    public void increaseLevel(){
        userDao.increaseLevel();
    }

    public double getWeight(){
        return userDao.getWeight();
    }

    public int getLevel(){
        return userDao.getLevel();
    }
}
