package data.init;

import helper.TypeTransform;

import java.util.ArrayList;








import data.matchesData.Matches_new;
import data.playersData.PlayerAdvancedStats_new;
import data.playersData.PlayerBasicStats_new;
import data.playersData.PlayerStats_new;
import data.teamsData.TeamAdvancedStats_new;
import data.teamsData.TeamBasicStats_new;
import data.teamsData.TeamStats_new;
import enums.Teams;
import po.MatchPO;
import po.PlayerStatsPO;

public class Calculator {
	//输入一场比赛的所有数据，获取所有队伍和球员数据
	MatchPO match;
	
	public Calculator(MatchPO match) {
		this.match = match;
	}
	
	public ArrayList<PlayerStats_new> getPlayerStats() {
		ArrayList<PlayerStats_new> playerStats=new ArrayList<PlayerStats_new>();
		ArrayList<PlayerStatsPO> team1player=match.team1Players();
		ArrayList<PlayerStatsPO> team2player=match.team2Players();
		for(PlayerStatsPO playerpo:team1player){
			PlayerStats_new playerStat=new PlayerStats_new();
			playerStat.setSeason(match.season());
			playerStat.setDate(match.date());
			playerStat.setName(playerpo.name());
			playerStat.setTeam(match.homeTeam());
			PlayerBasicStats_new basic=getPlayerBasicStats(playerpo);
			playerStat.setBasic(basic);
			playerStat.setAdvanced(getPlayerAdvancedStats(basic,match.homeTeam()));
			playerStats.add(playerStat);
		}
		for(PlayerStatsPO playerpo:team2player){
			PlayerStats_new playerStat=new PlayerStats_new();
			playerStat.setSeason(match.season());
			playerStat.setDate(match.date());
			playerStat.setName(playerpo.name());
			playerStat.setTeam(match.guestTeam());
			PlayerBasicStats_new basic=getPlayerBasicStats(playerpo);
			playerStat.setBasic(basic);
			playerStat.setAdvanced(getPlayerAdvancedStats(basic,match.guestTeam()));
			playerStats.add(playerStat);
		}
		return playerStats;
	}
	
	public ArrayList<TeamStats_new> getTeamStats() {
		ArrayList<TeamStats_new> teams=new ArrayList<TeamStats_new>();
		TeamStats_new hometeam=getHomeTeamStats();
		TeamStats_new guestteam=getGuestTeamStats();
		teams.add(hometeam);
		teams.add(guestteam);
		return teams;
	}
	
	public Matches_new getMatchStats() {
		Matches_new matchesStats=getMatches();
		return matchesStats;
	}
	
	private Matches_new getMatches(){
		Matches_new matchStats=new Matches_new();
		matchStats.setSeason(match.season());
		matchStats.setDate(match.date());
		matchStats.setHomeTeam(match.homeTeam());
		matchStats.setGuestTeam(match.guestTeam());
		matchStats.setScore(match.score());
		matchStats.setScore1(match.score1());
		matchStats.setScore2(match.score2());
		matchStats.setScore3(match.score3());
		matchStats.setScore4(match.score4());
		matchStats.setScoreExtra(match.scoreExtra());
		return matchStats;
	}
	
	private PlayerBasicStats_new getPlayerBasicStats(PlayerStatsPO player){
		PlayerBasicStats_new player_new=new PlayerBasicStats_new();
		player_new.setGamesStarting(player.isGameStarting());
		player_new.setPosition(player.position());
		player_new.setMinutes(TypeTransform.str_to_minutes(player.minutes()));
		player_new.setFieldGoalsMade((double)player.fieldGoalsMade());
		player_new.setFieldGoalsAttempted((double)player.fieldGoalsAttempted());
		player_new.setThreePointFieldGoalsMade((double)player.threePointFieldGoalsMade());
		player_new.setThreePointFieldGoalsAttempted((double)player.threePointFieldGoalsAttempted());
		player_new.setFreeThrowsMade((double)player.freeThrowsMade());
		player_new.setFreeThrowsAttempted((double)player.freeThrowsAttempted());
		player_new.setOffensiveRebounds((double)player.offensiveRebounds());
		player_new.setDefensiveRebounds((double)player.defensiveRebounds());
		player_new.setRebounds((double)player.rebounds());
		player_new.setAssists((double)player.assists());
		player_new.setSteals((double)player.steals());
		player_new.setBlocks((double)player.blocks());
		player_new.setTurnovers((double)player.turnovers());
		player_new.setPersonalFouls((double)player.personalFouls());
		player_new.setPoints((double)player.points());
		return player_new;
	}
	
