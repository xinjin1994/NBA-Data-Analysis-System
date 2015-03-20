package businessLogic.playersBL;

import java.util.ArrayList;

import javax.swing.ImageIcon;

import po.PlayerPO;
import dataService.imageService.ImageService;
import dataService.playersDataService.PlayersDataService;
import vo.PlayerAdvancedStatsVO;
import vo.PlayerBasicStatsVO;
import vo.PlayerVO;
import enums.Conference;
import enums.Division;
import enums.Position;
import enums.Teams;
import exceptions.PlayerNotFound;
import exceptions.TeamNotFound;
import businessLogicService.matchesBLService.PlayerDataInMatchesService;
import businessLogicService.playersBLService.PlayersBLService;
import businessLogicService.teamsBLService.TeamInfoService;
import factory.ObjectCreator;
import factory.PlayerCalculator;

public class PlayersBL implements PlayersBLService {
	//
	PlayersDataService playersService;
	PlayerDataInMatchesService matchesService;
	TeamInfoService teamsService;
	PlayerCalculator calculator;
	ImageService imageService;
	
	public PlayersBL(){
		playersService = new ObjectCreator().playersDataService();
		matchesService = new ObjectCreator().dataInMatchesService();
		teamsService = new ObjectCreator().teamInfoService();
		calculator = new PlayerCalculator();
		imageService = new ObjectCreator().imageService();
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
		PlayerVO vo = new PlayerVO(po.name(), po.number(), po.position(), 
				po.height_Foot(), po.height_Inch(), po.weight_Pounds(), 
				po.birthday(), po.age(), po.exp(), po.school());
		ImageIcon portrait = imageService.getPlayerPortrait(name);
		ImageIcon action = imageService.getPlayerAction(name);
		vo.addImage(portrait, action);
		return vo;
	}
	
	@Override
	public ArrayList<PlayerVO> getAllPlayersInfo() {
		ArrayList<PlayerVO> voList = new ArrayList<PlayerVO>();
		ArrayList<PlayerPO> poList = playersService.getAllPlayers();
		for(PlayerPO po: poList){
			PlayerVO vo = new PlayerVO(po.name(), po.number(), po.position(), 
					po.height_Foot(), po.height_Inch(), po.weight_Pounds(), 
					po.birthday(), po.age(), po.exp(), po.school());
			ImageIcon portrait = imageService.getPlayerPortrait(po.name());
			ImageIcon action = imageService.getPlayerAction(po.name());
			vo.addImage(portrait, action);
			voList.add(vo);
		}
		
		return voList;
	}
	
	@Override
	public PlayerBasicStatsVO getBasicPlayerStatsTotal(String name) throws PlayerNotFound {
		ArrayList<BasicPlayerStats> stats = matchesService.getBasicPlayerStats(name);
		BasicPlayerStats total = calculator.Sum(stats);
		return new PlayerBasicStatsVO(total);
	}
	
	/*
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
	 */

	@Override
	public PlayerBasicStatsVO getBasicPlayerStatsAverage(String name)
			throws PlayerNotFound {
		ArrayList<BasicPlayerStats> stats = matchesService.getBasicPlayerStats(name);
		BasicPlayerStats average = calculator.Average(stats);
		PlayerBasicStatsVO vo = new PlayerBasicStatsVO(average);
		vo.addPortrait(imageService.getPlayerPortrait(name));
		return vo;
	}
	
	/*
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
	 */

	@Override
	public PlayerAdvancedStatsVO getAdvancedPlayerStatsTotal(String name)
			throws PlayerNotFound {
		ArrayList<PlayerStatsForCalculation> stats = matchesService.getPlayerStatsForCalculation(name);
		calculator = new PlayerCalculator(stats);
		AdvancedPlayerStats adv = calculator.getAdvancedStatsTotal();
		PlayerAdvancedStatsVO vo = new PlayerAdvancedStatsVO(adv);
		vo.addPortrait(imageService.getPlayerPortrait(name));
		return vo;
	}
	
	@Override
	public PlayerAdvancedStatsVO getAdvancedPlayerStatsAverage(String name)
			throws PlayerNotFound {
		//高级数据没有平均与总和的区别
		return getAdvancedPlayerStatsTotal(name);
	}
	
	private ArrayList<String> getPlayers(Conference con, Division div, Position pos) throws PlayerNotFound {
		ArrayList<PlayerPO> players = playersService.getAllPlayers();
		ArrayList<String> playerNames = new ArrayList<String>();
		
		ArrayList<Teams> teams;
		try {
			teams = teamsService.getTeams(con, div);
		} catch (TeamNotFound e1) {
			throw new PlayerNotFound("该地区没有球队，没有球员");
		}
		
		for(PlayerPO player: players){
			if(player.position() != pos){
				continue;
			}
			
			try {
				Teams team = matchesService.getTeam(player.name());
				
				if(teams.contains(team)){
					playerNames.add(player.name());
				}
			} catch (TeamNotFound e) {
				//没找到的不管
				continue;
			}
			
		}
		
		return playerNames;
	}

	@Override
	public ArrayList<PlayerBasicStatsVO> getBasicPlayersStatsTotal(Conference con,
			Division div, Position pos) throws PlayerNotFound {
		ArrayList<String> playerNames = this.getPlayers(con, div, pos);
		
		ArrayList<PlayerBasicStatsVO> result = new ArrayList<PlayerBasicStatsVO>();
		for(String name: playerNames){
			try{
				PlayerBasicStatsVO vo = this.getBasicPlayerStatsTotal(name);
				vo.addPortrait(imageService.getPlayerPortrait(name));
				result.add(vo);
			}catch(PlayerNotFound e){
				continue;
			}
		}
		
		if(result.size() != 0){
			return result;
		}else{
			throw new PlayerNotFound("");
		}
	}
	
	@Override
	public ArrayList<PlayerBasicStatsVO> getBasicPlayersStatsAverage(Conference con,
			Division div, Position pos) throws PlayerNotFound {
		ArrayList<String> playerNames = this.getPlayers(con, div, pos);
		
		ArrayList<PlayerBasicStatsVO> result = new ArrayList<PlayerBasicStatsVO>();
		for(String name: playerNames){
			try{
				PlayerBasicStatsVO vo = this.getBasicPlayerStatsAverage(name);
				vo.addPortrait(imageService.getPlayerPortrait(name));
				result.add(vo);
			}catch(PlayerNotFound e){
				continue;
			}
		}
		
		return result;
	}

	@Override
	public ArrayList<PlayerAdvancedStatsVO> getAdvancedPlayersStatsTotal(
			Conference con, Division div, Position pos) throws PlayerNotFound {
		ArrayList<String> names = this.getPlayers(con, div, pos);
		ArrayList<PlayerAdvancedStatsVO> result = new ArrayList<PlayerAdvancedStatsVO>();
		
		for(String name: names){
			try{
				PlayerAdvancedStatsVO vo = this.getAdvancedPlayerStatsTotal(name);
				vo.addPortrait(imageService.getPlayerPortrait(name));
				result.add(vo);
			}catch(PlayerNotFound e){
				continue;
			}
		}
		
		return result;
	}
	
	@Override
	public ArrayList<PlayerAdvancedStatsVO> getAdvancedPlayersStatsAverage(
			Conference con, Division div, Position pos) throws PlayerNotFound {
		//高级数据不区分平均和总和
		return this.getAdvancedPlayersStatsTotal(con, div, pos);
	}

}
