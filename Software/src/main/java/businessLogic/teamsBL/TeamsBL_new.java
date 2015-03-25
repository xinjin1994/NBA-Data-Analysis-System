package businessLogic.teamsBL;

import java.util.ArrayList;

import po.TeamDefensiveFoulsStatsPO;
import po.TeamOffensiveStatsPO;
import po.TeamPO;
import po.TeamRatioGeneralStatsPO;
import dataService.teamsDataService.TeamsDataService_new;
import vo.TeamDefensiveFoulsVO;
import vo.TeamOffensiveStatsVO;
import vo.TeamRatioGeneralVO;
import vo.TeamVO;
import enums.Conference;
import enums.Division;
import enums.Teams;
import exceptions.TeamNotFound;
import factory.ObjectCreator;
import businessLogicService.teamsBLService.PlayersInTeamsService;
import businessLogicService.teamsBLService.TeamsBLService_new;

public class TeamsBL_new implements TeamsBLService_new, PlayersInTeamsService {
	TeamsDataService_new teamService;
	
	public TeamsBL_new(){
		teamService = new ObjectCreator().teamsDataService_new();
	}

	@Override
	public TeamVO getTeamInfo(Teams team) throws TeamNotFound {
		TeamPO po = teamService.getTeam(team);
		TeamVO vo = new TeamVO(po.name(), team.toAbbr(), po.location(), po.conference(),
				po.division(), po.homeCourt(), po.yearOfEstablishment());
		return vo;
	}

	@Override
	public ArrayList<TeamVO> getAllTeamsInfo() {
		ArrayList<TeamVO> voList = new ArrayList<TeamVO>();
		ArrayList<TeamPO> poList = teamService.getAllTeams();
		for(TeamPO po: poList){
			TeamVO vo = new TeamVO(po.name(), po.abbreviationOfName(), po.location(), po.conference(),
					po.division(), po.homeCourt(), po.yearOfEstablishment());
			voList.add(vo);
		}
		
		return voList;
	}

	@Override
	public ArrayList<TeamVO> getTeamsInfo(Conference conference,
			Division division) throws TeamNotFound {
		ArrayList<TeamVO> voList = new ArrayList<TeamVO>();
		ArrayList<TeamPO> poList = teamService.getTeams(conference, division);
		for(TeamPO po: poList){
			TeamVO vo = new TeamVO(po.name(), po.abbreviationOfName(), po.location(), po.conference(),
					po.division(), po.homeCourt(), po.yearOfEstablishment());
			voList.add(vo);
		}
		
		return voList;
	}

	@Override
	public ArrayList<TeamOffensiveStatsVO> getTeamOffensiveStatsTotal(
			Conference conference, Division division) throws TeamNotFound {
		ArrayList<Teams> teamNames = teamService.getTeamNames(conference, division);
		ArrayList<TeamOffensiveStatsVO> voList = new ArrayList<TeamOffensiveStatsVO>();
		for(Teams team: teamNames){
			ArrayList<TeamOffensiveStatsPO> poList = teamService.getOffensiveStats(team);
			TeamOffensiveStatsVO vo = this.sum_offensive(poList);
			voList.add(vo);
		}
		
		return null;
	}

	@Override
	public ArrayList<TeamRatioGeneralVO> getTeamRatioGeneralStatsTotal(
			Conference conference, Division division) throws TeamNotFound {
		ArrayList<Teams> teamNames = teamService.getTeamNames(conference, division);
		ArrayList<TeamRatioGeneralVO> voList = new ArrayList<TeamRatioGeneralVO>();
		for(Teams team: teamNames){
			ArrayList<TeamRatioGeneralStatsPO> poList = teamService.getRatioGeneralStats(team);
			TeamRatioGeneralVO vo = this.sum_ratio(poList);
			voList.add(vo);
		}
		
		return null;
	}

	@Override
	public ArrayList<TeamDefensiveFoulsVO> getTeamDefensiveFoulsStatsTotal(
			Conference conference, Division division) throws TeamNotFound {
		ArrayList<Teams> teamNames = teamService.getTeamNames(conference, division);
		ArrayList<TeamDefensiveFoulsVO> voList = new ArrayList<TeamDefensiveFoulsVO>();
		for(Teams team: teamNames){
			ArrayList<TeamDefensiveFoulsStatsPO> poList = teamService.getDefensiveFoulsStats(team);
			TeamDefensiveFoulsVO vo = this.sum_defensive(poList);
			voList.add(vo);
		}
		
		return null;
	}

	@Override
	public ArrayList<TeamOffensiveStatsVO> getTeamOffensiveStatsAverage(
			Conference conference, Division division) throws TeamNotFound {
		ArrayList<TeamOffensiveStatsVO> voList = this.getTeamOffensiveStatsTotal(conference, division);
		for(TeamOffensiveStatsVO vo: voList){
			vo.average();
		}
		
		return voList;
	}

	@Override
	public ArrayList<TeamRatioGeneralVO> getTeamRatioGeneralStatsAverage(
			Conference conference, Division division) throws TeamNotFound {
		return this.getTeamRatioGeneralStatsTotal(conference, division);
	}

	@Override
	public ArrayList<TeamDefensiveFoulsVO> getTeamDefensiveFoulsStatsAverage(
			Conference conference, Division division) throws TeamNotFound {
		ArrayList<TeamDefensiveFoulsVO> voList = this.getTeamDefensiveFoulsStatsTotal(conference, division);
		for(TeamDefensiveFoulsVO vo: voList){
			vo.average();
		}
		
		return voList;
	}

	@Override
	public ArrayList<Teams> getTeams(Conference con, Division div)
			throws TeamNotFound {
		return teamService.getTeamNames(con, div);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	private TeamOffensiveStatsVO sum_offensive(ArrayList<TeamOffensiveStatsPO> poList){
		return null;
	}
	
	private TeamDefensiveFoulsVO sum_defensive(ArrayList<TeamDefensiveFoulsStatsPO> poList){
		return null;
	}
	
	private TeamRatioGeneralVO sum_ratio(ArrayList<TeamRatioGeneralStatsPO> poList){
		return null;
	}

}
