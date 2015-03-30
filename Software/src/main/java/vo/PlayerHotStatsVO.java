package vo;

import enums.Position;
import enums.Teams;

public class PlayerHotStatsVO {
	//此类存放热点球员的筛选数据
	String name;
	Teams team;
	Position position;
	double stats;
	
	public PlayerHotStatsVO(String nm, Teams tm, Position pos, double stats){
		this.name = nm;
		this.team = tm;
		this.position = pos;
		this.stats = stats;
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

	public double getStats() {
		return stats;
	}
	
}
