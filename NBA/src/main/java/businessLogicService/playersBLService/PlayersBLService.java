package businessLogicService.playersBLService;

import java.util.ArrayList;

import enums.Teams;
import enums.Position;
import enums.Conference;
import enums.Division;
import vo.PlayerBasicStatsVO;
import vo.PlayerPortraitVO;
import vo.PlayerVO;
import vo.PlayerAdvancedStatsVO;
import exceptions.PlayerNotFound;
import exceptions.TeamNotFound;

public interface PlayersBLService {
	//获取球员名单
	public ArrayList<String> getPlayerList(String season, Teams team) throws TeamNotFound;
		/*后续方法DataInMatchesService.getPlayser(season, team)
	 	*
	 	*/
	
	//获取基本信息
	public PlayerVO getPlayerInfo(String name) throws PlayerNotFound;
	public ArrayList<PlayerPortraitVO> getPlayersPortrait(Conference con, Division div, Position pos) throws PlayerNotFound;
	public ArrayList<PlayerVO> getAllPlayersInfo();
	
	//获取统计数据
	//基本数据
	public ArrayList<PlayerBasicStatsVO> getBasicPlayersStatsTotal(Conference con, Division div, 
			Position pos) throws PlayerNotFound;
	public ArrayList<PlayerBasicStatsVO> getBasicPlayersStatsAverage(Conference con, Division div, 
			Position pos) throws PlayerNotFound;
	
	//高级数据
	public ArrayList<PlayerAdvancedStatsVO> getAdvancedPlayersStatsTotal(Conference con, 
			Division div, Position pos) throws PlayerNotFound;
	public ArrayList<PlayerAdvancedStatsVO> getAdvancedPlayersStatsAverage(Conference con, 
			Division div, Position pos) throws PlayerNotFound;
	
	
	
	//迭代一不需要
	public PlayerBasicStatsVO getBasicPlayerStatsTotal(String name) throws PlayerNotFound;
	public PlayerBasicStatsVO getBasicPlayerStatsAverage(String name) throws PlayerNotFound;
	
	public PlayerAdvancedStatsVO getAdvancedPlayerStatsTotal(String name) throws PlayerNotFound;
	public PlayerAdvancedStatsVO getAdvancedPlayerStatsAverage(String name) throws PlayerNotFound;
	
}
