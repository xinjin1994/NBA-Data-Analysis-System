package factory;

import java.util.ArrayList;

import businessLogic.teamsBL.AdvancedTeamStats;
import businessLogic.teamsBL.BasicTeamStats;
import businessLogic.teamsBL.TeamStatsForCalculation;

public class TeamsCalculator {
	private ArrayList<TeamStatsForCalculation> list;
	public TeamsCalculator(){
		
	}
	public TeamsCalculator (ArrayList<TeamStatsForCalculation> list){
		this.list=list;
	}
	
	public BasicTeamStats Average(ArrayList<BasicTeamStats> average){
		BasicTeamStats result=new BasicTeamStats();
		Integer games=average.get(0).games();
		result.setName(average.get(0).name());
		Double fieldGoalsMade=0.00;                  
		Double fieldGoalsAttempted=0.00;             
		Double threePointFieldGoalsMade=0.00;        
		Double threePointFieldGoalsAttempted=0.00;   
		Double freeThrowsMade=0.00;                   
		Double freeThrowsAttempted=0.00;              
		Double offensiveRebounds=0.00;               
		Double defensiveRebounds=0.00;               
		Double rebounds=0.00;                        
		Double assists=0.00;                         
		Double steals=0.00;                           
		Double blocks=0.00;                           
		Double turnovers=0.00;                        
		Double fouls=0.00;                            
		Double points=0.00;                           
		for(BasicTeamStats basic:average){
			result.setName(basic.name());
			fieldGoalsMade=fieldGoalsMade+basic.fieldGoalsMade();
			fieldGoalsAttempted=fieldGoalsAttempted+basic.fieldGoalsAttempted();
			threePointFieldGoalsMade=threePointFieldGoalsMade+basic.threePointFieldGoalsMade();
			threePointFieldGoalsAttempted=threePointFieldGoalsAttempted+basic.threePointFieldGoalsAttempted();
			freeThrowsMade=freeThrowsMade+basic.freeThrowsMade();
			freeThrowsAttempted=freeThrowsAttempted+basic.fieldGoalsAttempted();
			offensiveRebounds=offensiveRebounds+basic.offensiveRebounds();
			defensiveRebounds=defensiveRebounds+basic.defensiveRebounds();
			rebounds=rebounds+basic.rebounds();
			assists=assists+basic.assists();
			steals=steals+basic.steals();
			blocks=blocks+basic.blocks();
			turnovers=turnovers+basic.turnovers();
			fouls=fouls+basic.fouls();
			points=points+basic.points();
		}
		int size=average.size();
		result.setGames(games);
		result.setFieldGoalsMade(fieldGoalsMade/size);
		result.setFieldGoalsAttempted(fieldGoalsAttempted/size);
		result.setThreePointFieldGoalsMade(threePointFieldGoalsMade/size);
		result.setThreePointFieldGoalsAttempted(threePointFieldGoalsAttempted/size);
		result.setFreeThrowsMade(freeThrowsMade/size);
		result.setFreeThrowsAttempted(freeThrowsAttempted/size);
		result.setOffensiveRebounds(offensiveRebounds/size);
		result.setDefensiveRebounds(defensiveRebounds/size);
		result.setRebounds(rebounds/size);
		result.setAssists(assists/size);
		result.setSteals(steals/size);
		result.setBlocks(blocks/size);
		result.setTurnovers(turnovers/size);
		result.setFouls(fouls/size);
		result.setPoints(points/size);
		return result;
	}
	
	public BasicTeamStats Sum(ArrayList<BasicTeamStats> sum){
		BasicTeamStats result=new BasicTeamStats();
		result.setName(sum.get(0).name());
		Integer games=sum.get(0).games();
		Integer wins=0;
		Double fieldGoalsMade=0.00;                  
		Double fieldGoalsAttempted=0.00;             
		Double threePointFieldGoalsMade=0.00;        
		Double threePointFieldGoalsAttempted=0.00;   
		Double freeThrowsMade=0.00;                   
		Double freeThrowsAttempted=0.00;              
		Double offensiveRebounds=0.00;               
		Double defensiveRebounds=0.00;               
		Double rebounds=0.00;                        
		Double assists=0.00;                         
		Double steals=0.00;                           
		Double blocks=0.00;                           
		Double turnovers=0.00;                        
		Double fouls=0.00;                            
		Double points=0.00;                           
		for(BasicTeamStats basic:sum){
			result.setName(basic.name());
			wins=wins+basic.wins();
			fieldGoalsMade=fieldGoalsMade+basic.fieldGoalsMade();
			fieldGoalsAttempted=fieldGoalsAttempted+basic.fieldGoalsAttempted();
			threePointFieldGoalsMade=threePointFieldGoalsMade+basic.threePointFieldGoalsMade();
			threePointFieldGoalsAttempted=threePointFieldGoalsAttempted+basic.threePointFieldGoalsAttempted();
			freeThrowsMade=freeThrowsMade+basic.freeThrowsMade();
			freeThrowsAttempted=freeThrowsAttempted+basic.freeThrowsAttempted();
			offensiveRebounds=offensiveRebounds+basic.offensiveRebounds();
			defensiveRebounds=defensiveRebounds+basic.defensiveRebounds();
			rebounds=rebounds+basic.rebounds();
			assists=assists+basic.assists();
			steals=steals+basic.steals();
			blocks=blocks+basic.blocks();
			turnovers=turnovers+basic.turnovers();
			fouls=fouls+basic.fouls();
			points=points+basic.points();
		}
		result.setGames(games);
		result.setWins(wins);
		result.setFieldGoalsMade(fieldGoalsMade);
		result.setFieldGoalsAttempted(fieldGoalsAttempted);
		result.setThreePointFieldGoalsMade(threePointFieldGoalsMade);
		result.setThreePointFieldGoalsAttempted(threePointFieldGoalsAttempted);
		result.setFreeThrowsMade(freeThrowsMade);
		result.setFreeThrowsAttempted(freeThrowsAttempted);
		result.setOffensiveRebounds(offensiveRebounds);
		result.setDefensiveRebounds(defensiveRebounds);
		result.setRebounds(rebounds);
		result.setAssists(assists);
		result.setSteals(steals);
		result.setBlocks(blocks);
		result.setTurnovers(turnovers);
		result.setFouls(fouls);
		result.setPoints(points);
		return result;
	}
	
