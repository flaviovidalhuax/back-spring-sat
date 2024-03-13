package com.userTest.TestUser.controller;

import com.userTest.TestUser.entity.UserEntity;
import com.userTest.TestUser.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/user")
public class userController {
    @Autowired
    private UserService userService;

    @Autowired
    private UserEntity userEntity;
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UserEntity GuardarUSer(@Valid @RequestBody UserEntity userEntity){
            return userService.saveUser(userEntity);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<UserEntity> GetAllUser(){
        return userService.getAllUSers();
    }

    @GetMapping("/{id}")
   // @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<UserEntity> getUserById(@PathVariable("id") Long userID){

        return userService.getUserById(userID)
                .map(ResponseEntity::ok)
                .orElseGet(()->ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserEntity> actualizarUser(@PathVariable("id") long userId,@RequestBody UserEntity userEntity){
        return userService.getUserById(userId)
                .map(userGuardado-> {
                    userGuardado.setName(userEntity.getName());
                    userGuardado.setLastName(userEntity.getLastName());
                    userGuardado.setEmail(userEntity.getEmail());

                    UserEntity userActualizado=userService.updateUser(userGuardado);
                    return new ResponseEntity<>(userActualizado,HttpStatus.OK);
                })
                .orElseGet(()->ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarUser(@PathVariable("id") long userId){
        userService.deleteUser(userId);
        return new ResponseEntity<String>("userio eliminado", HttpStatus.OK);
    }
}
