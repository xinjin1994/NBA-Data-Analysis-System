package businessLogicServiceTest.teamsBLService;

import java.util.ArrayList;

import enums.Conference;
import enums.Division;
import enums.Teams;
import exceptions.TeamNotFound;
import vo.TeamDefensiveStatsVO;
import vo.TeamFoulsStatsVO;
import vo.TeamGeneralStatsVO;
import vo.TeamOffensiveStatsVO;
import vo.TeamRatioStatsVO;
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
			TeamVO trueValue = new TeamVO(Teams.ATL, "ATL", "Atlanta", Conference.EASTERN, 
					Division.SOUTHEAST, "Philips Arena", "1949");
			assertTrue(vo.equals(trueValue));
		} catch (TeamNotFound e) {
			assertTrue(false);
		}
	}
	
	public void testGetAllTeamsInfo(){
		ArrayList<TeamVO> list = service.getAllTeamsInfo();
		assertTrue(list.size() == 30);
	}
	
	public void testGetTeams(){
		Conference conference = Conference.EASTERN;
		Division division = Division.CENTRAL;
		try {
			ArrayList<TeamVO> list = service.getTeamsInfo(conference, division);
			Teams[] trueValue = new Teams[]{Teams.CHI, Teams.CLE, Teams.DET, Teams.IND, Teams.MIL};
			ArrayList<Teams> teamsGet = new ArrayList<Teams>();
			for(TeamVO team: list){
				teamsGet.add(team.getName());
			}
		
			assertTrue(teamsGet.size() == trueValue.length);
			
			for(int i=0; i<5; i++){
				assertTrue(teamsGet.contains(trueValue[i]));
			}
		} catch (TeamNotFound e) {
			assertTrue(false);
		}
	}
	
	public void testGetTeamsGeneralStatsTotal(){
		Conference conference = Conference.EASTERN;
		Division division = Division.SOUTHEAST;
		try {
			ArrayList<TeamGeneralStatsVO> list = service.getTeamsGeneralStatsTotal(conference, division);
			assertTrue(list.size() == 5);
			
			for(TeamGeneralStatsVO vo: list){
				//vo.print();
			}
			
		} catch (TeamNotFound e) {
			assertTrue(false);
		}
	}
	
	public void testGetTeamsOffensiveStatsTotal(){
		Conference conference = Conference.EASTERN;
		Division division = Division.SOUTHEAST;
		try {
			ArrayList<TeamOffensiveStatsVO> list = service.getTeamsOffensiveStatsTotal(conference, division);
			assertTrue(list.size() == 5);
			
			for(TeamOffensiveStatsVO vo: list){
				vo.print();
			}
			
		} catch (TeamNotFound e) {
			assertTrue(false);
		}
	}
	
	public void testGetTeamsDefensiveStatsTotal(){
		Conference conference = Conference.EASTERN;
		Division division = Division.SOUTHEAST;
		try {
			ArrayList<TeamDefensiveStatsVO> list = service.getTeamsDefensiveStatsTotal(conference, division);
			assertTrue(list.size() == 5);
			
			for(TeamDefensiveStatsVO vo: list){
				//vo.print();
			}
			
		} catch (TeamNotFound e) {
			assertTrue(false);
		}
	}
	
	public void testGetTeamsFoulsStatsTotal(){
		Conference conference = Conference.EASTERN;
		Division division = Division.SOUTHEAST;
		try {
			ArrayList<TeamFoulsStatsVO> list = service.getTeamsFoulsStatsTotal(conference, division);
			assertTrue(list.size() == 5);
			
			for(TeamFoulsStatsVO vo: list){
				//vo.print();
			}
			
		} catch (TeamNotFound e) {
			assertTrue(false);
		}
	}
	
	public void testGetTeamsRatioStatsTotal(){
		Conference conference = Conference.EASTERN;
		Division division = Division.SOUTHEAST;
		try {
			ArrayList<TeamRatioStatsVO> list = service.getTeamsRatioStatsTotal(conference, division);
			assertTrue(list.size() == 5);
			
			for(TeamRatioStatsVO vo: list){
				//vo.print();
			}
			
		} catch (TeamNotFound e) {
			assertTrue(false);
		}
	}

}
