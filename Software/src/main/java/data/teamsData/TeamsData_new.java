package data.teamsData;

import java.util.ArrayList;

import po.TeamDefensiveFoulsStatsPO;
import po.TeamOffensiveStatsPO;
import po.TeamPO;
import po.TeamRatioGeneralStatsPO;
import dataService.teamsDataService.TeamsDataService_new;
import enums.Conference;
import enums.Division;
import enums.Teams;
import exceptions.TeamNotFound;

public class TeamsData_new implements TeamsDataService_new {
	static ArrayList<Teams_new> teams;
	
	public TeamsData_new(ArrayList<Teams_new> teams) {
		//仅用于数据初始化
		if(teams == null){
			TeamsData_new.teams = teams;
		}
	}
	
	public TeamsData_new() {
		//do nothing
	}

	@Override
	public TeamPO getTeam(Teams team) throws TeamNotFound {
		for(Teams_new t: teams){
			if(t.team == team){
				return t.getInfo();
			}
		}
		
		throw new TeamNotFound("");
	}

	@Override
	public ArrayList<TeamPO> getTeams(Conference conference, Division division)
			throws TeamNotFound {
		ArrayList<TeamPO> poList = new ArrayList<TeamPO>();
		for(Teams_new t: teams){
			TeamPO info = t.info;
			boolean conOK = conference == Conference.NATIONAL || conference == info.conference();
			boolean divOK = division == Division.NATIONAL || division == info.division();
			if(conOK && divOK){
				poList.add(info);
			}
		}
		
		return poList;
	}

	@Override
	public ArrayList<TeamPO> getAllTeams() {
		ArrayList<TeamPO> poList = new ArrayList<TeamPO>();
		for(Teams_new t: teams){
			poList.add(t.info);
		}
		
		return poList;
	}

	@Override
	public ArrayList<Teams> getTeamNames(Conference conference,
			Division division) {
		ArrayList<Teams> names = new ArrayList<Teams>();
		for(Teams_new t: teams){
			TeamPO info = t.info;
			boolean conOK = conference == Conference.NATIONAL || conference == info.conference();
			boolean divOK = division == Division.NATIONAL || division == info.division();
			if(conOK && divOK){
				names.add(t.team);
			}
		}
		
		return names;
	}

	@Override
	public ArrayList<TeamOffensiveStatsPO> getOffensiveStats(Teams team)
			throws TeamNotFound {
		ArrayList<TeamOffensiveStatsPO> poList = new ArrayList<TeamOffensiveStatsPO>();
		for(Teams_new t: teams){
			if(t.team == team){
				ArrayList<TeamStats_new> stats = t.stats;
				for(TeamStats_new s: stats){
					TeamBasicStats_new basic = s.getBasic();
					TeamOffensiveStatsPO po = new TeamOffensiveStatsPO(team, basic.points, 
							basic.fieldGoalsMade, basic.fieldGoalsAttempted, basic.freeThrowsMade, 
							basic.freeThrowsAttempted, basic.threePointFieldGoalsMade, 
							basic.threePointFieldGoalsAttempted, basic.assists);
					poList.add(po);
				}
			}
		}
		
		return poList;
	}

	@Override
	public ArrayList<TeamRatioGeneralStatsPO> getRatioGeneralStats(Teams team)
			throws TeamNotFound {
		ArrayList<TeamRatioGeneralStatsPO> poList = new ArrayList<TeamRatioGeneralStatsPO>();
		for(Teams_new t: teams){
			if(t.team == team){
				ArrayList<TeamStats_new> stats = t.stats;
				int wins = 0;
				for(TeamStats_new s: stats){
					if(s.basic.win){
						wins++;
					}
				}
				for(TeamStats_new s: stats){
					TeamBasicStats_new basic = s.basic;
					TeamAdvancedStats_new advanced = s.advanced;
					TeamRatioGeneralStatsPO po = new TeamRatioGeneralStatsPO(team, stats.size(), 
							wins, basic.fieldGoalsMade, basic.fieldGoalsAttempted, basic.freeThrowsMade,
							basic.freeThrowsAttempted, basic.threePointFieldGoalsMade, 
							basic.threePointFieldGoalsAttempted, basic.offensiveRebounds,
							advanced.offensiveEfficiency, advanced.defensiveEfficiency, 
							advanced.offensiveReboudnsEfficiency, advanced.defensiveReboundsEfficiency, 
							advanced.stealsEfficiency, advanced.assistsEfficiency);
					poList.add(po);
				}
			}
		}
		
		return poList;
	}

	@Override
	public ArrayList<TeamDefensiveFoulsStatsPO> getDefensiveFoulsStats(
			Teams team) throws TeamNotFound {
		ArrayList<TeamDefensiveFoulsStatsPO> poList = new ArrayList<TeamDefensiveFoulsStatsPO>();
		for(Teams_new t: teams){
			if(t.team == team){
				ArrayList<TeamStats_new> stats = t.stats;
				for(TeamStats_new s: stats){
					TeamBasicStats_new basic = s.basic;
					TeamDefensiveFoulsStatsPO po = new TeamDefensiveFoulsStatsPO(team,
							stats.size(), basic.offensiveRebounds, basic.defensiveRebounds, 
							basic.rebounds, basic.steals, basic.blocks, basic.turnovers, 
							basic.fouls);
					poList.add(po);
				}
			}
		}
		
		return poList;
	}
}
