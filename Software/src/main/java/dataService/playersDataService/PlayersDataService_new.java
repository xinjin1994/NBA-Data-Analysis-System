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
}
