package businessLogic.playersBL;

import helper.TypeTransform;

import java.util.ArrayList;

import po.PlayerPO;
import dataService.playersDataService.PlayersDataService;
import vo.PlayerAdvancedStatsVO;
import vo.PlayerBasicStatsVO;
import vo.PlayerVO;
import enums.Conference;
import enums.Division;
import enums.Position;
import enums.Teams;
import exceptions.MatchNotFound;
import exceptions.PlayerNotFound;
import exceptions.TeamNotFound;
import businessLogicService.matchesBLService.PlayerDataInMatchesService;
import businessLogicService.playersBLService.PlayersBLService;
import businessLogicService.teamsBLService.TeamInfoService;
import factory.ObjectCreater;

public class PlayersBL implements PlayersBLService {
	//
	PlayersDataService playersService;
	PlayerDataInMatchesService matchesService;
	TeamInfoService teamsService;
	
	public PlayersBL(){
		playersService = new ObjectCreater().playersDataService();
		matchesService = new ObjectCreater().dataInMatchesService();
		teamsService = new ObjectCreater().teamInfoService();
	}
	
	@Override
	public ArrayList<String> getPlayerList(String season, Teams team)
			throws TeamNotFound {
		// TODO Auto-generated method stub
		//此方法暂未想好怎么实现
		return null;
	}

	@Override
	public PlayerVO getPlayerInfo(String name) throws PlayerNotFound {
		PlayerPO po = playersService.getPlayer(name);
		Player player = new Player(po);
		return player.toVO();
	}
	
	@Override
	public ArrayList<PlayerVO> getAllPlayersInfo() throws PlayerNotFound {
		ArrayList<PlayerVO> voList = new ArrayList<PlayerVO>();
		ArrayList<PlayerPO> poList = playersService.getAllPlayers();
		for(PlayerPO po: poList){
			Player player = new Player(po);
			voList.add(player.toVO());
		}
		
		return voList;
	}
	
	@Override
	public PlayerBasicStatsVO getBasicPlayerStatsTotal(String name) throws MatchNotFound, TeamNotFound{
		ArrayList<BasicPlayerStats> stats = matchesService.getBasicPlayerStats(name);
		Teams team = matchesService.getTeam(name);
		double games = stats.size();
		double gamesStarting = stats.get(0).gamesStarting();
		String minutes = null;                                  //在场时间
		double minutes_double = 0;
		double rebounds = 0;                                 //篮板数
		double assists = 0;                                  //助攻数
		double fieldGoalPercentage = 0;                      //命中率
		double threePointFieldGoalPercentage = 0;            //三分命中率
		double freeThrowPercentage = 0;                      //罚球命中率
		double offensiveRebounds = 0;                        //进攻（篮板）数
		double defensiveRebounds = 0;                        //防守(篮板)数
		double steals = 0;                                   //抢断数
		double blocks = 0;                                   //盖帽数
		double turnovers = 0;                                //失误数
		double personalFouls = 0;                              //犯规数
		double points = 0;                                   //个人得分
		
		for(BasicPlayerStats player: stats){
			minutes_double += player.minutes();
			rebounds += player.rebounds();
			assists = player.assists();
			fieldGoalPercentage += player.fieldGoalsMade/player.fieldGoalsAttempted;
			threePointFieldGoalPercentage += player.threePointFieldGoalsMade/player.threePointFieldGoalsAttempted;
			freeThrowPercentage += player.freeThrowsMade/player.freeThrowsAttempted;
			offensiveRebounds += player.offensiveRebounds();
			defensiveRebounds += player.defensiveRebounds();
			steals += player.steals();
			blocks += player.blocks();
			turnovers += player.turnovers();
			personalFouls += player.personalFouls();
			points += player.points();
		}
		
		minutes = TypeTransform.minutes_to_str(minutes_double);
		
		return new PlayerBasicStatsVO(name, team, games, gamesStarting, minutes, rebounds, 
				assists, fieldGoalPercentage/games, threePointFieldGoalPercentage/games, 
			freeThrowPercentage/games, offensiveRebounds, defensiveRebounds, steals, 
			blocks, turnovers, personalFouls, points);
	}

