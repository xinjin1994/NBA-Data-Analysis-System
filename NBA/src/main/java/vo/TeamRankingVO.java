package vo;

import enums.Conference;
import enums.Teams;

public class TeamRankingVO {
	Teams team;
	Conference conference;
	int games;
	int wins;
	int loses;
	int ranking;
	
	public TeamRankingVO(Teams team, Conference conference, int games, int wins){
		this.team = team;
		this.conference = conference;
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
	
	public Conference getConference() {
		return conference;
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
