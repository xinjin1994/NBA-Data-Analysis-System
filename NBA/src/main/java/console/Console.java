package console;

import java.io.PrintStream;
import java.util.ArrayList;

import businessLogic.playersBL.PlayersBL_new;
import businessLogic.teamsBL.TeamsBL_new;
import businessLogicService.playersBLService.PlayersBLForTest;
import businessLogicService.teamsBLService.TeamsBLForTest;
import data.init.DataInit;
import enums.Terminology;
import test.data.*;

public class Console {
	
	PlayersBLForTest playerService = new PlayersBL_new();
	TeamsBLForTest teamService = new TeamsBL_new();
	
	public void excute(PrintStream out, String[] args) {
		if(args[0].equals("--datasource")) {
			new DataInit(args[1]).init();
		}else if(args[0].equals("-player")){
			new DataInit().init();
			excute_player(out, args);
		}else {
			new DataInit().init();
			excute_team(out, args);
		}
	}
	
	private void excute_player(PrintStream out, String[] args) {
		int len = args.length;
		int ci = 1;
		boolean isAvg = true;
		boolean isHot = false;
		boolean isKing = false;
		boolean isHigh = false;
		boolean isDaily = false;
		
		String hotField = null;
		String kingField = null;
		Terminology[] sortField = null;
		boolean[] asc = null;
		String[] filters = null;
		boolean hasSort = false;
		int num = 50;
		
		while(ci < len) {
			if(args[ci].equals("-avg")) {
				isAvg = true;
				ci++;
			}else if(args[ci].equals("-total")) {
				isAvg = false;
				ci++;
			}else if(args[ci].equals("-all")) {
				ci++;
			}else if(args[ci].equals("-hot")) {
				isHot = true;
				hotField = args[ci+1];
				ci += 2;
			}else if(args[ci].equals("-king")) {
				isKing = true;
				kingField = args[ci+1];
				ci += 2;
				if(args[ci].equals("-season")) {
					isDaily = false;
					break;
				}else {
					isDaily = true;
					break;
				}
			}else if(args[ci].equals("-n")) {
				num = Integer.parseInt(args[ci+1]);
				ci += 2;
			}else if(args[ci].equals("-high")) {
				isHigh = true;
				ci++;
			}else if(args[ci].equals("-filter")) {
				filters = args[ci+1].split(",");
				ci += 2;
			}else if(args[ci].equals("-sort")) {
				hasSort = true;
				String[] sorts = args[ci+1].split(",");
				sortField = new Terminology[sorts.length];
				asc = new boolean[sorts.length];
				for(int i=0; i<sorts.length; i++){
					String[] arr = sorts[i].split("\\.");
					sortField[i] = Terminology.toEnum_player(arr[0]);
					if(arr[1].equals("asc")){
						asc[i] = true;
					}else{
						asc[i] = false;
					}
				}
				ci += 2;
			}
		}
		
		if(isHigh && !hasSort){
			sortField = new Terminology[1];
			sortField[0] = Terminology.toEnum_player("realShot");
			asc = new boolean[1];
			asc[0] = false;
		}else if(!hasSort){
			sortField = new Terminology[1];
			sortField[0] = Terminology.toEnum_player("score");
			asc = new boolean[1];
			asc[0] = false;
		}
		
		
		if(isHot) {
			printPlayerHot(out, hotField, num);
		}else if(isKing) {
			if(isDaily) {
				printPlayerKing_daily(out, kingField, num);
			}else {
				printPlayerKing_season(out, kingField, num);
			}
		}else if(isHigh) {
			printPlayerHigh(out, sortField, asc, num);
		}else if(isAvg) {
			printPlayerNormal_avg(out, filters, sortField, asc, num);
		}else {
			printPlayerNormal_total(out, filters, sortField, asc, num);
		}
		
	}
	
	private void printPlayerHot(PrintStream out, String hotField, int num) {
		//System.out.println("Player King " + hotField + " " + num);
		ArrayList<PlayerHotInfo> list = playerService.getPlayerHotInfo(hotField, num);
		for(PlayerHotInfo info: list){
			out.println(info);
		}
	}
	
	private void printPlayerKing_daily(PrintStream out, String kingField, int num) {
		//System.out.println("Player King " + kingField + " daily " + num);
		ArrayList<PlayerKingInfo> list = playerService.getPlayerKingInfo_daily(kingField, num);
		for(PlayerKingInfo info: list){
			out.println(info);
		}
	}
	
	private void printPlayerKing_season(PrintStream out, String kingField, int num) {
		//System.out.println("Player King " + kingField + " season " + num);
		ArrayList<PlayerKingInfo> list = playerService.getPlayerKingInfo_season(kingField, num);
		for(PlayerKingInfo info: list){
			out.println(info);
		}
	}
	
	private void printPlayerHigh(PrintStream out, Terminology[] sortField,
			 boolean[] asc, int num) {
		/*
		System.out.println("Player High " + num);
		for(int i=0; i<sortField.length; i++){
			System.out.println(sortField[i]);
			System.out.println(asc[i]);
		}
		*/
		ArrayList<PlayerHighInfo> list = playerService.getPlayerHighInfo(sortField, asc, num);
		for(PlayerHighInfo info: list){
			out.println(info);
		}
	}
	
