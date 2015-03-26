package po;

import enums.Teams;

public class TeamDefensiveFoulsStatsPO {
	Teams team;
	int games;
	double offensiveRebounds;                //进攻篮板
	double defensiveRebounds;                //防守篮板
	double rebounds;                         //总篮板
	double steals;                           //抢断
	double blocks;                           //盖帽
	double turnovers;                        //失误
	double fouls;                            //犯规
	
	public TeamDefensiveFoulsStatsPO(Teams team, int games, double or, double dr, double rebd, 
			double stl, double blk, double tov, double fouls) {
		this.team = team;
		this.games = games;
		this.offensiveRebounds = or;
		this.defensiveRebounds = dr;
		this.rebounds = rebd;
		this.steals = stl;
		this.blocks = blk;
		this.turnovers = tov;
		this.fouls = fouls;
	}

	public Teams getTeam() {
		return team;
	}

	public int getGames() {
		return games;
	}

	public double getOffensiveRebounds() {
		return offensiveRebounds;
	}

	public double getDefensiveRebounds() {
		return defensiveRebounds;
	}

	public double getRebounds() {
		return rebounds;
	}

	public double getSteals() {
		return steals;
	}

	public double getBlocks() {
		return blocks;
	}

	public double getTurnovers() {
		return turnovers;
	}

	public double getFouls() {
		return fouls;
	}
	
	
}
