package com.object.modeling.codingame.commands;

import java.util.List;

import com.object.modeling.codingame.entities.Contest;
import com.object.modeling.codingame.entities.Level;
import com.object.modeling.codingame.services.IContestService;

public class ListContestCommand implements ICommand{

    private final IContestService contestService;
    
    public ListContestCommand(IContestService contestService) {
        this.contestService = contestService;
    }

    // TODO: CRIO_TASK_MODULE_CONTROLLER
    // Execute getAllContestLevelWise method of IContestService and print the result.
    // Look for the unit tests to see the expected output.
    // Sample Input Token List:- ["LIST_CONTEST","HIGH"]
    // or
    // ["LIST_CONTEST"]

    @Override
    public void execute(List<String> tokens) {
        //"[Contest [id=1, name=contestName1, level=HIGH, creator=creator1, contestStatus=NOT_STARTED, questions=[Question [id=1, level=HIGH, score=100, title=title1], Question [id=2, level=HIGH, score=90, title=title2], Question [id=3, level=HIGH, score=80, title=title3]]],
        // Contest [id=1, name=contestName2, level=LOW, creator=creator2, contestStatus=NOT_STARTED, questions=[Question [id=4, level=LOW, score=1100, title=title4], Question [id=5, level=LOW, score=900, title=title5], Question [id=6, level=LOW, score=800, title=title6]]]]";

        // Level level = null;
        // if(tokens.size()==2)
        //     level = Level.valueOf(tokens.get(1));
        // try{
        //     List<Contest> contests = contestService.getAllContestLevelWise(level);
        //     //System.out.println(tokens.size());
        //     System.out.println(contests.stream().map(c ->c.toString()).collect(Collectors.joining(", "))+"]");
        // }catch(RuntimeException e){
        //     System.out.println(e.getMessage());
        // }
        try {
            if(tokens.size() == 1){
                List<Contest> listOfContest = contestService.getAllContestLevelWise(null);
                System.out.println(listOfContest);
                return;
            }
            Level contestLevel=Level.valueOf(tokens.get(1));
            List<Contest> listOfContest=contestService.getAllContestLevelWise(contestLevel);
            System.out.println(listOfContest);            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
}
