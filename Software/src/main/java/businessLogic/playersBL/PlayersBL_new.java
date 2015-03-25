package businessLogic.playersBL;

import helper.TypeTransform;

import java.util.ArrayList;

import po.PlayerAdvancedStatsPO;
import po.PlayerBasicStatsPO;
import po.PlayerPO;
import dataService.imageService.ImageService;
import dataService.playersDataService.PlayersDataService_new;
import vo.PlayerAdvancedStatsVO;
import vo.PlayerBasicStatsVO;
import vo.PlayerPortraitVO;
import vo.PlayerVO;
import enums.Conference;
import enums.Division;
import enums.Position;
import enums.Teams;
import exceptions.PlayerNotFound;
import exceptions.TeamNotFound;
import factory.ObjectCreator;
import businessLogicService.playersBLService.PlayersBLService_new;
import businessLogicService.teamsBLService.PlayersInTeamsService;

public class PlayersBL_new implements PlayersBLService_new{
	PlayersDataService_new playerService;
	PlayersInTeamsService teamService;
	ImageService imageService;
	
	public PlayersBL_new(){
		playerService = new ObjectCreator().playersDataService_new();
		teamService = new ObjectCreator().playersInTeamsService();
		imageService = new ObjectCreator().imageService();
	}

	private ArrayList<String> getPlayers(Conference con, Division div, Position pos)
			throws PlayerNotFound {
		ArrayList<String> players = new ArrayList<String>();
		ArrayList<Teams> teams;
		try {
			//先获取该赛区的球队
			teams = teamService.getTeams(con, div);
		} catch (TeamNotFound e) {
			//该地区没有球队
			throw new PlayerNotFound("该地区没有球队，也没有球员");
		}
		for(Teams team: teams){
			//根据球队获取该地区球员
			ArrayList<String> names = playerService.getPlayers(team, pos);
			players.addAll(names);
		}
		
		return players;
	}
	
	@Override
	public ArrayList<PlayerPortraitVO> getPlayersPortrait(Conference con,
			Division div, Position pos) throws PlayerNotFound {
		ArrayList<PlayerPortraitVO> voList = new ArrayList<PlayerPortraitVO>();
		
		//获取球员名单
		ArrayList<String> names = this.getPlayers(con, div, pos);
		for(String name: names){
			PlayerPortraitVO vo = new PlayerPortraitVO(name, imageService.getPlayerPortrait(name));
			voList.add(vo);
		}
		
		return voList;
	}

	@Override
	public PlayerVO getPlayerInfo(String name) throws PlayerNotFound {
		PlayerPO po = playerService.getPlayerInfo(name);
		PlayerVO vo = new PlayerVO(po.name(), po.number(), po.position(), po.height_Foot(), 
				po.height_Inch(), po.weight_Pounds(), po.birthday(), po.age(), po.exp(), po.school());
		vo.addImage(imageService.getPlayerPortrait(name), imageService.getPlayerAction(name));
		
		return vo;
	}

	@Override
	public ArrayList<PlayerVO> getAllPlayersInfo() {
		ArrayList<PlayerVO> voList = new ArrayList<PlayerVO>();
		ArrayList<PlayerPO> poList = playerService.getAllPlayersInfo();
		for(PlayerPO po: poList){
			PlayerVO vo = new PlayerVO(po.name(), po.number(), po.position(), po.height_Foot(), 
					po.height_Inch(), po.weight_Pounds(), po.birthday(), po.age(), po.exp(), po.school());
			vo.addImage(imageService.getPlayerPortrait(po.name()), imageService.getPlayerAction(po.name()));
			voList.add(vo);
		}
		
		return voList;
	}

	@Override
	public ArrayList<PlayerBasicStatsVO> getBasicPlayersStatsTotal(
			Conference con, Division div, Position pos) throws PlayerNotFound {
		ArrayList<PlayerBasicStatsVO> voList = new ArrayList<PlayerBasicStatsVO>();
		ArrayList<String> players = this.getPlayers(con, div, pos);
		for(String name: players){
			try{
				ArrayList<PlayerBasicStatsPO> stats = playerService.getBasicStats(name);
				PlayerBasicStatsVO vo = this.sum_basic(stats);
				voList.add(vo);
			}catch(PlayerNotFound e){
				//没找到比赛数据的不处理
			}
		}
		
		return voList;
	}

	@Override
	public ArrayList<PlayerBasicStatsVO> getBasicPlayersStatsAverage(
			Conference con, Division div, Position pos) throws PlayerNotFound {
		ArrayList<PlayerBasicStatsVO> voList = this.getBasicPlayersStatsTotal(con, div, pos);
		for(PlayerBasicStatsVO vo: voList){
			vo.average();
		}
		return voList;
	}