	public AdvancedTeamStats calculate(){
		AdvancedTeamStats advanced=new AdvancedTeamStats();
		advanced.setName(list.get(0).basicTeamStats().name());
		advanced.setWinningRate(WinningRate());
		advanced.setOffensiveRounds(OffensiveRounds());
		advanced.setDefensiveRounds(DefensiveRounds());
		advanced.setOffensiveEfficiency(OffensiveEfficiency());
		advanced.setDefensiveEfficiency(DefensiveEfficiency());
		advanced.setDefensiveReboundsEfficiency(DefensiveReboundsEfficiency());
		advanced.setOffensiveReboudnsEfficiency(OffensiveReboudnsEfficiency());
		advanced.setStealsEfficiency(StealsEfficiency());
		advanced.setAssistsEfficiency(AssistsEfficiency());
		return advanced;
	}
	
	private Double WinningRate(){
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
	
	private Double Offensive(TeamStatsForCalculation team){
		BasicTeamStats basic=team.basicTeamStats();
		Double offensiveRounds=basic.fieldGoalsAttempted()+0.4*basic.freeThrowsAttempted()-
				1.07*(basic.offensiveRebounds()/(basic.offensiveRebounds()+
				    team.defensiveRebounds_opponent())*(basic.fieldGoalsAttempted()-
						basic.fieldGoalsMade()))+1.07*basic.turnovers();
		return offensiveRounds;
	}
	
	private Double Defensive(TeamStatsForCalculation team){
		BasicTeamStats basic=team.basicTeamStats();
		Double defensiveRounds=team.fieldGoalsMade_opponent()+0.4*team.freeThrowsMade_opponent()
				-1.07*((double)team.offensiveRebounds_opponent()/(team.offensiveRebounds_opponent()
				+basic.defensiveRebounds())*team.fumbles_opponent())+1.07*team.turnovers_opponent();
		return defensiveRounds;
	}
	
	private Double OffensiveRounds(){
		try{
			Double offensiveRounds=0.00;
			for(TeamStatsForCalculation team:list){
				offensiveRounds=offensiveRounds+Offensive(team);
			}
			offensiveRounds=offensiveRounds/list.size();
			return offensiveRounds;
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}
	
	private Double DefensiveRounds(){
		try{
			Double defensiveRounds=0.00;
			for(TeamStatsForCalculation team:list){
				defensiveRounds=defensiveRounds+Defensive(team);
			}
			defensiveRounds=defensiveRounds/list.size();
			return defensiveRounds;
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}
	
	private Double OffensiveEfficiency(){
		Double offensiveEfficiency=0.00;
		for(TeamStatsForCalculation team:list){
			offensiveEfficiency=offensiveEfficiency+team.basicTeamStats().points()*100/Offensive(team);
		}
		offensiveEfficiency=offensiveEfficiency/list.size();
		return offensiveEfficiency;
	}
	
	private Double DefensiveEfficiency(){
		Double defensiveEfficiency=0.00;
		for(TeamStatsForCalculation team:list){
			defensiveEfficiency=defensiveEfficiency+team.point_opponent()*100/Defensive(team);
		}
		defensiveEfficiency=defensiveEfficiency/list.size();
		return defensiveEfficiency;
	}
	
	private Double OffensiveReboudnsEfficiency(){
		Double offensiveReboudnsEfficiency=0.00;
		for(TeamStatsForCalculation team:list){
			offensiveReboudnsEfficiency=offensiveReboudnsEfficiency+team.basicTeamStats().offensiveRebounds()/(team.basicTeamStats().offensiveRebounds()+team.defensiveRebounds_opponent());
		}
		offensiveReboudnsEfficiency=offensiveReboudnsEfficiency/list.size();
		return offensiveReboudnsEfficiency;
	}
	
	private Double DefensiveReboundsEfficiency(){
		Double defensiveReboundsEfficiency=0.00;
		for(TeamStatsForCalculation team:list){
			defensiveReboundsEfficiency=defensiveReboundsEfficiency+team.basicTeamStats().defensiveRebounds()/(team.basicTeamStats().defensiveRebounds()+team.offensiveRebounds_opponent());
		}
		defensiveReboundsEfficiency=defensiveReboundsEfficiency/list.size();
		return defensiveReboundsEfficiency;
	}
	
	private Double StealsEfficiency(){
		Double stealsEfficiency=0.00;
		for(TeamStatsForCalculation team:list){
			stealsEfficiency=stealsEfficiency+team.basicTeamStats().steals()*100/Defensive(team);
		}
		stealsEfficiency=stealsEfficiency/list.size();
		return stealsEfficiency;
	}
	
	private Double AssistsEfficiency(){
		Double assistsEfficiency=0.00;
		for(TeamStatsForCalculation team:list){
			assistsEfficiency=assistsEfficiency+team.basicTeamStats().assists()*100/Offensive(team);
		}
		assistsEfficiency=assistsEfficiency/list.size();
		return assistsEfficiency;
	}
}
