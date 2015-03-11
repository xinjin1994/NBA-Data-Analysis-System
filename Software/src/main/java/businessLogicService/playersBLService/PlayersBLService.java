package businessLogicService.playersBLService;

import java.util.ArrayList;
import enums.Teams;
import enums.Position;
import enums.Conference;
import enums.Division;
import vo.PlayerStatsVO;
import vo.PlayerVO;

public interface PlayersBLService {
	//获取球员名单
	public ArrayList<String> getPlayerList(String season, Teams team);
		/*后续方法DataInMatchesService.getPlayser(season, team)
	 	*
	 	*/
	
	//获取基本信息
	public PlayerVO getPlayerInfo(String name);
	
	//获取统计数据
	public PlayerStatsVO getPlayerStats(String name);
	public ArrayList<PlayerStatsVO> getPlayersStats(Conference con, Division div, Position pos);
	public ArrayList<PlayerStatsVO> getPlayersStats(String season, Teams team);
	
}
