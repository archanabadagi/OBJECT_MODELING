package com.object.modeling.jukebox.services;

import com.object.modeling.jukebox.repositories.IUserRepository;
import com.object.modeling.jukebox.entities.User;

public class UserService implements IUserService{
    private final IUserRepository userRepository;

    public UserService(IUserRepository userRepository){
        this.userRepository=userRepository;
    }

    public User create(String name){
        return userRepository.save(new User(name));
    }
    
}
