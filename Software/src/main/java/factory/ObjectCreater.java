package factory;

import data.teamsData.ReadTeams;
import data.playersData.ReadPlayers;
import data.matchesData.ReadMatches;

public class ObjectCreater {
	
	public ReadTeams teamsReader(){
		return new data.teamsData.ReadFromTxt();
	}
	
	public ReadPlayers playersReader(){
		return new data.playersData.ReadFromTxt();
	}
	
	public ReadMatches matchesReader(){
		return new data.matchesData.ReadFromTxt();
	}

}
