package businessLogic.matchesBL;

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
	
	public boolean inTeam1(String name){
		//队员是否在主队中
		for(PlayerStatsPO po: match.team1Players()){
			if(po.name().equals(name)){
				return true;
			}
		}
		
		return false;
	}
	
	public Integer minutes_teammate(String name) {
		return null;
	}

	public Integer offensiveRebounds_teammate(String name) {
		return null;
	}

	public Integer defensiveRebounds_teammate(String name) {
		return null;
	}

	public Integer offensiveRebounds_opponent(String name) {
		return null;
	}

	public Integer defensiveRebounds_opponent(String name) {
		return null;
	}

	public Integer fieldGoalsMade_teammate(String name) {
		return null;
	}

	public Integer fieldGoalsAttempted_teammate(String name) {
		return null;
	}

	public Integer fieldGoalsAttempted_opponent(String name) {
		return null;
	}

	public Integer offensiveRounds_opponent(String name) {
		return null;
	}
	
	public Integer offensiveRebounds_opponent(Teams team){
		return null;
	}
	
	public Integer defensiveRebounds_opponent(Teams team){
		return null;
	}
}
