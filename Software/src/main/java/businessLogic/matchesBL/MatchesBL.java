package businessLogic.matchesBL;

import java.util.ArrayList;

import po.MatchPO;
import po.PlayerStatsPO;
import dataService.matchesDataService.MatchesDataService;
import vo.MatchVO;
import enums.Teams;
import exceptions.MatchNotFound;
import exceptions.PlayerNotFound;
import exceptions.TeamNotFound;
import factory.ObjectCreator;
import businessLogic.playersBL.BasicPlayerStats;
import businessLogic.playersBL.PlayerStatsForCalculation;
import businessLogic.teamsBL.BasicTeamStats;
import businessLogic.teamsBL.TeamStatsForCalculation;
import businessLogicService.matchesBLService.PlayerDataInMatchesService;
import businessLogicService.matchesBLService.MatchesBLService;
import businessLogicService.matchesBLService.TeamDataInMatchesService;

public class MatchesBL implements MatchesBLService, PlayerDataInMatchesService, TeamDataInMatchesService{
	//
	MatchesDataService matchesService;
	
	public MatchesBL(){
		matchesService = new ObjectCreator().matchesDataService();
	}
	
	@Override
	public ArrayList<TeamStatsForCalculation> getTeamDataForCalculation(Teams team) 
			throws TeamNotFound {
		ArrayList<MatchPO> matchList;
		try {
			matchList = matchesService.getMatches(null, null, team, null);
		} catch (MatchNotFound e) {
			throw new TeamNotFound("未找到该球队的比赛");
		}
		
		int games = matchList.size();
		int wins = 0;
		
		for(int i=0; i<games; i++){              //统计胜场数
			MatchPO match = matchList.get(i);
			int n = match.homeTeam() == team ? 0 : 1;
			String[] score = match.score().split("-");
			if(Integer.parseInt(score[n]) > Integer.parseInt(score[1-n])){
				wins++;
			}
		}
		
		ArrayList<TeamStatsForCalculation> stats = new ArrayList<TeamStatsForCalculation>();
		for(int i=0; i<matchList.size(); i++){
			MatchPO po = matchList.get(i);
			Match match = new Match(po);
			BasicTeamStats basic = new BasicTeamStats(team, games, wins, match.getTeamStats(team));
			TeamStatsForCalculation s = new TeamStatsForCalculation(basic, match.offensiveRebounds_opponent(team), 
					match.defensiveRebounds_opponent(team), match.fieldGoalsMade_opponent(team), 
					match.freeThrowsMade_opponent(team), match.fumbles_opponent(team), 
					match.turnovers_opponent(team));
			stats.add(s);
		}
		
		return stats;
	}

	@Override
	public ArrayList<BasicTeamStats> getBasicTeamStats(Teams team) throws TeamNotFound {
		ArrayList<MatchPO> matchList;
		try {
			matchList = matchesService.getMatches(null, null, team, null);
		} catch (MatchNotFound e) {
			throw new TeamNotFound("未找到该球队参加的比赛");
		}
		
		int games = matchList.size();
		int wins = 0;
		
		for(int i=0; i<games; i++){              //统计胜场数
			MatchPO match = matchList.get(i);
			int n = match.homeTeam() == team ? 0 : 1;
			String[] score = match.score().split("-");
			if(Integer.parseInt(score[n]) > Integer.parseInt(score[1-n])){
				wins++;
			}
		}
		
		ArrayList<BasicTeamStats> stats = new ArrayList<BasicTeamStats>();
		for(int i=0; i<matchList.size(); i++){
			MatchPO po = matchList.get(i);
			Match match = new Match(po);
			stats.add(new BasicTeamStats(team, games, wins, match.getTeamStats(team)));
		}
		
		return stats;
	}

