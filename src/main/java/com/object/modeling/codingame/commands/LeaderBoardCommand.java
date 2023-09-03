package com.object.modeling.codingame.commands;

import java.util.List;
import java.util.stream.Collectors;


import com.object.modeling.codingame.entities.ScoreOrder;
import com.object.modeling.codingame.entities.User;
import com.object.modeling.codingame.services.IUserService;

public class LeaderBoardCommand implements ICommand{

    private final IUserService userService;
    
    public LeaderBoardCommand(IUserService userService) {
        this.userService = userService;
    }

    // TODO: CRIO_TASK_MODULE_CONTROLLER
    // Execute getAllUserScoreOrderWise method of IUserService and print the result.
    // Look for the unit tests to see the expected output.
    // Sample Input Token List:- ["LEADERBOARD","ASC"]
    // or
    // ["LEADERBOARD","DESC"]

    @Override
    public void execute(List<String> tokens) {
        try{
            List<User> users = userService.getAllUserScoreOrderWise(ScoreOrder.valueOf(tokens.get(1)));
            System.out.println("["+users.stream().map(u -> "User [id=" + u.getId() + ", contests=" + u.getContests() + ", name=" + u.getName() +", score=" + u.getScore()+"]").collect(Collectors.joining(", "))+"]");
            //String expectedOutput = "[User [id=1, contests=[], name=name1, score=30], User [id=3, contests=[], name=name3, score=40], User [id=2, contests=[], name=name2, score=50]]";
        }catch(RuntimeException e){
            System.out.println(e.getMessage());
        }
    }
    
}
