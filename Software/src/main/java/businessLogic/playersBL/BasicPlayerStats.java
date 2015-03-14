package businessLogic.playersBL;

import enums.Position;

public class BasicPlayerStats {
	//球员的直接统计数据
	String name;
	Position position;                       //位置
	double minutes;                          //在场时间
	Double fieldGoalsMade;                   //投篮命中数
	Double fieldGoalsAttempted;              //投篮出手数
	Double threePointFieldGoalsMade;         //三分命中数
	Double threePointFieldGoalsAttempted;    //三分出手数
	Double freeThrowsMade;                   //罚球命中数
	Double freeThrowsAttempted;              //罚球出手数
	Double offensiveRebounds;                //进攻篮板数
	Double defensiveRebounds;                //防守篮板数
	Double rebounds;                         //总篮板数
	Double assists;                          //助攻数
	Double steals;                           //抢断数
	Double blocks;                           //盖帽数
	Double turnovers;                        //失误数
	Double personalFouls;                    //犯规数
	Double points;                           //个人得分

}
