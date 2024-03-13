package com.userTest.TestUser.controller;

import com.userTest.TestUser.entity.ChildEntity;
import com.userTest.TestUser.entity.UserEntity;
import com.userTest.TestUser.service.ChildService;
import com.userTest.TestUser.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/child")
@CrossOrigin(origins = "*")
public class ChildController {
    @Autowired
    ChildService childService;
    @Autowired
    UserService userService;
    @PostMapping("/{id}")
    public ResponseEntity<ChildEntity> saveChild(@Valid @RequestBody ChildEntity child , @PathVariable("id") Long id) {
        Optional<UserEntity> user=userService.getUserById(id);
        return new ResponseEntity<ChildEntity>(childService.saveChild(child, id),HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<ChildEntity>> allChild(){
        return (ResponseEntity<List<ChildEntity>>) childService.getAllChild();
    }
}
