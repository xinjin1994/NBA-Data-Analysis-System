package vo;

import enums.Teams;

public class TeamRankingVO {
	Teams team;
	int games;
	int wins;
	int loses;
	int ranking;
	
	public TeamRankingVO(Teams team, int games, int wins){
		this.team = team;
		this.games = games;
		this.wins = wins;
		this.loses = games - loses;
		this.ranking = 0;
	}
	
	public void setRanking(int r){
		this.ranking = r;
	}

	public Teams getTeam() {
		return team;
	}

	public int getGames() {
		return games;
	}

	public int getWins() {
		return wins;
	}

	public int getLoses() {
		return loses;
	}

	public int getRanking() {
		return ranking;
	}
	
}
