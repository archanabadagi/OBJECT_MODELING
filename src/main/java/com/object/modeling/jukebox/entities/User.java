package com.object.modeling.jukebox.entities;

public class User extends BaseEntity{
    private final String name;

    public User(User user){
        this(user.id, user.name);
    }

    public User(String id, String name){
        this.id=id;
        this.name=name;
    }
    
    public User(String name){
        this.name=name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return id+" "+name;
    }
    
}
