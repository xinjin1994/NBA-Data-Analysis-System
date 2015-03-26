package po;

import enums.Teams;

public class TeamRatioGeneralStatsPO {
	Teams team;
	int games;
	int wins;
	double fieldGoalsMade;                              //投篮命中率
	double fieldGoalsAttempted;
	double freeThrowsMade;                              //罚球命中率
	double freeThrowsAttempted;
	double threePointFieldGoalsMade;                    //三分命中率
	double threePointFieldGoalsAttempted;
	double winningRating;                               //胜率
	double offensiveRounds;                             //进攻回合
	double offensiveEfficiency;                         //进攻效率
	double defensiveEfficiency;                         //防守效率
	double offensiveReboundsEfficiency;                 //进攻篮板效率
	double defensiveReboundsEfficiency;                 //防守篮板效率
	double stealsEfficiency;                            //抢断效率
	double assistsEfficiency;                           //助攻（效）率
	
	public TeamRatioGeneralStatsPO(Teams team, int games, int wins, double fgm, double fga, 
			double ftm, double fta, double tpm, double tpa, double or, double oe, double de, 
			double ore, double dre, double se, double ae) {
		this.team = team;
		this.games = games;
		this.wins = wins;
		this.fieldGoalsMade = fgm;
		this.fieldGoalsAttempted = fga;
		this.freeThrowsMade = ftm;
		this.freeThrowsAttempted = fta;
		this.threePointFieldGoalsMade = tpm;
		this.threePointFieldGoalsAttempted = tpa;
		this.offensiveRounds = or;
		this.offensiveEfficiency = oe;
		this.defensiveEfficiency = de;
		this.offensiveReboundsEfficiency = ore;
		this.defensiveReboundsEfficiency = dre;
		this.stealsEfficiency = se;
		this.assistsEfficiency = ae;
	}

	public Teams getTeam() {
		return team;
	}

	public int getGames() {
		return games;
	}

	public int getWins() {
		return wins;
	}

	public double getFieldGoalsPercentage() {
		double p;
		try{
			p = this.fieldGoalsMade/this.fieldGoalsAttempted;
		}catch(Exception e){
			p = 0;
		}
		return p;
	}

	public double getFreeThrowsPercentage() {
		double p;
		try{
			p = this.freeThrowsMade/this.freeThrowsAttempted;
		}catch(Exception e){
			p = 0;
		}
		return p;
	}

	public double getThreePointFieldGoalsPercentage() {
		double p;
		try{
			p = this.threePointFieldGoalsMade/this.threePointFieldGoalsAttempted;
		}catch(Exception e){
			p = 0;
		}
		return p;
	}

	public double getWinningRating() {
		double p;
		try{
			p = (double)this.wins/this.games;
		}catch(Exception e){
			p = 0;
		}
		return p;
	}

	public double getOffensiveRounds() {
		return offensiveRounds;
	}

	public double getOffensiveEfficiency() {
		return offensiveEfficiency;
	}

	public double getDefensiveEfficiency() {
		return defensiveEfficiency;
	}

	public double getOffensiveReboundsEfficiency() {
		return offensiveReboundsEfficiency;
	}

	public double getDefensiveReboundsEfficiency() {
		return defensiveReboundsEfficiency;
	}

	public double getStealsEfficiency() {
		return stealsEfficiency;
	}

	public double getAssistsEfficiency() {
		return assistsEfficiency;
	}

	public double getFieldGoalsAttempted() {
		return fieldGoalsAttempted;
	}

	public double getFreeThrowsAttempted() {
		return freeThrowsAttempted;
	}

	public double getThreePointFieldGoalsAttempted() {
		return threePointFieldGoalsAttempted;
	}
	
	
	
}