	private PlayerAdvancedStats_new getPlayerAdvancedStats(PlayerBasicStats_new player,Teams team){
		PlayerAdvancedStats_new player_new=new PlayerAdvancedStats_new();
		player_new.setDoubleDouble(IsDoubleDouble(player));
		player_new.setHitRate(HitRate(player));
		player_new.setRebounds(Rebounds(player));
		player_new.setPlayerEfficiencyRating(PlayerEfficiencyRating(player));
		player_new.setGmsc(Gmsc(player));
		player_new.setTrueScorePercent(TrueScorePercent(player));
		player_new.setFieldGoalsPercent(FieldGoalsPercent(player));
		player_new.setReboundsPercent(ReboundsPercent(player,team));
		player_new.setOffensiveReboundsPercent(OffensiveReboundsPercent(player,team));
		player_new.setDefensiveReboundsPercent(DefensiveReboundsPercent(player,team));
		player_new.setAssistsPercent(AssistsPercent(player,team));
		player_new.setStealsPercent(StealsPercent(player,team));
		player_new.setBlockPercent(BlockPercent(player,team));
		player_new.setTurnoversPercent(TurnoversPercent(player));
		player_new.setUsagePercent(UsagePercent(player,team));
		return player_new;
	}
	
	private TeamStats_new getHomeTeamStats(){
		TeamStats_new team=new TeamStats_new();
		team.setSeason(match.season());
		team.setDate(match.date());
		team.setTeam(match.homeTeam());
		ArrayList<String> player=new ArrayList<String>();
		ArrayList<PlayerStatsPO> players=match.team1Players();
		for(PlayerStatsPO name:players){
			player.add(name.name());
		}
		team.setPlayers(player);
		team.setBasic(getHomeTeamBasicStats());
		team.setAdvanced(getTeamAdvancedStats(getHomeTeamBasicStats(),getGuestTeamBasicStats()));
		return team;
	}
	
	private TeamStats_new getGuestTeamStats(){
		TeamStats_new team=new TeamStats_new();
		team.setSeason(match.season());
		team.setDate(match.date());
		team.setTeam(match.guestTeam());
		ArrayList<String> player=new ArrayList<String>();
		ArrayList<PlayerStatsPO> players=match.team2Players();
		for(PlayerStatsPO name:players){
			player.add(name.name());
		}
		team.setPlayers(player);
		team.setBasic(getGuestTeamBasicStats());
		team.setAdvanced(getTeamAdvancedStats(getGuestTeamBasicStats(),getHomeTeamBasicStats()));
		return team;
	}
	
