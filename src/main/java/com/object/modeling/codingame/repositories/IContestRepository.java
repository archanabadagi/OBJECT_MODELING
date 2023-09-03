package com.object.modeling.codingame.repositories;

import java.util.List;

import com.object.modeling.codingame.entities.Contest;
import com.object.modeling.codingame.entities.Level;

public interface IContestRepository extends CRUDRepository<Contest,String> {
    public List<Contest> findAllContestLevelWise(Level level);
}
