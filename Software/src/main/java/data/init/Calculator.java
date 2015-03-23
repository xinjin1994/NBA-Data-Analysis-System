package data.init;

import java.util.ArrayList;

import data.matchesData.Matches_new;
import data.playersData.PlayerStats_new;
import data.teamsData.TeamStats_new;
import po.MatchPO;

public class Calculator {
	//输入一场比赛的所有数据，获取所有队伍和球员数据
	MatchPO match;
	
	public Calculator(MatchPO match) {
		this.match = match;
	}
	
	public ArrayList<PlayerStats_new> getPlayerStats() {
		//返回该场比赛所有球员的所有数据
		return null;
	}
	
	public ArrayList<TeamStats_new> getTeamStats() {
		//返回该场比赛所有队伍的所有数据
		return null;
	}
	
	public Matches_new getMatchStats() {
		//返回某场比赛基本情况
		return null;
	}
}
