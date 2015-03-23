package businessLogicService.teamsBLService;

import java.util.ArrayList;

import enums.Conference;
import enums.Division;
import enums.Teams;
import exceptions.TeamNotFound;

public interface PlayersInTeamsService {
	public ArrayList<Teams> getTeams(Conference con, Division div) throws TeamNotFound;
}
