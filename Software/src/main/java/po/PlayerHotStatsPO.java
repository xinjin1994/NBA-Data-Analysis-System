package po;

import java.util.ArrayList;

import enums.Position;
import enums.Teams;

public class PlayerHotStatsPO {
	String name;
	Teams team;
	Position position;
	ArrayList<Double> stats;
	
	public PlayerHotStatsPO(String name, Teams team, Position pos) {
		this.name = name;
		this.team = team;
		this.position = pos;
		this.stats = new ArrayList<Double>();
	}
	
	public void addStats(Double s){
		stats.add(s);
	}

	public String getName() {
		return name;
	}

	public Teams getTeam() {
		return team;
	}

	public Position getPosition() {
		return position;
	}

	public ArrayList<Double> getStats() {
		return stats;
	}
	
}
