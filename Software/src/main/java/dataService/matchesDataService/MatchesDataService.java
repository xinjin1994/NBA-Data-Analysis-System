package dataService.matchesDataService;

import enums.Teams;
import po.MatchPO;
import java.util.ArrayList;

public interface MatchesDataService {
	//获取比赛的所有数据，包括队员的详细数据
	public MatchPO getMatch(String season, String date, Teams homeTeam, Teams guestTeam);
	public ArrayList<MatchPO> getMatches(String season, String date, 
			Teams homeTeam, Teams guestTeam);
}
