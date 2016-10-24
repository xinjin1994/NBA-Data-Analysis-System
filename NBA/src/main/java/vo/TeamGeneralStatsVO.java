package vo;

import enums.Teams;

public class TeamGeneralStatsVO {
	Teams team;
	int games;                                    //参赛场数
	double offensiveRounds;                       //进攻回合
	double offensiveEfficiency;                   //进攻效率
	double defensiveEfficiency;                   //防守效率
	double offensiveReboundsEfficiency;           //进攻篮板效率
	double defensiveReboundsEfficiency;           //防守篮板效率
	double stealsEfficiency;                      //抢断效率
	double assistsEfficiency;                     //助攻（效）率
	
	public TeamGeneralStatsVO(Teams team, int games, double offRounds, double off, 
			double def, double offRebd, double defRebd, double stl, double ast){
		this.team = team;
		this.games = games;
		this.offensiveRounds = offRounds;
		this.offensiveEfficiency = off;
		this.defensiveEfficiency = def;
		this.offensiveReboundsEfficiency = offRebd;
		this.defensiveReboundsEfficiency = defRebd;
		this.stealsEfficiency = stl;
		this.assistsEfficiency = ast;
	}

	public Teams getTeam() {
		return team;
	}

	public int getGames() {
		return games;
	}

	public double getOffensiveRounds() {
		return offensiveRounds;
	}

	public double getOffensiveEfficiency() {
		return offensiveEfficiency;
	}

	public double getDefensiveEfficiency() {
		return defensiveEfficiency;
	}

	public double getOffensiveReboundsEfficiency() {
		return offensiveReboundsEfficiency*100;
	}
	
	public double getDefensiveReboundsEfficiency() {
		return defensiveReboundsEfficiency*100;
	}

	public double getStealsEfficiency() {
		return stealsEfficiency;
	}
	
	public double getAssistsEfficiency(){
		return assistsEfficiency;
	}
	
	public void print(){
		System.out.println(this.team + "\n" +
				this.games + "\n" +
				this.offensiveRounds + "\n" +
				this.offensiveEfficiency + "\n" +
				this.defensiveEfficiency + "\n" +
				this.offensiveReboundsEfficiency + "\n" +
				this.defensiveReboundsEfficiency + "\n" +
				this.stealsEfficiency + "\n" +
				this.assistsEfficiency);
	}
	
}
