package vo;

import enums.Teams;

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
	
}
