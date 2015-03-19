package businessLogicServiceTest.matchesBLService;

import java.util.ArrayList;

import enums.Teams;
import exceptions.MatchNotFound;
import exceptions.TeamNotFound;
import businessLogic.matchesBL.MatchesBL;
import businessLogic.playersBL.BasicPlayerStats;
import businessLogic.playersBL.PlayerStatsForCalculation;
import businessLogicService.matchesBLService.PlayerDataInMatchesService;
import junit.framework.TestCase;

public class PlayerDataInMatchesServiceTest extends TestCase {
	
	PlayerDataInMatchesService service = new MatchesBL();
	
	protected void setUp() throws Exception {
		super.setUp();
	}
	
	
	private boolean PlayerStatsForCalculationEqual(PlayerStatsForCalculation p1,
			PlayerStatsForCalculation p2){
		if(p1.minutes_teammate() == p2.minutes_teammate() &&
				p1.defensiveRebounds_opponent() == p2.defensiveRebounds_opponent() &&
				p1.defensiveRebounds_teammate() == p2.defensiveRebounds_teammate() &&
				p1.fieldGoalsAttempted_opponent() == p2.fieldGoalsAttempted_opponent() &&
				p1.fieldGoalsAttempted_teammate() == p2.fieldGoalsAttempted_teammate() &&
				p1.fieldGoalsMade_teammate() == p2.fieldGoalsMade_teammate() &&
				p1.freeThrowsAttempted_teammate() == p2.freeThrowsAttempted_teammate() &&
				p1.offensiveRebounds_opponent() == p2.offensiveRebounds_opponent() &&
				p1.offensiveRebounds_teammate() == p2.offensiveRebounds_teammate() &&
				p1.offensiveRounds_opponent() == p2.offensiveRounds_opponent() &&
				p1.turnovers_teammate() == p2.turnovers_teammate()){
			return true;
		}
		
		return false;
	}
	
	public void testGetPlayerStatsForCalculation(){
		try {
			String name = "Kobe Bryant";
			ArrayList<PlayerStatsForCalculation> list = service.getPlayerStatsForCalculation(name);
			
			assertTrue(list.size() == 6);
			
			/*
			PlayerStatsForCalculation s1 = list.get(0);
			System.out.println(s1.minutes_teammate() + "\n" +
					s1.defensiveRebounds_opponent() + "\n" +
					s1.defensiveRebounds_teammate() + "\n" +
					s1.fieldGoalsAttempted_opponent() + "\n" +
					s1.fieldGoalsAttempted_teammate() + "\n" +
					s1.fieldGoalsMade_teammate() + "\n" +
					s1.freeThrowsAttempted_teammate() + "\n" +
					s1.offensiveRebounds_opponent() + "\n" +
					s1.offensiveRebounds_teammate() + "\n" +
					s1.offensiveRounds_opponent() + "\n" +
					s1.turnovers_teammate());
			*/
		} catch (MatchNotFound | TeamNotFound e) {
			assertTrue(false);
		}
	}
	
	public void testGetBasicPlayerStats() {
		try {
			String name = "Kobe Bryant";
			ArrayList<BasicPlayerStats> list = service.getBasicPlayerStats(name);
			assertTrue(list.size() == 6);
		} catch (MatchNotFound | TeamNotFound e) {
			assertTrue(false);
		}
	}
	
	public void testGetPlayers(){
		try {
			ArrayList<String> players = service.getPlayers("13-14", Teams.DEN);
			
			for(String name: players){
				System.out.println(name);
			}
			//此方法不对，但没有简单且更好的获取方法
			
		} catch (MatchNotFound e) {
			assertTrue(false);
		}
	}
	
	public void testGetTeam(){
		String[] names = new String[]{"Wilson Chandler",
				"Kenneth Faried",
				"JJ Hickson",
				"Jordan Hamilton",
				"Ty Lawson",
				"Randy Foye",
				"Darrell Arthur",
				"Timofey Mozgov",
				"Nate Robinson",
				"Andre Miller",
				"Anthony Randolph",
				"Quincy Miller",
				"Evan Fournier",
				"JaVale McGee",
				"Aaron Brooks",
				"Jan Vesely"};
		
		Teams[] teams = new Teams[]{Teams.DEN,
				Teams.DEN,
				Teams.DEN,
				Teams.HOU,
				Teams.DEN,
				Teams.DEN,
				Teams.DEN,
				Teams.DEN,
				Teams.DEN,
				Teams.WAS,
				Teams.DEN,
				Teams.DEN,
				Teams.DEN,
				Teams.DEN,
				Teams.DEN,
				Teams.DEN};
		
		for(int i=0; i<names.length; i++){
			try {
				Teams team = service.getTeam(names[i]);
				assertTrue(team == teams[i]);
			} catch (TeamNotFound e) {
				assertTrue(false);
			}
		}
	}
	
}
