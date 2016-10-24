package businessLogicService.teamsBLService;

import java.util.ArrayList;

import enums.Conference;
import enums.Division;
import enums.Teams;
import exceptions.TeamNotFound;

public interface TeamInfoService {
	//
	
	//根据赛区获取队伍名
	public ArrayList<Teams> getTeams(Conference conference, Division division) throws TeamNotFound;
}
