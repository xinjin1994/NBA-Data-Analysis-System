package vo;

import javax.swing.ImageIcon;

import enums.Teams;
import enums.Terminology;
import gui.util.GUIUtility;
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
	ImageIcon portrait;                             //头像
	
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
	
	public void addPortrait(ImageIcon image){
		this.portrait = image;
	}
	
	public ImageIcon getPortrait(){
		return portrait;
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
		return trueScorePercent*100;
	}

	public double getFieldGoalEfficiency() {
		return fieldGoalEfficiency*100;
	}

	public double getReboundsPercent() {
		return reboundsPercent*100;
	}

	public double getOffensiveReboundsPercent() {
		return offensiveReboundsPercent*100;
	}

	public double getDefensiveReboundsPercent() {
		return defensiveReboundsPercent*100;
	}

	public double getAssistsPercent() {
		return assistsPercent*100;
	}

	public double getStealsPercent() {
		return stealsPercent*100;
	}

	public double getBlocksPercent() {
		return blocksPercent*100;
	}

	public double getTurnoversPercent() {
		return turnoversPercent*100;
	}

	public double getUsagePercent() {
		return usagePercent*100;
	}
	
	public String getProperty(Terminology term){
		switch(term){
		case PER:
			return GUIUtility.formatDouble(this.efficiency);
		case GMSC:
			return GUIUtility.formatDouble(this.GmSc);
		case TSP:
			return GUIUtility.formatDouble(this.trueScorePercent);
		case FGE:
			return GUIUtility.formatDouble(this.fieldGoalEfficiency);
		case REBP:
			return GUIUtility.formatDouble(this.reboundsPercent);
		case OREBP:
			return GUIUtility.formatDouble(this.offensiveReboundsPercent);
		case DREBP:
			return GUIUtility.formatDouble(this.defensiveReboundsPercent);
		case ASTP:
			return GUIUtility.formatDouble(this.assistsPercent);
		case STLP:
			return GUIUtility.formatDouble(this.stealsPercent);
		case BLKP:
			return GUIUtility.formatDouble(this.blocksPercent);
		case TOVP:
			return GUIUtility.formatDouble(this.turnoversPercent);
		case USGP:
			return GUIUtility.formatDouble(this.usagePercent);
		default:
			return null;
		}
	}
	
	public void print(){
		System.out.println(this.name + "\n" +
		this.team + "\n" +
		this.efficiency + "\n" +
		this.GmSc + "\n" +
		this.trueScorePercent + "\n" +
		this.fieldGoalEfficiency + "\n" +
		this.reboundsPercent + "\n" +
		this.offensiveReboundsPercent + "\n" +
		this.defensiveReboundsPercent + "\n" +
		this.assistsPercent + "\n" +
		this.stealsPercent + "\n" +
		this.blocksPercent + "\n" +
		this.turnoversPercent + "\n" +
		this.usagePercent);
	}
	
}
