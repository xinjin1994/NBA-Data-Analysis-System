package po;

import java.util.ArrayList;

import enums.Teams;
import exceptions.ErrorData;
import exceptions.TeamNotFound;
import po.PlayerStatsPO;
import sorter.data.DataSortByDate;

public class MatchPO implements DataSortByDate {
	String season;                          //赛季
	String date;                            //日期
	Teams homeTeam;                         //主队
	Teams guestTeam;                        //客队
	String score;                           //总比分
	String score1;                          //第一节比分
	String score2;                          //第二节比分
	String score3;                          //第三节比分
	String score4;                          //第四节比分
	String scoreExtra;                      //加时赛比分
	ArrayList<PlayerStatsPO> team1Players;  //主队球员数据
	ArrayList<PlayerStatsPO> team2Players;  //客队球员数据
	
	public void setSimpleData(String season, String[] arr1, String[] arr2){
		//arr1：日期；球队1-球队2；总比分 
		//arr2：第一节比分；第二节比分；第三节比分；第四节比分
		this.season = season;
		date = arr1[0];
		String[] teams = arr1[1].split("-");
		try {
			homeTeam = Teams.toEnum(teams[0]);
			guestTeam = Teams.toEnum(teams[1]);
		} catch (TeamNotFound e) {
			System.out.println(e.getErrorMessage());
			e.printStackTrace();
		}
		score = arr1[2];
		
		score1 = arr2[0];
		score2 = arr2[1];
		score3 = arr2[2];
		score4 = arr2[3];
		
		if(arr2.length == 5){
			scoreExtra = arr2[4];
		}else{
			scoreExtra = null;
		}
	}
	
	public void setTeamsStats(ArrayList<String[]> team1, ArrayList<String[]> team2){
		//String[]：见PlayersStatsPO构造函数
		team1Players = new ArrayList<PlayerStatsPO>();
		team2Players = new ArrayList<PlayerStatsPO>();
		
		for(int i=0; i<team1.size(); i++){
			PlayerStatsPO player1;
			try {
				player1 = new PlayerStatsPO(team1.get(i));
				if(i<5){
					player1.setGameStarting(true);
				}
				team1Players.add(player1);
			} catch (ErrorData e) {
				//错误数据不处理
				//e.printStackTrace();
			}
		}
		for(int i=0; i<team2.size(); i++){
			PlayerStatsPO player2;
			try {
				player2 = new PlayerStatsPO(team2.get(i));
				if(i<5){
					player2.setGameStarting(true);
				}
				team2Players.add(player2);
			} catch (ErrorData e) {
				//错误数据不处理
				//e.printStackTrace();
			}
		}
	}
	
	public String season(){
		return season;
	}
	
	public String date(){
		return date;
	}
	
	public Teams homeTeam(){
		return homeTeam;
	}
	
	public Teams guestTeam(){
		return guestTeam;
	}
	
	public String score(){
		return score;
	}
	
	public String score1(){
		return score1;
	}
	
	public String score2(){
		return score2;
	}
	
	public String score3(){
		return score3;
	}
	
	public String score4(){
		return score4;
	}
	
	public String scoreExtra(){
		return scoreExtra;
	}
	
	public ArrayList<PlayerStatsPO> team1Players(){
		return team1Players;
	}
	
	public ArrayList<PlayerStatsPO> team2Players(){
		return team2Players;
	}
	
	public void print(){
		System.out.println(season + ';' + date + '\n' +
				           homeTeam + '-' + guestTeam + '\n' +
				           score + '\n' +
				           score1 + ';' + score2 + ';' + score3 + ';' + score4);
		for(int i=0; i<team1Players.size(); i++){
			team1Players.get(i).print();
		}
		for(int i=0; i<team2Players.size(); i++){
			team2Players.get(i).print();
		}
	}

	@Override
	public String getSeason() {
		return season;
	}

	@Override
	public String getDate() {
		return date;
	}
	
}
