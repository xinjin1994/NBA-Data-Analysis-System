package businessLogicService.matchesBLService;

import java.util.ArrayList;

import businessLogic.playersBL.BasicPlayerStats;
import businessLogic.playersBL.PlayerStatsForCalculation;
import enums.Teams;
import exceptions.MatchNotFound;

public interface PlayerDataInMatchesService {
	//获取比赛的详细数据
	//仅提供给球员模块的业务逻辑层
	
	public ArrayList<PlayerStatsForCalculation> getPlayerDataForCalculation(String name) throws MatchNotFound;
	public ArrayList<BasicPlayerStats> getBasicPlayerStats(String name) throws MatchNotFound;

	
	//根据条件获取球员，用于Teams模块中根据(Season, Conference, Division)搜索球员
	public ArrayList<String> getPlayers(String season, Teams team);
	
}
