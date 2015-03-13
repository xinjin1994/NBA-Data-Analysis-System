package dataService.playersDataService;

import java.util.ArrayList;

import po.PlayerPO;
import enums.Conference;
import enums.Division;
import enums.Position;
import exceptions.PlayerNotFound;

public interface PlayersDataService {
	//获取球员基本信息
	public PlayerPO getPlayer(String name) throws PlayerNotFound;
	public ArrayList<PlayerPO> getPlayers(Conference conference, Division division,
			Position position) throws PlayerNotFound;
}
