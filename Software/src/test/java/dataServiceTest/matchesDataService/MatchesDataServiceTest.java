package dataServiceTest.matchesDataService;

import java.util.ArrayList;

import po.MatchPO;
import data.matchesData.MatchesData;
import dataService.matchesDataService.MatchesDataService;
import enums.Teams;
import exceptions.MatchNotFound;
import exceptions.TeamNotFound;
import junit.framework.TestCase;

public class MatchesDataServiceTest extends TestCase {
	
	MatchesDataService service = new MatchesData();

	protected void setUp() throws Exception {
		super.setUp();
	}
	
	public void testGetMatch(){
		String season = "13-14";
		String date = "12-31";
		Teams team1 = Teams.toEnum("TOR");
		Teams team2 = Teams.toEnum("CHI");
		
		try {
			MatchPO matchGet = service.getMatch(season, date, team1, team2);
			
		} catch (MatchNotFound e) {
			assertTrue(false);
		}
	}
	
	public void testGetMatches(){
		String season = null;
		String date = null;
		Teams team1 = Teams.toEnum("CHI");
		Teams team2 = Teams.ALL;
		
		try {
			ArrayList<MatchPO> matches = service.getMatches(season, date, team1, team2);
			if(matches.size() != 82){
				assertTrue(false);
			}
			
		} catch (MatchNotFound e) {
			assertTrue(false);
		}
	}
	
	public void testGetMatchesByName(){
		String name = "Alex Len";
		try {
			ArrayList<MatchPO> matches = service.getMatches(name);
			
			for(MatchPO match: matches){
				System.out.println(match.date() + "_" + match.homeTeam().toAbbr() 
						+ "-" + match.guestTeam().toAbbr());
			}
		} catch (MatchNotFound e) {
			assertTrue(false);
		}
	}
	
	public void testGetTeamByPlayer(){
		String player = "Kobe Bryant";
		Teams team;
		try {
			team = service.getTeam(player);
			if(team == Teams.LAL){
				assertTrue(true);
			}else{
				assertTrue(false);
			}
		} catch (TeamNotFound e) {
			assertTrue(false);
		}
		
	}

}
