package po;

import enums.Position;
import exceptions.ErrorData;
import helper.ReaderHelper;
import helper.TypeTransform;

public class PlayerStatsPO {
	//单场比赛球员的基本数据，一般包含在MatchPO中
	String name;
	boolean isGameStarting = false;          //是否先发
	Position position;                       //位置
	String minutes;                          //在场时间
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
	
	public PlayerStatsPO(String[] arr) throws ErrorData{
		//arr大小为18，依次为此类所有成员变量
		
		ReaderHelper helper = new ReaderHelper();
		
		this.name = arr[0];
		this.position = Position.toEnum(arr[1]);
		this.minutes = arr[2].equals("None") ? "0" : arr[2];
		this.fieldGoalsMade = helper.str_to_int(arr[3]);
		this.fieldGoalsAttempted = helper.str_to_int(arr[4]);
		this.threePointFieldGoalsMade = helper.str_to_int(arr[5]);
		this.threePointFieldGoalsAttempted = helper.str_to_int(arr[6]);
		this.freeThrowsMade = helper.str_to_int(arr[7]);
		this.freeThrowsAttempted = helper.str_to_int(arr[8]);
		this.offensiveRebounds = helper.str_to_int(arr[9]);
		this.defensiveRebounds = helper.str_to_int(arr[10]);
		this.rebounds = helper.str_to_int(arr[11]);
		this.assists = helper.str_to_int(arr[12]);
		this.steals = helper.str_to_int(arr[13]);
		this.blocks = helper.str_to_int(arr[14]);
		this.turnovers = helper.str_to_int(arr[15]);
		this.personalFouls = helper.str_to_int(arr[16]);
		this.points = helper.str_to_int(arr[17]);
		
		if(points == null){                          //points可能为null
			points = this.fieldGoalsMade*2 + this.threePointFieldGoalsMade*3
					 + this.freeThrowsMade;
		}
		
		if(TypeTransform.str_to_minutes(minutes) < 0.001 ||
				this.fieldGoalsMade > this.fieldGoalsAttempted ||
				this.threePointFieldGoalsMade > this.threePointFieldGoalsAttempted ||
				this.freeThrowsMade > this.freeThrowsAttempted){
			throw new ErrorData();
		}

	}
	
	public void setGameStarting(boolean bool){
		isGameStarting = bool;
	}
	
	public String name(){
		return name;
	}
	
	public boolean isGameStarting(){
		return isGameStarting;
	}
	
	public Position position(){
		return position;
	}
	
	public String minutes(){
		return minutes;
	}
	
	public Integer fieldGoalsMade(){
		return fieldGoalsMade;
	}
	
	public Integer fieldGoalsAttempted(){
		return fieldGoalsAttempted;
	}
	
	public Integer threePointFieldGoalsAttempted(){
		return threePointFieldGoalsAttempted;
	}
	
	public Integer threePointFieldGoalsMade(){
		return threePointFieldGoalsMade;
	}
	
	public Integer freeThrowsMade(){
		return freeThrowsMade;
	}
	
	public Integer freeThrowsAttempted(){
		return freeThrowsAttempted;
	}
	
	public Integer offensiveRebounds(){
		return offensiveRebounds;
	}
	
	public Integer defensiveRebounds(){
		return defensiveRebounds;
	}
	
	public Integer rebounds(){
		return rebounds;
	}
	
	public Integer assists(){
		return assists;
	}
	
	public Integer steals(){
		return steals;
	}
	
	public Integer blocks(){
		return blocks;
	}
	
	public Integer turnovers(){
		return turnovers;
	}
	
	public Integer personalFouls(){
		return personalFouls;
	}
	
	public Integer points(){
		return points;
	}
	
	public void print(){
		System.out.println(this.name + ';' +
				           this.isGameStarting + ";" +
				           this.position + ';' +
				           this.minutes + ';' +
				           this.fieldGoalsMade + ';' +
				           this.fieldGoalsAttempted + ';' +
				           this.threePointFieldGoalsMade + ';' +
				           this.threePointFieldGoalsAttempted + ';' +
				           this.freeThrowsMade + ';' +
				           this.freeThrowsAttempted + ';' +
				           this.offensiveRebounds + ';' +
				           this.defensiveRebounds + ';' +
				           this.rebounds + ';' +
				           this.assists + ';' +
				           this.steals + ';' +
				           this.blocks + ';' +
				           this.turnovers + ';' +
				           this.personalFouls + ';' +
				           this.points);
	}
}
