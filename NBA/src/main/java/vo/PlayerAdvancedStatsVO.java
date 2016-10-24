package vo;

import javax.swing.ImageIcon;

import enums.Teams;
import enums.Terminology;
import exceptions.TermNotFound;
import gui.util.GUIUtility;
import businessLogic.playersBL.AdvancedPlayerStats;

public class PlayerAdvancedStatsVO implements StatsVO{
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
	
	public PlayerAdvancedStatsVO(String name, Teams team, double eff, double gmsc, 
			double tsp, double fge, double rp, double orp, double drp, double ap, 
			double sp, double bp, double tp, double up){
		this.name = name;
		this.team = team;
		this.efficiency = eff;
		this.GmSc = gmsc;
		this.trueScorePercent = tsp;
		this.fieldGoalEfficiency = fge;
		this.reboundsPercent = rp;
		this.offensiveReboundsPercent = orp;
		this.defensiveReboundsPercent = drp;
		this.assistsPercent = ap;
		this.stealsPercent = sp;
		this.blocksPercent = bp;
		this.turnoversPercent = tp;
		this.usagePercent = up;
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
	
	public String getProperty(Terminology term) throws TermNotFound{
		switch(term){
		case PER:
			return GUIUtility.formatDouble(this.getEfficiency());
		case GMSC:
			return GUIUtility.formatDouble(this.getGmSc());
		case TSP:
			return GUIUtility.formatDouble(this.getTrueScorePercent());
		case FGE:
			return GUIUtility.formatDouble(this.getFieldGoalEfficiency());
		case REBP:
			return GUIUtility.formatDouble(this.getReboundsPercent());
		case OREBP:
			return GUIUtility.formatDouble(this.getOffensiveReboundsPercent());
		case DREBP:
			return GUIUtility.formatDouble(this.getDefensiveReboundsPercent());
		case ASTP:
			return GUIUtility.formatDouble(this.getAssistsPercent());
		case STLP:
			return GUIUtility.formatDouble(this.getStealsPercent());
		case BLKP:
			return GUIUtility.formatDouble(this.getBlocksPercent());
		case TOVP:
			return GUIUtility.formatDouble(this.getTurnoversPercent());
		case USGP:
			return GUIUtility.formatDouble(this.getUsagePercent());
		default:
			throw new TermNotFound(term);
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
