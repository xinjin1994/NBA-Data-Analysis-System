package data.teamsData;


public class TeamBasicStats_new {
	//某场比赛某个队伍所有基础数据
	boolean win;                                    //是否获胜
	Double fieldGoalsMade;                          //投篮命中数
	Double fieldGoalsAttempted;              		//投篮出手数
	Double threePointFieldGoalsMade;        		//三分命中数
	Double threePointFieldGoalsAttempted;    		//三分出手数
	Double freeThrowsMade;                   		//罚球命中数
	Double freeThrowsAttempted;              		//罚球出手数
	Double offensiveRebounds;                		//进攻篮板数
	Double defensiveRebounds;                		//防守篮板数
	Double rebounds;                         		//总篮板数
	Double assists;                          		//助攻数
	Double steals;                           		//抢断数
	Double blocks;                           		//盖帽数
	Double turnovers;                        		//失误数
	Double fouls;                            		//犯规数
	Double points;                           		//得分
	
	public TeamBasicStats_new() {
		
	}

	public boolean isWin() {
		return win;
	}

	public void setWin(boolean win) {
		this.win = win;
	}

	public Double getFieldGoalsMade() {
		return fieldGoalsMade;
	}

	public void setFieldGoalsMade(Double fieldGoalsMade) {
		this.fieldGoalsMade = fieldGoalsMade;
	}

	public Double getFieldGoalsAttempted() {
		return fieldGoalsAttempted;
	}

	public void setFieldGoalsAttempted(Double fieldGoalsAttempted) {
		this.fieldGoalsAttempted = fieldGoalsAttempted;
	}

	public Double getThreePointFieldGoalsMade() {
		return threePointFieldGoalsMade;
	}

	public void setThreePointFieldGoalsMade(Double threePointFieldGoalsMade) {
		this.threePointFieldGoalsMade = threePointFieldGoalsMade;
	}

	public Double getThreePointFieldGoalsAttempted() {
		return threePointFieldGoalsAttempted;
	}

	public void setThreePointFieldGoalsAttempted(
			Double threePointFieldGoalsAttempted) {
		this.threePointFieldGoalsAttempted = threePointFieldGoalsAttempted;
	}

	public Double getFreeThrowsMade() {
		return freeThrowsMade;
	}

	public void setFreeThrowsMade(Double freeThrowsMade) {
		this.freeThrowsMade = freeThrowsMade;
	}

	public Double getFreeThrowsAttempted() {
		return freeThrowsAttempted;
	}

	public void setFreeThrowsAttempted(Double freeThrowsAttempted) {
		this.freeThrowsAttempted = freeThrowsAttempted;
	}

	public Double getOffensiveRebounds() {
		return offensiveRebounds;
	}

	public void setOffensiveRebounds(Double offensiveRebounds) {
		this.offensiveRebounds = offensiveRebounds;
	}

	public Double getDefensiveRebounds() {
		return defensiveRebounds;
	}

	public void setDefensiveRebounds(Double defensiveRebounds) {
		this.defensiveRebounds = defensiveRebounds;
	}

	public Double getRebounds() {
		return rebounds;
	}

	public void setRebounds(Double rebounds) {
		this.rebounds = rebounds;
	}

	public Double getAssists() {
		return assists;
	}

	public void setAssists(Double assists) {
		this.assists = assists;
	}

	public Double getSteals() {
		return steals;
	}

	public void setSteals(Double steals) {
		this.steals = steals;
	}

	public Double getBlocks() {
		return blocks;
	}

	public void setBlocks(Double blocks) {
		this.blocks = blocks;
	}

	public Double getTurnovers() {
		return turnovers;
	}

	public void setTurnovers(Double turnovers) {
		this.turnovers = turnovers;
	}

	public Double getFouls() {
		return fouls;
	}

	public void setFouls(Double fouls) {
		this.fouls = fouls;
	}

	public Double getPoints() {
		return points;
	}

	public void setPoints(Double points) {
		this.points = points;
	}
	
	
	
}