	private TeamBasicStats_new getHomeTeamBasicStats(){
		TeamBasicStats_new team=new TeamBasicStats_new();
		boolean win=false;                                   
		Double fieldGoalsMade=0.0;                          
		Double fieldGoalsAttempted=0.0;              		
		Double threePointFieldGoalsMade=0.0;        		
		Double threePointFieldGoalsAttempted=0.0;    		
		Double freeThrowsMade=0.0;                   		
		Double freeThrowsAttempted=0.0;              	
		Double offensiveRebounds=0.0;                		
		Double defensiveRebounds=0.0;                		
		Double rebounds=0.0;                         	
		Double assists=0.0;                          		
		Double steals=0.0;                           		
		Double blocks=0.0;                           		
		Double turnovers=0.0;                        	
		Double fouls=0.0;                            	
		Double points=0.0;
		String[] point=match.score().split("-");
		if(point[0].compareTo(point[1])>=0){
			win=true;
		}
		ArrayList<PlayerStatsPO> team1player=match.team1Players();
		for(PlayerStatsPO playerpo:team1player){
			fieldGoalsMade=fieldGoalsMade+playerpo.fieldGoalsMade();                          
			fieldGoalsAttempted=fieldGoalsAttempted+playerpo.fieldGoalsAttempted();              		
			threePointFieldGoalsMade=threePointFieldGoalsMade+playerpo.threePointFieldGoalsMade();        		
			threePointFieldGoalsAttempted=threePointFieldGoalsAttempted+playerpo.threePointFieldGoalsAttempted();    		
			freeThrowsMade=freeThrowsMade+playerpo.freeThrowsMade();                   		
			freeThrowsAttempted=freeThrowsAttempted+playerpo.freeThrowsAttempted();              	
			offensiveRebounds=offensiveRebounds+playerpo.offensiveRebounds();                		
			defensiveRebounds=defensiveRebounds+playerpo.defensiveRebounds();                		
			rebounds=rebounds+playerpo.rebounds();                         	
			assists=assists+playerpo.assists();                          		
			steals=steals+playerpo.steals();                           		
			blocks=blocks+playerpo.blocks();                           		
			turnovers=turnovers+playerpo.turnovers();                        	
			fouls=fouls+playerpo.personalFouls();                            	
			points=points+playerpo.points();
		}
		team.setWin(win);
		team.setFieldGoalsMade(fieldGoalsMade);
		team.setFieldGoalsAttempted(fieldGoalsAttempted);
		team.setThreePointFieldGoalsMade(threePointFieldGoalsMade);
		team.setThreePointFieldGoalsAttempted(threePointFieldGoalsAttempted);
		team.setFreeThrowsMade(freeThrowsMade);
		team.setFreeThrowsAttempted(freeThrowsAttempted);
		team.setOffensiveRebounds(offensiveRebounds);
		team.setDefensiveRebounds(defensiveRebounds);
		team.setRebounds(rebounds);
		team.setAssists(assists);
		team.setSteals(steals);
		team.setBlocks(blocks);
		team.setFouls(fouls);
		team.setPoints(points);
		return team;
	}
	
	private TeamBasicStats_new getGuestTeamBasicStats(){
		TeamBasicStats_new team=new TeamBasicStats_new();
		boolean win=false;                                   
		Double fieldGoalsMade=0.0;                          
		Double fieldGoalsAttempted=0.0;              		
		Double threePointFieldGoalsMade=0.0;        		
		Double threePointFieldGoalsAttempted=0.0;    		
		Double freeThrowsMade=0.0;                   		
		Double freeThrowsAttempted=0.0;              	
		Double offensiveRebounds=0.0;                		
		Double defensiveRebounds=0.0;                		
		Double rebounds=0.0;                         	
		Double assists=0.0;                          		
		Double steals=0.0;                           		
		Double blocks=0.0;                           		
		Double turnovers=0.0;                        	
		Double fouls=0.0;                            	
		Double points=0.0;
		String[] point=match.score().split("-");
		if(point[0].compareTo(point[1])<0){
			win=true;
		}
		ArrayList<PlayerStatsPO> team2player=match.team1Players();
		for(PlayerStatsPO playerpo:team2player){
			fieldGoalsMade=fieldGoalsMade+playerpo.fieldGoalsMade();                          
			fieldGoalsAttempted=fieldGoalsAttempted+playerpo.fieldGoalsAttempted();              		
			threePointFieldGoalsMade=threePointFieldGoalsMade+playerpo.threePointFieldGoalsMade();        		
			threePointFieldGoalsAttempted=threePointFieldGoalsAttempted+playerpo.threePointFieldGoalsAttempted();    		
			freeThrowsMade=freeThrowsMade+playerpo.freeThrowsMade();                   		
			freeThrowsAttempted=freeThrowsAttempted+playerpo.freeThrowsAttempted();              	
			offensiveRebounds=offensiveRebounds+playerpo.offensiveRebounds();                		
			defensiveRebounds=defensiveRebounds+playerpo.defensiveRebounds();                		
			rebounds=rebounds+playerpo.rebounds();                         	
			assists=assists+playerpo.assists();                          		
			steals=steals+playerpo.steals();                           		
			blocks=blocks+playerpo.blocks();                           		
			turnovers=turnovers+playerpo.turnovers();                        	
			fouls=fouls+playerpo.personalFouls();                            	
			points=points+playerpo.points();
		}
		team.setWin(win);
		team.setFieldGoalsMade(fieldGoalsMade);
		team.setFieldGoalsAttempted(fieldGoalsAttempted);
		team.setThreePointFieldGoalsMade(threePointFieldGoalsMade);
		team.setThreePointFieldGoalsAttempted(threePointFieldGoalsAttempted);
		team.setFreeThrowsMade(freeThrowsMade);
		team.setFreeThrowsAttempted(freeThrowsAttempted);
		team.setOffensiveRebounds(offensiveRebounds);
		team.setDefensiveRebounds(defensiveRebounds);
		team.setRebounds(rebounds);
		team.setAssists(assists);
		team.setSteals(steals);
		team.setBlocks(blocks);
		team.setFouls(fouls);
		team.setPoints(points);
		return team;
	}
	
