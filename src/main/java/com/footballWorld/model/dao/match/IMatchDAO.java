package com.footballWorld.model.dao.match;

import java.util.List;

import com.footballWorld.controller.exceptions.DataException;
import com.footballWorld.pojo.Match;

public interface IMatchDAO {

	List<Match> getLiveMatches() throws DataException;

}
