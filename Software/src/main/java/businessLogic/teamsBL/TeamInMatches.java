package businessLogic.teamsBL;

import vo.TeamDefensiveStatsVO;
import vo.TeamFoulsStatsVO;
import vo.TeamGeneralStatsVO;
import vo.TeamOffensiveStatsVO;
import vo.TeamRatioStatsVO;

public class TeamInMatches {
	//
	BasicTeamStats basic;
	AdvancedTeamStats advanced;
	
	public TeamInMatches(BasicTeamStats bsc, AdvancedTeamStats adv){
		this.basic = bsc;
		this.advanced = adv;
	}
	
	public TeamOffensiveStatsVO getOffensiveStatsVO(){
		return new TeamOffensiveStatsVO(basic.name, basic.games, basic.points, basic.fieldGoalsMade, 
				basic.fieldGoalsAttempted, basic.freeThrowsMade, basic.freeThrowsAttempted, 
				basic.threePointFieldGoalsMade, basic.threePointFieldGoalsAttempted, basic.assists);
	}
	
	public TeamDefensiveStatsVO getDefensiveStatsVO(){
		return new TeamDefensiveStatsVO(basic.name, basic.games, basic.offensiveRebounds, 
				basic.defensiveRebounds, basic.rebounds, basic.steals, basic.blocks);
	}
	
	public TeamFoulsStatsVO getFoulsStatsVO(){
		return new TeamFoulsStatsVO(basic.name, basic.games, basic.turnovers, basic.fouls);
	}
	
	public TeamRatioStatsVO getRatioStatsVO(){
		return new TeamRatioStatsVO(basic.name, basic.games,
				basic.fieldGoalsMade/basic.fieldGoalsAttempted,
				basic.freeThrowsMade/basic.freeThrowsAttempted,
				basic.threePointFieldGoalsMade/basic.threePointFieldGoalsAttempted);
	}
	
	public TeamGeneralStatsVO getGeneralStatsVO(){
		return new TeamGeneralStatsVO(basic.name, basic.games, advanced.offensiveRounds, 
				advanced.offensiveEfficiency, advanced.defensiveEfficiency, 
				advanced.offensiveReboudnsEfficiency, advanced.defensiveReboundsEfficiency,
				advanced.stealsEfficiency);
	}
	
}
