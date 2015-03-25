package data.playersData;

import enums.Position;

public class PlayerBasicStats_new {
	//某场比赛某个球员的所有基础统计数据
	boolean gamesStarting;                   //是否首发
	Position position;                       //位置
	Double minutes;                          //在场时间
	Double fieldGoalsMade;                   //投篮命中数
	Double fieldGoalsAttempted;              //投篮出手数
	Double threePointFieldGoalsMade;         //三分命中数
	Double threePointFieldGoalsAttempted;    //三分出手数
	Double freeThrowsMade;                   //罚球命中数
	Double freeThrowsAttempted;              //罚球出手数
	Double offensiveRebounds;                //进攻篮板数
	Double defensiveRebounds;                //防守篮板数
	Double rebounds;                         //总篮板数
	Double assists;                          //助攻数
	Double steals;                           //抢断数
	Double blocks;                           //盖帽数
	Double turnovers;                        //失误数
	Double personalFouls;                    //犯规数
	Double points;                           //个人得分
	
	
	public boolean isGamesStarting() {
		return gamesStarting;
	}
	
	public void setGamesStarting(boolean gamesStarting) {
		this.gamesStarting = gamesStarting;
	}
	
	public Position getPosition() {
		return position;
	}
	
	public void setPosition(Position position) {
		this.position = position;
	}
	
	public Double getMinutes() {
		return minutes;
	}
	
	public void setMinutes(Double minutes) {
		this.minutes = minutes;
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
	
	public Double getPersonalFouls() {
		return personalFouls;
	}
	
	public void setPersonalFouls(Double personalFouls) {
		this.personalFouls = personalFouls;
	}
	
	public Double getPoints() {
		return points;
	}
	
	public void setPoints(Double points) {
		this.points = points;
	}
	
	
}