	private TeamAdvancedStats_new getTeamAdvancedStats(TeamBasicStats_new hostteam,TeamBasicStats_new guestteam){
		TeamAdvancedStats_new advanced=new TeamAdvancedStats_new();
		advanced.setWinningRate(WinningRate(hostteam));
		advanced.setOffensiveRounds(OffensiveRounds(hostteam,guestteam));
		advanced.setDefensiveRounds(OffensiveRounds(guestteam,hostteam));
		advanced.setOffensiveEfficiency(OffensiveEfficiency(hostteam,guestteam));
		advanced.setDefensiveEfficiency(DefensiveEfficiency(hostteam,guestteam));
		advanced.setOffensiveReboudnsEfficiency(OffensiveReboudnsEfficiency(hostteam,guestteam));
		advanced.setDefensiveReboundsEfficiency(DefensiveReboundsEfficiency(hostteam,guestteam));
		advanced.setStealsEfficiency(StealsEfficiency(hostteam,guestteam));
		advanced.setAssistsEfficiency(AssistsEfficiency(hostteam,guestteam));
		return advanced;
	}
	
    private boolean IsDoubleDouble(PlayerBasicStats_new player){
    	boolean isDoubleDouble=false;
    	ArrayList<Double> doubles=new ArrayList<Double>();
		doubles.add(player.getAssists());
		doubles.add(player.getRebounds());
		doubles.add(player.getBlocks());
		doubles.add(player.getSteals());
		int count=0;
		for(double i:doubles){
			if(i>=10){
				count=count+1;
			}
		}
		if(count>=2){
			isDoubleDouble=true;
		}
    	return isDoubleDouble;
    }
    
    private Double HitRate(PlayerBasicStats_new player){
    	Double hitRate=0.0;
    	if(player.getFieldGoalsAttempted()==0){
    		return null;
    	}else{
    		hitRate=player.getFieldGoalsMade()/player.getFieldGoalsAttempted();
        	return hitRate;
    	}
    }
    
    private Double Rebounds(PlayerBasicStats_new player){
    	Double rebounds=0.0;
    	rebounds=player.getOffensiveRebounds()+player.getDefensiveRebounds();
    	return rebounds;
    }
    
    private Double PlayerEfficiencyRating(PlayerBasicStats_new player){
    	Double playerEfficiencyRating=0.0;
    	playerEfficiencyRating=player.getAssists()+player.getBlocks()+player.getRebounds()+
    			player.getSteals()+player.getPoints()+player.getFieldGoalsMade()+
    			player.getFreeThrowsMade()-player.getFieldGoalsAttempted()-
    			player.getFreeThrowsAttempted()-player.getTurnovers();
    	return playerEfficiencyRating;
    }
    
    private Double Gmsc(PlayerBasicStats_new player){
    	Double gmsc=0.0;
    	gmsc=player.getPoints()+0.4*player.getFieldGoalsMade()-0.7*player.getFieldGoalsAttempted()
				-0.4*(player.getFreeThrowsAttempted()-player.getFreeThrowsMade())+0.7*player.getOffensiveRebounds()
				+0.3*player.getDefensiveRebounds()+player.getSteals()+0.7*player.getAssists()+0.7*player.getBlocks()
				-0.4*player.getPersonalFouls()-player.getTurnovers();
    	return gmsc;
    }
    
