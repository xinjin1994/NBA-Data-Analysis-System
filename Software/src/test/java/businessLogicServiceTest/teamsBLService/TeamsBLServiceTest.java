package businessLogicServiceTest.teamsBLService;

import enums.Conference;
import enums.Division;
import enums.Teams;
import exceptions.TeamNotFound;
import vo.TeamVO;
import businessLogic.teamsBL.TeamsBL;
import businessLogicService.teamsBLService.TeamsBLService;
import junit.framework.TestCase;

public class TeamsBLServiceTest extends TestCase {

	TeamsBLService service = new TeamsBL();
	
	protected void setUp() throws Exception {
		super.setUp();
	}
	
	public void testGetTeamInfo(){
		Teams team = Teams.ATL;
		try {
			TeamVO vo = service.getTeamInfo(team);
			TeamVO trueValue = new TeamVO(Teams.ATL, "ATL", "Atlanta", Conference.ESTERN, 
					Division.SOUTHEAST, "Philips Arena", "1949");
			vo.print();
			
		} catch (TeamNotFound e) {
			assertTrue(false);
		}
	}

}