	@Override
	public ArrayList<PlayerAdvancedStatsVO> getAdvancedPlayersStatsTotal(
			Conference con, Division div, Position pos) throws PlayerNotFound {
		ArrayList<PlayerAdvancedStatsVO> voList = new ArrayList<PlayerAdvancedStatsVO>();
		ArrayList<String> players = this.getPlayers(con, div, pos);
		for(String name: players){
			try{
				ArrayList<PlayerAdvancedStatsPO> stats = playerService.getAdvancedStats(name);
				PlayerAdvancedStatsVO vo = this.average_advanced(stats);
				voList.add(vo);
			}catch(PlayerNotFound e){
				//没找到比赛数据的不处理
			}
		}
		
		return voList;
	}

	@Override
	public ArrayList<PlayerAdvancedStatsVO> getAdvancedPlayersStatsAverage(
			Conference con, Division div, Position pos) throws PlayerNotFound {
		//高级数据没有平均和总和的区别
		return this.getAdvancedPlayersStatsTotal(con, div, pos);
	}
	
	
	
	
	
	
	
	
	
	private PlayerBasicStatsVO sum_basic(ArrayList<PlayerBasicStatsPO> poList) {
		String name = poList.get(0).getName();
		Teams team = poList.get(0).getTeam();
		double games = 0;
		double gamesStarting = 0;
		double minutes = 0;
		double rebounds = 0;
		double assists = 0;
		double fieldGoalPercentage = 0;
		double threePointFieldGoalPercentage = 0;
		double freeThrowPercentage = 0;
		double offensiveRebounds = 0;
		double defensiveRebounds = 0;
		double steals = 0;
		double blocks = 0;
		double turnovers = 0;
		double personalFouls = 0;
		double points = 0;
		int fg_num = 0;       //两分数
		int tp_num = 0;       //三分数
		int ft_num = 0;       //罚球数
		for(PlayerBasicStatsPO po: poList){
			games++;
			gamesStarting = po.isGamesStarting() ? gamesStarting + 1 : gamesStarting;
			minutes += po.getMinutes();
			rebounds += po.getRebounds();
			assists += po.getAssists();
			try{
				fieldGoalPercentage += po.getFieldGoalsMade()/po.getFieldGoalsAttempted();
				fg_num++;
			}catch(Exception e){
				//除0
			}
			try{
				threePointFieldGoalPercentage += po.getThreePointFieldGoalsMade()/po.getThreePointFieldGoalsAttempted();
				tp_num++;
			}catch(Exception e){
				//除0
			}
			try{
				freeThrowPercentage += po.getFreeThrowsMade()/po.getFreeThrowsAttempted();
				ft_num++;
			}catch(Exception e){
				//除0
			}
			offensiveRebounds = po.getOffensiveRebounds();
			defensiveRebounds = po.getDefensiveRebounds();
			steals = po.getSteals();
			blocks = po.getBlocks();
			turnovers = po.getTurnovers();
			personalFouls = po.getPersonalFouls();
			points = po.getPoints();
		}
		
		if(fg_num != 0){
			fieldGoalPercentage /= fg_num;
		}
		if(tp_num != 0){
			threePointFieldGoalPercentage /= tp_num;
		}
		if(ft_num != 0){
			freeThrowPercentage /= ft_num;
		}
		
		PlayerBasicStatsVO vo = new PlayerBasicStatsVO(name, team, games, gamesStarting, 
				TypeTransform.minutes_to_str(minutes), rebounds, assists, fieldGoalPercentage,
				threePointFieldGoalPercentage, freeThrowPercentage, offensiveRebounds, 
				defensiveRebounds, steals, blocks, turnovers, personalFouls, points);
		
		return vo;
	}
	
	private PlayerAdvancedStatsVO average_advanced(ArrayList<PlayerAdvancedStatsPO> poList) {
		int games = 0;
		String name = poList.get(0).getName();
		Teams team = poList.get(0).getTeam();
		double efficiency = 0;
		double GmSc = 0;
		double trueScore = 0;
		double fieldGoal = 0;
		double rebounds = 0;
		double offensiveRebounds = 0;
		double defensiveRebounds = 0;
		double assists = 0;
		double steals = 0;
		double blocks = 0;
		double turnovers = 0;
		double usage = 0;
		for(PlayerAdvancedStatsPO po: poList){
			games++;
			efficiency += po.getPlayerEfficiency();
			GmSc += po.getGmsc();
			trueScore += po.getTrueScorePercent();
			fieldGoal += po.getFieldGoalsPercent();
			rebounds += po.getReboundsPercent();
			offensiveRebounds += po.getOffensiveReboundsPercent();
			defensiveRebounds += po.getDefensiveReboundsPercent();
			assists += po.getAssistsPercent();
			steals += po.getStealsPercent();
			blocks += po.getBlockPercent();
			turnovers += po.getTurnoversPercent();
			usage += po.getUsagePercent();
		}
		PlayerAdvancedStatsVO vo = new PlayerAdvancedStatsVO(name, team, efficiency/games, 
				GmSc/games, trueScore/games, fieldGoal/games, rebounds/games, 
				offensiveRebounds/games, defensiveRebounds/games, assists/games,
				steals/games, blocks/games, turnovers/games, usage/games);
		
		return vo;
	}

}
