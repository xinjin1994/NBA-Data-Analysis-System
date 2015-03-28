package businessLogicServiceTest.teamsBLService;

import java.util.ArrayList;

import vo.TeamDefensiveFoulsVO;
import vo.TeamOffensiveStatsVO;
import vo.TeamRatioGeneralVO;
import vo.TeamVO;
import businessLogic.teamsBL.TeamsBL_new;
import businessLogicService.teamsBLService.TeamsBLService_new;
import data.init.DataInit;
import enums.Conference;
import enums.Division;
import enums.Teams;
import exceptions.TeamNotFound;
import junit.framework.TestCase;

public class TeamsBLService_newTest extends TestCase {

	TeamsBLService_new service = new TeamsBL_new();
	
	protected void setUp() throws Exception {
		super.setUp();
		new DataInit().init();
	}
	
	public void testGetInfo() {
		Conference conference = Conference.ESTERN;
		Division division = Division.ATLANTIC;
		try {
			ArrayList<TeamVO> list = service.getTeamsInfo(conference, division);
			System.out.println(list.size());
		} catch (TeamNotFound e) {
			assertTrue(false);
		}
	}
	
	public void testGetAllInfo() {
		ArrayList<TeamVO> list = service.getAllTeamsInfo();
		System.out.println(list.size());
	}
	
	public void testGetOffensiveStats() {
		Conference conference = Conference.ESTERN;
		Division division = Division.ATLANTIC;
		try {
			ArrayList<TeamOffensiveStatsVO> list = service.getTeamOffensiveStatsAverage(conference, division);
			System.out.println(list.size());
		} catch (TeamNotFound e) {
			assertTrue(false);
		}
	}
	
	public void testGerDefensiveStats() {
		Conference conference = Conference.ESTERN;
		Division division = Division.ATLANTIC;
		try {
			ArrayList<TeamDefensiveFoulsVO> list = service.getTeamDefensiveFoulsStatsAverage(conference, division);
			System.out.println(list.size());
		} catch (TeamNotFound e) {
			assertTrue(false);
		}
	}
	
	public void testGetRatioStats() {
		Conference conference = Conference.ESTERN;
		Division division = Division.ATLANTIC;
		try {
			ArrayList<TeamRatioGeneralVO> list = service.getTeamRatioGeneralStatsAverage(conference, division);
			System.out.println(list.size());
		} catch (TeamNotFound e) {
			assertTrue(false);
		}
	}
	
	public void testGetNames() {
		Conference conference = Conference.ESTERN;
		Division division = Division.ATLANTIC;
		try {
			ArrayList<Teams> list = new TeamsBL_new().getTeams(conference, division);
			System.out.println(list.size());
		} catch (TeamNotFound e) {
			assertTrue(false);
		}
	}

}
