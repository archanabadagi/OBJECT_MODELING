package com.object.modeling.codingame.repositories;

import java.util.List;

import com.object.modeling.codingame.entities.Level;
import com.object.modeling.codingame.entities.Question;

public interface IQuestionRepository extends CRUDRepository<Question,String> {
    public List<Question> findAllQuestionLevelWise(Level level);
}
