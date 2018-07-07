package com.footballWorld.pojo;

import java.time.LocalDate;
import java.time.LocalTime;

import org.springframework.stereotype.Component;


public class Match {
   
	private int id;
	private String homeName;
	private String awayName;
	private LocalDate date;
	private LocalTime time;
	private String score;
	private String status;
	private String htScore;
	private String ftScore;
	private String currentTime;
	private String league;
	private String country;
	
	
	
	public int getId() {
		return id;
	}
	public Match(int id, String homeName, String awayName, LocalDate date, LocalTime time, String league,
			String country) {
		this.id = id;
		this.homeName = homeName;
		this.awayName = awayName;
		this.date = date;
		this.time = time;
		this.league = league;
		this.country = country;
	}
	public Match(String homeName, String awayName, LocalTime time, String score, String status, String htScore, String currentTime) {
		
		this.homeName = homeName;
		this.awayName = awayName;
		this.time = time;
		this.score = score;
		this.status = status;
		this.htScore = htScore;
		
		this.currentTime = currentTime;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getHomeName() {
		return homeName;
	}
	public void setHomeName(String homeName) {
		this.homeName = homeName;
	}
	public String getAwayName() {
		return awayName;
	}
	public void setAwayName(String awayName) {
		this.awayName = awayName;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public LocalTime getTime() {
		return time;
	}
	public void setTime(LocalTime time) {
		this.time = time;
	}
	public String getScore() {
		return score;
	}
	public void setScore(String score) {
		this.score = score;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}

	public String getCurrentTime() {
		return currentTime;
	}
	public void setCurrentTime(String currentTime) {
		this.currentTime = currentTime;
	}
	public String getLeague() {
		return league;
	}
	public void setLeague(String league) {
		this.league = league;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getFtScore() {
		return ftScore;
	}
	public void setFtScore(String ftScore) {
		this.ftScore = ftScore;
	}
	public String getHtScore() {
		return htScore;
	}
	public void setHtScore(String htScore) {
		this.htScore = htScore;
	}
	
}
