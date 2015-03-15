package businessLogic.playersBL;

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
import exceptions.PlayerNotFound;
import exceptions.TeamNotFound;
import businessLogicService.matchesBLService.PlayerDataInMatchesService;
import businessLogicService.playersBLService.PlayersBLService;
import factory.ObjectCreater;

public class PlayersBL implements PlayersBLService {
	//
	PlayersDataService playersService;
	PlayerDataInMatchesService matchesService;
	
	public PlayersBL(){
		playersService = new ObjectCreater().playersDataService();
		matchesService = new ObjectCreater().dataInMatchesService();
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
		PlayerInfoVO player = new PlayerInfoVO(po);
		return player.toVO();
	}
	
	@Override
	public PlayerBasicStatsVO getBasicPlayerStatsTotal(String name)
			throws PlayerNotFound {
		// TODO Auto-generated method stub
				return null;
	}

	@Override
	public PlayerBasicStatsVO getBasicPlayerStatsAverage(String name)
			throws PlayerNotFound {
		// TODO Auto-generated method stub
				return null;
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

	@Override
	public ArrayList<PlayerBasicStatsVO> getBasicPlayersStatsTotal(Conference con,
			Division div, Position pos) throws PlayerNotFound {
		// TODO Auto-generated method stub
		
		return null;
	}
	
	@Override
	public ArrayList<PlayerBasicStatsVO> getBasicPlayersStatsAverage(Conference con,
			Division div, Position pos) throws PlayerNotFound {
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
