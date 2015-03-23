package data.teamsData;

import java.util.ArrayList;

import enums.Teams;



public class TeamStats_new {
	//某场比赛某个队伍的所有数据
	String season;
	String date;
	Teams team;
	ArrayList<String> players;
	TeamBasicStats_new basic;
	TeamAdvancedStats_new advanced;
	
	public TeamStats_new() {
		
	}

	public String getSeason() {
		return season;
	}

	public void setSeason(String season) {
		this.season = season;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public Teams getTeam() {
		return team;
	}

	public void setTeam(Teams team) {
		this.team = team;
	}

	public ArrayList<String> getPlayers() {
		return players;
	}

	public void setPlayers(ArrayList<String> players) {
		this.players = players;
	}

	public TeamBasicStats_new getBasic() {
		return basic;
	}

	public void setBasic(TeamBasicStats_new basic) {
		this.basic = basic;
	}

	public TeamAdvancedStats_new getAdvanced() {
		return advanced;
	}

	public void setAdvanced(TeamAdvancedStats_new advanced) {
		this.advanced = advanced;
	}
	
	
}
