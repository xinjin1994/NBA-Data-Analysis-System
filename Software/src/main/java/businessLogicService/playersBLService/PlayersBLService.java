package businessLogicService.playersBLService;

import java.util.ArrayList;
import enums.Teams;
import enums.Position;
import enums.Conference;
import enums.Division;
import vo.PlayerBasicStatsVO;
import vo.PlayerVO;
import vo.PlayerAdvancedStatsVO;

public interface PlayersBLService {
	//获取球员名单
	public ArrayList<String> getPlayerList(String season, Teams team);
		/*后续方法DataInMatchesService.getPlayser(season, team)
	 	*
	 	*/
	
	//获取基本信息
	public PlayerVO getPlayerInfo(String name);
	
	//获取统计数据
	public PlayerBasicStatsVO getBasicPlayerStats(String name);
	public PlayerAdvancedStatsVO getAdvancedPlayerStats(String name);
	public ArrayList<PlayerBasicStatsVO> getBasicPlayersStats(Conference con, Division div, Position pos);
	public ArrayList<PlayerAdvancedStatsVO> getAdvancedPlayersStats(Conference con, Division div, Position pos);
	
}
