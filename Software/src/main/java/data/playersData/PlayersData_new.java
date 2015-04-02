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
			if(player.getInfo() == null){
				continue;
			}
			if((team == Teams.ALL || player.team == team) &&
					(pos == Position.ALL || player.getInfo().position() == pos)){
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

	@Override
	public PlayerBasicStatsPO getBasicStats(String season, String date,
			String player) throws PlayerNotFound {
		for(Players_new p: players){
			if(p.name.equals(player)){
				ArrayList<PlayerStats_new> stats = p.stats;
				for(PlayerStats_new s: stats){
					if(s.season.equals(season) && s.date.equals(date)){
						return new PlayerBasicStatsPO(player, s.team, s.basic);
					}
				}
			}
		}
		
		throw new PlayerNotFound("当天没有该球员的比赛");
	}

	@Override
	public PlayerAdvancedStatsPO getAdvancedStats(String season, String date,
			String player) throws PlayerNotFound {
		for(Players_new p: players){
			if(p.name.equals(player)){
				ArrayList<PlayerStats_new> stats = p.stats;
				for(PlayerStats_new s: stats){
					if(s.season.equals(season) && s.date.equals(date)){
						return new PlayerAdvancedStatsPO(player, s.team, s.advanced);
					}
				}
			}
		}
		
		throw new PlayerNotFound("当天没有该球员的比赛");
	}

	@Override
	public ArrayList<String> getAvailableDays(String season, String player)
			throws PlayerNotFound {
		ArrayList<String> dates = new ArrayList<String>();
		for(Players_new p: players){
			if(p.name.equals(player)){
				ArrayList<PlayerStats_new> stats = p.stats;
				for(PlayerStats_new s: stats){
					if(s.season.equals(season)){
						dates.add(s.date);
					}
				}
			}
		}
		
		if(dates.size() != 0){
			return dates;
		}else{
			throw new PlayerNotFound("该赛季没有该球员的比赛");
		}
	}
	
}
