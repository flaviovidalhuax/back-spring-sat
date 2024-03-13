package com.userTest.TestUser.service;

import com.userTest.TestUser.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public interface UserService {
    UserEntity saveUser(UserEntity userEntity);
    List<UserEntity> getAllUSers();
    Optional<UserEntity> getUserById(Long id);
    UserEntity updateUser(UserEntity userActualizado);
    void deleteUser(Long id);

}
