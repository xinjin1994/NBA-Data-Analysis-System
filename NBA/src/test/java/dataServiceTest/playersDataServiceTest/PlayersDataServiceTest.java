package dataServiceTest.playersDataServiceTest;

import java.util.ArrayList;

import po.PlayerPO;
import data.playersData.PlayersData;
import dataService.playersDataService.PlayersDataService;
import exceptions.PlayerNotFound;
import junit.framework.TestCase;

public class PlayersDataServiceTest extends TestCase {

	PlayersDataService service = new PlayersData();
	int numOfPlayers = 448;
	
	protected void setUp() throws Exception {
		super.setUp();
	}
	
	private boolean PlayerPOEqual(PlayerPO p1, PlayerPO p2){
		if(p1.name().equals(p2.name()) &&
			p1.number().equals(p2.number()) &&
			p1.position() == p2.position() &&
			p1.height_Foot() == p2.height_Foot() &&
			p1.height_Inch() == p2.height_Inch() &&
			p1.weight_Pounds() == p2.weight_Pounds() &&
			p1.birthday().equals(p2.birthday()) &&
			p1.age() == p2.age() &&
			p1.exp() == p2.exp() &&
			p1.school().equals(p2.school())){
			return true;
		}
		
		return false;
	}

	public void testGetPlayer(){
		try {
			PlayerPO player = service.getPlayer("Kobe Bryant");
			String[] info = new String[]{"Kobe Bryant", "24", "G", "6-6", "205", "AUG 23, 1978", "35", "17", "Lower Merion HS (PA)"};
			PlayerPO trueValue = new PlayerPO(info);
			if(PlayerPOEqual(player, trueValue)){
				assertTrue(true);
			}else{
				assertTrue(false);
			}
		} catch (PlayerNotFound e) {
			assertTrue(false);
		}
		
	}
	
	public void testGetAllPlayer(){
		ArrayList<PlayerPO> players = service.getAllPlayers();
		if(players.size() == numOfPlayers){
			assertTrue(true);
		}else{
			assertTrue(false);
		}
	}
}
