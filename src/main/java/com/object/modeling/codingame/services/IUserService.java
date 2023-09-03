package com.object.modeling.codingame.services;

import java.util.List;

import com.object.modeling.codingame.dtos.UserRegistrationDto;
import com.object.modeling.codingame.entities.ScoreOrder;
import com.object.modeling.codingame.entities.User;
import com.object.modeling.codingame.exceptions.ContestNotFoundException;
import com.object.modeling.codingame.exceptions.InvalidOperationException;
import com.object.modeling.codingame.exceptions.UserNotFoundException;

public interface IUserService {
    public User create(String name);
    public List<User> getAllUserScoreOrderWise(ScoreOrder scoreOrder);
public UserRegistrationDto attendContest(String contestId, String userName) throws ContestNotFoundException, UserNotFoundException, InvalidOperationException;
    public UserRegistrationDto withdrawContest(String contestId, String userName) throws ContestNotFoundException, UserNotFoundException, InvalidOperationException;
}
