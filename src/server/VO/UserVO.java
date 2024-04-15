package server.VO;

public class UserVO {
    private String id;
    private String password;
    private String sunfishName;
    private double weight;
    private int level;

    public UserVO() {}
    public UserVO(String id, String password, String sunfishName) {
        this.id = id;
        this.password = password;
        this.sunfishName = sunfishName;
        this.weight = 0.1;
        this.level = 1;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSunfishName() {
        return sunfishName;
    }

    public void setSunfishName(String sunfishName) {
        this.sunfishName = sunfishName;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public int getLevel() {
        return level;
    }

    public void increaseLevel(){
        level++;
    }
}