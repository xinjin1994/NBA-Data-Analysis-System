package businessLogic.teamsBL;

import enums.Teams;

public class Team {
	String season;
	String date;
	Teams homeTeam;
	Teams courtTeam;
	String score;
	String score_firstPeriod;
	String socre_secondPeriod;
	String score_thirdPeriod;
	String score_fourthPeriod;
	
	public Team(String season, String date, Teams homeTeam, Teams courtTeam, 
			String score, String s1, String s2, String s3, String s4){
		this.season = season;
		this.date = date;
		this.homeTeam = homeTeam;
		this.courtTeam = courtTeam;
		this.score = score;
		score_firstPeriod = s1;
		socre_secondPeriod = s2;
		score_thirdPeriod = s3;
		score_fourthPeriod = s4;
	}
}
