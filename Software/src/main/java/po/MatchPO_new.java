package po;

import java.util.ArrayList;

import enums.Teams;

public class MatchPO_new {
	String season;                          //赛季
	String date;                            //日期
	Teams homeTeam;                         //主队
	Teams guestTeam;                        //客队
	String score;                           //总比分
	String score1;                          //第一节比分
	String score2;                          //第二节比分
	String score3;                          //第三节比分
	String score4;                          //第四节比分
	String scoreExtra;                      //加时赛比分
	ArrayList<String> homeTeamPlayers;      //主队球员
	public ArrayList<String> getHomeTeamPlayers() {
		return homeTeamPlayers;
	}

	public void setHomeTeamPlayers(ArrayList<String> homeTeamPlayers) {
		this.homeTeamPlayers = homeTeamPlayers;
	}

	public ArrayList<String> getGuestTeamPlayers() {
		return guestTeamPlayers;
	}

	public void setGuestTeamPlayers(ArrayList<String> guestTeamPlayers) {
		this.guestTeamPlayers = guestTeamPlayers;
	}

	ArrayList<String> guestTeamPlayers;     //客队球员
	
	public MatchPO_new() {
		
	}

	public String getSeason() {
		return season;
	}

	public void setSeason(String season) {
		this.season = season;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public Teams getHomeTeam() {
		return homeTeam;
	}

	public void setHomeTeam(Teams homeTeam) {
		this.homeTeam = homeTeam;
	}

	public Teams getGuestTeam() {
		return guestTeam;
	}

	public void setGuestTeam(Teams guestTeam) {
		this.guestTeam = guestTeam;
	}

	public String getScore() {
		return score;
	}

	public void setScore(String score) {
		this.score = score;
	}

	public String getScore1() {
		return score1;
	}

	public void setScore1(String score1) {
		this.score1 = score1;
	}

	public String getScore2() {
		return score2;
	}

	public void setScore2(String score2) {
		this.score2 = score2;
	}

	public String getScore3() {
		return score3;
	}

	public void setScore3(String score3) {
		this.score3 = score3;
	}

	public String getScore4() {
		return score4;
	}

	public void setScore4(String score4) {
		this.score4 = score4;
	}

	public String getScoreExtra() {
		return scoreExtra;
	}

	public void setScoreExtra(String scoreExtra) {
		this.scoreExtra = scoreExtra;
	}
	
}