    private Double TrueScorePercent(PlayerBasicStats_new player){
    	Double trueScorePercent=0.0;
    	if(player.getFieldGoalsAttempted()+player.getFreeThrowsAttempted()==0){
    		return null;
    	}else{
    		trueScorePercent=player.getPoints()/(2*(player.getFieldGoalsAttempted()+0.44*player.getFreeThrowsAttempted()));
    		return trueScorePercent;
    	}
    }
    
    private Double FieldGoalsPercent(PlayerBasicStats_new player){
    	Double fieldGoalsPercent=0.0;
    	if(player.getFieldGoalsAttempted()==0){
    		return null;
    	}else{
    		fieldGoalsPercent=(player.getFieldGoalsMade()+0.5*player.getThreePointFieldGoalsMade())/player.getFieldGoalsAttempted();
    		return fieldGoalsPercent;
    	}
    }
    
    private Double Minutes_team(Teams team){
    	Double minutes_team=0.0;
    	ArrayList<PlayerStatsPO> team1player=match.team1Players();
		ArrayList<PlayerStatsPO> team2player=match.team2Players();
    	if(team==match.homeTeam()){
			for(PlayerStatsPO po:team1player){
				minutes_team=minutes_team+TypeTransform.str_to_minutes(po.minutes());
			}
		}else{
			for(PlayerStatsPO po:team2player){
				minutes_team=minutes_team+TypeTransform.str_to_minutes(po.minutes());
			}
		}
    	return minutes_team;
    }
    
    private Double ReboundsPercent(PlayerBasicStats_new player,Teams team){
    	Double reboundsPercent=0.0;
    	if(player.getMinutes()==0){
    		return null;
    	}else{
    		ArrayList<PlayerStatsPO> team1player=match.team1Players();
    		ArrayList<PlayerStatsPO> team2player=match.team2Players();
    		Double rebounds=0.0;
    		Double minutes_team=Minutes_team(team);
    		for(PlayerStatsPO po:team1player){
    			rebounds=rebounds+po.rebounds();
    		}
    		for(PlayerStatsPO po:team2player){
    			rebounds=rebounds+po.rebounds();
    		}
    		reboundsPercent=player.getRebounds()*minutes_team/5/player.getMinutes()/rebounds;
    		return reboundsPercent;
    	}
    }
    
    private Double OffensiveReboundsPercent(PlayerBasicStats_new player,Teams team){
    	Double offensiveReboundsPercent=0.0;
    	if(player.getMinutes()==0){
    		return null;
    	}else{
    		ArrayList<PlayerStatsPO> team1player=match.team1Players();
    		ArrayList<PlayerStatsPO> team2player=match.team2Players();
    		Double offensiverebounds=0.0;
    		Double minutes_team=Minutes_team(team);
    		for(PlayerStatsPO po:team1player){
    			offensiverebounds=offensiverebounds+po.offensiveRebounds();
    		}
    		for(PlayerStatsPO po:team2player){
    			offensiverebounds=offensiverebounds+po.offensiveRebounds();
    		}
    		offensiveReboundsPercent=player.getRebounds()*minutes_team/5/player.getMinutes()/offensiverebounds;
    		return offensiveReboundsPercent;
    	}
    }
    
    private Double DefensiveReboundsPercent(PlayerBasicStats_new player,Teams team){
    	Double defensiveReboundsPercent=0.0;
    	if(player.getMinutes()==0){
    		return null;
    	}else{
    		ArrayList<PlayerStatsPO> team1player=match.team1Players();
    		ArrayList<PlayerStatsPO> team2player=match.team2Players();
    		Double defensiverebounds=0.0;
    		Double minutes_team=Minutes_team(team);
    		for(PlayerStatsPO po:team1player){
    			defensiverebounds=defensiverebounds+po.defensiveRebounds();
    		}
    		for(PlayerStatsPO po:team2player){
    			defensiverebounds=defensiverebounds+po.defensiveRebounds();
    		}
    		defensiveReboundsPercent=player.getRebounds()*minutes_team/5/player.getMinutes()/defensiverebounds;
    		return defensiveReboundsPercent;
    	}
    }
    
