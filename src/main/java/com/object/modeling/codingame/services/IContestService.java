package com.object.modeling.codingame.services;

import java.util.List;

import com.object.modeling.codingame.dtos.ContestSummaryDto;
import com.object.modeling.codingame.entities.Contest;
import com.object.modeling.codingame.entities.Level;
import com.object.modeling.codingame.exceptions.ContestNotFoundException;
import com.object.modeling.codingame.exceptions.InvalidContestException;
import com.object.modeling.codingame.exceptions.QuestionNotFoundException;
import com.object.modeling.codingame.exceptions.UserNotFoundException;

public interface IContestService {
    public Contest create(String contestName, Level level, String contestCreator, Integer numQuestion) throws UserNotFoundException, QuestionNotFoundException;
    public List<Contest> getAllContestLevelWise(Level level);
    public ContestSummaryDto runContest(String contestId, String contestCreator) throws ContestNotFoundException, InvalidContestException;
}
