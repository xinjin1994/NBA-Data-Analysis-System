package po;

import enums.Position;

public class PlayerStatsPO {
	//单场比赛球员的基本数据，一般包含在MatchPO中
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
	
	public PlayerStatsPO(String[] arr){
		//arr大小为18，依次为此类所有成员变量
		this.name = arr[0];
		this.position = Position.toEnum(arr[1]);
		this.minutes = Double.parseDouble(arr[2]);
		this.fieldGoalsMade = Integer.parseInt(arr[3]);
		this.fieldGoalsAttempted = Integer.parseInt(arr[4]);
		this.threePointFieldGoalsMade = Integer.parseInt(arr[5]);
		this.threePointFieldGoalsAttempted = Integer.parseInt(arr[6]);
		this.freeThrowsMade = Integer.parseInt(arr[7]);
		this.freeThrowsAttempted = Integer.parseInt(arr[8]);
		this.offensiveRebounds = Integer.parseInt(arr[9]);
		this.defensiveRebounds = Integer.parseInt(arr[10]);
		this.rebounds = Integer.parseInt(arr[11]);
		this.assists = Integer.parseInt(arr[12]);
		this.steals = Integer.parseInt(arr[13]);
		this.blocks = Integer.parseInt(arr[14]);
		this.turnovers = Integer.parseInt(arr[15]);
		this.personalFouls = Integer.parseInt(arr[16]);
		this.points = Integer.parseInt(arr[17]);
	}
}
