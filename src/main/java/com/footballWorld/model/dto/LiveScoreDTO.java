package com.footballWorld.model.dto;



import com.footballWorld.pojo.Match;

public class LiveScoreDTO {

	private String currentTime;
	private String homeTeam;
	private String awayTeam;
	private String score;
	private String status;
	private String halfTimeScore;
	
	public LiveScoreDTO(Match match){
		this.currentTime=match.getCurrentTime();
		this.homeTeam=match.getHomeName();
		this.awayTeam=match.getAwayName();
		this.score=match.getScore();
		this.status=match.getStatus();
		this.halfTimeScore=match.getHtScore();
	}
	
	public String getCurrentTime() {
		return currentTime;
	}
	public void setCurrentTime(String currentTime) {
		this.currentTime = currentTime;
	}
	public String getHomeTeam() {
		return homeTeam;
	}
	public void setHomeTeam(String homeTeam) {
		this.homeTeam = homeTeam;
	}
	public String getAwayTeam() {
		return awayTeam;
	}
	public void setAwayTeam(String awayTeam) {
		this.awayTeam = awayTeam;
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
	public String getHalfTimeScore() {
		return halfTimeScore;
	}
	public void setHalfTimeScore(String halfTimeScore) {
		this.halfTimeScore = halfTimeScore;
	}

	@Override
	public String toString() {
		return "LiveScoreDTO [ currentTime=" + currentTime + ", homeTeam=" + homeTeam
				+ ", awayTeam=" + awayTeam + ", score=" + score + ", status=" + status + ", halfTimeScore="
				+ halfTimeScore + "]";
	}

	
}
