package dataService.teamsDataService;

import java.util.ArrayList;

import po.TeamDefensiveFoulsStatsPO;
import po.TeamHotStatsPO;
import po.TeamOffensiveStatsPO;
import po.TeamPO;
import po.TeamRatioGeneralStatsPO;
import enums.Conference;
import enums.Division;
import enums.Teams;
import enums.Terminology;
import exceptions.TeamNotFound;

public interface TeamsDataService_new {
	TeamPO getTeam(Teams team) throws TeamNotFound;
	ArrayList<TeamPO> getTeams(Conference conference, Division division) throws TeamNotFound;
	ArrayList<TeamPO> getAllTeams();
	
	ArrayList<Teams> getTeamNames(Conference conference, Division division);
	ArrayList<TeamOffensiveStatsPO> getOffensiveStats(String season, Teams team) throws TeamNotFound;
	ArrayList<TeamRatioGeneralStatsPO> getRatioGeneralStats(String season, Teams team) throws TeamNotFound;
	ArrayList<TeamDefensiveFoulsStatsPO> getDefensiveFoulsStats(String season, Teams team) throws TeamNotFound;
	
	//迭代二
	//比赛日期
	public ArrayList<String> getAvailableDays(String season, Teams team);
	
	//热点数据
	public ArrayList<TeamHotStatsPO> getTeamHotStats(String season, Terminology term);
	
	//单场比赛数据
	TeamOffensiveStatsPO getOffensiveStats(String season, String date, Teams team) throws TeamNotFound;
	TeamRatioGeneralStatsPO getRatioGeneralStats(String season, String date, Teams team) throws TeamNotFound;
	TeamDefensiveFoulsStatsPO getDefensiveFoulsStats(String season, String date, Teams team) throws TeamNotFound;
}
