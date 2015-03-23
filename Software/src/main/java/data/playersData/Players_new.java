package data.playersData;

import java.util.ArrayList;

import po.PlayerPO;
import enums.Teams;

public class Players_new {
	//此类拥有一个球员的所有信息
	String name;
	Teams team;
	Integer games;
	PlayerPO info;
	ArrayList<PlayerStats_new> stats;
	
	public Players_new(String name, PlayerPO info){
		this.name = info.name();
		this.info = info;
		games = 0;
		stats = new ArrayList<PlayerStats_new>();
	}
	
	public void addStats(PlayerStats_new s){
		stats.add(s);
		games++;
		if(s.team != team){
			team = s.team;
		}
	}

	public String getName() {
		return name;
	}

	public Teams getTeam() {
		return team;
	}

	public PlayerPO getInfo() {
		return info;
	}

	public ArrayList<PlayerStats_new> getStats() {
		return stats;
	}
	
}
