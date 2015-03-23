package businessLogic.playersBL;

import java.util.ArrayList;

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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<PlayerVO> getAllPlayersInfo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<PlayerBasicStatsVO> getBasicPlayersStatsTotal(
			Conference con, Division div, Position pos) throws PlayerNotFound {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<PlayerBasicStatsVO> getBasicPlayersStatsAverage(
			Conference con, Division div, Position pos) throws PlayerNotFound {
		// TODO Auto-generated method stub
		return null;
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