    private Double AssistsPercent(PlayerBasicStats_new player,Teams team){
    	Double assistsPercent=0.0;
    	if(player.getMinutes()==0){
    		return null;
    	}else{
    		ArrayList<PlayerStatsPO> team1player=match.team1Players();
    		ArrayList<PlayerStatsPO> team2player=match.team2Players();
    		Double minutes_team=Minutes_team(team);
    		Integer fieldGoalsMade_teammate=0;
    		if(team==match.homeTeam()){
    			for(PlayerStatsPO play:team1player){
    				fieldGoalsMade_teammate=fieldGoalsMade_teammate+play.fieldGoalsMade();
    			}
    		}else{
    			for(PlayerStatsPO play:team2player){
    				fieldGoalsMade_teammate=fieldGoalsMade_teammate+play.fieldGoalsMade();
    			}
    		}
    		assistsPercent=player.getAssists()/(player.getMinutes()/(minutes_team/5)*fieldGoalsMade_teammate-player.getFieldGoalsMade());
    		return assistsPercent;
    	}
    }
    
    private Double StealsPercent(PlayerBasicStats_new player,Teams team){
    	Double stealsPercent=0.0;
    	if(player.getMinutes()==0){
    		return null;
    	}else{
    		ArrayList<PlayerStatsPO> team1player=match.team1Players();
    		ArrayList<PlayerStatsPO> team2player=match.team2Players();
    		Double minutes_team=Minutes_team(team);
    		Double fieldGoalsAttempted_opponent=0.0;
    		if(team==match.homeTeam()){
    			for(PlayerStatsPO play:team2player){
    				fieldGoalsAttempted_opponent=fieldGoalsAttempted_opponent+play.fieldGoalsAttempted();
    			}
    		}else{
    			for(PlayerStatsPO play:team1player){
    				fieldGoalsAttempted_opponent=fieldGoalsAttempted_opponent+play.fieldGoalsAttempted();
    			}
    		}
    		stealsPercent=player.getSteals()*(minutes_team/5)/player.getMinutes()/fieldGoalsAttempted_opponent;
    		return stealsPercent;
    	}
    }
    
    private Double BlockPercent(PlayerBasicStats_new player,Teams team){
    	Double blockPercent=0.0;
    	if(player.getMinutes()==0){
    		return null;
    	}else{
    		ArrayList<PlayerStatsPO> team1player=match.team1Players();
    		ArrayList<PlayerStatsPO> team2player=match.team2Players();
    		Double minutes_team=Minutes_team(team);
    		Double fieldGoalsAttempted_opponent=0.0;
    		if(team==match.homeTeam()){
    			for(PlayerStatsPO play:team2player){
    				fieldGoalsAttempted_opponent=fieldGoalsAttempted_opponent+play.fieldGoalsAttempted();
    			}
    		}else{
    			for(PlayerStatsPO play:team1player){
    				fieldGoalsAttempted_opponent=fieldGoalsAttempted_opponent+play.fieldGoalsAttempted();
    			}
    		}
    		blockPercent=player.getBlocks()*(minutes_team/5)/player.getMinutes()/fieldGoalsAttempted_opponent;
    		return blockPercent;
    	}
    }
    
    private Double TurnoversPercent(PlayerBasicStats_new player){
    	Double turnoversPercent=0.0;
    	if(player.getFieldGoalsAttempted()+player.getFreeThrowsAttempted()+player.getTurnovers()==0){
    		return null;
    	}else{
    		turnoversPercent=player.getTurnovers()/(player.getFieldGoalsAttempted()+0.44*player.getFreeThrowsAttempted()+player.getTurnovers());
    		return turnoversPercent;
    	}
    }
    
