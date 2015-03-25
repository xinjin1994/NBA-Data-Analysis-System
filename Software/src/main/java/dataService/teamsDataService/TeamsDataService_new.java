package dataService.teamsDataService;

import java.util.ArrayList;

import po.TeamDefensiveFoulsStatsPO;
import po.TeamOffensiveStatsPO;
import po.TeamPO;
import po.TeamRatioGeneralStatsPO;
import enums.Conference;
import enums.Division;
import enums.Teams;
import exceptions.TeamNotFound;

public interface TeamsDataService_new {
	TeamPO getTeam(Teams team) throws TeamNotFound;
	ArrayList<TeamPO> getTeams(Conference conference, Division division) throws TeamNotFound;
	ArrayList<TeamPO> getAllTeams();
	
	ArrayList<Teams> getTeamNames(Conference conference, Division division);
	ArrayList<TeamOffensiveStatsPO> getOffensiveStats(Teams team) throws TeamNotFound;
	ArrayList<TeamRatioGeneralStatsPO> getRatioGeneralStats(Teams team) throws TeamNotFound;
	ArrayList<TeamDefensiveFoulsStatsPO> getDefensiveFoulsStats(Teams team) throws TeamNotFound;
}
