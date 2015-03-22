package factory;

import java.util.ArrayList;

import businessLogic.playersBL.AdvancedPlayerStats;
import businessLogic.playersBL.BasicPlayerStats;
import businessLogic.playersBL.PlayerStatsForCalculation;

public class PlayerCalculator {
	private ArrayList<PlayerStatsForCalculation> list;
	public PlayerCalculator(){
		
	}
	public PlayerCalculator(ArrayList<PlayerStatsForCalculation> list){
		this.list=list;
	}
	public AdvancedPlayerStats getAdvancedStatsTotal(){
		AdvancedPlayerStats advanced=new AdvancedPlayerStats();
		advanced.setName(list.get(0).player().name());
		advanced.setAverage(Averager(list));
		advanced.setDoubleDouble(DoubleDoubless());
		advanced.setHitRate(HitRates());
		advanced.setRebounds(Rebounds());
		advanced.setPlayerEfficiencyRating(PlayerEfficiencyRatings());
		advanced.setGmsc(Gmscs());
		advanced.setTrueScorePercent(TrueScorePercents());
		advanced.setFieldGoalsPercent(FieldGoalsPercents());
		advanced.setReboundsPercent(ReboundsPercents());
		advanced.setOffensiveReboundsPercent(OffensiveReboundsPercents());
		advanced.setDefensiveReboundsPercent(DefensiveReboundsPercents());
		advanced.setAssistsPercent(AssistsPercents());
		advanced.setStealsPercent(StealsPercents());
		advanced.setBlockPercent(BlockPercents());
		advanced.setTurnoversPercent(TurnoversPercents());
		advanced.setUsagePercent(UsagePercents());
		return advanced;
	}
	
	//两双计算 doubledoubles
	
	private Double DoubleDoubless(){
		Double doubledouble=0.00;
		for(PlayerStatsForCalculation player:list){
			ArrayList<Double> doubles=new ArrayList<Double>();
			doubles.add(player.player().assists());
			doubles.add(player.player().rebounds());
			doubles.add(player.player().blocks());
			doubles.add(player.player().steals());
			doubledouble=doubledouble+DoubleDoubles(doubles);
		}
		doubledouble=doubledouble/list.size();
		return doubledouble;
	}
	
	private Double DoubleDoubles(ArrayList<Double> point){
		Double doubledoubles=new Double(0);
		if(point.contains(null)){
			return null;
		}else{
			int count=0;
			for(double i:point){
				if(i>=0){
					count=count+1;
				}
			}
			if(count>=2){
				doubledoubles=1.0;
			}
		}
		return doubledoubles;
	}
	
