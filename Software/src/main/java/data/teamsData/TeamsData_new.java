package data.teamsData;

import java.util.ArrayList;

import po.TeamDefensiveFoulsStatsPO;
import po.TeamHotStatsPO;
import po.TeamOffensiveStatsPO;
import po.TeamPO;
import po.TeamRatioGeneralStatsPO;
import dataService.teamsDataService.TeamsDataForTest;
import dataService.teamsDataService.TeamsDataService_new;
import enums.Conference;
import enums.Division;
import enums.Teams;
import enums.Terminology;
import exceptions.TeamNotFound;
import test.data.*;

public class TeamsData_new implements TeamsDataService_new, TeamsDataForTest{
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
	
	public static void addData(ArrayList<TeamStats_new> stats){
		int num = stats.size();
		for(Teams_new team: teams){
			for(int i=0; i<stats.size(); i++){
				if(team.team == stats.get(i).team){
					team.addLatestStats(stats.get(i));
					num--;
					stats.remove(i);
					break;
				}
			}
			
			if(num == 0){
				break;
			}
		}
	}
	
	public ArrayList<Teams_new> getData(){
		//测试用
		return teams;
	}
	
	private int getGames(String season, Teams team){
		int games = 0;
		for(int i=0; i<teams.size(); i++){
			Teams_new t = teams.get(i);
			if(t.team == team){
				for(int j=0; j<t.stats.size(); j++){
					TeamStats_new stats = t.stats.get(i);
					if(stats.season.equals(season)){
						games++;
					}
				}
			}
		}
		return games;
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
	public ArrayList<TeamOffensiveStatsPO> getOffensiveStats(String season, Teams team)
			throws TeamNotFound {
		ArrayList<TeamOffensiveStatsPO> poList = new ArrayList<TeamOffensiveStatsPO>();
		for(Teams_new t: teams){
			if(t.team == team){
				ArrayList<TeamStats_new> stats = t.stats;
				for(TeamStats_new s: stats){
					if(season != null && !s.season.equals(season))
						continue;
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
	public ArrayList<TeamRatioGeneralStatsPO> getRatioGeneralStats(String season, Teams team)
			throws TeamNotFound {
		ArrayList<TeamRatioGeneralStatsPO> poList = new ArrayList<TeamRatioGeneralStatsPO>();
		for(Teams_new t: teams){
			if(t.team == team){
				ArrayList<TeamStats_new> stats = t.stats;
				int wins = 0;
				for(TeamStats_new s: stats){
					if(season != null && !s.season.equals(season))
						continue;
					if(s.basic.win){
						wins++;
					}
				}
				for(TeamStats_new s: stats){
					if(season != null && !s.season.equals(season))
						continue;
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
	public ArrayList<TeamDefensiveFoulsStatsPO> getDefensiveFoulsStats(String season, 
			Teams team) throws TeamNotFound {
		ArrayList<TeamDefensiveFoulsStatsPO> poList = new ArrayList<TeamDefensiveFoulsStatsPO>();
		for(Teams_new t: teams){
			if(t.team == team){
				ArrayList<TeamStats_new> stats = t.stats;
				for(TeamStats_new s: stats){
					if(season != null && !s.season.equals(season))
						continue;
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
			if(po.getStats().size() != 0){
				poList.add(po);
			}
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
			if(po.getStats().size() != 0){
				poList.add(po);
			}
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
			if(po.getStats().size() != 0){
				poList.add(po);
			}
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
			if(po.getStats().size() != 0){
				poList.add(po);
			}
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
			if(po.getStats().size() != 0){
				poList.add(po);
			}
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
					po.addStats(100*s.basic.fieldGoalsMade/s.basic.fieldGoalsAttempted);
				}
			}
			if(po.getStats().size() != 0){
				poList.add(po);
			}
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
					po.addStats(100*s.basic.threePointFieldGoalsMade/s.basic.threePointFieldGoalsAttempted);
				}
			}
			if(po.getStats().size() != 0){
				poList.add(po);
			}
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
					po.addStats(100*s.basic.freeThrowsMade/s.basic.freeThrowsAttempted);
				}
			}
			if(po.getStats().size() != 0){
				poList.add(po);
			}
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
								basic.freeThrowsMade, basic.freeThrowsAttempted, 
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

	
	
	
	
	
	
	
	
	
	@Override
	public ArrayList<TeamNormalInfo> getTeamNormalInfo_avg() {
		ArrayList<TeamNormalInfo> list=getTeamNormalInfo_total();
		for(TeamNormalInfo info:list){
			int games=info.getNumOfGame();
			if(games==0){
				continue;
			}
			info.setPoint(info.getPoint()/games);
			info.setOffendRebound(info.getOffendRebound()/games);
			info.setDefendRebound(info.getDefendRebound()/games);
			info.setRebound(info.getRebound()/games);
			info.setAssist(info.getAssist()/games);
			info.setBlockShot(info.getBlockShot()/games);
			info.setSteal(info.getSteal()/games);
			info.setFault(info.getFault()/games);
			info.setFoul(info.getFoul()/games);
		}
		return list;
	}

	@Override
	public ArrayList<TeamNormalInfo> getTeamNormalInfo_total() {
		ArrayList<TeamNormalInfo> list=new ArrayList<TeamNormalInfo>();
		for(Teams_new tm:teams){
			TeamNormalInfo nor=new TeamNormalInfo();
			nor.setTeamName(tm.getTeam().toEnglish());
			nor.setNumOfGame(tm.getGames());
	        if(tm.getGames()==0){
	        	list.add(nor);
	        	continue;
	        }else{
			int numOfShot=0;
			int numOfThree=0;
			int numOfPenalty=0;
			for(TeamStats_new stat:tm.getStats()){
				double	shot=0.0;                                
				double	three=0.0;                                  
				double	penalty=0.0;
				if(stat.basic.fieldGoalsAttempted==0){
					numOfShot++;
				}else{
					shot=stat.basic.fieldGoalsMade/stat.basic.fieldGoalsAttempted;
				}
				if(stat.basic.threePointFieldGoalsAttempted==0){
					numOfThree++;
				}else{
					three=stat.basic.threePointFieldGoalsMade/stat.basic.threePointFieldGoalsAttempted;
				}
				if(stat.basic.freeThrowsAttempted==0){
					numOfPenalty++;
				}else{
					penalty=stat.basic.freeThrowsMade/stat.basic.freeThrowsAttempted;
				}
				nor.setPoint(nor.getPoint()+stat.basic.getPoints());
				nor.setShot(nor.getShot()+shot);
				nor.setThree(nor.getThree()+three);
				nor.setPenalty(nor.getPenalty()+penalty);
				nor.setOffendRebound(nor.getOffendRebound()+stat.basic.offensiveRebounds);
				nor.setDefendRebound(nor.getDefendRebound()+stat.basic.defensiveRebounds);
				nor.setRebound(nor.getRebound()+stat.basic.rebounds);
				nor.setAssist(nor.getAssist()+stat.basic.assists);
				nor.setBlockShot(nor.getBlockShot()+stat.basic.blocks);
				nor.setSteal(nor.getSteal()+stat.basic.steals);
				nor.setFault(nor.getFault()+stat.basic.turnovers);
				nor.setFoul(nor.getFoul()+stat.basic.fouls);
			}
			nor.setShot(nor.getShot()/(tm.getGames()-numOfShot));
			nor.setThree(nor.getThree()/(tm.getGames()-numOfThree));
			nor.setPenalty(nor.getPenalty()/(tm.getGames()-numOfPenalty));
			list.add(nor);
	        }
		}
		return list;
	}

	@Override
	public ArrayList<TeamHighInfo> getTeamHighInfo() {
		ArrayList<TeamHighInfo> list=new ArrayList<TeamHighInfo>();
		for(Teams_new tm:teams){
			TeamHighInfo high=new TeamHighInfo();
			high.setTeamName(tm.getTeam().toEnglish());
			if(tm.games==0){
				list.add(high);
				continue;
			}
			for(TeamStats_new stat:tm.getStats()){
				TeamAdvancedStats_new adv=stat.advanced;
				high.setWinRate(high.getWinRate()+adv.winningRate);
				high.setOffendRound(high.getOffendRound()+adv.offensiveRounds);
				high.setOffendEfficient(high.getOffendEfficient()+adv.offensiveEfficiency);
				high.setDefendEfficient(high.getDefendEfficient()+adv.defensiveEfficiency);
				high.setOffendReboundEfficient(high.getOffendReboundEfficient()+adv.offensiveReboudnsEfficiency);
				high.setDefendReboundEfficient(high.getDefendReboundEfficient()+adv.defensiveReboundsEfficiency);
				high.setAssistEfficient(high.getAssistEfficient()+adv.assistsEfficiency);
				high.setStealEfficient(high.getStealEfficient()+adv.stealsEfficiency);
			}
			high.setWinRate(high.getWinRate()/tm.games);
			high.setOffendRound(high.getOffendRound()/tm.games);
			high.setOffendEfficient(high.getOffendEfficient()/tm.games);
			high.setDefendEfficient(high.getDefendEfficient()/tm.games);
			high.setOffendReboundEfficient(high.getOffendReboundEfficient()/tm.games);
			high.setDefendReboundEfficient(high.getDefendReboundEfficient()/tm.games);
			high.setAssistEfficient(high.getAssistEfficient()/tm.games);
			high.setStealEfficient(high.getStealEfficient()/tm.games);
			list.add(high);
		}
		return list;
	}
	
}
