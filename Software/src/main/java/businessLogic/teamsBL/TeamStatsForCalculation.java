package businessLogic.teamsBL;

public class TeamStatsForCalculation {
	//
	BasicTeamStats basicTeamStats;
	Integer offensiveRebounds_opponent;
	Integer defensiveRebounds_opponent;
	
	public TeamStatsForCalculation(BasicTeamStats stats, int offensiveRebounds_opponent, 
			int defensiveRebounds_opponent){
		this.basicTeamStats = stats;
		this.offensiveRebounds_opponent = offensiveRebounds_opponent;
		this.defensiveRebounds_opponent = defensiveRebounds_opponent;
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
	
	
	
}
