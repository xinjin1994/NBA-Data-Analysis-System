package data.playersData;

import java.util.ArrayList;

import po.PlayerAdvancedStatsPO;
import po.PlayerBasicStatsPO;
import po.PlayerPO;
import dataService.playersDataService.PlayersDataService_new;
import enums.Position;
import enums.Teams;
import exceptions.PlayerNotFound;

public class PlayersData_new implements PlayersDataService_new {
	static ArrayList<Players_new> players;
	
	public PlayersData_new(ArrayList<Players_new> players) {
		//仅用于数据初始化
		if(PlayersData_new.players == null){
			PlayersData_new.players = players;
		}
	}
	
	public PlayersData_new() {
		//do nothing
	}
	
	public ArrayList<Players_new> getData(){
		//测试用
		return players;
	}

	@Override
	public ArrayList<String> getPlayers(Teams team, Position pos)
			throws PlayerNotFound {
		ArrayList<String> names = new ArrayList<String>();
		for(Players_new player: players){
			if(player.team == team && player.getInfo().position() == pos){
				names.add(player.name);
			}
		}
		
		return names;
	}

	@Override
	public PlayerPO getPlayerInfo(String name) throws PlayerNotFound {
		for(Players_new player: players){
			if(player.name.equals(name)){
				if(player.getInfo() == null){
					throw new PlayerNotFound("没有该球员的信息");
				}
				return player.getInfo();
			}
		}
		
		throw new PlayerNotFound("该球员不存在");
	}

	@Override
	public ArrayList<PlayerPO> getAllPlayersInfo() {
		ArrayList<PlayerPO> info = new ArrayList<PlayerPO>();
		for(Players_new player: players){
			if(player.getInfo() != null){
				info.add(player.getInfo());
			}
		}
		
		return info;
	}

	@Override
	public ArrayList<PlayerBasicStatsPO> getBasicStats(String name)
			throws PlayerNotFound {
		ArrayList<PlayerBasicStatsPO> poList = new ArrayList<PlayerBasicStatsPO>();
		for(Players_new player: players){
			if(player.name.equals(name)){
				ArrayList<PlayerStats_new> statsList = player.getStats();
				for(PlayerStats_new stats: statsList){
					PlayerBasicStatsPO po = new PlayerBasicStatsPO(name, player.team, 
							stats.getBasic());
					poList.add(po);
				}
			}
		}
		
		if(poList.size() != 0){
			return poList;
		}else{
			throw new PlayerNotFound("该球员未找到");
		}
	}

	@Override
	public ArrayList<PlayerAdvancedStatsPO> getAdvancedStats(String name)
			throws PlayerNotFound {
		ArrayList<PlayerAdvancedStatsPO> poList = new ArrayList<PlayerAdvancedStatsPO>();
		for(Players_new player: players){
			if(player.name.equals(name)){
				ArrayList<PlayerStats_new> statsList = player.getStats();
				for(PlayerStats_new stats: statsList){
					PlayerAdvancedStatsPO po = new PlayerAdvancedStatsPO(name, player.team, 
							stats.getAdvanced());
					poList.add(po);
				}
			}
		}
		
		if(poList.size() != 0){
			return poList;
		}else{
			throw new PlayerNotFound("该球员未找到");
		}
	}
	
}
