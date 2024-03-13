package com.userTest.TestUser.service.impl;

import com.userTest.TestUser.entity.ChildEntity;
import com.userTest.TestUser.entity.UserEntity;
import com.userTest.TestUser.repository.ChildRepository;
import com.userTest.TestUser.repository.UserRepository;
import com.userTest.TestUser.service.ChildService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ChildServiceImpl implements ChildService {
    @Autowired
    ChildRepository childRepository;
    @Autowired
    UserRepository userRepository;


    @Override
    public ChildEntity saveChild(ChildEntity child, Long id) {
        Optional<UserEntity> childSave= userRepository.findById(id);
        if(childSave.isPresent()){
            try {
                throw new ReflectiveOperationException("el hijo ya existe"+child.getChild_name());
            }catch (ReflectiveOperationException e){
                throw new RuntimeException(e);
            }
        }
        return childRepository.save(child);
    }

    @Override
    public List<ChildEntity> getAllChild() {
        return childRepository.findAll();
    }

    @Override
    public Optional<ChildEntity> getChildById(Long id) {
        return childRepository.findById(id);
    }

    @Override
    public void deletedChild(Long id) {
        childRepository.deleteById(id);
    }
}
