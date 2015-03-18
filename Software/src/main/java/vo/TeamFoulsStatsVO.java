package vo;

import enums.Teams;

public class TeamFoulsStatsVO {
	//
	Teams team;
	int games;
	double turnovers;                   //失误
	double fouls;                       //犯规
	
	public TeamFoulsStatsVO(Teams team, int games, double tov, double fouls){
		this.team = team;
		this.games = games;
		this.turnovers = tov;
		this.fouls = fouls;
	}
	
	public void average(){
		this.turnovers /= games;
		this.fouls /= games;
	}

	public Teams getTeam() {
		return team;
	}

	public int getGames() {
		return games;
	}

	public double getTurnovers() {
		return turnovers;
	}

	public double getFouls() {
		return fouls;
	}
	
}
