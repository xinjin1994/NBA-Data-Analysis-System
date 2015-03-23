package data.matchesData;


import po.MatchPO_new;
import enums.Teams;

public class Matches_new {
	//某场比赛的球队、球员以外的信息
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

	public Matches_new() {
		
	}
	
	public MatchPO_new toPO() {
		MatchPO_new match = new MatchPO_new();
		match.setSeason(season);
		match.setDate(date);
		match.setHomeTeam(homeTeam);
		match.setGuestTeam(guestTeam);
		match.setScore(score);
		match.setScore1(score1);
		match.setScore2(score2);
		match.setScore3(score3);
		match.setScore4(score4);
		match.setScoreExtra(scoreExtra);
		
		return match;
	}

	public String getSeason() {
		return season;
	}

	public String getDate() {
		return date;
	}

	public Teams getHomeTeam() {
		return homeTeam;
	}

	public Teams getGuestTeam() {
		return guestTeam;
	}

	public String getScore() {
		return score;
	}

	public String getScore1() {
		return score1;
	}

	public String getScore2() {
		return score2;
	}

	public String getScore3() {
		return score3;
	}

	public String getScore4() {
		return score4;
	}

	public String getScoreExtra() {
		return scoreExtra;
	}
	
}
