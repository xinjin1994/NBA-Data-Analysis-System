package dataService.playersDataService;

import java.util.ArrayList;

import po.PlayerAdvancedStatsPO;
import po.PlayerBasicStatsPO;
import po.PlayerHotStatsPO;
import po.PlayerPO;
import po.PlayerProgressPO;
import enums.Position;
import enums.Teams;
import enums.Terminology;
import exceptions.PlayerNotFound;

public interface PlayersDataService_new {
	//根据球队找队员
	public ArrayList<String> getPlayers(Teams team, Position pos) throws PlayerNotFound;
	
	
	//获取球员基本信息
	public PlayerPO getPlayerInfo(String name) throws PlayerNotFound;
	public ArrayList<PlayerPO> getAllPlayersInfo();
	
	
	//获取数据
	//基本数据
	public ArrayList<PlayerBasicStatsPO> getBasicStats(String season, String name) throws PlayerNotFound;
	
	//高级数据
	public ArrayList<PlayerAdvancedStatsPO> getAdvancedStats(String season, String name) throws PlayerNotFound;
	
	//迭代二
	//获取单场比赛数据
	public PlayerBasicStatsPO getBasicStats(String season, String date, String player) throws PlayerNotFound;
	public PlayerAdvancedStatsPO getAdvancedStats(String season, String date, String player) throws PlayerNotFound;
	
	//获取比赛日期
	public ArrayList<String> getAvailableDays(String season, String player) throws PlayerNotFound;
	
	//获取热点数据
	public ArrayList<PlayerHotStatsPO> getPlayerHotStats(String season, String date, Terminology term);
	public ArrayList<PlayerHotStatsPO> getPlayerHotStats(String season, Terminology term);
	
	//获取进步最快的球员
	public ArrayList<PlayerProgressPO> getPlayerProgress(String season, Terminology term, int num);
	public double getPlayerProgress_single(String player, Terminology term, int num);
	
	public Teams getTeam(String player) throws PlayerNotFound;
}
