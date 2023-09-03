package com.object.modeling.codingame.commands;

import java.util.List;
import java.util.stream.Collectors;

import com.object.modeling.codingame.entities.Level;
import com.object.modeling.codingame.entities.Question;
import com.object.modeling.codingame.services.IQuestionService;

public class ListQuestionCommand implements ICommand{

    private final IQuestionService questionService;
    
    public ListQuestionCommand(IQuestionService questionService) {
        this.questionService = questionService;
    }

    // TODO: CRIO_TASK_MODULE_CONTROLLER
    // Execute getAllQuestionLevelWise method of IQuestionService and print the result.
    // Look for the unit tests to see the expected output.
    // Sample Input Token List:- ["LIST_QUESTION","HIGH"]
    // or
    // ["LIST_QUESTION"]

    @Override
    public void execute(List<String> tokens) {
        Level level = null;
        if(tokens.size() == 2)
            level = Level.valueOf(tokens.get(1));
        try{
            List<Question> qList = questionService.getAllQuestionLevelWise(level);
            System.out.println("["+qList.stream().map(q -> "Question [id="+q.getId()+", level="+q.getLevel()+", score="+q.getScore()+", title="+q.getTitle()+"]").collect(Collectors.joining(", "))+"]");
        }catch(RuntimeException e){
            System.out.println(e.getMessage());
        }
    }
    
}
