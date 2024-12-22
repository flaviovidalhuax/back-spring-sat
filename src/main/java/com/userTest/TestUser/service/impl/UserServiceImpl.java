package com.userTest.TestUser.service.impl;

import com.userTest.TestUser.entity.UserEntity;
import com.userTest.TestUser.repository.UserRepository;
import com.userTest.TestUser.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.List;
@Service
//@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserEntity saveUser(UserEntity userEntity) {
        Optional<UserEntity> userGuardado=userRepository.findByEmail(userEntity.getEmail());
        if (userGuardado.isPresent()){
            try {
                throw new ReflectiveOperationException(("el usaurio ya existe: "+userEntity.getEmail()));
            } catch (ReflectiveOperationException e) {
                throw new RuntimeException(e);
            }
        }
        return userRepository.save(userEntity);
    }

    @Override
    public List<UserEntity> getAllUSers() {
        return userRepository.findAll();
    }

    @Override
    public Optional<UserEntity> getUserById(Long id) {
        return Optional.ofNullable(userRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException(" este usuario on id no exte")));
    }

    @Override
    public UserEntity updateUser(UserEntity userActualizado) {
        return userRepository.save(userActualizado);
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
