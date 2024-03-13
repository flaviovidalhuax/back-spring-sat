package com.userTest.TestUser.service;

import com.userTest.TestUser.entity.ChildEntity;

import java.util.List;
import java.util.Optional;

public interface ChildService {

    List<ChildEntity> getAllChild();
    Optional<ChildEntity> getChildById(Long id);
    void deletedChild(Long id);

    ChildEntity saveChild(ChildEntity child, Long id);
}
