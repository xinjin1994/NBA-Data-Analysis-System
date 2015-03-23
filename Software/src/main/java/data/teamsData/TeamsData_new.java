package data.teamsData;

import java.util.ArrayList;

public class TeamsData_new {
	static ArrayList<Teams_new> teams;
	
	public TeamsData_new(ArrayList<Teams_new> teams) {
		//仅用于数据初始化
		if(teams == null){
			TeamsData_new.teams = teams;
		}
	}
	
	public TeamsData_new() {
		//do nothing
	}
}
