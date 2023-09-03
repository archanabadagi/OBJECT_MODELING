package com.object.modeling.codingame.commands;

import java.util.List;

import com.object.modeling.codingame.entities.User;
import com.object.modeling.codingame.services.IUserService;

public class CreateUserCommand implements ICommand{

    private final IUserService userService;
    
    public CreateUserCommand(IUserService userService) {
        this.userService = userService;
    }

    // TODO: CRIO_TASK_MODULE_CONTROLLER
    // Execute create method of IUserService and print the result.
    // Look for the unit tests to see the expected output.
    // Sample Input Token List:- ["CREATE_QUESTION","Ross"]

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
