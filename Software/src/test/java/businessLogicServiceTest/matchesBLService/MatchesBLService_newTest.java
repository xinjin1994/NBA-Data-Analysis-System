package businessLogicServiceTest.matchesBLService;

import java.util.ArrayList;

import data.init.DataInit;
import enums.Teams;
import exceptions.MatchNotFound;
import exceptions.TeamNotFound;
import vo.MatchVO;
import businessLogic.matchesBL.MatchesBL_new;
import businessLogicService.matchesBLService.MatchesBLService;
import junit.framework.TestCase;

public class MatchesBLService_newTest extends TestCase {

	MatchesBLService service = new MatchesBL_new();
	
	protected void setUp() throws Exception {
		super.setUp();
		new DataInit().init();
	}
	
	public void testGetMatchVO() {
		String season = "13-14";
		String date = "03-02";
		Teams team1 = Teams.PHX;
		Teams team2 = Teams.ATL;
		try {
			MatchVO vo = service.getMatchVO(season, date, team1, team2);
			assertTrue(vo != null);
		} catch (TeamNotFound | MatchNotFound e) {
			assertTrue(false);
		}
	}
	
	public void testGetMatchesVO() {
		String season = null;
		String date = "03-02";
		Teams team1 = Teams.ALL;
		Teams team2 = Teams.ATL;
		try {
			ArrayList<MatchVO> list = service.getMatchesVO(season, date, team1, team2);
			assertTrue(list.size() == 1);
		} catch (TeamNotFound | MatchNotFound e) {
			assertTrue(false);
		}
	}
	

}
