package businessLogic.matchesBL;

import helper.TypeTransform;

import java.util.ArrayList;

import enums.Teams;
import po.MatchPO;
import po.PlayerStatsPO;
import vo.MatchVO;


public class Match {
	//
	
	MatchPO match;
	
	public Match(MatchPO po){
		match = po;
	}
	
	public MatchVO getMatchVO(){
		return new MatchVO(match.homeTeam(), match.guestTeam(), match.date(), match.score(), 
				match.score1(), match.score2(), match.score3(), match.score4());
	}
	
	public ArrayList<PlayerStatsPO> getTeamStats(Teams team){
		if(match.homeTeam() == team){
			return match.team1Players();
		}else{
			return match.team2Players();
		}
	}
	
	public boolean isGameStarting(String name){
		ArrayList<String> startingPlayers = new ArrayList<String>();      //首发阵容
		for(int i=0; i<5; i++){
			startingPlayers.add(match.team1Players().get(i).name());
			startingPlayers.add(match.team2Players().get(i).name());
		}
		
		if(startingPlayers.contains(name)){
			return true;
		}else{
			return false;
		}
	}
	
	public PlayerStatsPO getPlayerStats(String name){
		ArrayList<PlayerStatsPO> team1 = match.team1Players();
		for(PlayerStatsPO player: team1){
			if(player.name().equals(name)){
				return player;
			}
		}
		
		ArrayList<PlayerStatsPO> team2 = match.team1Players();
		for(PlayerStatsPO player: team2){
			if(player.name().equals(name)){
				return player;
			}
		}
		
		return null;
	}
	
	private ArrayList<PlayerStatsPO> teamStats(String name){
		//队员是否在主队中
		for(PlayerStatsPO po: match.team1Players()){
			if(po.name().equals(name)){
				return match.team1Players();
			}
		}
		
		return match.team2Players();
	}
	
	private ArrayList<PlayerStatsPO> opponentTeamStats(String name){
		//队员是否在主队中
		for(PlayerStatsPO po: match.team1Players()){
			if(po.name().equals(name)){
				return match.team2Players();
			}
		}
		
		return match.team1Players();
	}
	
	public Double minutes_teammate(String name) {
		ArrayList<PlayerStatsPO> teamStats = this.teamStats(name);
		Double minutes = 0.0;
		for(PlayerStatsPO player: teamStats){
			minutes += TypeTransform.str_to_minutes(player.minutes());
		}
		
		return minutes;
	}

	public Integer offensiveRebounds_teammate(String name) {
		ArrayList<PlayerStatsPO> teamStats = this.teamStats(name);
		Integer rebounds = 0;
		for(PlayerStatsPO player: teamStats){
			rebounds += player.offensiveRebounds();
		}
		
		return rebounds;
	}

	public Integer defensiveRebounds_teammate(String name) {
		ArrayList<PlayerStatsPO> teamStats = this.teamStats(name);
		Integer rebounds = 0;
		for(PlayerStatsPO player: teamStats){
			rebounds += player.defensiveRebounds();
		}
		
		return rebounds;
	}

	public Integer offensiveRebounds_opponent(String name) {
		ArrayList<PlayerStatsPO> teamStats = this.opponentTeamStats(name);
		Integer rebounds = 0;
		for(PlayerStatsPO player: teamStats){
			rebounds += player.offensiveRebounds();
		}
		
		return rebounds;
	}

	public Integer defensiveRebounds_opponent(String name) {
		ArrayList<PlayerStatsPO> teamStats = this.opponentTeamStats(name);
		Integer rebounds = 0;
		for(PlayerStatsPO player: teamStats){
			rebounds += player.defensiveRebounds();
		}
		
		return rebounds;
	}

	public Integer fieldGoalsMade_teammate(String name) {
		ArrayList<PlayerStatsPO> teamStats = this.teamStats(name);
		Integer fieldGoalsMade = 0;
		for(PlayerStatsPO player: teamStats){
			fieldGoalsMade += player.fieldGoalsMade();
		}
		
		return fieldGoalsMade;
	}

	public Integer fieldGoalsAttempted_teammate(String name) {
		ArrayList<PlayerStatsPO> teamStats = this.teamStats(name);
		Integer fieldGoalsAttempted = 0;
		for(PlayerStatsPO player: teamStats){
			fieldGoalsAttempted += player.fieldGoalsAttempted();
		}
		
		return fieldGoalsAttempted;
	}

