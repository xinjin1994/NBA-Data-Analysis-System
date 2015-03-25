package po;

import data.playersData.PlayerAdvancedStats_new;
import enums.Teams;

public class PlayerAdvancedStatsPO {
	String name;
	Teams team;
	PlayerAdvancedStats_new stats;
	
	public PlayerAdvancedStatsPO(String name, Teams team, PlayerAdvancedStats_new stats) {
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

	public boolean isDoubleDouble() {
		return stats.isDoubleDouble();
	}

	public Double getHitRate() {
		return stats.getHitRate();
	}

	public Double getRebounds() {
		return stats.getRebounds();
	}

	public Double getPlayerEfficiency() {
		return stats.getPlayerEfficiencyRating();
	}

	public Double getGmsc() {
		return stats.getGmsc();
	}

	public Double getTrueScorePercent() {
		return stats.getTrueScorePercent();
	}
	
	public Double getFieldGoalsPercent() {
		return stats.getFieldGoalsPercent();
	}

	public Double getReboundsPercent() {
		return stats.getReboundsPercent();
	}

	public Double getOffensiveReboundsPercent() {
		return stats.getOffensiveReboundsPercent();
	}

	public Double getDefensiveReboundsPercent() {
		return stats.getDefensiveReboundsPercent();
	}

	public Double getAssistsPercent() {
		return stats.getAssistsPercent();
	}

	public Double getStealsPercent() {
		return stats.getStealsPercent();
	}

	public Double getBlockPercent() {
		return stats.getBlockPercent();
	}

	public Double getTurnoversPercent() {
		return stats.getTurnoversPercent();
	}

	public Double getUsagePercent() {
		return stats.getUsagePercent();
	}
	
}
