package po;

import java.util.ArrayList;

import enums.Conference;
import enums.Division;
import enums.Teams;

public class TeamHotStatsPO {
	Teams team;
	Conference conference;
	Division division;
	ArrayList<Double> stats;
	
	public TeamHotStatsPO(Teams tm, Conference con, Division div){
		this.team = tm;
		this.conference = con;
		this.division = div;
		stats = new ArrayList<Double>();
	}
	
	public void addStats(Double s){
		stats.add(s);
	}

	public Teams getTeam() {
		return team;
	}

	public Conference getConference() {
		return conference;
	}

	public Division getDivision() {
		return division;
	}

	public ArrayList<Double> getStats() {
		return stats;
	}
	
}
