package com.object.modeling.codingame.services;

import java.util.List;

import com.object.modeling.codingame.entities.Level;
import com.object.modeling.codingame.entities.Question;

public interface IQuestionService {
    public Question create(String title, Level level, Integer difficultyScore);
    public List<Question> getAllQuestionLevelWise(Level level);
}
