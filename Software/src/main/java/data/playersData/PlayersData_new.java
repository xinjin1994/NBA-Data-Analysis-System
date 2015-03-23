package data.playersData;

import java.util.ArrayList;

public class PlayersData_new {
	static ArrayList<Players_new> players;
	
	public PlayersData_new(ArrayList<Players_new> players) {
		//仅用于数据初始化
		if(players == null){
			PlayersData_new.players = players;
		}
	}
	
	public PlayersData_new() {
		//do nothing
	}
	
}