	@Override
	public ArrayList<PlayerStatsForCalculation> getPlayerStatsForCalculation(
			String name) throws PlayerNotFound {
		ArrayList<MatchPO> matchList;
		try {
			matchList = matchesService.getMatches(name);
		} catch (MatchNotFound e) {
			throw new PlayerNotFound("该球员没有参加过比赛");
		}
		
		int games = matchList.size();
		int gameStarting = 0;
		
		for(int i=0; i<games; i++){
			Match match = new Match(matchList.get(i));
			
			if(match.isGameStarting(name)){
				gameStarting++;
			}
		}
		
		ArrayList<PlayerStatsForCalculation> stats = new ArrayList<PlayerStatsForCalculation>();
		for(int i=0; i<games; i++){
			Match match = new Match(matchList.get(i));
			Teams team;
			
			try {
				team = this.getTeam(name);
			} catch (TeamNotFound e) {
				throw new PlayerNotFound("没有找到该球员所在球队");
			}
			
			BasicPlayerStats basic = new BasicPlayerStats(match.getPlayerStats(name), games, gameStarting, team);
			PlayerStatsForCalculation s = new PlayerStatsForCalculation(basic, match.minutes_teammate(name),
					match.offensiveRebounds_teammate(name), match.defensiveRebounds_teammate(name), 
					match.offensiveRebounds_opponent(name), match.defensiveRebounds_opponent(name), 
					match.fieldGoalsMade_teammate(name), match.fieldGoalsAttempted_teammate(name), 
					match.fieldGoalsAttempted_opponent(name), match.freeThrowsAttempted_teammate(name), 
					match.turnovers_teammate(name), match.offensiveRounds_opponent(name));
			stats.add(s);
		}
		
		return stats;
	}

	@Override
	public ArrayList<BasicPlayerStats> getBasicPlayerStats(String name) throws PlayerNotFound {
		ArrayList<MatchPO> matchList;
		try {
			matchList = matchesService.getMatches(name);
		} catch (MatchNotFound e) {
			throw new PlayerNotFound("未找到该球员参加的比赛");
		}
		
		int games = matchList.size();
		int gameStarting = 0;
		
		for(int i=0; i<games; i++){
			Match match = new Match(matchList.get(i));
			
			if(match.isGameStarting(name)){
				gameStarting++;
			}
		}
		
		ArrayList<BasicPlayerStats> stats = new ArrayList<BasicPlayerStats>();
		for(int i=0; i<games; i++){
			Match match = new Match(matchList.get(i));
			
			Teams team;
			try {
				team = this.getTeam(name);
			} catch (TeamNotFound e) {
				throw new PlayerNotFound("未找到该球员所在队伍");
			}
			
			BasicPlayerStats basic = new BasicPlayerStats(match.getPlayerStats(name), games, gameStarting, team);
			stats.add(basic);
		}
		
		return stats;
	}

	@Override
	public ArrayList<String> getPlayers(String season, Teams team) throws PlayerNotFound {
		ArrayList<MatchPO> matches;
		try {
			matches = matchesService.getMatches(season, null, team, null);
		} catch (MatchNotFound e) {
			throw new PlayerNotFound("未找到该球队在此赛季参加的比赛");
		}
		
		ArrayList<String> names = new ArrayList<String>();
		for(int i=matches.size()-1; i>=0; i--){
			MatchPO match = matches.get(i);
			ArrayList<PlayerStatsPO> players = team == match.homeTeam() ? match.team1Players() : match.team2Players();
			for(PlayerStatsPO player: players){
				this.addName(names, player.name());
			}
		}
		
		return names;
	}
	
	private void addName(ArrayList<String> list, String name){
		for(String nm: list){
			if(nm.equals(name)){
				return;
			}
		}
		
		list.add(name);
	}

	@Override
	public MatchVO getMatchVO(String season, String date, Teams team1,
			Teams team2) throws MatchNotFound {
		MatchPO po = matchesService.getMatch(season, date, team1, team2);
		Match match = new Match(po);
		return match.getMatchVO();
	}

	@Override
	public ArrayList<MatchVO> getMatchesVO(String season, String date,
			Teams team1, Teams team2) throws MatchNotFound {
		ArrayList<MatchPO> poList = matchesService.getMatches(season, date, team1, team2);
		ArrayList<MatchVO> voList = new ArrayList<MatchVO>();
		
		for(int i=0; i<poList.size(); i++){
			Match match = new Match(poList.get(i));
			voList.add(match.getMatchVO());
		}
		
		return voList;
	}

	@Override
	public Teams getTeam(String player) throws TeamNotFound {
		return matchesService.getTeam(player);
	}

}
