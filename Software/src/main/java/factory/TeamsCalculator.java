package factory;

import java.util.ArrayList;

import businessLogic.teamsBL.AdvancedTeamStats;
import businessLogic.teamsBL.TeamStatsForCalculation;

public class TeamsCalculator {
	private ArrayList<TeamStatsForCalculation> list;
	public TeamsCalculator (ArrayList<TeamStatsForCalculation> list){
		this.list=list;
	}
	
	public AdvancedTeamStats calculate(){
		return null;
	}
	
	public Double WinningRate(){
		try{
			Double winningRate=0.00;
			for(TeamStatsForCalculation team:list){
				winningRate=winningRate+(double)team.basicTeamStats().wins()/team.basicTeamStats().games();
			}
			winningRate=winningRate/list.size();
			return winningRate;
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}
	
	public Double OffensiveRounds(){
		try{
			Double offensiveRounds=0.00;
			for(TeamStatsForCalculation team:list){
				
			}
			return null;
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}
}
