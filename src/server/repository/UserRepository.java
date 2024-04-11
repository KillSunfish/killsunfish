package server.repository;

import server.entity.UserEntity;

public interface UserRepository {

    void create(UserEntity userEntity);
}
