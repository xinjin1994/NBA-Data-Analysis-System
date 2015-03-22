package vo;

import enums.Teams;

public class TeamOffensiveStatsVO {
	//
	Teams team;
	int games;
	double points;                                           //得分
	double fieldGoalsMade;                                   //投篮命中数
	double fieldGoalsAttempted;                              //投篮出手数
	double freeThrowsMade;                                   //罚球命中数
	double freeThrowsAttempted;                              //罚球出手数
	double threePointFieldGoalsMade;                         //三分命中数
	double threePointFieldGoalsAttempted;                    //三分出手数
	double assists;                                          //助攻数
	
	public TeamOffensiveStatsVO(Teams team, int games, double pts, double fgm, double fga,
			double ftm, double fta, double tgm, double tga, double ast){
		this.team = team;
		this.games = games;
		this.points = pts;
		this.fieldGoalsMade = fgm;
		this.fieldGoalsAttempted = fga;
		this.freeThrowsMade = ftm;
		this.freeThrowsAttempted = fta;
		this.threePointFieldGoalsMade = tgm;
		this.threePointFieldGoalsAttempted = tga;
		this.assists = ast;
	}
	
	public void average(){
		this.points /= games;
		this.fieldGoalsMade /= games;
		this.fieldGoalsAttempted /= games;
		this.freeThrowsMade /= games;
		this.freeThrowsAttempted /= games;
		this.threePointFieldGoalsMade /= games;
		this.threePointFieldGoalsAttempted /= games;
		this.assists /= games;
	}

	public Teams getTeam() {
		return team;
	}

	public int getGames() {
		return games;
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
	
	
	public void print(){
		System.out.println(this.team + "\n" +
				this.games + "\n" +
				this.points + "\n" +
				this.fieldGoalsMade + "\n" +
				this.fieldGoalsAttempted + "\n" +
				this.freeThrowsMade + "\n" +
				this.freeThrowsAttempted + "\n" +
				this.threePointFieldGoalsMade + "\n" +
				this.threePointFieldGoalsAttempted + "\n" +
				this.assists );
	}
	
}
