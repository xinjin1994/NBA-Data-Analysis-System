package data.teamsData;

import java.util.ArrayList;

import po.TeamDefensiveFoulsStatsPO;
import po.TeamHotStatsPO;
import po.TeamOffensiveStatsPO;
import po.TeamPO;
import po.TeamRatioGeneralStatsPO;
import dataService.teamsDataService.TeamsDataService_new;
import enums.Conference;
import enums.Division;
import enums.Teams;
import enums.Terminology;
import exceptions.TeamNotFound;

public class TeamsData_new implements TeamsDataService_new {
	static ArrayList<Teams_new> teams;
	
	public TeamsData_new(ArrayList<Teams_new> teams) {
		//仅用于数据初始化
		if(TeamsData_new.teams == null){
			TeamsData_new.teams = teams;
		}
	}
	
	public TeamsData_new() {
		//do nothing
	}
	
	public ArrayList<Teams_new> getData(){
		//测试用
		return teams;
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
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	//迭代二

	@Override
	public ArrayList<String> getAvailableDays(String season, Teams team) {
		ArrayList<String> dates = new ArrayList<String>();
		for(Teams_new t: teams){
			if(t.team == team){
				for(TeamStats_new s: t.stats){
					if(!dates.contains(s.date)){
						dates.add(s.date);
					}
				}
				break;
			}
		}
		
		return dates;
	}

	@Override
	public ArrayList<TeamHotStatsPO> getTeamHotStats(String season,
			Terminology term) {
		switch(term){
		case PTS: return this.getTeamHotStats_points(season);
		case REB: return this.getTeamHotStats_rebounds(season);
		case AST: return this.getTeamHotStats_assists(season);
		case BLK: return this.getTeamHotStats_blocks(season);
		case STL: return this.getTeamHotStats_steals(season);
		case FGP: return this.getTeamHotStats_fgp(season);
		case TPP: return this.getTeamHotStats_tpp(season);
		case FTP: return this.getTeamHotStats_ftp(season);
		default: return null;
		}
	}
	
	private ArrayList<TeamHotStatsPO> getTeamHotStats_points(String season){
		ArrayList<TeamHotStatsPO> poList = new ArrayList<TeamHotStatsPO>();
		for(Teams_new team: teams){
			TeamPO info = team.info;
			TeamHotStatsPO po = new TeamHotStatsPO(team.team, info.conference(), info.division());
			for(TeamStats_new s: team.stats){
				if(s.season.equals(season)){
					po.addStats(s.basic.points);
				}
			}
			poList.add(po);
		}
		
		return poList;
	}
	
	private ArrayList<TeamHotStatsPO> getTeamHotStats_rebounds(String season){
		ArrayList<TeamHotStatsPO> poList = new ArrayList<TeamHotStatsPO>();
		for(Teams_new team: teams){
			TeamPO info = team.info;
			TeamHotStatsPO po = new TeamHotStatsPO(team.team, info.conference(), info.division());
			for(TeamStats_new s: team.stats){
				if(s.season.equals(season)){
					po.addStats(s.basic.rebounds);
				}
			}
			poList.add(po);
		}
		
		return poList;
	}
	
	private ArrayList<TeamHotStatsPO> getTeamHotStats_assists(String season){
		ArrayList<TeamHotStatsPO> poList = new ArrayList<TeamHotStatsPO>();
		for(Teams_new team: teams){
			TeamPO info = team.info;
			TeamHotStatsPO po = new TeamHotStatsPO(team.team, info.conference(), info.division());
			for(TeamStats_new s: team.stats){
				if(s.season.equals(season)){
					po.addStats(s.basic.assists);
				}
			}
			poList.add(po);
		}
		
		return poList;
	}
	
	private ArrayList<TeamHotStatsPO> getTeamHotStats_blocks(String season){
		ArrayList<TeamHotStatsPO> poList = new ArrayList<TeamHotStatsPO>();
		for(Teams_new team: teams){
			TeamPO info = team.info;
			TeamHotStatsPO po = new TeamHotStatsPO(team.team, info.conference(), info.division());
			for(TeamStats_new s: team.stats){
				if(s.season.equals(season)){
					po.addStats(s.basic.blocks);
				}
			}
			poList.add(po);
		}
		
		return poList;
	}
	
	private ArrayList<TeamHotStatsPO> getTeamHotStats_steals(String season){
		ArrayList<TeamHotStatsPO> poList = new ArrayList<TeamHotStatsPO>();
		for(Teams_new team: teams){
			TeamPO info = team.info;
			TeamHotStatsPO po = new TeamHotStatsPO(team.team, info.conference(), info.division());
			for(TeamStats_new s: team.stats){
				if(s.season.equals(season)){
					po.addStats(s.basic.steals);
				}
			}
			poList.add(po);
		}
		
		return poList;
	}
	
	private ArrayList<TeamHotStatsPO> getTeamHotStats_fgp(String season){
		ArrayList<TeamHotStatsPO> poList = new ArrayList<TeamHotStatsPO>();
		for(Teams_new team: teams){
			TeamPO info = team.info;
			TeamHotStatsPO po = new TeamHotStatsPO(team.team, info.conference(), info.division());
			for(TeamStats_new s: team.stats){
				if(s.season.equals(season)){
					po.addStats(s.basic.fieldGoalsMade/s.basic.fieldGoalsAttempted);
				}
			}
			poList.add(po);
		}
		
		return poList;
	}
	
	private ArrayList<TeamHotStatsPO> getTeamHotStats_tpp(String season){
		ArrayList<TeamHotStatsPO> poList = new ArrayList<TeamHotStatsPO>();
		for(Teams_new team: teams){
			TeamPO info = team.info;
			TeamHotStatsPO po = new TeamHotStatsPO(team.team, info.conference(), info.division());
			for(TeamStats_new s: team.stats){
				if(s.season.equals(season)){
					po.addStats(s.basic.threePointFieldGoalsMade/s.basic.threePointFieldGoalsAttempted);
				}
			}
			poList.add(po);
		}
		
		return poList;
	}
	
	private ArrayList<TeamHotStatsPO> getTeamHotStats_ftp(String season){
		ArrayList<TeamHotStatsPO> poList = new ArrayList<TeamHotStatsPO>();
		for(Teams_new team: teams){
			TeamPO info = team.info;
			TeamHotStatsPO po = new TeamHotStatsPO(team.team, info.conference(), info.division());
			for(TeamStats_new s: team.stats){
				if(s.season.equals(season)){
					po.addStats(s.basic.freeThrowsMade/s.basic.freeThrowsAttempted);
				}
			}
			poList.add(po);
		}
		
		return poList;
	}

	@Override
	public TeamOffensiveStatsPO getOffensiveStats(String season, String date,
			Teams team) throws TeamNotFound {
		for(Teams_new tm: teams){
			if(tm.team == team){
				ArrayList<TeamStats_new> stats = tm.stats;
				for(TeamStats_new s: stats){
					if(s.season.equals(season) && s.date.equals(date)){
						TeamBasicStats_new basic = s.basic;
						TeamOffensiveStatsPO po = new TeamOffensiveStatsPO(team, 
								basic.points, basic.fieldGoalsMade, basic.fieldGoalsAttempted, 
								basic.freeThrowsMade, basic.fieldGoalsAttempted, 
								basic.threePointFieldGoalsMade, basic.threePointFieldGoalsAttempted, 
								basic.assists);
						return po;
					}
				}
			}
		}
		
		throw new TeamNotFound("该球队当天没有比赛");
	}

	@Override
	public TeamRatioGeneralStatsPO getRatioGeneralStats(String season,
			String date, Teams team) throws TeamNotFound {
		for(Teams_new tm: teams){
			if(tm.team == team){
				ArrayList<TeamStats_new> stats = tm.stats;
				for(TeamStats_new s: stats){
					if(s.season.equals(season) && s.date.equals(date)){
						TeamBasicStats_new basic = s.basic;
						TeamAdvancedStats_new advanced = s.advanced;
						TeamRatioGeneralStatsPO po = new TeamRatioGeneralStatsPO(team, stats.size(), 
								basic.win==true?1:0 , basic.fieldGoalsMade, basic.fieldGoalsAttempted, 
								basic.freeThrowsMade, basic.freeThrowsAttempted, 
								basic.threePointFieldGoalsMade, 
								basic.threePointFieldGoalsAttempted, basic.offensiveRebounds,
								advanced.offensiveEfficiency, advanced.defensiveEfficiency, 
								advanced.offensiveReboudnsEfficiency, 
								advanced.defensiveReboundsEfficiency, 
								advanced.stealsEfficiency, advanced.assistsEfficiency);
						return po;
					}
				}
			}
		}
		
		throw new TeamNotFound("该球队当天没有比赛");
	}

	@Override
	public TeamDefensiveFoulsStatsPO getDefensiveFoulsStats(String season,
			String date, Teams team) throws TeamNotFound {
		for(Teams_new tm: teams){
			if(tm.team == team){
				ArrayList<TeamStats_new> stats = tm.stats;
				for(TeamStats_new s: stats){
					if(s.season.equals(season) && s.date.equals(date)){
						TeamBasicStats_new basic = s.basic;
						TeamDefensiveFoulsStatsPO po = new TeamDefensiveFoulsStatsPO(team,
								stats.size(), basic.offensiveRebounds, basic.defensiveRebounds, 
								basic.rebounds, basic.steals, basic.blocks, basic.turnovers, 
								basic.fouls);
						return po;
					}
				}
			}
		}
		
		throw new TeamNotFound("该球队当天没有比赛");
	}
}
