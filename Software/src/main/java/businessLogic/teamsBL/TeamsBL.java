package businessLogic.teamsBL;

import java.util.ArrayList;

import po.TeamPO;
import dataService.teamsDataService.TeamsDataService;
import enums.Conference;
import enums.Division;
import enums.Teams;
import exceptions.TeamNotFound;
import factory.ObjectCreater;
import businessLogicService.teamsBLService.TeamInfoService;

public class TeamsBL implements TeamInfoService {
	//
	TeamsDataService teamsService;
	
	public TeamsBL(){
		teamsService = new ObjectCreater().teamsDataService();
	}

	@Override
	public ArrayList<Teams> getTeams(Conference conference, Division division)
			throws TeamNotFound {
		ArrayList<TeamPO> list = teamsService.getTeams(conference, division);
		ArrayList<Teams> result = new ArrayList<Teams>();
		
		for(int i=0; i<list.size(); i++){
			result.add(list.get(i).name());
		}
		
		if(result.size() != 0){
			return result;
		}else{
			throw new TeamNotFound("");
		}
	}

}
