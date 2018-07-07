package com.footballWorld.controller.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.footballWorld.controller.exceptions.DataException;
import com.footballWorld.model.dao.match.IMatchDAO;
import com.footballWorld.model.dto.LiveScoreDTO;
import com.footballWorld.pojo.Match;

@Service
public class LiveScoreService {

	@Autowired
	private IMatchDAO matchDao;
	
	public List<LiveScoreDTO> getMatches() throws DataException {
		
		List<Match> matches = matchDao.getLiveMatches();
		List<LiveScoreDTO> scores = new ArrayList<>();
		for(Match match:matches){
			scores.add(new LiveScoreDTO(match));
		}
		return scores;
	}

	
}
