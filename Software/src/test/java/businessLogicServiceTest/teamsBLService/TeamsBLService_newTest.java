package businessLogicServiceTest.teamsBLService;

import helper.TypeTransform;

import java.util.ArrayList;
import java.util.Date;

import vo.TeamDefensiveFoulsVO;
import vo.TeamHotStatsVO;
import vo.TeamOffensiveStatsVO;
import vo.TeamRatioGeneralVO;
import vo.TeamVO;
import businessLogic.teamsBL.TeamsBL_new;
import businessLogicService.teamsBLService.TeamsBLService_new;
import data.init.DataInit;
import enums.Conference;
import enums.Division;
import enums.Teams;
import enums.Terminology;
import exceptions.TeamNotFound;
import junit.framework.TestCase;

public class TeamsBLService_newTest extends TestCase {

	TeamsBLService_new service = new TeamsBL_new();
	String season;
	
	protected void setUp() throws Exception {
		super.setUp();
		new DataInit().init();
		season = "13-14";
	}
	
	public void testGetInfo() {
		Conference conference = Conference.EASTERN;
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
		Conference conference = Conference.EASTERN;
		Division division = Division.ATLANTIC;
		try {
			ArrayList<TeamOffensiveStatsVO> list = service.getTeamOffensiveStatsAverage(season, conference, division);
			System.out.println(list.size());
		} catch (TeamNotFound e) {
			assertTrue(false);
		}
	}
	
	public void testGerDefensiveStats() {
		Conference conference = Conference.EASTERN;
		Division division = Division.ATLANTIC;
		try {
			ArrayList<TeamDefensiveFoulsVO> list = service.getTeamDefensiveFoulsStatsAverage(season, conference, division);
			System.out.println(list.size());
		} catch (TeamNotFound e) {
			assertTrue(false);
		}
	}
	
	public void testGetRatioStats() {
		Conference conference = Conference.NATIONAL;
		Division division = Division.NATIONAL;
		try {
			ArrayList<TeamRatioGeneralVO> list = service.getTeamRatioGeneralStatsAverage(season, conference, division);
			System.out.println(list.size());
		} catch (TeamNotFound e) {
			assertTrue(false);
		}
	}
	
	public void testGetNames() {
		Conference conference = Conference.EASTERN;
		Division division = Division.ATLANTIC;
		try {
			ArrayList<Teams> list = new TeamsBL_new().getTeams(conference, division);
			System.out.println(list.size());
		} catch (TeamNotFound e) {
			assertTrue(false);
		}
	}
	
	public void testGetAvailableDays(){
		String season = "13-14";
		Teams team = Teams.ATL;
		ArrayList<Date> days = service.getAvailableDays(season, team);
		for(Date date: days){
			System.out.println(TypeTransform.date_to_str(date));
		}
	}
	
	public void testGetHotTeams(){
		String season = "13-14";
		Terminology term = Terminology.PTS;
		int num = 5;
		ArrayList<TeamHotStatsVO> list = service.getHotTeams(season, term, num);
		System.out.println(list.size());
	}
	
	public void testGetStats(){
		String season = "13-14";
		Date date = TypeTransform.str_to_date("04-01");
		Teams team = Teams.HOU;
		try {
			TeamOffensiveStatsVO vo1 = service.getOffensiveStats(season, date, team);
			TeamDefensiveFoulsVO vo2 = service.getDefensiveStats(season, date, team);
			TeamRatioGeneralVO vo3 = service.getRatioStats(season, date, team);
			assertTrue(vo1 != null && vo2 != null && vo3 != null);
		} catch (TeamNotFound e) {
			assertTrue(false);
		}
	}
	
	public void testGetSeasonData(){
		String season = "13-14";
		Teams team = Teams.BOS;
		try {
			TeamOffensiveStatsVO list1 = service.getTeamOffensiveStatsAverage(season, team);
			TeamDefensiveFoulsVO list2 = service.getTeamDefensiveFoulsStatsAverage(season, team);
			TeamRatioGeneralVO list3 = service.getTeamRatioGeneralStatsAverage(season, team);
			System.out.println();
		} catch (TeamNotFound e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
