package vo;

import enums.Teams;

public class TeamDefensiveStatsVO {
	//
	Teams team;
	int games;
	double offensiveRebounds;                //进攻篮板
	double defensiveRebounds;                //防守篮板
	double rebounds;                         //总篮板
	double steals;                           //抢断
	double blocks;                           //盖帽
	
	public TeamDefensiveStatsVO(Teams team, int games, double offRebd, double defRebd, 
			double rebd, double stl, double blk){
		this.team = team;
		this.games = games;
		this.offensiveRebounds = offRebd;
		this.defensiveRebounds = defRebd;
		this.rebounds = rebd;
		this.steals = stl;
		this.blocks = blk;
	}
	
	public void average(){
		this.offensiveRebounds /= games;
		this.defensiveRebounds /= games;
		this.rebounds /= games;
		this.steals /= games;
		this.blocks /= games;
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
	
	
	public void print(){
		System.out.println(this.team + "\n" +
		this.games + "\n" +
		this.offensiveRebounds + "\n" +
		this.defensiveRebounds + "\n" +
		this.rebounds + "\n" +
		this.steals + "\n" +
		this.blocks);
	}
	
}
