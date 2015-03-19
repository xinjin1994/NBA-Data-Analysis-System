package businessLogicServiceTest.playersBLService;


import enums.Conference;
import enums.Division;
import enums.Position;
import enums.Teams;
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
			
	public void getPlayerInfo(String name) {
		
	}
	
	public void getAllPlayersInfo() {
		
	}
		
	public void getBasicPlayersStatsTotal(Conference con, Division div, 
			Position pos) {
		
	}
	
	public void getBasicPlayersStatsAverage(Conference con, Division div, 
			Position pos) {
		
	}
	
	public void getAdvancedPlayersStatsTotal(Conference con, 
			Division div, Position pos) {
		
	}
	
	public void getAdvancedPlayersStatsAverage(Conference con, 
			Division div, Position pos){
		
	}

}
