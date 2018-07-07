package com.footballWorld.controller.rest;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.footballWorld.controller.exceptions.DataBaseException;
import com.footballWorld.controller.exceptions.DataException;
import com.footballWorld.controller.exceptions.IllegalInputException;
import com.footballWorld.controller.service.LiveScoreService;
import com.footballWorld.model.dto.LiveScoreDTO;



@RestController
public class LivescoreRestController {

	@Autowired
	private LiveScoreService liveScoreService;
	
	@RequestMapping(value = "/livescore ", method = RequestMethod.GET)
	public List<LiveScoreDTO> like( ) throws IllegalInputException, DataBaseException, DataException {
		   
		List<LiveScoreDTO> scores = liveScoreService.getMatches();
	
		return scores;
	}
	
}
