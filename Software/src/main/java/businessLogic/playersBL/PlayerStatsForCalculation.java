package businessLogic.playersBL;

public class PlayerStatsForCalculation {
	//有单个球员的所有基本数据
	//某场比赛的部分其他球员数据
	//此类只用于计算
	
	BasicPlayerStats player;
	Double minutes_teammate;
	Integer offensiveRebounds_teammate;
	Integer defensiveRebounds_teammate;
	Integer offensiveRebounds_opponent;
	Integer defensiveRebounds_opponent;
	Integer fieldGoalsMade_teammate;
	Integer fieldGoalsAttempted_teammate;
	Integer fieldGoalsAttempted_opponent;
	Integer freeThrowsAttempted_teammate;
	Integer turnovers_teammate;
	Double offensiveRounds_opponent;
	
	public PlayerStatsForCalculation(BasicPlayerStats player, Double minutes_teammate,
			Integer offensiveRebounds_teammate, Integer defensiveRebounds_teammate, 
			Integer offensiveRebounds_opponent, Integer defensiveRebounds_opponent, 
			Integer fieldGoalsMade_teammate, Integer fieldGoalsAttempted_teammate,
			Integer fieldGoalsAttempted_opponent, Double offensiveRounds_opponent){
		this.player = player;
		this.minutes_teammate = minutes_teammate;
		this.offensiveRebounds_teammate = offensiveRebounds_teammate;
		this.defensiveRebounds_teammate = defensiveRebounds_teammate;
		this.offensiveRebounds_opponent = offensiveRebounds_opponent;
		this.defensiveRebounds_opponent = defensiveRebounds_opponent;
		this.fieldGoalsMade_teammate = fieldGoalsMade_teammate;
		this.fieldGoalsAttempted_teammate = fieldGoalsAttempted_teammate;
		this.fieldGoalsAttempted_opponent = fieldGoalsAttempted_opponent;
		this.offensiveRounds_opponent = offensiveRounds_opponent;
		this.turnovers_teammate=turnovers_teammate;
		this.freeThrowsAttempted_teammate=freeThrowsAttempted_teammate;
	}

	public BasicPlayerStats player() {
		return player;
	}

	public Double minutes_teammate() {
		return minutes_teammate;
	}

	public Integer offensiveRebounds_teammate() {
		return offensiveRebounds_teammate;
	}

	public Integer defensiveRebounds_teammate() {
		return defensiveRebounds_teammate;
	}

	public Integer offensiveRebounds_opponent() {
		return offensiveRebounds_opponent;
	}

	public Integer defensiveRebounds_opponent() {
		return defensiveRebounds_opponent;
	}

	public Integer fieldGoalsMade_teammate() {
		return fieldGoalsMade_teammate;
	}

	public Integer fieldGoalsAttempted_teammate() {
		return fieldGoalsAttempted_teammate;
	}

	public Integer fieldGoalsAttempted_opponent() {
		return fieldGoalsAttempted_opponent;
	}

	public Double offensiveRounds_opponent() {
		return offensiveRounds_opponent;
	}
	
	public Integer freeThrowsAttempted_teammate() {
		return freeThrowsAttempted_teammate;
	}
	
	public Integer turnovers_teammate() {
		return turnovers_teammate;
	}
	
}
