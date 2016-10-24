package businessLogic.teamsBL;

import java.util.ArrayList;

import enums.Teams;
import po.PlayerStatsPO;

public class BasicTeamStats {
	//
	Teams name;
	Integer games;                           //参赛场数
	Integer wins;                            //获胜场数
	Double fieldGoalsMade = 0.0;                   //投篮命中数
	Double fieldGoalsAttempted = 0.0;              //投篮出手数
	Double threePointFieldGoalsMade = 0.0;         //三分命中数
	Double threePointFieldGoalsAttempted = 0.0;    //三分出手数
	Double freeThrowsMade = 0.0;                   //罚球命中数
	Double freeThrowsAttempted = 0.0;              //罚球出手数
	Double offensiveRebounds = 0.0;                //进攻篮板数
	Double defensiveRebounds = 0.0;                //防守篮板数
	Double rebounds = 0.0;                         //总篮板数
	Double assists = 0.0;                          //助攻数
	Double steals = 0.0;                           //抢断数
	Double blocks = 0.0;                           //盖帽数
	Double turnovers = 0.0;                        //失误数
	Double fouls = 0.0;                            //犯规数
	Double points = 0.0;                           //得分
	
	public BasicTeamStats(){
		
	}
	
	public BasicTeamStats(Teams team, int games, int wins, ArrayList<PlayerStatsPO> players){
		this.name = team;
		this.games = games;
		this.wins = wins;
		
		for(PlayerStatsPO player: players){
			this.fieldGoalsMade += (double)player.fieldGoalsMade();
			this.fieldGoalsAttempted += (double)player.fieldGoalsAttempted();
			this.threePointFieldGoalsMade += (double)player.threePointFieldGoalsMade();
			this.threePointFieldGoalsAttempted += (double)player.threePointFieldGoalsAttempted();
			this.freeThrowsMade += (double)player.freeThrowsMade();
			this.freeThrowsAttempted += (double)player.freeThrowsAttempted();
			this.offensiveRebounds += (double)player.offensiveRebounds();
			this.defensiveRebounds += (double)player.defensiveRebounds();
			this.rebounds += (double)player.rebounds();
			this.assists += (double)player.assists();
			this.steals += (double)player.steals();
			this.blocks += (double)player.blocks();
			this.turnovers += (double)player.turnovers();
			this.fouls += (double)player.personalFouls();
			this.points += (double)player.points();
		}
		
	}

	public Teams name() {
		return name;
	}

	public Integer games() {
		return games;
	}

	public Integer wins() {
		return wins;
	}

	public Double fieldGoalsMade() {
		return fieldGoalsMade;
	}

	public Double fieldGoalsAttempted() {
		return fieldGoalsAttempted;
	}

	public Double threePointFieldGoalsMade() {
		return threePointFieldGoalsMade;
	}

	public Double threePointFieldGoalsAttempted() {
		return threePointFieldGoalsAttempted;
	}

	public Double freeThrowsMade() {
		return freeThrowsMade;
	}

	public Double freeThrowsAttempted() {
		return freeThrowsAttempted;
	}

	public Double offensiveRebounds() {
		return offensiveRebounds;
	}

	public Double defensiveRebounds() {
		return defensiveRebounds;
	}

	public Double rebounds() {
		return rebounds;
	}

	public Double assists() {
		return assists;
	}

	public Double steals() {
		return steals;
	}

	public Double blocks() {
		return blocks;
	}

	public Double turnovers() {
		return turnovers;
	}

	public Double fouls() {
		return fouls;
	}

	public Double points() {
		return points;
	}

	public void setName(Teams name) {
		this.name = name;
	}

	public void setGames(Integer games) {
		this.games = games;
	}

	public void setWins(Integer wins) {
		this.wins = wins;
	}

	public void setFieldGoalsMade(Double fieldGoalsMade) {
		this.fieldGoalsMade = fieldGoalsMade;
	}

	public void setFieldGoalsAttempted(Double fieldGoalsAttempted) {
		this.fieldGoalsAttempted = fieldGoalsAttempted;
	}

	public void setThreePointFieldGoalsMade(Double threePointFieldGoalsMade) {
		this.threePointFieldGoalsMade = threePointFieldGoalsMade;
	}

	public void setThreePointFieldGoalsAttempted(
			Double threePointFieldGoalsAttempted) {
		this.threePointFieldGoalsAttempted = threePointFieldGoalsAttempted;
	}

	public void setFreeThrowsMade(Double freeThrowsMade) {
		this.freeThrowsMade = freeThrowsMade;
	}

	public void setFreeThrowsAttempted(Double freeThrowsAttempted) {
		this.freeThrowsAttempted = freeThrowsAttempted;
	}

	public void setOffensiveRebounds(Double offensiveRebounds) {
		this.offensiveRebounds = offensiveRebounds;
	}

	public void setDefensiveRebounds(Double defensiveRebounds) {
		this.defensiveRebounds = defensiveRebounds;
	}

	public void setRebounds(Double rebounds) {
		this.rebounds = rebounds;
	}

	public void setAssists(Double assists) {
		this.assists = assists;
	}

	public void setSteals(Double steals) {
		this.steals = steals;
	}

	public void setBlocks(Double blocks) {
		this.blocks = blocks;
	}

	public void setTurnovers(Double turnovers) {
		this.turnovers = turnovers;
	}

	public void setFouls(Double fouls) {
		this.fouls = fouls;
	}

	public void setPoints(Double points) {
		this.points = points;
	}
	
	
}
