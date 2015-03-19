package businessLogicServiceTest.matchesBLService;

import java.util.ArrayList;

import vo.MatchVO;
import enums.Teams;
import exceptions.MatchNotFound;
import exceptions.TeamNotFound;
import businessLogic.matchesBL.MatchesBL;
import businessLogicService.matchesBLService.MatchesBLService;
import junit.framework.TestCase;

public class MatchesBLServiceTest extends TestCase {

	MatchesBLService service = new MatchesBL();
	
	protected void setUp() throws Exception {
		super.setUp();
	}
	
	private boolean MatchVOEqual(MatchVO match1, MatchVO match2){
		if(match1.getDate().equals(match2.getDate()) &&
				match1.getScore().equals(match2.getScore()) &&
				match1.getScore1().equals(match2.getScore1()) &&
				match1.getScore2().equals(match2.getScore2()) &&
				match1.getScore3().equals(match2.getScore3()) &&
				match1.getScore4().equals(match2.getScore4()) &&
				match1.getScoreExtra().equals(match2.getScoreExtra()) &&
				match1.getTeam1() == match2.getTeam1() &&
				match1.getTeam2() == match2.getTeam2()){
			return true;
		}
		
		return false;
	}
	
	public void testGetMatchVO(){
		Teams team1 = Teams.MEM;
		Teams team2 = Teams.PHX;
		try {
			MatchVO match = service.getMatchVO("13-14", "01-02", team1, team2);
			MatchVO trueValue = new MatchVO(team1, team2, "01-02", "99-91", "22-26", 
					"31-15", "16-32", "30-18", "无");
			assertTrue(this.MatchVOEqual(match, trueValue));
			
		} catch (TeamNotFound | MatchNotFound e) {
			assertTrue(false);
		}
		
		team1 = Teams.HOU;
		team2 = Teams.GSW;
		
		try {
			MatchVO match = service.getMatchVO("13-14", "02-20", team1, team2);
			MatchVO trueValue = new MatchVO(team1, team2, "02-20", "99-102", "24-20", 
					"19-27", "24-24", "22-18", "10-13");
			assertTrue(this.MatchVOEqual(match, trueValue));
		} catch (TeamNotFound | MatchNotFound e) {
			assertTrue(false);
		}
		
	}
	
	public void testGetMatchesVO(){
		try {
			ArrayList<MatchVO> matches = service.getMatchesVO("13-14", null, null, null);
			assertTrue(matches.size() == 1230);
			matches = service.getMatchesVO("13-14", "11-11", null, null);
			assertTrue(matches.size() == 9);
		} catch (TeamNotFound | MatchNotFound e) {
			assertTrue(false);
		}
	}

}
