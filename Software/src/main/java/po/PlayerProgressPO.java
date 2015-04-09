package po;

import java.util.ArrayList;

import enums.Position;
import enums.Teams;

public class PlayerProgressPO {
	String name;
	Teams team;
	Position position;
	
	ArrayList<Double> stats;
	
	public PlayerProgressPO(String name, Teams team, Position position){
		this.name = name;
		this.team = team;
		this.position = position;
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