    private Double UsagePercent(PlayerBasicStats_new player,Teams team){
    	Double usagePercent=0.0;
    	if(player.getMinutes()==0){
    		return null;
    	}else{
    		ArrayList<PlayerStatsPO> team1player=match.team1Players();
    		ArrayList<PlayerStatsPO> team2player=match.team2Players();
    		Double minutes_team=Minutes_team(team);
    		Double fieldGoalsAttempted_teammate=0.0;
    		Double freeThrowsAttempted_teammate=0.0;
    		Double turnovers_teammate=0.0;
    		if(team==match.homeTeam()){
    			for(PlayerStatsPO play:team1player){
    				fieldGoalsAttempted_teammate=fieldGoalsAttempted_teammate+play.fieldGoalsAttempted();
    				freeThrowsAttempted_teammate=freeThrowsAttempted_teammate+play.freeThrowsAttempted();
    				turnovers_teammate=turnovers_teammate+play.turnovers();
    			}
    		}else{
    			for(PlayerStatsPO play:team2player){
    				fieldGoalsAttempted_teammate=fieldGoalsAttempted_teammate+play.fieldGoalsAttempted();
    				freeThrowsAttempted_teammate=freeThrowsAttempted_teammate+play.freeThrowsAttempted();
    				turnovers_teammate=turnovers_teammate+play.turnovers();
    			}
    		}
    		usagePercent=(player.getFieldGoalsAttempted()+player.getThreePointFieldGoalsAttempted()
					+0.44*player.getFreeThrowsAttempted()+player.getTurnovers())*
					(minutes_team/5)/player.getMinutes()/(fieldGoalsAttempted_teammate
					+0.44*freeThrowsAttempted_teammate+turnovers_teammate);
    		return usagePercent;
    	}
    }
    
    private Double WinningRate(TeamBasicStats_new team){
    	Double winningRate=0.0;
    	if(team.isWin()){
    		winningRate=1.0;
    	}
    	return winningRate;
    }
    
    private Double OffensiveRounds(TeamBasicStats_new hostteam,TeamBasicStats_new guestteam){
    	Double offensiveRounds=0.0;
    	offensiveRounds=hostteam.getFieldGoalsAttempted()+0.4*hostteam.getFreeThrowsAttempted()-
				1.07*(hostteam.getOffensiveRebounds()/(hostteam.getOffensiveRebounds()+
					    guestteam.getDefensiveRebounds())*(hostteam.getFieldGoalsAttempted()-
							hostteam.getFieldGoalsMade()))+1.07*hostteam.getTurnovers();
    	return offensiveRounds;
    }
    
    private Double OffensiveEfficiency(TeamBasicStats_new hostteam,TeamBasicStats_new guestteam){
    	Double offensiveEfficiency=0.0;
    	offensiveEfficiency=hostteam.getPoints()/OffensiveRounds(hostteam,guestteam)*100;
    	return offensiveEfficiency;
    }
    
    private Double DefensiveEfficiency(TeamBasicStats_new hostteam,TeamBasicStats_new guestteam){
    	Double defensiveEfficiency=0.0;
    	defensiveEfficiency=guestteam.getPoints()/OffensiveRounds(guestteam,hostteam)*100;
    	return defensiveEfficiency;
    }
    
    private Double OffensiveReboudnsEfficiency(TeamBasicStats_new hostteam,TeamBasicStats_new guestteam){
    	Double offensiveReboudnsEfficiency=hostteam.getOffensiveRebounds()/(hostteam.getOffensiveRebounds()+guestteam.getDefensiveRebounds());
    	return offensiveReboudnsEfficiency;
    }
    
    private Double DefensiveReboundsEfficiency(TeamBasicStats_new hostteam,TeamBasicStats_new guestteam){
    	Double defensiveReboundsEfficiency=hostteam.getDefensiveRebounds()/(hostteam.getDefensiveRebounds()+guestteam.getOffensiveRebounds());
    	return defensiveReboundsEfficiency;
    }
    
    private Double StealsEfficiency(TeamBasicStats_new hostteam,TeamBasicStats_new guestteam){
    	Double stealsEfficiency=hostteam.getSteals()*100/OffensiveRounds(guestteam,hostteam);
    	return stealsEfficiency;
    }
    
    private Double AssistsEfficiency(TeamBasicStats_new hostteam,TeamBasicStats_new guestteam){
    	Double assistsEfficiency=hostteam.getAssists()*100/OffensiveRounds(hostteam,guestteam);
        return assistsEfficiency;
    }
}
