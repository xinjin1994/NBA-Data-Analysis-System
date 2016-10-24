package dataService.teamsDataService;

import enums.Teams;
import enums.Conference;
import enums.Division;
import po.TeamPO;
import java.util.ArrayList;
import exceptions.TeamNotFound;

public interface TeamsDataService {
	TeamPO getTeam(Teams team) throws TeamNotFound;
	ArrayList<Teams> getTeamsName(Conference conference, Division division) throws TeamNotFound;
	ArrayList<TeamPO> getTeams(Conference conference, Division division) throws TeamNotFound;
	ArrayList<TeamPO> getAllTeams();
}
