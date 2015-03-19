package vo;

import javax.swing.ImageIcon;

import helper.TypeTransform;
import businessLogic.playersBL.BasicPlayerStats;
import enums.Teams;

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
	
	
	public PlayerBasicStatsVO(String name, Teams team, double games, double gamesStarting, 
			String minutes, double rebounds, double assists, double fieldGoalsPercentage, 
			double threePointFieldGoalsPercentage, double freeThrowPercentage, 
			double offensiveRebounds, double defensiveRebounds, double steals, 
			double blocks, double turnovers, double personalFouls, double points){
		this.name = name;
		this.team = team;
		this.games = games;
		this.gamesStarting = gamesStarting;
		this.minutes = minutes;
		this.rebounds = rebounds;
		this.assists = assists;
		this.fieldGoalPercentage = fieldGoalsPercentage;
		this.threePointFieldGoalPercentage = threePointFieldGoalsPercentage;
		this.freeThrowPercentage = freeThrowPercentage;
		this.offensiveRebounds = offensiveRebounds;
		this.defensiveRebounds = defensiveRebounds;
		this.steals = steals;
		this.blocks = blocks;
		this.turnovers = turnovers;
		this.personalFouls = personalFouls;
		this.points = points;
	}
	
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
	
	
	
}
