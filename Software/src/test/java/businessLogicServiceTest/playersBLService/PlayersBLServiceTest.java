package businessLogicServiceTest.playersBLService;


import java.util.ArrayList;

import vo.PlayerAdvancedStatsVO;
import vo.PlayerBasicStatsVO;
import vo.PlayerVO;
import enums.Conference;
import enums.Division;
import enums.Position;
import enums.Teams;
import exceptions.PlayerNotFound;
import businessLogic.playersBL.PlayersBL;
import businessLogicService.playersBLService.PlayersBLService;
import junit.framework.TestCase;

public class PlayersBLServiceTest extends TestCase {

	PlayersBLService service = new PlayersBL();
	
	protected void setUp() throws Exception {
		super.setUp();
	}
	
	
	public void getPlayerList(String season, Teams team) {
		//此方法不对，暂无好的解决方法
	}
			
	public void testGetPlayerInfo() {
		String name = "Kobe Bryant";
		try {
			PlayerVO player = service.getPlayerInfo(name);
			PlayerVO trueValue = new PlayerVO("Kobe Bryant", "24", Position.GUARD, 
					6.0, 6.0, 205.0, "AUG 23, 1978", 35, 17, "Lower Merion HS (PA)");
			
			assertTrue(player.equals(trueValue));
		} catch (PlayerNotFound e) {
			assertTrue(false);
		}
	}
	
	public void testGetAllPlayersInfo() {
		ArrayList<PlayerVO> list = service.getAllPlayersInfo();
		assertTrue(list.size() == 448);
	}
		
	public void testGetBasicPlayersStatsTotal_Single() {
		try {
			PlayerBasicStatsVO stats = service.getBasicPlayerStatsTotal("Alex Len");
			stats.print();
			assertTrue(stats != null);
		} catch (PlayerNotFound e) {
			assertTrue(false);
		}
	}
	
	public void testGetBasicPlayersStatsAverage_Single() {
		try {
			PlayerBasicStatsVO stats = service.getBasicPlayerStatsAverage("Kobe Bryant");
			//stats.print();
			assertTrue(stats != null);
		} catch (PlayerNotFound e) {
			assertTrue(false);
		}
	}
	
	public void testGetBasicPlayersStatsAverage(){
		Conference con = Conference.NATIONAL;
		Division div = Division.NATIONAL;
		Position pos = Position.ALL;
		try {
			ArrayList<PlayerBasicStatsVO> list = service.getBasicPlayersStatsAverage(con, div, pos);
			assertTrue(list.size() != 0);
		} catch (PlayerNotFound e) {
			assertTrue(false);
		}
	}
	
	public void testGetAdvancedPlayersStatsTotal() {
		try {
			PlayerAdvancedStatsVO stats = service.getAdvancedPlayerStatsTotal("Kobe Bryant");
			//stats.print();
			assertTrue(stats != null);
		} catch (PlayerNotFound e) {
			assertTrue(false);
		}
	}

}
