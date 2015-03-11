package factory;

import data.teamsData.ReadTeams;
import data.teamsData.ReadFromTxt;


public class ObjectCreater {
	
	public ReadTeams teamsReader(){
		return new ReadFromTxt();
	}

}
