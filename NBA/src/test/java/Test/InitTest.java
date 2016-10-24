package Test;

import java.util.ArrayList;

import data.init.DataInit;
import data.matchesData.MatchesData_new;
import data.matchesData.Matches_new;
import data.playersData.PlayersData_new;
import data.playersData.Players_new;
import data.teamsData.TeamsData_new;
import data.teamsData.Teams_new;
import junit.framework.TestCase;

public class InitTest extends TestCase {

	protected void setUp() throws Exception {
		super.setUp();
	}
	
	public void testDataInit(){
		long t1 = System.currentTimeMillis();
		
		DataInit init = new DataInit();
		init.init();
		
		long t2 = System.currentTimeMillis();
		
		PlayersData_new playerData = new PlayersData_new();
		TeamsData_new teamData = new TeamsData_new();
		MatchesData_new matchData = new MatchesData_new();
		
		ArrayList<Players_new> players = playerData.getData();
		ArrayList<Teams_new> teams = teamData.getData();
		ArrayList<Matches_new> matches = matchData.getData();
		
		System.out.println("Time: " + (t2-t1));
		System.out.println(players.size());
		System.out.println(teams.size());
		System.out.println(matches.size());
	}

}