	private void printPlayerNormal_avg(PrintStream out, String[] filter, 
			Terminology[] sortField, boolean[] asc, int num) {
		/*
		System.out.println("Player Normal AVG " + num);
		for(int i=0; i<filter.length; i++){
			System.out.println(filter[i]);
		}
		for(int i=0; i<sortField.length; i++){
			System.out.println(sortField[i]);
			System.out.println(asc[i]);
		}
		*/
		ArrayList<PlayerNormalInfo> list = playerService.getPlayerNormalInfo_avg(filter, sortField, asc, num);
		for(PlayerNormalInfo info: list){
			out.println(info);
		}
	}
	
	private void printPlayerNormal_total(PrintStream out, String[] filter, 
			Terminology[] sortField, boolean[] asc, int num) {
		/*
		System.out.println("Player Normal TOTAL " + num);
		for(int i=0; i<filter.length; i++){
			System.out.println(filter[i]);
		}
		for(int i=0; i<sortField.length; i++){
			System.out.println(sortField[i]);
			System.out.println(asc[i]);
		}
		*/
		ArrayList<PlayerNormalInfo> list = playerService.getPlayerNormalInfo_total(filter, sortField, asc, num);
		for(PlayerNormalInfo info: list){
			out.println(info);
		}
	}
	
	
	
	
	
	
	private void excute_team(PrintStream out, String[] args) {
		int len = args.length;
		int ci = 1;                        //current instruction;
		boolean isAvg = true;                     //avg or total
		boolean isHot = false;
		boolean isHigh = false;
		
		String hotField = null;
		Terminology[] sortField = null;
		boolean[] asc = null;
		boolean hasSort = false;
		int num = 30;
		
		while(ci < len){
			if(args[ci].equals("-total")) {
				isAvg = false;
				ci++;
			}else if(args[ci].equals("-avg")) {
				isAvg = true;
				ci++;
			}else if(args[ci].equals("-all")) {
				ci++;
				isHot = false;
			}else if(args[ci].equals("-hot")) {
				hotField = args[ci+1];
				ci += 2;
				isHot = true;
			}else if(args[ci].equals("-n")) {
				num = Integer.parseInt(args[ci+1]);
				ci += 2;
			}else if(args[ci].equals("-high")) {
				isHigh = true;
				ci++;
			}else if(args[ci].equals("-sort")) {
				hasSort = true;
				String[] sorts = args[ci+1].split(",");
				sortField = new Terminology[sorts.length];
				asc = new boolean[sorts.length];
				for(int i=0; i<sorts.length; i++){
					String[] arr = sorts[i].split("\\.");
					sortField[i] = Terminology.toEnum_team(arr[0]);
					if(arr[1].equals("asc")){
						asc[i] = true;
					}else{
						asc[i] = false;
					}
				}
				ci += 2;
			}
		}
		
		if(isHigh && !hasSort){
			sortField = new Terminology[1];
			sortField[0] = Terminology.toEnum_team("winRate");
			asc = new boolean[1];
			asc[0] = false;
		}else if (!hasSort){
			sortField = new Terminology[1];
			sortField[0] = Terminology.toEnum_team("score");
			asc = new boolean[1];
			asc[0] = false;
		}
		
		
		if(isHot) {
			printTeamHot(out, hotField, num);
		}else if(isHigh) {
			printTeamHigh(out, sortField, asc, num);
		}else if(isAvg) {
			printTeamNormal_avg(out, sortField, asc, num);
		}else {
			printTeamNormal_total(out, sortField, asc, num);
		}
		
	}
	
	private void printTeamNormal_avg(PrintStream out, Terminology[] sortField, 
			boolean[] asc, int num) {
		/*
		System.out.println("Team Normal AVG " + num);
		for(int i=0; i<sortField.length; i++){
			System.out.println(sortField[i]);
			System.out.println(asc[i]);
		}
		*/
		ArrayList<TeamNormalInfo> list = teamService.getTeamNormalInfo_avg(sortField, asc, num);
		for(TeamNormalInfo info: list){
			out.println(info);
		}
	}
	
	private void printTeamNormal_total(PrintStream out, Terminology[] sortField, 
			boolean[] asc, int num) {
		/*
		System.out.println("Team Normal TOTAL " + num);
		for(int i=0; i<sortField.length; i++){
			System.out.println(sortField[i]);
			System.out.println(asc[i]);
		}
		*/
		ArrayList<TeamNormalInfo> list = teamService.getTeamNormalInfo_total(sortField, asc, num);
		for(TeamNormalInfo info: list){
			out.println(info);
		}
	}
	
	private void printTeamHigh(PrintStream out, Terminology[] sortField, 
			boolean[] asc, int num) {
		/*
		System.out.println("Team High " + num);
		for(int i=0; i<sortField.length; i++){
			System.out.println(sortField[i]);
			System.out.println(asc[i]);
		}
		*/
		ArrayList<TeamHighInfo> list = teamService.getTeamHighInfo(sortField, asc, num);
		for(TeamHighInfo info: list){
			out.println(info);
		}
	}
	
	private void printTeamHot(PrintStream out, String hotField, int num) {
		/*
		System.out.println("Team Hot " + num);
		System.out.println(hotField);
		*/
		ArrayList<TeamHotInfo> list = teamService.getTeamHotInfo(hotField, num);
		for(TeamHotInfo info: list){
			out.println(info);
		}
	}
	
	public static void main(String[] args) {
		Console con = new Console();
		con.excute(System.out, args);
	}
}
