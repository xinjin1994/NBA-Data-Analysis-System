package businessLogicServiceTest.playersBLService;

import helper.TypeTransform;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import vo.PlayerAdvancedStatsVO;
import vo.PlayerBasicStatsVO;
import vo.PlayerHotStatsVO;
import vo.PlayerProgressVO;
import vo.PlayerVO;
import data.init.DataInit;
import enums.Conference;
import enums.Division;
import enums.Position;
import enums.Terminology;
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
	
	public void testGetAvailableDays(){
		String season = "13-14";
		String player = "Jan Vesely";
		try {
			ArrayList<Date> days = service.getAvailableDays(season, player);
			for(Date date: days){
				System.out.println(TypeTransform.date_to_str(date));
			}
		} catch (PlayerNotFound e) {
			assertTrue(false);
		}
	}
	
	public void testGetAdvancedStats(){
		String season = "13-14";
		Date date = TypeTransform.str_to_date("01-09");
		String player = "LeBron James";
		try {
			PlayerAdvancedStatsVO vo = service.getAdvancedStats(season, date, player);
			assertTrue(vo != null);
		} catch (PlayerNotFound e) {
			assertTrue(false);
		}
	}
	
	public void testGetBasicStats(){
		String season = "13-14";
		Date date = TypeTransform.str_to_date("01-09");
		String player = "LeBron James";
		try {
			PlayerBasicStatsVO vo = service.getBasicStats(season, date, player);
			assertTrue(vo != null);
		} catch (PlayerNotFound e) {
			assertTrue(false);
		}
	}
	
	public void testGetHotPlayersByDay(){
		String season = "13-14";
		Date date = TypeTransform.str_to_date("04-01");
		Terminology term = Terminology.PTS;
		int num = 5;
		ArrayList<PlayerHotStatsVO> list = service.getHotPlayersByDay(season, date, term, num);
		System.out.println(list.size());
	}
	
	public void testGetHotPlayersBySeason(){
		String season = "13-14";
		Terminology term = Terminology.PTS;
		int num = 5;
		ArrayList<PlayerHotStatsVO> list = service.getHotPlayersBySeason(season, term, num);
		System.out.println(list.size());
	}
	
	public void testGetProgress(){
		Terminology term = Terminology.PTS;
		int num = 10;
		ArrayList<PlayerProgressVO> list = service.getPlayerProgress(term, num);
		System.out.println(list.size());
	}

}
