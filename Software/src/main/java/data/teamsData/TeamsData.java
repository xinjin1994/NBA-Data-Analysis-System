package data.teamsData;

import java.util.ArrayList;

import po.TeamPO;
import dataService.teamsDataService.TeamsDataService;
import enums.Conference;
import enums.Division;
import enums.Teams;
import factory.ObjectCreater;

public class TeamsData implements TeamsDataService {
	ReadTeams reader = new ObjectCreater().teamsReader();

	@Override
	public TeamPO getTeam(Teams team) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<TeamPO> getTeams(Conference conference, Division division) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public ArrayList<TeamPO> getAllTeams() {
		// TODO Auto-generated method stub
		return null;
	}

}
