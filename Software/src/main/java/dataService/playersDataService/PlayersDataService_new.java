package dataService.playersDataService;

import java.util.ArrayList;

import po.PlayerAdvancedStatsPO;
import po.PlayerBasicStatsPO;
import po.PlayerPO;
import enums.Position;
import enums.Teams;
import exceptions.PlayerNotFound;

public interface PlayersDataService_new {
	//根据球队找队员
	public ArrayList<String> getPlayers(Teams team, Position pos) throws PlayerNotFound;
	
	
	//获取球员基本信息
	public PlayerPO getPlayerInfo(String name) throws PlayerNotFound;
	public ArrayList<PlayerPO> getAllPlayersInfo();
	
	
	//获取数据
	//基本数据
	public ArrayList<PlayerBasicStatsPO> getBasicStats(String name) throws PlayerNotFound;
	
	//高级数据
	public ArrayList<PlayerAdvancedStatsPO> getAdvancedStats(String name) throws PlayerNotFound;
	
	//迭代二
	//获取单场比赛数据
	public PlayerBasicStatsPO getBasicStats(String season, String date, String player) throws PlayerNotFound;
	public PlayerAdvancedStatsPO getAdvancedStats(String season, String date, String player) throws PlayerNotFound;
	
	//获取比赛日期
	public ArrayList<String> getAvailableDays(String season, String player) throws PlayerNotFound;
}
