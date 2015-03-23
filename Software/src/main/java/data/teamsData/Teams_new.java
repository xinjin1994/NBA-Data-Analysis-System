package data.teamsData;

import java.util.ArrayList;

import po.TeamPO;
import enums.Teams;

public class Teams_new {
	//某个球队的所有数据
	Teams team;
	TeamPO info;
	Integer games;
	ArrayList<TeamStats_new> stats;
	
	public Teams_new(Teams team, TeamPO info) {
		this.team = team;
		this.info = info;
		games = 0;
		stats = new ArrayList<TeamStats_new>();
	}
	
	public void addStats(TeamStats_new s) {
		stats.add(s);
		games++;
	}

	public Teams getTeam() {
		return team;
	}

	public TeamPO getInfo() {
		return info;
	}

	public Integer getGames() {
		return games;
	}

	public ArrayList<TeamStats_new> getStats() {
		return stats;
	}
	
	
}