	public Integer fieldGoalsAttempted_opponent(String name) {
		ArrayList<PlayerStatsPO> teamStats = this.opponentTeamStats(name);
		Integer fieldGoalsAttempted = 0;
		for(PlayerStatsPO player: teamStats){
			fieldGoalsAttempted += player.fieldGoalsAttempted();
		}
		
		return fieldGoalsAttempted;
	}
	
	public Integer freeThrowsAttempted_teammate(String name){
		ArrayList<PlayerStatsPO> teamStats = this.teamStats(name);
		Integer freeThrows = 0;
		for(PlayerStatsPO player: teamStats){
			freeThrows += player.freeThrowsAttempted();
		}
		
		return freeThrows;
	}
	
	public Integer turnovers_teammate(String name){
		ArrayList<PlayerStatsPO> teamStats = this.teamStats(name);
		Integer turnovers = 0;
		for(PlayerStatsPO player: teamStats){
			turnovers += player.turnovers();
		}
		
		return turnovers;
	}

	public Double offensiveRounds_opponent(String name) {
		ArrayList<PlayerStatsPO> teamStats = this.opponentTeamStats(name);
		Integer fieldGoalsMade = 0;
		Integer fieldGoalsAttempted = 0;
		Integer freeThrows = 0;
		Integer offensiveRebounds = 0;
		Integer turnovers = 0;
		
		for(PlayerStatsPO player: teamStats){
			fieldGoalsMade += player.fieldGoalsMade();
			fieldGoalsAttempted += player.fieldGoalsAttempted();
			freeThrows += player.freeThrowsMade();
			turnovers += player.turnovers();
		}
		
		Double rounds = fieldGoalsMade + 0.4*freeThrows - 1.07*(offensiveRebounds + 
				this.defensiveRebounds_opponent(name)*(fieldGoalsAttempted - fieldGoalsMade))
				+ 1.07*turnovers;
		
		return rounds;
	}
	
	private ArrayList<PlayerStatsPO> opponentTeamStats(Teams team){
		if(team == match.homeTeam()){
			return match.team2Players();
		}else{
			return match.team1Players();
		}
	}
	
	public Integer offensiveRebounds_opponent(Teams team){
		ArrayList<PlayerStatsPO> teamStats = this.opponentTeamStats(team);
		Integer rebounds = 0;
		for(PlayerStatsPO player: teamStats){
			rebounds += player.offensiveRebounds();
		}
		
		return rebounds;
	}
	
	public Integer defensiveRebounds_opponent(Teams team){
		ArrayList<PlayerStatsPO> teamStats = this.opponentTeamStats(team);
		Integer rebounds = 0;
		for(PlayerStatsPO player: teamStats){
			rebounds += player.defensiveRebounds();
		}
		
		return rebounds;
	}
	
	public Integer fieldGoalsMade_opponent(Teams team) {
		ArrayList<PlayerStatsPO> teamStats = this.opponentTeamStats(team);
		Integer fieldGoalsMade = 0;
		for(PlayerStatsPO player: teamStats){
			fieldGoalsMade += player.fieldGoalsMade();
		}
		
		return fieldGoalsMade;
	}

	public Integer freeThrowsMade_opponent(Teams team) {
		ArrayList<PlayerStatsPO> teamStats = this.opponentTeamStats(team);
		Integer freeThrowsMade = 0;
		for(PlayerStatsPO player: teamStats){
			freeThrowsMade += player.freeThrowsMade();
		}
		
		return freeThrowsMade;
	}

	public Integer fumbles_opponent(Teams team) {
		ArrayList<PlayerStatsPO> teamStats = this.opponentTeamStats(team);
		Integer fumbles = 0;
		for(PlayerStatsPO player: teamStats){
			fumbles += player.fieldGoalsAttempted() - player.fieldGoalsMade();
		}
		
		return fumbles;
	}

	public Integer turnovers_opponent(Teams team) {
		ArrayList<PlayerStatsPO> teamStats = this.opponentTeamStats(team);
		Integer turnovers = 0;
		for(PlayerStatsPO player: teamStats){
			turnovers += player.turnovers();
		}
		
		return turnovers;
	}
}
