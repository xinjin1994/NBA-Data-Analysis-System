package data.playersData;

import java.util.ArrayList;
import po.PlayerPO;
import dataService.playersDataService.PlayersDataService;
import factory.ObjectCreater;
import exceptions.PlayerNotFound;

public class PlayersData implements PlayersDataService {
	ReadPlayers reader;
	
	ArrayList<PlayerPO> playerList;
	
	public PlayersData(){
		reader = new ObjectCreater().playersReader();
		playerList = reader.readAllPlayers();
	}

	@Override
	public PlayerPO getPlayer(String name) throws PlayerNotFound {
		for(int i=0; i<playerList.size(); i++){
			PlayerPO player = playerList.get(i);
			if(player.name().equals(name)){
				return player;
			}
		}
		
		throw new PlayerNotFound(name);
	}

	@Override
	public ArrayList<PlayerPO> getAllPlayers() throws PlayerNotFound {
		return playerList;
	}

}
