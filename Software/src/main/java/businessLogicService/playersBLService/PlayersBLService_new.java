package businessLogicService.playersBLService;

import java.util.Date;
import java.util.ArrayList;

import enums.Conference;
import enums.Division;
import enums.Position;
import exceptions.PlayerNotFound;
import vo.PlayerAdvancedStatsVO;
import vo.PlayerBasicStatsVO;
import vo.PlayerHotStatsVO;
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
	
	
	//迭代二内容
	ArrayList<Date> getAvailableDays(String season, String player) throws PlayerNotFound;
	
	//进步最大的球员
	//*******************************************
	
	//热点球员
	ArrayList<PlayerHotStatsVO> getHotPlayersByDay(String season, Date date, String player, int num);
	ArrayList<PlayerHotStatsVO> getHotPlayersBySeason(String season, String player, int num);
	
	//获取某个球员某场比赛的数据
	ArrayList<PlayerAdvancedStatsVO> getAdvancedStats(String season, Date date, String player) throws PlayerNotFound;
	ArrayList<PlayerBasicStatsVO> getBasicStats(String season, Date date, String player) throws PlayerNotFound;
}