	@Override
	public PlayerBasicStatsVO getBasicPlayerStatsAverage(String name)
			throws PlayerNotFound, MatchNotFound, TeamNotFound {
		ArrayList<BasicPlayerStats> stats = matchesService.getBasicPlayerStats(name);
		Teams team = matchesService.getTeam(name);
		double games = stats.size();
		double gamesStarting = stats.get(0).gamesStarting();
		String minutes = null;                                  //在场时间
		double minutes_double = 0;
		double rebounds = 0;                                 //篮板数
		double assists = 0;                                  //助攻数
		double fieldGoalPercentage = 0;                      //命中率
		double threePointFieldGoalPercentage = 0;            //三分命中率
		double freeThrowPercentage = 0;                      //罚球命中率
		double offensiveRebounds = 0;                        //进攻（篮板）数
		double defensiveRebounds = 0;                        //防守(篮板)数
		double steals = 0;                                   //抢断数
		double blocks = 0;                                   //盖帽数
		double turnovers = 0;                                //失误数
		double personalFouls = 0;                              //犯规数
		double points = 0;                                   //个人得分
		
		for(BasicPlayerStats player: stats){
			minutes_double += player.minutes();
			rebounds += player.rebounds();
			assists = player.assists();
			fieldGoalPercentage += player.fieldGoalsMade/player.fieldGoalsAttempted;
			threePointFieldGoalPercentage += player.threePointFieldGoalsMade/player.threePointFieldGoalsAttempted;
			freeThrowPercentage += player.freeThrowsMade/player.freeThrowsAttempted;
			offensiveRebounds += player.offensiveRebounds();
			defensiveRebounds += player.defensiveRebounds();
			steals += player.steals();
			blocks += player.blocks();
			turnovers += player.turnovers();
			personalFouls += player.personalFouls();
			points += player.points();
		}
		
		minutes = TypeTransform.minutes_to_str(minutes_double/games);
		
		return new PlayerBasicStatsVO(name, team, games, gamesStarting, minutes, rebounds/games, 
				assists/games, fieldGoalPercentage/games, threePointFieldGoalPercentage/games, 
			freeThrowPercentage/games, offensiveRebounds/games, defensiveRebounds/games, steals/games, 
			blocks/games, turnovers/games, personalFouls/games, points/games);
	}

	@Override
	public PlayerAdvancedStatsVO getAdvancedPlayerStatsTotal(String name)
			throws PlayerNotFound {
		// TODO Auto-generated method stub
				return null;
	}
	
	@Override
	public PlayerAdvancedStatsVO getAdvancedPlayerStatsAverage(String name)
			throws PlayerNotFound {
		// TODO Auto-generated method stub
				return null;
	}
	
	private ArrayList<String> getPlayers(Conference con, Division div, Position pos) throws PlayerNotFound, TeamNotFound{
		ArrayList<PlayerPO> players = playersService.getAllPlayers();
		ArrayList<String> playerNames = new ArrayList<String>();
		for(PlayerPO player: players){
			if(player.position() != pos){
				continue;
			}
			
			Teams team = matchesService.getTeam(player.name());
			ArrayList<Teams> teams = teamsService.getTeams(con, div);
			
			if(teams.contains(team)){
				playerNames.add(player.name());
			}
		}
		
		return playerNames;
	}

	@Override
	public ArrayList<PlayerBasicStatsVO> getBasicPlayersStatsTotal(Conference con,
			Division div, Position pos) throws PlayerNotFound, TeamNotFound, MatchNotFound {
		ArrayList<String> playerNames = this.getPlayers(con, div, pos);
		
		ArrayList<PlayerBasicStatsVO> result = new ArrayList<PlayerBasicStatsVO>();
		for(String name: playerNames){
			result.add(this.getBasicPlayerStatsTotal(name));
		}
		
		return result;
	}
	
	@Override
	public ArrayList<PlayerBasicStatsVO> getBasicPlayersStatsAverage(Conference con,
			Division div, Position pos) throws PlayerNotFound, TeamNotFound, MatchNotFound {
		ArrayList<String> playerNames = this.getPlayers(con, div, pos);
		
		ArrayList<PlayerBasicStatsVO> result = new ArrayList<PlayerBasicStatsVO>();
		for(String name: playerNames){
			result.add(this.getBasicPlayerStatsAverage(name));
		}
		
		return result;
	}

	@Override
	public ArrayList<PlayerAdvancedStatsVO> getAdvancedPlayersStatsTotal(
			Conference con, Division div, Position pos) throws PlayerNotFound {
		// TODO Auto-generated method stub
		
		return null;
	}
	
	@Override
	public ArrayList<PlayerAdvancedStatsVO> getAdvancedPlayersStatsAverage(
			Conference con, Division div, Position pos) throws PlayerNotFound {
		// TODO Auto-generated method stub
		
		return null;
	}

}
