package vo;

import java.util.ArrayList;

import enums.Position;
import enums.Teams;

public class PlayerProgressVO {
	String name;
	Teams team;
	Position position;
	
	ArrayList<Double> stats = new ArrayList<Double>();   //第0个数据是最近一场
	double improvement;
	
	public PlayerProgressVO(String name, Teams team, Position position, 
			ArrayList<Double> stats){
		this.name = name;
		this.team = team;
		this.position = position;
		this.stats = stats;
		if(stats.get(stats.size()-1)!=0){
			this.improvement = stats.get(0)/stats.get(stats.size()-1);
		}else{
			this.improvement = 0;
		}
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

	public double getImprovement() {
		return improvement;
	}
	
}
