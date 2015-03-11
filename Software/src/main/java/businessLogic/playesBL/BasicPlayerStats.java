package businessLogic.playesBL;

import enums.Position;

public class BasicPlayerStats {
	//球员的直接统计数据
	String name;
	Position position;                   //位置
	double minutes;                      //在场时间
	int fieldGoalsMade;                  //投篮命中数
	int fieldGoalsAttempted;             //投篮出手数
	int threePointFieldGoalsMade;        //三分命中数
	int threePointFieldGoalsAttempted;   //三分出手数
	int freeThrowsMade;                  //罚球命中数
	int freeThrowsAttempted;             //罚球出手数
	int offensiveRebounds;               //进攻篮板数
	int defensiveRebounds;               //防守篮板数
	int rebounds;                        //总篮板数
	int assists;                         //助攻数
	int steals;                          //抢断数
	int blocks;                          //盖帽数
	int turnovers;                       //失误数
	int personalFouls;                   //犯规数
	int points;                          //个人得分

}
