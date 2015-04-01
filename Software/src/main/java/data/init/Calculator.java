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
	//杈撳叆涓�満姣旇禌鐨勬墍鏈夋暟鎹紝鑾峰彇鎵�湁闃熶紞鍜岀悆鍛樻暟鎹�
	MatchPO match;
	Double minutes_hometeam;
	Double minutes_guestteam;
	Double offensiveRebounds_hometeam;
	Double defensiveRebounds_hometeam;
	Double offensiveRebounds_guestteam;
	Double defensiveRebounds_guestteam;
	Double fieldGoalsMade_hometeam;
	Double fieldGoalsMade_guestteam;
	Double fieldGoalsAttempted_hometeam;
	Double fieldGoalsAttempted_guestteam;
	Double twoPointFieldGoalsAttempted_hometeam;
	Double twoPointFieldGoalsAttempted_guestteam;
	Double freeThrowsAttempted_hometeam;
	Double freeThrowsAttempted_guestteam;
	Double turnovers_hometeam;
	Double turnovers_guestteam;
	
	public Calculator(MatchPO match) {
		this.match = match;
		this.minutes_hometeam=0.0;
		this.minutes_guestteam=0.0;
		this.offensiveRebounds_hometeam=0.0;
		this.defensiveRebounds_hometeam=0.0;
		this.offensiveRebounds_guestteam=0.0;
		this.defensiveRebounds_guestteam=0.0;
		this.fieldGoalsMade_hometeam=0.0;
		this.fieldGoalsMade_guestteam=0.0;
		this.fieldGoalsAttempted_hometeam=0.0;
		this.fieldGoalsAttempted_guestteam=0.0;
		this.twoPointFieldGoalsAttempted_hometeam=0.0;
		this.twoPointFieldGoalsAttempted_guestteam=0.0;
		this.freeThrowsAttempted_hometeam=0.0;
		this.freeThrowsAttempted_guestteam=0.0;
		this.turnovers_hometeam=0.0;
		this.turnovers_guestteam=0.0;
		ArrayList<PlayerStatsPO> team1player=match.team1Players();
		ArrayList<PlayerStatsPO> team2player=match.team2Players();
		for(PlayerStatsPO player1:team1player){
			minutes_hometeam=minutes_hometeam+TypeTransform.str_to_minutes(player1.minutes());
			offensiveRebounds_hometeam=offensiveRebounds_hometeam+player1.offensiveRebounds();
			defensiveRebounds_hometeam=defensiveRebounds_hometeam+player1.defensiveRebounds();
			fieldGoalsMade_hometeam=fieldGoalsMade_hometeam+player1.fieldGoalsMade();
			fieldGoalsAttempted_hometeam=fieldGoalsAttempted_hometeam+player1.fieldGoalsAttempted();
			twoPointFieldGoalsAttempted_hometeam=twoPointFieldGoalsAttempted_hometeam+player1.fieldGoalsAttempted()-player1.threePointFieldGoalsAttempted();
			freeThrowsAttempted_hometeam=freeThrowsAttempted_hometeam+player1.fieldGoalsAttempted();
			turnovers_hometeam=turnovers_hometeam+player1.turnovers();
		}
		for(PlayerStatsPO player2:team2player){
			minutes_guestteam=minutes_guestteam+TypeTransform.str_to_minutes(player2.minutes());
			offensiveRebounds_guestteam=offensiveRebounds_guestteam+player2.offensiveRebounds();
			defensiveRebounds_guestteam=defensiveRebounds_guestteam+player2.defensiveRebounds();
			fieldGoalsMade_guestteam=fieldGoalsMade_guestteam+player2.fieldGoalsMade();
			fieldGoalsAttempted_guestteam=fieldGoalsAttempted_guestteam+player2.fieldGoalsAttempted();
			twoPointFieldGoalsAttempted_guestteam=twoPointFieldGoalsAttempted_guestteam+player2.fieldGoalsAttempted()-player2.threePointFieldGoalsAttempted();
			freeThrowsAttempted_guestteam=freeThrowsAttempted_guestteam+player2.fieldGoalsAttempted();
			turnovers_guestteam=turnovers_guestteam+player2.turnovers();
		}
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
		player_new.setIsDoubleDouble(isDoubleDouble(player));
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
		team.setTurnovers(turnovers);
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
		team.setTurnovers(turnovers);
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
	
	private boolean isDoubleDouble(PlayerStatsPO player){
    	boolean isDoubleDouble=false;
    	ArrayList<Integer> doubles=new ArrayList<Integer>();
    	doubles.add(player.points());
		doubles.add(player.assists());
		doubles.add(player.rebounds());
		doubles.add(player.blocks());
		doubles.add(player.steals());
		int count=0;
		for(Integer i:doubles){
			if(i>=10){
				count=count+1;
			}
		}
		if(count>=2){
			isDoubleDouble=true;
		}
    	return isDoubleDouble;
    }
	
    private boolean IsDoubleDouble(PlayerBasicStats_new player){
    	boolean isDoubleDouble=false;
    	ArrayList<Double> doubles=new ArrayList<Double>();
    	doubles.add(player.getPoints());
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
    
    private Double ReboundsPercent(PlayerBasicStats_new player,Teams team){
    	Double reboundsPercent=0.0;
    	if(player.getMinutes()==0){
    		return null;
    	}else{
    		Double rebounds=0.0;
    		Double minutes_team=0.0;
    		if(team==match.homeTeam()){
    			minutes_team=minutes_hometeam;
    		}else{
    			minutes_team=minutes_guestteam;
    		}
    		rebounds=offensiveRebounds_hometeam+defensiveRebounds_hometeam+offensiveRebounds_guestteam+defensiveRebounds_guestteam;
    		reboundsPercent=player.getRebounds()*minutes_team/5/player.getMinutes()/rebounds;
    		return reboundsPercent;
    	}
    }
    
    private Double OffensiveReboundsPercent(PlayerBasicStats_new player,Teams team){
    	Double offensiveReboundsPercent=0.0;
    	if(player.getMinutes()==0){
    		return null;
    	}else{
    		Double offensiverebounds=0.0;
    		Double minutes_team=0.0;
    		if(team==match.homeTeam()){
    			minutes_team=minutes_hometeam;
    		}else{
    			minutes_team=minutes_guestteam;
    		}
    		offensiverebounds=offensiveRebounds_hometeam+offensiveRebounds_guestteam;
    		offensiveReboundsPercent=player.getOffensiveRebounds()*minutes_team/5/player.getMinutes()/offensiverebounds;
    		return offensiveReboundsPercent;
    	}
    }
    
    private Double DefensiveReboundsPercent(PlayerBasicStats_new player,Teams team){
    	Double defensiveReboundsPercent=0.0;
    	if(player.getMinutes()==0){
    		return null;
    	}else{
    		Double defensiverebounds=0.0;
    		Double minutes_team=0.0;
    		if(team==match.homeTeam()){
    			minutes_team=minutes_hometeam;
    		}else{
    			minutes_team=minutes_guestteam;
    		}
    		defensiverebounds=defensiveRebounds_hometeam+defensiveRebounds_guestteam;
    		defensiveReboundsPercent=player.getDefensiveRebounds()*minutes_team/5/player.getMinutes()/defensiverebounds;
    		return defensiveReboundsPercent;
    	}
    }
    
    private Double AssistsPercent(PlayerBasicStats_new player,Teams team){
    	Double assistsPercent=0.0;
    	if(player.getMinutes()==0){
    		return null;
    	}else{
    		Double minutes_team=0.0;
    		Double fieldGoalsMade_teammate=0.0;
    		if(team==match.homeTeam()){
    			minutes_team=minutes_hometeam;
    			fieldGoalsMade_teammate= fieldGoalsMade_hometeam;
    		}else{
    			minutes_team=minutes_guestteam;
    			fieldGoalsMade_teammate= fieldGoalsMade_guestteam;
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
    		Double minutes_team=0.0;
    		Double fieldGoalsAttempted_opponent=0.0;
    		if(team==match.homeTeam()){
    			minutes_team=minutes_hometeam;
    			fieldGoalsAttempted_opponent=fieldGoalsAttempted_guestteam;
    		}else{
    			minutes_team=minutes_guestteam;
    			fieldGoalsAttempted_opponent=fieldGoalsAttempted_hometeam;
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
    		Double minutes_team=0.0;
    		Double twoPointFieldGoalsAttempted_opponent=0.0;
    		if(team==match.homeTeam()){
    			minutes_team=minutes_hometeam;
    			twoPointFieldGoalsAttempted_opponent=twoPointFieldGoalsAttempted_guestteam;
    		}else{
    			minutes_team=minutes_guestteam;
    			twoPointFieldGoalsAttempted_opponent=twoPointFieldGoalsAttempted_hometeam;
    		}
    		blockPercent=player.getBlocks()*(minutes_team/5)/player.getMinutes()/twoPointFieldGoalsAttempted_opponent;
    		return blockPercent;
    	}
    }
    
    private Double TurnoversPercent(PlayerBasicStats_new player){
    	Double turnoversPercent=0.0;
    	if(player.getFieldGoalsAttempted()-player.getThreePointFieldGoalsAttempted()+player.getFreeThrowsAttempted()+player.getTurnovers()==0){
    		return null;
    	}else{
    		turnoversPercent=player.getTurnovers()/(player.getFieldGoalsAttempted()-player.getThreePointFieldGoalsAttempted()+0.44*player.getFreeThrowsAttempted()+player.getTurnovers());
    		return turnoversPercent;
    	}
    }
    
    private Double UsagePercent(PlayerBasicStats_new player,Teams team){
    	Double usagePercent=0.0;
    	if(player.getMinutes()==0){
    		return null;
    	}else{
    		Double minutes_team=0.0;
    		Double fieldGoalsAttempted_teammate=0.0;
    		Double freeThrowsAttempted_teammate=0.0;
    		Double turnovers_teammate=0.0;
    		if(team==match.homeTeam()){
    			minutes_team=minutes_hometeam;
    			fieldGoalsAttempted_teammate=fieldGoalsAttempted_hometeam;
    			freeThrowsAttempted_teammate=freeThrowsAttempted_hometeam;
    			turnovers_teammate=turnovers_hometeam;
    		}else{
    			minutes_team=minutes_guestteam;
    			fieldGoalsAttempted_teammate=fieldGoalsAttempted_guestteam;
    			freeThrowsAttempted_teammate=freeThrowsAttempted_guestteam;
    			turnovers_teammate=turnovers_guestteam;
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