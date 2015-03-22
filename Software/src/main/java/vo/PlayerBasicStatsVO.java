package vo;

import javax.swing.ImageIcon;

import gui.util.GUIUtility;
import helper.TypeTransform;
import businessLogic.playersBL.BasicPlayerStats;
import enums.Teams;
import enums.Terminology;

public class PlayerBasicStatsVO {
	//
	String name;                                     //姓名
	Teams team;                                      //所属球队
	double games;                                    //参赛场数
	double gamesStarting;                            //先发场数
	String minutes;                                  //在场时间
	double rebounds;                                 //篮板数
	double assists;                                  //助攻数
	double fieldGoalPercentage;                      //命中率
	double threePointFieldGoalPercentage;            //三分命中率
	double freeThrowPercentage;                      //罚球命中率
	double offensiveRebounds;                        //进攻（篮板）数
	double defensiveRebounds;                        //防守(篮板)数
	double steals;                                   //抢断数
	double blocks;                                   //盖帽数
	double turnovers;                                //失误数
	double personalFouls;                              //犯规数
	double points;                                   //个人得分
	ImageIcon portrait;                             //头像
	
	public PlayerBasicStatsVO(BasicPlayerStats stats){
		this.name = stats.name();
		this.team = stats.team();
		this.games = stats.games();
		this.gamesStarting = stats.gamesStarting();
		this.minutes = TypeTransform.minutes_to_str(stats.minutes());
		this.rebounds = stats.rebounds();
		this.assists = stats.assists();
		this.fieldGoalPercentage = stats.fieldGoalsMade()/stats.fieldGoalsAttempted();
		this.threePointFieldGoalPercentage = stats.threePointFieldGoalsMade()/stats.threePointFieldGoalsAttempted();
		this.freeThrowPercentage = stats.freeThrowsMade()/stats.freeThrowsAttempted();
		this.offensiveRebounds = stats.offensiveRebounds();
		this.defensiveRebounds = stats.defensiveRebounds();
		this.steals = stats.steals();
		this.blocks = stats.blocks();
		this.turnovers = stats.turnovers();
		this.personalFouls = stats.personalFouls();
		this.points = stats.points();
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

	public double getGames() {
		return games;
	}

	public double getGamesStarting() {
		return gamesStarting;
	}

	public double getRebounds() {
		return rebounds;
	}

	public double getAssists() {
		return assists;
	}

	public String getMinutes() {
		return minutes;
	}

	public double getFieldGoalPercentage() {
		return fieldGoalPercentage*100;
	}

	public double getThreePointFieldGoalPercentage() {
		return threePointFieldGoalPercentage*100;
	}

	public double getFreeThrowPercentage() {
		return freeThrowPercentage*100;
	}

	public double getOffensiveRebounds() {
		return offensiveRebounds;
	}

	public double getDefensiveRebounds() {
		return defensiveRebounds;
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

	public double getPersonalFouls() {
		return personalFouls;
	}

	public double getPoints() {
		return points;
	}
	
	public String getProperty(Terminology term){
		switch(term){
		case ATTENDED:
			return GUIUtility.formatDouble(this.games);
		case PREMIERE:
			return GUIUtility.formatDouble(this.gamesStarting);
		case REB:
			return GUIUtility.formatDouble(this.rebounds);
		case AST:
			return GUIUtility.formatDouble(this.assists);
		case MIN:
			return minutes;
		case FGP:
			return GUIUtility.formatDouble(this.fieldGoalPercentage);
		case TPP:
			return GUIUtility.formatDouble(this.threePointFieldGoalPercentage);
		case FTM:
			return GUIUtility.formatDouble(this.freeThrowPercentage);
		case OFR:
			return GUIUtility.formatDouble(this.offensiveRebounds);
		case DFR:
			return GUIUtility.formatDouble(this.defensiveRebounds);
		case TOV:
			return GUIUtility.formatDouble(this.turnovers);
		case STL:
			return GUIUtility.formatDouble(this.steals);
		case BLK:
			return GUIUtility.formatDouble(this.blocks);
		case PF:
			return GUIUtility.formatDouble(this.personalFouls);
		case PTS:
			return GUIUtility.formatDouble(this.points);
		default:
			return null;
		}
	}
	
	public void print(){
		System.out.println(this.name + "\n" + 
		this.team + "\n" + 
		this.games + "\n" + 
		this.gamesStarting + "\n" + 
		this.minutes + "\n" + 
		this.rebounds + "\n" + 
		this.assists + "\n" + 
		this.fieldGoalPercentage + "\n" + 
		this.threePointFieldGoalPercentage + "\n" + 
		this.freeThrowPercentage + "\n" + 
		this.offensiveRebounds + "\n" + 
		this.defensiveRebounds + "\n" + 
		this.steals + "\n" + 
		this.blocks + "\n" + 
		this.turnovers + "\n" + 
		this.personalFouls + "\n" + 
		this.points);
	}
	
}
