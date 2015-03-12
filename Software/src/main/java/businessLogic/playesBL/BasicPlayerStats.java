package businessLogic.playesBL;

import enums.Position;

public class BasicPlayerStats {
	//球员的直接统计数据
	String name;
	Position position;                       //位置
	double minutes;                          //在场时间
	Integer fieldGoalsMade;                  //投篮命中数
	Integer fieldGoalsAttempted;             //投篮出手数
	Integer threePointFieldGoalsMade;        //三分命中数
	Integer threePointFieldGoalsAttempted;   //三分出手数
	Integer freeThrowsMade;                  //罚球命中数
	Integer freeThrowsAttempted;             //罚球出手数
	Integer offensiveRebounds;               //进攻篮板数
	Integer defensiveRebounds;               //防守篮板数
	Integer rebounds;                        //总篮板数
	Integer assists;                         //助攻数
	Integer steals;                          //抢断数
	Integer blocks;                          //盖帽数
	Integer turnovers;                       //失误数
	Integer personalFouls;                   //犯规数
	Integer points;                          //个人得分

}
