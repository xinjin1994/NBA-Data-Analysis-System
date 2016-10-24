package po;

import enums.Teams;

public class TeamOffensiveStatsPO {
	Teams team;
	double points;                                           //得分
	double fieldGoalsMade;                                   //投篮命中数
	double fieldGoalsAttempted;                              //投篮出手数
	double freeThrowsMade;                                   //罚球命中数
	double freeThrowsAttempted;                              //罚球出手数
	double threePointFieldGoalsMade;                         //三分命中数
	double threePointFieldGoalsAttempted;                    //三分出手数
	double assists;                                          //助攻数
	
	public TeamOffensiveStatsPO(Teams team, double pts, double fgm, double fga, 
			double ftm, double fta, double tpm, double tpa, double ast){
		this.team = team;
		this.points = pts;
		this.fieldGoalsMade = fgm;
		this.fieldGoalsAttempted = fga;
		this.freeThrowsMade = ftm;
		this.freeThrowsAttempted = fta;
		this.threePointFieldGoalsMade = tpm;
		this.threePointFieldGoalsAttempted = tpa;
		this.assists = ast;
	}

	public Teams getTeam() {
		return team;
	}

	public double getPoints() {
		return points;
	}

	public double getFieldGoalsMade() {
		return fieldGoalsMade;
	}

	public double getFieldGoalsAttempted() {
		return fieldGoalsAttempted;
	}

	public double getFreeThrowsMade() {
		return freeThrowsMade;
	}

	public double getFreeThrowsAttempted() {
		return freeThrowsAttempted;
	}

	public double getThreePointFieldGoalsMade() {
		return threePointFieldGoalsMade;
	}

	public double getThreePointFieldGoalsAttempted() {
		return threePointFieldGoalsAttempted;
	}

	public double getAssists() {
		return assists;
	}
	
}
