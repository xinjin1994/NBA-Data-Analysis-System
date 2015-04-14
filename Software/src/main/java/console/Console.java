package console;

import java.io.PrintStream;
import java.util.ArrayList;

import vo.TeamHighInfo;
import vo.TeamHotInfo;
import vo.TeamNormalInfo;
import businessLogicService.teamsBLService.TeamsBLForTest;
import data.init.DataInit;
import enums.Terminology;

public class Console {
	public void excute(PrintStream out, String[] args) {
		if(args[0].equals("--datasource")) {
			new DataInit(args[1]).init();
		}else if(args[0].equals("-player")){
			excute_player(out, args);
		}else {
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
		
		/*
		while(true) {
			if(ci >= len) break;
			
			if(args[ci].equals("-avg")) {
				isAvg = true;
				ci++;
			}else if(args[ci].equals("-total")) {
				isAvg = false;
				ci++;
			}else {
				isAvg = true;
			}
			
			if(ci >= len) break;
			
			if(args[ci].equals("-all")) {
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
			}else {
				isHot = false;
				isKing = false;
			}
			
			if(ci >= len) break;
			
			if(args[ci].equals("-n")) {
				num = Integer.parseInt(args[ci+1]);
				ci += 2;
			}
			
			if(ci >= len) break;
			
			if(args[ci].equals("-high")) {
				isHigh = true;
				ci++;
			}
			
			if(ci >= len) break;
			
			if(args[ci].equals("-filter")) {
				filters = args[ci+1].split(",");
				ci += 2;
			}
			
			if(ci >= len) break;
			
			if(args[ci].equals("-sort")) {
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
			}
			
			break;
		}
		*/
		
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
		System.out.println("Player King " + hotField + " " + num);
	}
	
	private void printPlayerKing_daily(PrintStream out, String kingField, int num) {
		System.out.println("Player King " + kingField + " daily " + num);
	}
	
	private void printPlayerKing_season(PrintStream out, String kingField, int num) {
		System.out.println("Player King " + kingField + " season " + num);
	}
	
	private void printPlayerHigh(PrintStream out, Terminology[] sortField,
			 boolean[] asc, int num) {
		System.out.println("Player High " + num);
		for(int i=0; i<sortField.length; i++){
			System.out.println(sortField[i]);
			System.out.println(asc[i]);
		}
	}
	
	private void printPlayerNormal_avg(PrintStream out, String[] filter, 
			Terminology[] sortField, boolean[] asc, int num) {
		System.out.println("Player Normal AVG " + num);
		for(int i=0; i<filter.length; i++){
			System.out.println(filter[i]);
		}
		for(int i=0; i<sortField.length; i++){
			System.out.println(sortField[i]);
			System.out.println(asc[i]);
		}
	}
	
	private void printPlayerNormal_total(PrintStream out, String[] filter, 
			Terminology[] sortField, boolean[] asc, int num) {
		System.out.println("Player Normal TOTAL " + num);
		for(int i=0; i<filter.length; i++){
			System.out.println(filter[i]);
		}
		for(int i=0; i<sortField.length; i++){
			System.out.println(sortField[i]);
			System.out.println(asc[i]);
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
		
		/*
		while(true) {
			if(ci >= len) break;
			
			if(args[ci].equals("-total")) {
				isAvg = false;
				ci++;
			}else if(args[ci].equals("-avg")) {
				isAvg = true;
				ci++;
			}else {
				isAvg = true;
			}
			
			if(ci >= len) break;
			
			if(args[ci].equals("-all")) {
				ci++;
				isHot = false;
			}else if(args[ci].equals("-hot")) {
				hotField = args[ci+1];
				ci += 2;
				isHot = true;
			}else {
				isHot = false;
			}
			
			if(ci >= len) break;
			
			if(args[ci].equals("-n")) {
				num = Integer.parseInt(args[ci+1]);
				ci += 2;
			}
			
			if(ci >= len) break;
			
			if(args[ci].equals("-high")) {
				isHigh = true;
				ci++;
			}else {
				isHigh = false;
			}
			
			if(ci >= len) break;
			
			if(args[ci].equals("-sort")) {
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
			}
			
			break;
		}
		*/
		
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
		System.out.println("Team Normal AVG " + num);
		for(int i=0; i<sortField.length; i++){
			System.out.println(sortField[i]);
			System.out.println(asc[i]);
		}
	}
	
	private void printTeamNormal_total(PrintStream out, Terminology[] sortField, 
			boolean[] asc, int num) {
		System.out.println("Team Normal TOTAL " + num);
		for(int i=0; i<sortField.length; i++){
			System.out.println(sortField[i]);
			System.out.println(asc[i]);
		}
	}
	
	private void printTeamHigh(PrintStream out, Terminology[] sortField, 
			boolean[] asc, int num) {
		System.out.println("Team High " + num);
		for(int i=0; i<sortField.length; i++){
			System.out.println(sortField[i]);
			System.out.println(asc[i]);
		}
	}
	
	private void printTeamHot(PrintStream out, String hotField, int num) {
		System.out.println("Team Hot " + num);
		System.out.println(hotField);
	}
	
	public static void main(String[] args) {
		Console con = new Console();
		con.excute(System.out, args);
	}
}
