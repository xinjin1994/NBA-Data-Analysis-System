package businessLogic.matchesBL;

import java.util.ArrayList;

import po.MatchPO;
import po.PlayerStatsPO;
import dataService.matchesDataService.MatchesDataService;
import vo.MatchVO;
import enums.Teams;
import exceptions.MatchNotFound;
import exceptions.TeamNotFound;
import factory.ObjectCreater;
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
		matchesService = new ObjectCreater().matchesDataService();
	}
	
	@Override
	public ArrayList<TeamStatsForCalculation> getTeamDataForCalculation(Teams team) 
			throws TeamNotFound, MatchNotFound {
		ArrayList<MatchPO> matchList = matchesService.getMatches(null, null, team, null);
		
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
			BasicTeamStats basic = new BasicTeamStats(games, wins, match.getTeamStats(team));
			TeamStatsForCalculation s = new TeamStatsForCalculation(basic, match.offensiveRebounds_opponent(team), 
					match.defensiveRebounds_opponent(team), match.fieldGoalsMade_opponent(team), 
					match.freeThrowsMade_opponent(team), match.fumbles_opponent(team), 
					match.turnovers_opponent(team));
			stats.add(s);
		}
		
		if(stats.size() != 0){
			return stats;
		}else{
			throw new MatchNotFound("");
		}
	}

	@Override
	public ArrayList<BasicTeamStats> getBasicTeamStats(Teams team) throws MatchNotFound {
		ArrayList<MatchPO> matchList = matchesService.getMatches(null, null, team, null);
		
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
			stats.add(new BasicTeamStats(games, wins, match.getTeamStats(team)));
		}
		
		if(stats.size() != 0){
			return stats;
		}else{
			throw new MatchNotFound("");
		}
	}

	@Override
	public ArrayList<PlayerStatsForCalculation> getPlayerDataForCalculation(
			String name) throws MatchNotFound {
		ArrayList<MatchPO> matchList = matchesService.getMatches(name);
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
			BasicPlayerStats basic = new BasicPlayerStats(match.getPlayerStats(name), games, gameStarting);
			PlayerStatsForCalculation s = new PlayerStatsForCalculation(basic, match.minutes_teammate(name),
					match.offensiveRebounds_teammate(name), match.defensiveRebounds_teammate(name), 
					match.offensiveRebounds_opponent(name), match.defensiveRebounds_opponent(name), 
					match.fieldGoalsMade_teammate(name), match.fieldGoalsAttempted_teammate(name), 
					match.fieldGoalsAttempted_opponent(name), match.freeThrowsAttempted_teammate(name), 
					match.turnovers_teammate(name), match.offensiveRounds_opponent(name));
			stats.add(s);
		}
		
		if(stats.size() != 0){
			return stats;
		}else{
			throw new MatchNotFound("");
		}
	}

	@Override
	public ArrayList<BasicPlayerStats> getBasicPlayerStats(String name) throws MatchNotFound {
		ArrayList<MatchPO> matchList = matchesService.getMatches(name);
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
			BasicPlayerStats basic = new BasicPlayerStats(match.getPlayerStats(name), games, gameStarting);
			stats.add(basic);
		}
		
		if(stats.size() != 0){
			return stats;
		}else{
			throw new MatchNotFound("");
		}
	}

	@Override
	public ArrayList<String> getPlayers(String season, Teams team) throws MatchNotFound {
		ArrayList<MatchPO> matches = matchesService.getMatches(season, null, team, null);
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
