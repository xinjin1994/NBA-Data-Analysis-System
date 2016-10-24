package dataServiceTest.teamsDataServiceTest;

import java.util.ArrayList;

import po.TeamPO;
import data.teamsData.TeamsData;
import dataService.teamsDataService.TeamsDataService;
import enums.Conference;
import enums.Division;
import enums.Teams;
import exceptions.TeamNotFound;
import junit.framework.TestCase;

public class TeamsDataServiceTest extends TestCase {

	TeamsDataService service = new TeamsData();
	
	protected void setUp() throws Exception {
		super.setUp();
	}
	
	private boolean teamPOEqual(TeamPO t1, TeamPO t2){
		if(t1.name() == t2.name() &&
				t1.abbreviationOfName().equals(t2.abbreviationOfName()) &&
				t1.conference() == t2.conference() &&
				t1.division() == t2.division() &&
				t1.location().equals(t2.location()) &&
				t1.homeCourt().equals(t2.homeCourt()) &&
				t1.yearOfEstablishment().equals(t2.yearOfEstablishment())){
			return true;
		}
		
		return false;
	}
	
	public void testGetTeam(){
		Teams team = Teams.BKN;
		try {
			TeamPO teamGet = service.getTeam(team);
			String[] info = new String[]{"Nets", "BKN", "Brooklyn", "E", "Atlantic", "Barclays Center", "1976"};
			TeamPO trueValue = new TeamPO(info);
			
			assertTrue(teamPOEqual(teamGet, trueValue));
			
		} catch (TeamNotFound e) {
			assertTrue(false);
		}
	}
	
	public void testGetTeamByConference(){
		Conference con = Conference.EASTERN;
		Division div = Division.ATLANTIC;
		
		try {
			ArrayList<TeamPO> teams = service.getTeams(con, div);
			ArrayList<Teams> trueValue = new ArrayList<Teams>();
			trueValue.add(Teams.BOS);
			trueValue.add(Teams.BKN);
			trueValue.add(Teams.NYK);
			trueValue.add(Teams.PHI);
			trueValue.add(Teams.TOR);
			
			if(teams.size() != 5){
				assertTrue(false);
			}
			
			for(TeamPO team: teams){
				if(!(trueValue.contains(team.name()))){
					assertTrue(false);
				}
				
			}
			
			assertTrue(true);
			
		} catch (TeamNotFound e) {
			assertTrue(false);
		}
	}
	
	public void testGetAllTeams(){
		int numOfTeams = 30;
		ArrayList<TeamPO> teams = service.getAllTeams();
		if(teams.size() != numOfTeams){
			assertTrue(false);
		}else{
			assertTrue(true);
		}
	}

}
