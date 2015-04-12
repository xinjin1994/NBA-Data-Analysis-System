package dataService.matchesDataService;

import java.util.ArrayList;

import enums.Teams;
import exceptions.MatchNotFound;
import exceptions.StatsNotFound;
import po.MatchPO_new;

public interface MatchesDataService_new {
	//精确查找
	public MatchPO_new getMatch(String season, String date, Teams team1, Teams team2) 
			throws MatchNotFound;
	
	//条件筛选
	public ArrayList<MatchPO_new> getMatches(String season, String date, Teams team1, 
			Teams team2) throws MatchNotFound;
	
	//迭代二
	ArrayList<String> getAvailableSeasons() throws StatsNotFound;
	ArrayList<String> getAvailableDays(String season) throws StatsNotFound;
	MatchPO_new getMatches(String season, String date, String player) throws MatchNotFound;
	MatchPO_new getMatches(String season, String date, Teams team) throws MatchNotFound;
	ArrayList<MatchPO_new> getMatches(Teams team, int num) throws MatchNotFound;
	ArrayList<MatchPO_new> getMatches(String player, int num) throws MatchNotFound;
	ArrayList<MatchPO_new> getMatches(String season, String date) throws MatchNotFound;
	ArrayList<MatchPO_new> getMatches(String season) throws MatchNotFound;
}