	private BasicPlayerStats Averager(ArrayList<PlayerStatsForCalculation> list){
		Integer games=0;                        
		Integer gamesStarting=0;                                          
		Double minutes=0.00;                         
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
		Double personalFouls=0.00;                    
		Double points=0.00;
		for(PlayerStatsForCalculation player:list){
			games=games+player.player().games();
			gamesStarting=gamesStarting+player.player().gamesStarting();
			minutes=minutes+player.player().minutes();
			fieldGoalsMade=fieldGoalsMade+player.player().fieldGoalsMade();
			fieldGoalsAttempted=fieldGoalsAttempted+player.player().fieldGoalsAttempted();
			threePointFieldGoalsMade=threePointFieldGoalsMade+player.player().threePointFieldGoalsMade();
			threePointFieldGoalsAttempted=threePointFieldGoalsAttempted+player.player().threePointFieldGoalsAttempted();
			freeThrowsMade=freeThrowsMade+player.player().freeThrowsMade();
			freeThrowsAttempted=freeThrowsAttempted+player.player().freeThrowsAttempted();
			offensiveRebounds=offensiveRebounds+player.player().offensiveRebounds();
			defensiveRebounds=defensiveRebounds+player.player().defensiveRebounds();
			rebounds=rebounds+player.player().rebounds();
			assists=assists+player.player().assists();
			steals=steals+player.player().steals();
			blocks=blocks+player.player().blocks();
			turnovers=turnovers+player.player().turnovers();
			personalFouls=personalFouls+player.player().personalFouls();
			points=points+player.player().points();
		}
		BasicPlayerStats player=new BasicPlayerStats();
		int size=list.size();
		player.setTeam(list.get(0).player().team());
		player.setGames(games/size);
		player.setGamesStarting(gamesStarting/size);
		player.setMinutes(minutes/size);
		player.setFieldGoalsMade(fieldGoalsMade/size);
		player.setFieldGoalsAttempted(fieldGoalsAttempted/size);
		player.setThreePointFieldGoalsMade(threePointFieldGoalsMade/size);
		player.setThreePointFieldGoalsAttempted(threePointFieldGoalsAttempted/size);
		player.setFreeThrowsMade(freeThrowsMade/size);
		player.setFreeThrowsAttempted(freeThrowsAttempted/size);
		player.setOffensiveRebounds(offensiveRebounds/size);
		player.setDefensiveRebounds(defensiveRebounds/size);
		player.setRebounds(rebounds/size);
		player.setAssists(assists/size);
		player.setSteals(steals/size);
		player.setBlocks(blocks/size);
		player.setTurnovers(turnovers/size);
		player.setPersonalFouls(personalFouls/size);
		player.setPoints(points/size);
		return player;
	}
	
	public BasicPlayerStats Sum(ArrayList<BasicPlayerStats> list){
		String name="";
		Integer games=list.get(0).games();                     
		Integer gamesStarting=0;                                          
		Double minutes=0.00;                         
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
		Double personalFouls=0.00;                    
		Double points=0.00;
		for(BasicPlayerStats player:list){
			name=player.name();
			gamesStarting=gamesStarting+player.gamesStarting();
			minutes=minutes+player.minutes();
			fieldGoalsMade=fieldGoalsMade+player.fieldGoalsMade();
			fieldGoalsAttempted=fieldGoalsAttempted+player.fieldGoalsAttempted();
			threePointFieldGoalsMade=threePointFieldGoalsMade+player.threePointFieldGoalsMade();
			threePointFieldGoalsAttempted=threePointFieldGoalsAttempted+player.threePointFieldGoalsAttempted();
			freeThrowsMade=freeThrowsMade+player.freeThrowsMade();
			freeThrowsAttempted=freeThrowsAttempted+player.freeThrowsAttempted();
			offensiveRebounds=offensiveRebounds+player.offensiveRebounds();
			defensiveRebounds=defensiveRebounds+player.defensiveRebounds();
			rebounds=rebounds+player.rebounds();
			assists=assists+player.assists();
			steals=steals+player.steals();
			blocks=blocks+player.blocks();
			turnovers=turnovers+player.turnovers();
			personalFouls=personalFouls+player.personalFouls();
			points=points+player.points();
		}
		BasicPlayerStats player=new BasicPlayerStats();
		player.setName(name);
		player.setGames(games);
		player.setGamesStarting(gamesStarting);
		player.setMinutes(minutes);
		player.setFieldGoalsMade(fieldGoalsMade);
		player.setFieldGoalsAttempted(fieldGoalsAttempted);
		player.setThreePointFieldGoalsMade(threePointFieldGoalsMade);
		player.setThreePointFieldGoalsAttempted(threePointFieldGoalsAttempted);
		player.setFreeThrowsMade(freeThrowsMade);
		player.setFreeThrowsAttempted(freeThrowsAttempted);
		player.setOffensiveRebounds(offensiveRebounds);
		player.setDefensiveRebounds(defensiveRebounds);
		player.setRebounds(rebounds);
		player.setAssists(assists);
		player.setSteals(steals);
		player.setBlocks(blocks);
		player.setTurnovers(turnovers);
		player.setPersonalFouls(personalFouls);
		player.setPoints(points);
		return player;
	}
	
