package com.footballWorld.model.dao.match;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.Charset;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.footballWorld.APIData.IApiData;
import com.footballWorld.controller.exceptions.DataBaseException;
import com.footballWorld.controller.exceptions.DataException;
import com.footballWorld.model.dto.LiveScoreDTO;
import com.footballWorld.pojo.Match;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;


@Component
public class MatchDAO implements IMatchDAO {

	@Override
	public List<Match> getLiveMatches() throws DataException {
		   String jsonText =  getJSONlikeString(IApiData.LIVESCORE);
		  Gson gson = new Gson();
		  JsonElement element =  gson.fromJson(jsonText,JsonElement.class);
		  
		  JsonArray games= element.getAsJsonObject().get("data").getAsJsonObject().get("match").getAsJsonArray();
		  List<Match> result=new ArrayList<>();
		  
		  for(JsonElement game : games){
			    
			  String homeName=game.getAsJsonObject().get("home_name").getAsString();
			  String awayName=game.getAsJsonObject().get("away_name").getAsString();
			  String score=game.getAsJsonObject().get("score").getAsString();
			  String currentTime=game.getAsJsonObject().get("time").getAsString();
			  String halftimeScore=game.getAsJsonObject().get("ht_score").getAsString();
			  String status=game.getAsJsonObject().get("status").getAsString();
			  LocalTime time = getTimeFromString(game.getAsJsonObject().get("added").getAsString());
			  
			  result.add(new Match(homeName, awayName, time, score, status, halftimeScore, currentTime));
		  }

		return result;
	}

	
	
	
	private LocalTime getTimeFromString(String time) {
		LocalDateTime t = getTimeAndDateFromString(time);
		return LocalTime.of(t.getHour(),t.getMinute(), t.getSecond()) ;
	}
	
	private LocalDateTime getTimeAndDateFromString(String text) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("uuuu-MM-dd HH:mm:ss");
       LocalDateTime dateTime = LocalDateTime.parse(text, formatter);
       dateTime = dateTime.plusHours(3);
		return dateTime;
	}
	




	private String getJSONlikeString(String url) throws DataException  {
		InputStream is;
		try {
			is = new URL(url).openStream();
			BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
			
			String jsonText = readAll(rd);
			System.out.println(jsonText);
			return jsonText;
		} catch (IOException e) {
			throw new DataException(e);
		}
		
	}

	private static String readAll(Reader rd) throws IOException {
		StringBuilder sb = new StringBuilder();
		int cp;
		while ((cp = rd.read()) != -1) {
			sb.append((char) cp);
		}
		return sb.toString();
	}
	
	public static void main(String[] args) throws DataException {
		new MatchDAO().getLiveMatches();
	}

}
