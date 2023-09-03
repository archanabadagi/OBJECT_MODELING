package com.object.modeling.codingame.repositories;

import java.util.Optional;

import com.object.modeling.codingame.entities.User;

public interface IUserRepository extends CRUDRepository<User,String> {
    public Optional<User> findByName(String name); 
}
