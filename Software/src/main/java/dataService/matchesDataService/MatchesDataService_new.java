package dataService.matchesDataService;

import java.util.ArrayList;

import enums.Teams;
import exceptions.MatchNotFound;
import po.MatchPO_new;

public interface MatchesDataService_new {
	//精确查找
	public MatchPO_new getMatch(String season, String date, Teams team1, Teams team2) 
			throws MatchNotFound;
	
	//条件筛选
	public ArrayList<MatchPO_new> getMatches(String season, String date, Teams team1, 
			Teams team2) throws MatchNotFound;
	
	//迭代二
	ArrayList<String> getAvailableSeasons();
	ArrayList<String> getAvailableDays(String season);
}
