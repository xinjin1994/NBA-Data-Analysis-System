package data.init;

import java.io.File;
import java.util.ArrayList;

import data.matchesData.MatchesData_new;
import data.matchesData.Matches_new;
import data.playersData.PlayerStats_new;
import data.playersData.PlayersData_new;
import data.teamsData.TeamStats_new;
import data.teamsData.TeamsData_new;
import po.MatchPO;

public class AddData {
	//动态增加文件后添加数据
	
	public void AddMatch(String path){
		File file = new File(path);
		if(file.exists()){
			MatchPO matchPO = new data.matchesData.ReadFromTxt().readFromOneFile(file);
			while(matchPO == null){
				matchPO = new data.matchesData.ReadFromTxt().readFromOneFile(file);
			}
			System.out.println("Add Data " + path);
			Calculator cal = new Calculator(matchPO);
			Matches_new match = cal.getMatchStats();
			ArrayList<PlayerStats_new> players = cal.getPlayerStats();
			ArrayList<TeamStats_new> teams = cal.getTeamStats();
			
			MatchesData_new.addData(match);
			TeamsData_new.addData(teams);
			PlayersData_new.addData(players);
		}
	}
}
