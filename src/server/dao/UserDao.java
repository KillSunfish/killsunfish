package server.dao;

import server.user.User;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicLong;

public class UserDao {
    // db 연동, 연산
    private final Map<Long, User> map = new HashMap<>();
    private final AtomicLong idCounter = new AtomicLong(0); // id 0부터 증가
    private long loginUserId = -1;

    public boolean signUp(User user) {
        for (User existingUser : map.values()) {
            if (existingUser.getId().equals(user.getId())) {
                return false;
            }
        }

        long id = idCounter.incrementAndGet();
        map.put(id, user);
        return true;
    }

    public User login(String id, String password) {
        for (long key : map.keySet()) {
            if (map.get(key).getId().equals(id) && map.get(key).getPassword().equals(password)) {
                loginUserId = key;
                return map.get(key); // 사용자가 일치하는 경우 해당 사용자 반환
            }
        }
        return null; // 사용자 없거나 비밀번호 일치하지 않는 경우
    }

    public void setWeight(double weight){
        if (loginUserId != -1) {
            User user = map.get(loginUserId);
            user.setWeight(weight);
        }
    }

    public void increaseLevel(){
        if (loginUserId != -1) {
            User user = map.get(loginUserId);
            user.increaseLevel();
        }
    }

    public double getWeight(){
        if (loginUserId != -1) {
            User user = map.get(loginUserId);
            return user.getWeight();
        }
        return -1; // 사용자가 로그인하지 않았거나 존재하지 않는 경우
    }

    public int getLevel(){
        if (loginUserId != -1) {
            User user = map.get(loginUserId);
            return user.getLevel();
        }
        return -1; // 사용자가 로그인하지 않았거나 존재하지 않는 경우
    }
}

