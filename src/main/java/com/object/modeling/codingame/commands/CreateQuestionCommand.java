package com.object.modeling.codingame.commands;

import java.util.List;

import com.object.modeling.codingame.entities.Level;
import com.object.modeling.codingame.entities.Question;
import com.object.modeling.codingame.services.IQuestionService;

public class CreateQuestionCommand implements ICommand{

    private final IQuestionService questionService;
    
    public CreateQuestionCommand(IQuestionService questionService) {
        this.questionService = questionService;
    }

    // TODO: CRIO_TASK_MODULE_CONTROLLER
    // Execute create method of IQuestionService and print the result.
    // Look for the unit tests to see the expected output.
    // Sample Input Token List:- ["CREATE_QUESTION","Question22","HIGH","220"]

    @Override
    public void execute(List<String> tokens) {
        String title = tokens.get(1);
        String level = tokens.get(2);
        Integer score = Integer.parseInt(tokens.get(3));
        try{
            Question question = questionService.create(title, Level.valueOf(level),score);
            System.out.println(question);
        }catch(RuntimeException e){
            System.out.println(e.getMessage());
        }
    }
    
}
