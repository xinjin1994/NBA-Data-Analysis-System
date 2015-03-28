package businessLogicServiceTest.playersBLService;

import java.util.ArrayList;

import vo.PlayerAdvancedStatsVO;
import vo.PlayerBasicStatsVO;
import vo.PlayerVO;
import data.init.DataInit;
import enums.Conference;
import enums.Division;
import enums.Position;
import exceptions.PlayerNotFound;
import businessLogic.playersBL.PlayersBL_new;
import businessLogicService.playersBLService.PlayersBLService_new;
import junit.framework.TestCase;

public class PlayersBLService_newTest extends TestCase {

	PlayersBLService_new service = new PlayersBL_new();
	
	protected void setUp() throws Exception {
		super.setUp();
		new DataInit().init();
	}
	
	public void testGetPlayerInfo() {
		try {
			PlayerVO player = service.getPlayerInfo("Kobe Bryant");
			assertTrue(player.getName().equals("Kobe Bryant"));
		} catch (PlayerNotFound e) {
			assertTrue(false);
		}
	}
	
	public void testGetAllPlayerInfo() {
		ArrayList<PlayerVO> list = service.getAllPlayersInfo();
		assertTrue(list.size() == 448);
	}
	
	public void testGetStats() {
		Conference con = Conference.NATIONAL;
		Division div = Division.NATIONAL;
		Position pos = Position.ALL;
		try {
			ArrayList<PlayerBasicStatsVO> basic = service.getBasicPlayersStatsAverage(con, div, pos);
			System.out.println(basic.size());
		} catch (PlayerNotFound e) {
			assertTrue(false);
		}
		try {
			ArrayList<PlayerAdvancedStatsVO> advanced = service.getAdvancedPlayersStatsAverage(con, div, pos);
			System.out.println(advanced.size());
		} catch (PlayerNotFound e) {
			assertTrue(false);
		}
	}
	
	

}
