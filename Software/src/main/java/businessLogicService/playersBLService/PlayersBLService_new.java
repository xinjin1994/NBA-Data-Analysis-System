package businessLogicService.playersBLService;

import java.util.ArrayList;

import enums.Conference;
import enums.Division;
import enums.Position;
import exceptions.PlayerNotFound;
import vo.PlayerAdvancedStatsVO;
import vo.PlayerBasicStatsVO;
import vo.PlayerPortraitVO;
import vo.PlayerVO;

public interface PlayersBLService_new {
	//获取所有球员头像
	public ArrayList<PlayerPortraitVO> getPlayersPortrait(Conference con, Division div, Position pos) throws PlayerNotFound;
	
	
	//获取球员基本信息
	public PlayerVO getPlayerInfo(String name) throws PlayerNotFound;
	public ArrayList<PlayerVO> getAllPlayersInfo();
	
	
	//获取球员比赛数据
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
	
}
