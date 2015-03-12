package businessLogicService.matchesBLService;

import java.util.ArrayList;

import businessLogic.matchesBL.Match;
import enums.Teams;

public interface DataInMatchesService {
	//获取比赛的详细数据
	//仅提供给球队、球员模块的业务逻辑层
	public Match getMatch(String season, String date, Teams team1, Teams team2);
	public ArrayList<Match> getMatches(String season, String date, Teams team1, Teams team2);

	//根据条件获取球员，用于Teams模块中根据(Season, Conference, Division)搜索球员
	public ArrayList<String> getPlayers(String season, Teams team);
	
	//根据队员获取球队，用于Team模块中根据球员索索球队
	public Teams getTeam(String name);
}
