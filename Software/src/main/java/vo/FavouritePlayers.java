package vo;

import java.io.Serializable;
import java.util.HashMap;

public class FavouritePlayers implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 5566528188413825258L;
	private HashMap<String, Integer> players;
	
	public FavouritePlayers() {
		players = new HashMap<String, Integer>();
	}
	
	public void addPlayers(String name){
		Integer num = players.get(name);
		if(num != null){
			players.remove(name);
			players.put(name, num+1);
		}else{
			players.put(name, 1);
		}
	}
	
	public int getVisits(String name){
		Integer num = players.get(name);
		if(num != null){
			return num;
		}else{
			return 0;
		}
	}
	
}