	public BasicPlayerStats Average(ArrayList<BasicPlayerStats> list){
		String name="";
		Integer games=list.get(0).games();
		Integer gamesStarting=0;                                          
		Double minutes=0.00;                         
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
		Double personalFouls=0.00;                    
		Double points=0.00;
		for(BasicPlayerStats player:list){
			name=player.name();
			gamesStarting=gamesStarting+player.gamesStarting();
			minutes=minutes+player.minutes();
			fieldGoalsMade=fieldGoalsMade+player.fieldGoalsMade();
			fieldGoalsAttempted=fieldGoalsAttempted+player.fieldGoalsAttempted();
			threePointFieldGoalsMade=threePointFieldGoalsMade+player.threePointFieldGoalsMade();
			threePointFieldGoalsAttempted=threePointFieldGoalsAttempted+player.threePointFieldGoalsAttempted();
			freeThrowsMade=freeThrowsMade+player.freeThrowsMade();
			freeThrowsAttempted=freeThrowsAttempted+player.freeThrowsAttempted();
			offensiveRebounds=offensiveRebounds+player.offensiveRebounds();
			defensiveRebounds=defensiveRebounds+player.defensiveRebounds();
			rebounds=rebounds+player.rebounds();
			assists=assists+player.assists();
			steals=steals+player.steals();
			blocks=blocks+player.blocks();
			turnovers=turnovers+player.turnovers();
			personalFouls=personalFouls+player.personalFouls();
			points=points+player.points();
		}
		BasicPlayerStats player=new BasicPlayerStats();
		int size=list.size();
		player.setTeam(list.get(0).team());
		player.setName(name);
		player.setGames(games);
		player.setGamesStarting(gamesStarting/size);
		player.setMinutes(minutes/size);
		player.setFieldGoalsMade(fieldGoalsMade/size);
		player.setFieldGoalsAttempted(fieldGoalsAttempted/size);
		player.setThreePointFieldGoalsMade(threePointFieldGoalsMade/size);
		player.setThreePointFieldGoalsAttempted(threePointFieldGoalsAttempted/size);
		player.setFreeThrowsMade(freeThrowsMade/size);
		player.setFreeThrowsAttempted(freeThrowsAttempted/size);
		player.setOffensiveRebounds(offensiveRebounds/size);
		player.setDefensiveRebounds(defensiveRebounds/size);
		player.setRebounds(rebounds/size);
		player.setAssists(assists/size);
		player.setSteals(steals/size);
		player.setBlocks(blocks/size);
		player.setTurnovers(turnovers/size);
		player.setPersonalFouls(personalFouls/size);
		player.setPoints(points/size);
		return player;
	}
	
	//命中率计算  hitRate
	
	private Double HitRates(){
		Double hitRate=0.00;
		int size=0;
		for(PlayerStatsForCalculation player:list){
			BasicPlayerStats basic=player.player();
			if(basic.fieldGoalsAttempted()!=0){
				hitRate=hitRate+HitRate(basic.fieldGoalsMade(),basic.fieldGoalsAttempted());
				size++;
			}
		}
		hitRate=hitRate/size;
		return hitRate;
	}
	
	private Double HitRate(Double fieldGoalsMade,Double fieldGoalsAttempted){
		if(fieldGoalsMade==null||fieldGoalsAttempted==null){
			return null;
		}else{
			Double hitRate=fieldGoalsMade/fieldGoalsAttempted;
			return hitRate;
		}
	}
	
	//篮板计算 Rebounds
	private Double Rebounds(){
		Double rebounds=0.0;
		for(PlayerStatsForCalculation player:list){
			BasicPlayerStats basic=player.player();
			rebounds=rebounds+basic.offensiveRebounds()+basic.defensiveRebounds();
		}
		rebounds=rebounds/list.size();
		return rebounds;
	}
	
	
	//效率计算  playerEfficiencyRating
	
