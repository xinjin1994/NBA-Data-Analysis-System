package vo;

import enums.Teams;

public class TeamRatioStatsVO {
	//
	Teams team;
	int games;
	double fieldGoalsPercentage;                        //投篮命中率
	double freeThrowsPercentage;                        //罚球命中率
	double threePointFieldGoalsPercentage;              //三分命中率
	
	public TeamRatioStatsVO(Teams team, int games, double fgp, double ftp, double tgp){
		this.team = team;
		this.games = games;
		this.fieldGoalsPercentage = fgp;
		this.freeThrowsPercentage = ftp;
		this.threePointFieldGoalsPercentage = tgp;
	}

	public Teams getTeam() {
		return team;
	}

	public int getGames() {
		return games;
	}

	public double getFieldGoalsPercentage() {
		return fieldGoalsPercentage*100;
	}

	public double getFreeThrowsPercentage() {
		return freeThrowsPercentage*100;
	}

	public double getThreePointFieldGoalsPercentage() {
		return threePointFieldGoalsPercentage*100;
	}

	
}
