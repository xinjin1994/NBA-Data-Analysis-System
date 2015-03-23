package vo;

import enums.Teams;

public class TeamDefensiveFoulsVO {
	//
	Teams team;
	int games;
	double offensiveRebounds;                //进攻篮板
	double defensiveRebounds;                //防守篮板
	double rebounds;                         //总篮板
	double steals;                           //抢断
	double blocks;                           //盖帽
	double turnovers;                        //失误
	double fouls;                            //犯规
	
	public TeamDefensiveFoulsVO(Teams team, int games, double offRebd, double defRebd, 
			double rebd, double stl, double blk, double tov, double fouls){
		this.team = team;
		this.games = games;
		this.offensiveRebounds = offRebd;
		this.defensiveRebounds = defRebd;
		this.rebounds = rebd;
		this.steals = stl;
		this.blocks = blk;
		this.turnovers = tov;
		this.fouls = fouls;
	}
	
	public void average(){
		this.offensiveRebounds /= games;
		this.defensiveRebounds /= games;
		this.rebounds /= games;
		this.steals /= games;
		this.blocks /= games;
		this.turnovers /= games;
		this.fouls /= games;
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
