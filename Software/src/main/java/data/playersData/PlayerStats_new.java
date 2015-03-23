package data.playersData;


import enums.Teams;

public class PlayerStats_new {
	//某场比赛某球员的所有数据
	String season;
	String date;
	String name;
	Teams team;
	PlayerBasicStats_new basic;
	PlayerAdvancedStats_new advanced;
	
	public PlayerStats_new() {
		
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
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
	
	public PlayerBasicStats_new getBasic() {
		return basic;
	}
	
	public void setBasic(PlayerBasicStats_new basic) {
		this.basic = basic;
	}
	
	public PlayerAdvancedStats_new getAdvanced() {
		return advanced;
	}
	
	public void setAdvanced(PlayerAdvancedStats_new advanced) {
		this.advanced = advanced;
	}
	
}