	private Double PlayerEfficiencyRatings(){
		Double playerEfficiencyRating=0.0;
		for(PlayerStatsForCalculation player:list){
			BasicPlayerStats basic=player.player();
			ArrayList<Double> doubles=new ArrayList<Double>();
			doubles.add(player.player().assists());
			doubles.add(player.player().rebounds());
			doubles.add(player.player().blocks());
			doubles.add(player.player().steals());
			doubles.add(basic.points());
			playerEfficiencyRating=playerEfficiencyRating+PlayerEfficiencyRating(doubles,basic.fieldGoalsAttempted(),basic.fieldGoalsMade(),basic.freeThrowsAttempted(),basic.fieldGoalsMade(),basic.turnovers());
		}
		playerEfficiencyRating=playerEfficiencyRating/list.size();
		return playerEfficiencyRating;
	}
	
	private Double PlayerEfficiencyRating(ArrayList<Double> point,Double fieldGoalsAttempted,Double fieldGoalsMade,
			Double freeThrowsAttempted,Double freeThrowsMade,Double turnovers){
		Double playerEfficiencyRating=0.0;
		if(point.contains(null)){
			return null;
		}
		if(fieldGoalsAttempted==null||fieldGoalsMade==null||freeThrowsAttempted==null||
				freeThrowsMade==null||turnovers==null){
			return null;
		}
		for(Double i:point){
			playerEfficiencyRating=playerEfficiencyRating+i;
		}
		playerEfficiencyRating=playerEfficiencyRating+fieldGoalsMade+freeThrowsMade-
				fieldGoalsAttempted-freeThrowsAttempted-turnovers;
		return playerEfficiencyRating;
	}
	
	//真得分计算  Gmsc
	
	private Double Gmscs(){
		Double Gmsc=0.00;
		for(PlayerStatsForCalculation player:list){
			BasicPlayerStats basic=player.player();
			Gmsc=Gmsc+Gmsc(basic);
		}
		Gmsc=Gmsc/list.size();
		return Gmsc;
	}
	
	private Double Gmsc(BasicPlayerStats basic){
		Double Gmsc=0.0;
		try{
			Gmsc=basic.points()+0.4*basic.fieldGoalsMade()-0.7*basic.fieldGoalsAttempted()
					-0.4*(basic.freeThrowsAttempted()-basic.freeThrowsMade())+0.7*basic.offensiveRebounds()
					+0.3*basic.defensiveRebounds()+basic.steals()+0.7*basic.assists()+0.7*basic.blocks()
					-0.4*basic.personalFouls()-basic.turnovers();
		}catch(Exception e){
			return null;
		}
		return Gmsc;
	}
	
	//真实投篮命中率计算   trueScorePercent
	
	private Double TrueScorePercents(){
		Double trueScorePercent=0.00;
		int size=0;
		for(PlayerStatsForCalculation player:list){
			BasicPlayerStats basic=player.player();
			if(basic.fieldGoalsAttempted()+basic.freeThrowsAttempted()!=0){
				trueScorePercent=trueScorePercent+TrueScorePercent(basic.points(),basic.fieldGoalsAttempted(),basic.freeThrowsAttempted());
				size++;
			}
		}
		trueScorePercent=trueScorePercent/size;
		return trueScorePercent;
	}
	
