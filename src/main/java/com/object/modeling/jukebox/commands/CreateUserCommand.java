package com.object.modeling.jukebox.commands;

import java.util.List;
import com.object.modeling.jukebox.services.IUserService;
import com.object.modeling.jukebox.entities.User;


public class CreateUserCommand implements ICommand{

    private final IUserService userService;

    public CreateUserCommand(IUserService userService){
        this.userService=userService;
    }

    @Override
    public void execute(List<String> tokens) {
        try{
            User user = userService.create(tokens.get(1));
            System.out.println(user);
        }catch(RuntimeException e){
            System.out.println(e.getMessage());
        }
    }
    
}
