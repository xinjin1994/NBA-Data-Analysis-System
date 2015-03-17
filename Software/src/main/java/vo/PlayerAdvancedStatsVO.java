package vo;

import enums.Teams;
import businessLogic.playersBL.AdvancedPlayerStats;

public class PlayerAdvancedStatsVO {
	//
	String name;                                    //姓名
	Teams team;                                     //所属球队
	double efficiency;                              //效率
	double GmSc;                                    //game score
	double trueScorePercent;                        //真实投篮效率
	double fieldGoalEfficiency;                     //投篮效率
	double reboundsPercent;                         //篮板率
	double offensiveReboundsPercent;                //进攻篮板率
	double defensiveReboundsPercent;                //防守篮板率
	double assistsPercent;                          //助攻率
	double stealsPercent;                           //抢断率
	double blocksPercent;                           //盖帽率
	double turnoversPercent;                        //失误率
	double usagePercent;                            //使用率
	
	public PlayerAdvancedStatsVO(AdvancedPlayerStats stats){
		this.name = stats.name();
		this.team = stats.team();
		this.efficiency = stats.playerEfficiencyRating();
		this.GmSc = stats.Gmsc();
		this.trueScorePercent = stats.trueScorePercent();
		this.fieldGoalEfficiency = stats.fieldGoalsPercent();
		this.reboundsPercent = stats.reboundsPercent();
		this.offensiveReboundsPercent = stats.offensiveReboundsPercent();
		this.defensiveReboundsPercent = stats.defensiveReboundsPercent();
		this.assistsPercent = stats.assistsPercent();
		this.stealsPercent = stats.stealsPercent();
		this.blocksPercent = stats.blockPercent();
		this.turnoversPercent = stats.turnoversPercent();
		this.usagePercent = stats.usagePercent();
	}

	public String getName() {
		return name;
	}

	public Teams getTeam() {
		return team;
	}

	public double getEfficiency() {
		return efficiency;
	}

	public double getGmSc() {
		return GmSc;
	}

	public double getTrueScorePercent() {
		return trueScorePercent;
	}

	public double getFieldGoalEfficiency() {
		return fieldGoalEfficiency;
	}

	public double getReboundsPercent() {
		return reboundsPercent;
	}

	public double getOffensiveReboundsPercent() {
		return offensiveReboundsPercent;
	}

	public double getDefensiveReboundsPercent() {
		return defensiveReboundsPercent;
	}

	public double getAssistsPercent() {
		return assistsPercent;
	}

	public double getStealsPercent() {
		return stealsPercent;
	}

	public double getBlocksPercent() {
		return blocksPercent;
	}

	public double getTurnoversPercent() {
		return turnoversPercent;
	}

	public double getUsagePercent() {
		return usagePercent;
	}
	
	
}
