package businessLogic.teamsBL;

public class TeamStatsForCalculation {
	//
	BasicTeamStats basicTeamStats;
	Integer offensiveRebounds_opponent;
	Integer defensiveRebounds_opponent;
	Integer fieldGoalsMade_opponent;
	Integer freeThrowsMade_opponent;
	Integer fumbles_opponent;                       //失球数
	Integer turnovers_opponent;
	
	public TeamStatsForCalculation(BasicTeamStats stats, int offensiveRebounds_opponent, 
			int defensiveRebounds_opponent, int fieldGoalsMade_opponent, int freeThrowsMade_opponent, 
			int fumbles_opponent, int turnovers_opponent){
		this.basicTeamStats = stats;
		this.offensiveRebounds_opponent = offensiveRebounds_opponent;
		this.defensiveRebounds_opponent = defensiveRebounds_opponent;
		this.fieldGoalsMade_opponent = fieldGoalsMade_opponent;
		this.freeThrowsMade_opponent = freeThrowsMade_opponent;
		this.fumbles_opponent = fumbles_opponent;
		this.turnovers_opponent = turnovers_opponent;
	}

	public BasicTeamStats basicTeamStats() {
		return basicTeamStats;
	}

	public Integer offensiveRebounds_opponent() {
		return offensiveRebounds_opponent;
	}

	public Integer defensiveRebounds_opponent() {
		return defensiveRebounds_opponent;
	}

	public Integer fieldGoalsMade_opponent() {
		return fieldGoalsMade_opponent;
	}

	public Integer freeThrowsMade_opponent() {
		return freeThrowsMade_opponent;
	}

	public Integer fumbles_opponent() {
		return fumbles_opponent;
	}

	public Integer turnovers_opponent() {
		return turnovers_opponent;
	}
	
	
	
}
