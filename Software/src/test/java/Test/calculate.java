package Test;

import java.util.ArrayList;







import enums.Teams;
import exceptions.MatchNotFound;
import exceptions.PlayerNotFound;
import exceptions.TeamNotFound;
import factory.PlayerCalculator;
import businessLogic.matchesBL.MatchesBL;
import businessLogic.playersBL.AdvancedPlayerStats;
import businessLogic.playersBL.BasicPlayerStats;
import businessLogic.playersBL.PlayerStatsForCalculation;
import businessLogicService.matchesBLService.PlayerDataInMatchesService;

public class calculate {
	public static void printP(BasicPlayerStats basic){
		System.out.println(basic.name()+" "+basic.minutes()+" "+basic.fieldGoalsMade()
				+" "+basic.fieldGoalsAttempted()+" "+basic.threePointFieldGoalsMade()
				+" "+basic.threePointFieldGoalsAttempted()+" "+basic.freeThrowsMade()
				+" "+basic.freeThrowsAttempted()+" "+basic.offensiveRebounds()
				+" "+basic.defensiveRebounds()+" "+basic.rebounds()
				+" "+basic.assists()+" "+basic.steals()+" "+basic.blocks()
				+" "+basic.turnovers()+" "+basic.personalFouls()+" "+basic.points());
	}
	
	public static void printPY(BasicPlayerStats basic){
		System.out.println(basic.name());
	}
	
	public static void printA(AdvancedPlayerStats adv){
		System.out.println(adv.name()+" "+adv.doubleDouble()+" "+adv.hitRate()+" "+adv.rebounds()
				+" "+adv.playerEfficiencyRating()+" "+adv.Gmsc()+" "+adv.trueScorePercent()
				+" "+adv.fieldGoalsPercent()+" "+adv.reboundsPercent()+" "+adv.offensiveReboundsPercent()
				+" "+adv.defensiveReboundsPercent()+" "+adv.assistsPercent()+" "+adv.stealsPercent()
				+" "+adv.blockPercent()+" "+adv.turnoversPercent()+" "+adv.usagePercent());
	}
	
	public static void printAY(AdvancedPlayerStats adv){
		System.out.println(adv.defensiveReboundsPercent());
	}
	public static void main(String[] args){
		PlayerDataInMatchesService playcal=new MatchesBL();
		ArrayList<PlayerStatsForCalculation> player;
		try {
			player = playcal.getPlayerStatsForCalculation("Kobe Bryant");
			for(PlayerStatsForCalculation cal:player){
				BasicPlayerStats basic=cal.player();
				//printP(basic);
			}
			PlayerCalculator calcu=new PlayerCalculator(player);
			AdvancedPlayerStats adv=calcu.getAdvancedStatsTotal();
			printAY(adv);
		} catch (PlayerNotFound e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
