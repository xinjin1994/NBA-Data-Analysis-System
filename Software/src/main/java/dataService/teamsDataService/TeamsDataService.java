package dataService.teamsDataService;

import enums.Teams;
import enums.Conference;
import enums.Division;
import po.TeamPO;
import java.util.ArrayList;

public interface TeamsDataService {
	TeamPO getTeam(Teams team);
	ArrayList<TeamPO> getTeams(Conference conference, Division division);
	ArrayList<TeamPO> getAllTeams();
}
