package businessLogic.teamsBL;

import java.util.ArrayList;
import po.PlayerStatsPO;

public class BasicTeamStats {
	//
	String name;
	Integer games;                           //参赛场数
	Integer wins;                            //获胜场数
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
	Double fouls;                    //犯规数
	Double points;                           //得分
	
	public BasicTeamStats(int games, int wins, ArrayList<PlayerStatsPO> players){
		
	}
}
