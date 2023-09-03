package com.object.modeling.jukebox.repositories;

import com.object.modeling.jukebox.entities.User;

import java.util.Optional;

public interface IUserRepository extends CRUDRepository<User,String> {
    public Optional<User> findByName(String name); 
}