	private Double TrueScorePercent(Double point,Double fieldGoalsAttempted,Double freeThrowsAttempted){
		try{
			Double trueScorePercent=point/(2*(fieldGoalsAttempted+0.44*freeThrowsAttempted));
			return trueScorePercent;
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}
	
	//投篮效率计算  fieldGoalsPercent
	
	private Double FieldGoalsPercents(){
		Double fieldGoalsPercent=0.00;
		int size=0;
		for(PlayerStatsForCalculation player:list){
			BasicPlayerStats basic=player.player();
			if(basic.fieldGoalsAttempted()!=0){
				fieldGoalsPercent=fieldGoalsPercent+FieldGoalsPercent(basic.fieldGoalsMade(),basic.threePointFieldGoalsMade(),basic.fieldGoalsAttempted());
				size++;
			}
		}
		fieldGoalsPercent=fieldGoalsPercent/size;
		return fieldGoalsPercent;
	}
	
	private Double FieldGoalsPercent(Double fieldGoalsMade,Double threePointFieldGoalsMade,Double fieldGoalsAttempted){
		try{
			Double fieldGoalsPercent=(fieldGoalsMade+0.5*threePointFieldGoalsMade)/fieldGoalsAttempted;
			return fieldGoalsPercent;
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}
	
	//篮板率计算  reboundsPercent
	
	private Double ReboundsPercents(){
		Double reboundsPercent=0.0;
		int size=0;
		for(PlayerStatsForCalculation player:list){
			BasicPlayerStats basic=player.player();
			if(basic.minutes()!=0){
				reboundsPercent=reboundsPercent+ReboundsPercent(basic.rebounds(),player.minutes_teammate(),basic.minutes(),player.offensiveRebounds_teammate(),player.defensiveRebounds_teammate(),player.offensiveRebounds_opponent(),player.defensiveRebounds_opponent());
				size++;
			}
		}
		reboundsPercent=reboundsPercent/size;
		return reboundsPercent;
	}
	
	private Double OffensiveReboundsPercents(){
		Double offensiveReboundsPercent=0.0;
		int size=0;
		for(PlayerStatsForCalculation player:list){
			BasicPlayerStats basic=player.player();
			if(basic.minutes()!=0){
				offensiveReboundsPercent=offensiveReboundsPercent+ReboundsPercent(basic.offensiveRebounds(),player.minutes_teammate(),basic.minutes(),player.offensiveRebounds_teammate(),player.defensiveRebounds_teammate(),player.offensiveRebounds_opponent(),player.defensiveRebounds_opponent());
				size++;
			}
		}
		offensiveReboundsPercent=offensiveReboundsPercent/size;
		return offensiveReboundsPercent;
	}
	
	private Double DefensiveReboundsPercents(){
		Double defensiveReboundsPercent=0.0;
		int size=0;
		for(PlayerStatsForCalculation player:list){
			BasicPlayerStats basic=player.player();
			if(basic.minutes()!=0){
				defensiveReboundsPercent=defensiveReboundsPercent+ReboundsPercent(basic.defensiveRebounds(),player.minutes_teammate(),basic.minutes(),player.offensiveRebounds_teammate(),player.defensiveRebounds_teammate(),player.offensiveRebounds_opponent(),player.defensiveRebounds_opponent());
				size++;
			}
		}
		defensiveReboundsPercent=defensiveReboundsPercent/size;
		return defensiveReboundsPercent;
	}
	
	private Double ReboundsPercent (Double rebounds,Double minutes_teammate,Double minutes,
			Integer offensiveRebounds_teammate,Integer defensiveRebounds_teammate,
	        Integer offensiveRebounds_opponent,Integer defensiveRebounds_opponent){
		try{
			Double reboundsPercent=rebounds*minutes_teammate/5/minutes
					/(offensiveRebounds_teammate+defensiveRebounds_teammate+
							offensiveRebounds_opponent+defensiveRebounds_opponent);
			return reboundsPercent;
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}
	
	//助攻率计算  assistsPercent
	
	private Double AssistsPercents(){
		Double assistsPercent=0.00;
		int size=0;
		for(PlayerStatsForCalculation player:list){
			BasicPlayerStats basic=player.player();
			if(basic.minutes()!=0){
				assistsPercent=assistsPercent+AssistsPercent(basic.assists(),basic.minutes(),player.minutes_teammate(),player.fieldGoalsMade_teammate(),basic.fieldGoalsMade());
                size++;
			}		
		}
		assistsPercent=assistsPercent/size;
		return assistsPercent;
	}
	
	private Double AssistsPercent(Double assists,Double minutes,Double minutes_teammate,
			Integer fieldGoalsMade_teammate,Double fieldGoalsMade){
		try{
			Double assistsPercent=assists/(minutes/(minutes_teammate/5)*fieldGoalsMade_teammate-fieldGoalsMade);
			return assistsPercent;
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}
	
	//抢断率计算  stealsPercent
	
	private Double StealsPercents(){
		Double stealsPercent=0.0;
		int size=0;
		for(PlayerStatsForCalculation player:list){
			BasicPlayerStats basic=player.player();
			if(basic.minutes()!=0){
				stealsPercent=stealsPercent+StealsPercent(basic.steals(),basic.minutes(),player.minutes_teammate(),player.fieldGoalsAttempted_opponent());
				size++;
			}
		}
		stealsPercent=stealsPercent/size;
		return stealsPercent;
	}
	
	private Double StealsPercent(Double steals,Double minutes,Double minutes_teammate,Integer fieldGoalsAttempted_opponent){
		try{
			Double stealsPercent=steals*(minutes_teammate/5)/minutes/fieldGoalsAttempted_opponent;
			return stealsPercent;
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}
	
	//盖帽率计算   blockPercent
	
	private Double BlockPercents(){
		Double blockPercent=0.00;
		int size=0;
		for(PlayerStatsForCalculation player:list){
			BasicPlayerStats basic=player.player();
			if(basic.minutes()!=0){
				blockPercent=blockPercent+BlockPercent(basic.blocks(),basic.minutes(),player.minutes_teammate(),player.fieldGoalsAttempted_opponent());
				size++;
			}
		}
		blockPercent=blockPercent/size;
		return blockPercent;
	}
	
	private Double BlockPercent(Double block,Double minutes,Double minutes_teammate,Integer fieldGoalsAttempted_opponent){
		try{
			Double blockPercent=block*(minutes_teammate/5)/minutes/fieldGoalsAttempted_opponent;
			return blockPercent;
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}
	
	//失误率计算   turnoversPercent
	
	private Double TurnoversPercents(){
		Double turnoversPercent=0.00;
		int size=0;
		for(PlayerStatsForCalculation player:list){
			BasicPlayerStats basic=player.player();
			if(basic.fieldGoalsAttempted()+basic.freeThrowsAttempted()+basic.turnovers()!=0){
				turnoversPercent=turnoversPercent+TurnoversPercent(basic.turnovers(),basic.fieldGoalsAttempted(),basic.freeThrowsAttempted());
				size++;
			}
		}
		turnoversPercent=turnoversPercent/size;
		return turnoversPercent;
	}
	
	private Double TurnoversPercent(Double turnovers,Double fieldGoalsAttempted,Double freeThrowsAttempted){
		try{
			Double turnoversPercent=turnovers/(fieldGoalsAttempted+0.44*freeThrowsAttempted+turnovers);
			return turnoversPercent;
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}
	
	//使用率计算  usagePercent
	
	private Double UsagePercents(){
		Double usagePercent=0.00;
		int size=0;
		for(PlayerStatsForCalculation player:list){
			if(player.player().minutes()!=0){
				usagePercent=usagePercent+UsagePercent(player);
				size++;
			}
		}
		usagePercent=usagePercent/size;
		return usagePercent;
	}
	
	private Double UsagePercent(PlayerStatsForCalculation play){
		try{
			Double usagePercent=(play.player().fieldGoalsAttempted()+play.player().threePointFieldGoalsAttempted()
					+0.44*play.player().freeThrowsAttempted()+play.player().turnovers())*
					(play.minutes_teammate()/5)/play.player().minutes()/(play.fieldGoalsAttempted_teammate()
					+0.44*play.freeThrowsAttempted_teammate()+play.turnovers_teammate());
			return usagePercent;
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}
}
