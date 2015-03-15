package businessLogicService.teamsBLService;

import java.util.ArrayList;

import enums.Conference;
import enums.Division;
import enums.Teams;
import exceptions.TeamNotFound;

public interface TeamInfoService {
	//
	
	public ArrayList<Teams> getTeams(Conference conference, Division division) throws TeamNotFound;
}
