package data.playersData;

import java.util.ArrayList;

import po.PlayerAdvancedStatsPO;
import po.PlayerBasicStatsPO;
import po.PlayerHotStatsPO;
import po.PlayerPO;
import po.PlayerProgressPO;
import dataService.playersDataService.PlayersDataService_new;
import enums.Position;
import enums.Teams;
import enums.Terminology;
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
	
	public static void addData(ArrayList<PlayerStats_new> stats){
		int num = stats.size();
		for(Players_new player: players){
			for(int i=0; i<stats.size(); i++){
				if(player.name.equals(stats.get(i).name)){
					player.addLatestStats(stats.get(i));
					num--;
					stats.remove(i);
					break;
				}
			}
			
			if(num == 0){
				break;
			}
		}
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

	@Override
	public ArrayList<PlayerHotStatsPO> getPlayerHotStats(String season,
			String date, Terminology term) {
		switch(term){
		case PTS: return this.getPlayerHotStats_points(season, date);
		case REB: return this.getPlayerHotStats_rebounds(season, date);
		case AST: return this.getPlayerHotStats_assists(season, date);
		case BLK: return this.getPlayerHotStats_blocks(season, date);
		case STL: return this.getPlayerHotStats_steals(season, date);
		case FGP: return this.getPlayerHotStats_fgp(season, date);
		case TPP: return this.getPlayerHotStats_tpp(season, date);
		case FTP: return this.getPlayerHotStats_ftp(season, date);
		default: return null;
		}
	}

	@Override
	public ArrayList<PlayerHotStatsPO> getPlayerHotStats(String season,
			Terminology term) {
		return this.getPlayerHotStats(season, null, term);
	}
	
	private ArrayList<PlayerHotStatsPO> getPlayerHotStats_points(String season,
			String date){
		ArrayList<PlayerHotStatsPO> poList = new ArrayList<PlayerHotStatsPO>();
		for(Players_new player: players){
			Position position = player.info == null ? Position.UNKNOWN : player.info.position();
			PlayerHotStatsPO po = new PlayerHotStatsPO(player.name, player.team, position);
			ArrayList<PlayerStats_new> stats = player.stats;
			for(PlayerStats_new s: stats){
				boolean seasonOK = s.season.equals(season);
				boolean dateOK = date == null || s.date.equals(date);
				if(seasonOK && dateOK){
					po.addStats(s.basic.points);
				}
			}
			if(po.getStats().size() != 0){
				poList.add(po);
			}
		}
		
		return poList;
	}
	
	private ArrayList<PlayerHotStatsPO> getPlayerHotStats_rebounds(String season,
			String date){
		ArrayList<PlayerHotStatsPO> poList = new ArrayList<PlayerHotStatsPO>();
		for(Players_new player: players){
			Position position = player.info == null ? Position.UNKNOWN : player.info.position();
			PlayerHotStatsPO po = new PlayerHotStatsPO(player.name, player.team, position);
			ArrayList<PlayerStats_new> stats = player.stats;
			for(PlayerStats_new s: stats){
				boolean seasonOK = s.season.equals(season);
				boolean dateOK = date == null || s.date.equals(date);
				if(seasonOK && dateOK){
					po.addStats(s.basic.rebounds);
				}
			}
			if(po.getStats().size() != 0){
				poList.add(po);
			}
		}
		
		return poList;
	}
	
	private ArrayList<PlayerHotStatsPO> getPlayerHotStats_assists(String season,
			String date){
		ArrayList<PlayerHotStatsPO> poList = new ArrayList<PlayerHotStatsPO>();
		for(Players_new player: players){
			Position position = player.info == null ? Position.UNKNOWN : player.info.position();
			PlayerHotStatsPO po = new PlayerHotStatsPO(player.name, player.team, position);
			ArrayList<PlayerStats_new> stats = player.stats;
			for(PlayerStats_new s: stats){
				boolean seasonOK = s.season.equals(season);
				boolean dateOK = date == null || s.date.equals(date);
				if(seasonOK && dateOK){
					po.addStats(s.basic.assists);
				}
			}
			if(po.getStats().size() != 0){
				poList.add(po);
			}
		}
		
		return poList;
	}
	
	private ArrayList<PlayerHotStatsPO> getPlayerHotStats_blocks(String season,
			String date){
		ArrayList<PlayerHotStatsPO> poList = new ArrayList<PlayerHotStatsPO>();
		for(Players_new player: players){
			Position position = player.info == null ? Position.UNKNOWN : player.info.position();
			PlayerHotStatsPO po = new PlayerHotStatsPO(player.name, player.team, position);
			ArrayList<PlayerStats_new> stats = player.stats;
			for(PlayerStats_new s: stats){
				boolean seasonOK = s.season.equals(season);
				boolean dateOK = date == null || s.date.equals(date);
				if(seasonOK && dateOK){
					po.addStats(s.basic.blocks);
				}
			}
			if(po.getStats().size() != 0){
				poList.add(po);
			}
		}
		
		return poList;
	}
	
	private ArrayList<PlayerHotStatsPO> getPlayerHotStats_steals(String season,
			String date){
		ArrayList<PlayerHotStatsPO> poList = new ArrayList<PlayerHotStatsPO>();
		for(Players_new player: players){
			Position position = player.info == null ? Position.UNKNOWN : player.info.position();
			PlayerHotStatsPO po = new PlayerHotStatsPO(player.name, player.team, position);
			ArrayList<PlayerStats_new> stats = player.stats;
			for(PlayerStats_new s: stats){
				boolean seasonOK = s.season.equals(season);
				boolean dateOK = date == null || s.date.equals(date);
				if(seasonOK && dateOK){
					po.addStats(s.basic.steals);
				}
			}
			if(po.getStats().size() != 0){
				poList.add(po);
			}
		}
		
		return poList;
	}
	
	private ArrayList<PlayerHotStatsPO> getPlayerHotStats_fgp(String season,
			String date){
		ArrayList<PlayerHotStatsPO> poList = new ArrayList<PlayerHotStatsPO>();
		for(Players_new player: players){
			Position position = player.info == null ? Position.UNKNOWN : player.info.position();
			PlayerHotStatsPO po = new PlayerHotStatsPO(player.name, player.team, position);
			ArrayList<PlayerStats_new> stats = player.stats;
			for(PlayerStats_new s: stats){
				boolean seasonOK = s.season.equals(season);
				boolean dateOK = date == null || s.date.equals(date);
				if(seasonOK && dateOK){
					PlayerBasicStats_new basic = s.basic;
					if(basic.fieldGoalsAttempted != 0){
						po.addStats(basic.fieldGoalsMade/basic.fieldGoalsAttempted);
					}
				}
			}
			if(po.getStats().size() != 0){
				poList.add(po);
			}
		}
		
		return poList;
	}
	
	private ArrayList<PlayerHotStatsPO> getPlayerHotStats_tpp(String season,
			String date){
		ArrayList<PlayerHotStatsPO> poList = new ArrayList<PlayerHotStatsPO>();
		for(Players_new player: players){
			Position position = player.info == null ? Position.UNKNOWN : player.info.position();
			PlayerHotStatsPO po = new PlayerHotStatsPO(player.name, player.team, position);
			ArrayList<PlayerStats_new> stats = player.stats;
			for(PlayerStats_new s: stats){
				boolean seasonOK = s.season.equals(season);
				boolean dateOK = date == null || s.date.equals(date);
				if(seasonOK && dateOK){
					PlayerBasicStats_new basic = s.basic;
					if(basic.threePointFieldGoalsAttempted != 0){
						po.addStats(basic.threePointFieldGoalsMade/basic.threePointFieldGoalsAttempted);
					}
				}
			}
			if(po.getStats().size() != 0){
				poList.add(po);
			}
		}
		
		return poList;
	}
	
	private ArrayList<PlayerHotStatsPO> getPlayerHotStats_ftp(String season,
			String date){
		ArrayList<PlayerHotStatsPO> poList = new ArrayList<PlayerHotStatsPO>();
		for(Players_new player: players){
			Position position = player.info == null ? Position.UNKNOWN : player.info.position();
			PlayerHotStatsPO po = new PlayerHotStatsPO(player.name, player.team, position);
			ArrayList<PlayerStats_new> stats = player.stats;
			for(PlayerStats_new s: stats){
				boolean seasonOK = s.season.equals(season);
				boolean dateOK = date == null || s.date.equals(date);
				if(seasonOK && dateOK){
					PlayerBasicStats_new basic = s.basic;
					if(basic.freeThrowsAttempted != 0){
						po.addStats(basic.freeThrowsMade/basic.freeThrowsAttempted);
					}
				}
			}
			if(po.getStats().size() != 0){
				poList.add(po);
			}
		}
		
		return poList;
	}

	@Override
	public ArrayList<PlayerProgressPO> getPlayerProgress(Terminology term,
			int num) {
		switch(term){
		case PTS: return this.getPlayerProgress_points(num);
		case BLK: return this.getPlayerProgress_blocks(num);
		case AST: return this.getPlayerProgress_assists(num);
		default: return null;
		}
	}
	
	private ArrayList<PlayerProgressPO> getPlayerProgress_points(int num){
		ArrayList<PlayerProgressPO> list = new ArrayList<PlayerProgressPO>();
		for(Players_new player: players){
			if(player.stats.size() < num){
				continue;
			}
			Position position = player.info == null ? Position.UNKNOWN : player.info.position();
			PlayerProgressPO po = new PlayerProgressPO(player.name, player.team, position);
			for(int i=0; i<num; i++){
				PlayerStats_new stats = player.stats.get(i);
				po.addStats(stats.basic.points);
			}
			list.add(po);
		}
		
		return list;
	}
	
	private ArrayList<PlayerProgressPO> getPlayerProgress_blocks(int num){
		ArrayList<PlayerProgressPO> list = new ArrayList<PlayerProgressPO>();
		for(Players_new player: players){
			if(player.stats.size() < num){
				continue;
			}
			Position position = player.info == null ? Position.UNKNOWN : player.info.position();
			PlayerProgressPO po = new PlayerProgressPO(player.name, player.team, position);
			for(int i=0; i<num; i++){
				PlayerStats_new stats = player.stats.get(i);
				po.addStats(stats.basic.blocks);
			}
			list.add(po);
		}
		
		return list;
	}

	private ArrayList<PlayerProgressPO> getPlayerProgress_assists(int num){
		ArrayList<PlayerProgressPO> list = new ArrayList<PlayerProgressPO>();
		for(Players_new player: players){
			if(player.stats.size() < num){
				continue;
			}
			Position position = player.info == null ? Position.UNKNOWN : player.info.position();
			PlayerProgressPO po = new PlayerProgressPO(player.name, player.team, position);
			for(int i=0; i<num; i++){
				PlayerStats_new stats = player.stats.get(i);
				po.addStats(stats.basic.assists);
			}
			list.add(po);
		}
		
		return list;
	}
	
}
