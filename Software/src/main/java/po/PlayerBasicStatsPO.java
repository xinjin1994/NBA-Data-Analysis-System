package po;

import data.playersData.PlayerBasicStats_new;
import enums.Position;
import enums.Teams;

public class PlayerBasicStatsPO {
	String name;
	Teams team;
	PlayerBasicStats_new stats;
	
	public PlayerBasicStatsPO(String name, Teams team, PlayerBasicStats_new stats){
		this.name = name;
		this.team = team;
		this.stats = stats;
	}
	
	public String getName() {
		return name;
	}

	public Teams getTeam() {
		return team;
	}

	public boolean isGamesStarting() {
		return stats.isGamesStarting();
	}
	
	public Position getPosition() {
		return stats.getPosition();
	}
	
	public Double getMinutes() {
		return stats.getMinutes();
	}
	
	public Double getFieldGoalsMade() {
		return stats.getFieldGoalsMade();
	}
	
	public Double getFieldGoalsAttempted() {
		return stats.getFieldGoalsAttempted();
	}
	
	public Double getThreePointFieldGoalsMade() {
		return stats.getThreePointFieldGoalsMade();
	}
	
	public Double getThreePointFieldGoalsAttempted() {
		return stats.getThreePointFieldGoalsAttempted();
	}
	
	public Double getFreeThrowsMade() {
		return stats.getFreeThrowsMade();
	}
	
	public Double getFreeThrowsAttempted() {
		return stats.getFreeThrowsAttempted();
	}
	
	public Double getOffensiveRebounds() {
		return stats.getOffensiveRebounds();
	}
	
	public Double getDefensiveRebounds() {
		return stats.getDefensiveRebounds();
	}
	
	public Double getRebounds() {
		return stats.getRebounds();
	}
	
	public Double getAssists() {
		return stats.getAssists();
	}
	
	public Double getSteals() {
		return stats.getSteals();
	}
	
	public Double getBlocks() {
		return stats.getBlocks();
	}
	
	public Double getTurnovers() {
		return stats.getTurnovers();
	}
	
	public Double getPersonalFouls() {
		return stats.getPersonalFouls();
	}
	
	public Double getPoints() {
		return stats.getPoints();
	}
	
	
}
