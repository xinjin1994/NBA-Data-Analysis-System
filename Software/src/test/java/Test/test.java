package Test;

import java.util.ArrayList;

import data.init.DataInit;
import enums.Terminology;
import test.data.*;
import businessLogic.teamsBL.TeamsBL_new;
import businessLogicService.teamsBLService.TeamsBLForTest;

public class test {
	public static void normalprint(TeamNormalInfo info){
		System.out.println(info.getTeamName()+"  得分  "+info.getPoint()+"  投篮命中率  "+info.getShot()+"  进攻篮板数  "+info.getOffendRebound()+"  抢断数  "+info.getSteal());
	}
	
	public static void highprint(TeamHighInfo info){
		System.out.println(info.getTeamName()+"  胜率  "+info.getWinRate()+"  进攻回合数  "+info.getOffendRound()+"  助攻效率           "+info.getAssistEfficient());
	}
	
	public static void hotprint(TeamHotInfo info){
		System.out.println(info.getTeamName()+"  联盟          "+info.getLeague()+"  属性        "+info.getField()+"  数值  "+info.getValue());
	}
	
	public static void getnoravg(Terminology[] sortField,
			boolean[] asc, int n){
		TeamsBLForTest test=new TeamsBL_new();
		ArrayList<TeamNormalInfo> list=test.getTeamNormalInfo_avg(sortField,asc,n);
		for(TeamNormalInfo i:list){
			normalprint(i);
		}
	}
	
	public static void getnortotal(Terminology[] sortField,
			boolean[] asc, int n){
		TeamsBLForTest test=new TeamsBL_new();
		ArrayList<TeamNormalInfo> list=test.getTeamNormalInfo_total(sortField,asc,n);
		for(TeamNormalInfo i:list){
			normalprint(i);
		}
	}
	
	public static void gethigh(Terminology[] sortField,
			boolean[] asc, int n){
		TeamsBLForTest test=new TeamsBL_new();
		ArrayList<TeamHighInfo> list=test.getTeamHighInfo(sortField,asc,n);
		for(TeamHighInfo i:list){
			highprint(i);
		}
	}
	
	public static void gethot(String hotField, int n){
		TeamsBLForTest test=new TeamsBL_new();
		ArrayList<TeamHotInfo> list=test.getTeamHotInfo(hotField,n);
		for(TeamHotInfo i:list){
			hotprint(i);
		}
	}
	
	public static void main(String[] args){
		/*
		 * 	NAME("名字"), TEAM("球队"), GM("比赛场数"), GMSTR("先发场数"), MIN("在场时间"), 
	       	FGM("投篮命中数"), FGA("投篮出手数"), FGP("投篮命中率"), 
	       	TPM("三分命中数"), TPA("三分出手数"), TPP("三分命中率"), 
			FTM("罚球命中数"), FTA("罚球出手数"), FTP("罚球命中率"), 
			OREB("进攻篮板数"), DREB("防守篮板数"), REB("总篮板数"), 
			AST("助攻数"), STL("抢断数"),  BLK("盖帽数"), 
			TOV("失误数"), PF("犯规数"), PTS("个人得分"), 
			PER("效率"), DBDB("两双数"), IMP("近五场提升率"), GMSC("GmSc"), 
			TSP("真实投篮命中率"), FGE("投篮效率"), 
			REBP("篮板率"), OREBP("进攻篮板率"), DREBP("防守篮板率"), 
			ASTP("助攻率"), STLP("抢断率"), BLKP("盖帽率"), TOVP("失误率"), 
			USGP("使用率"), 
			WINR("胜率"), 
			OFR("进攻回合"), DFR("防守回合"), 
			OFE("进攻效率"), DFE("防守效率"), 
			OREBDE("进攻篮板效率"), DREBDE("防守篮板效率"), 
			STLE("抢断效率"), ASTE("助攻效率"),
		 */
		Terminology[] sortField=new Terminology[]{Terminology.OFR};
		boolean[] asc={true};
		int n=10;
		DataInit init=new DataInit();
		init.init();
		String hotField="assist";
		gethot(hotField,n);
	}
}
