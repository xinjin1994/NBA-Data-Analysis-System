package vo;

import enums.Conference;
import enums.Division;
import enums.Teams;

public class TeamHotStatsVO {
	//
	Teams team;
	Conference con;
	Division div;
	double stats;
	
	public TeamHotStatsVO(Teams tm, Conference con, Division div, double stats){
		this.team = tm;
		this.con = con;
		this.div = div;
		this.stats = stats;
	}

	public Teams getTeam() {
		return team;
	}

	public Conference getConference() {
		return con;
	}

	public Division getDivision() {
		return div;
	}

	public double getStats() {
		return stats;
	}
	
}
