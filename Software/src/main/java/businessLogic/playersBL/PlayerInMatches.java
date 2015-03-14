package businessLogic.playersBL;

public class PlayerInMatches {
	//
	Integer numOfMatches;          //参加的比赛场数，还没决定放在哪个类里
	BasicPlayerStats basic;
	AdvancedPlayerStats advanced;
	
	public PlayerInMatches(BasicPlayerStats basic, AdvancedPlayerStats advanced){
		this.basic = basic;
		this.advanced = advanced;
	}
	
}
