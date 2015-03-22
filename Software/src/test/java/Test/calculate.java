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
		System.out.println(basic.name()+"上场时间 "+basic.minutes()+"两分 "+basic.fieldGoalsMade()
				+"两分试 "+basic.fieldGoalsAttempted()+"三分 "+basic.threePointFieldGoalsMade()
				+"三分试 "+basic.threePointFieldGoalsAttempted()+"罚球 "+basic.freeThrowsMade()
				+"罚球试 "+basic.freeThrowsAttempted()+"进攻篮板 "+basic.offensiveRebounds()
				+"防守篮板 "+basic.defensiveRebounds()+"篮板 "+basic.rebounds()
				+"助攻 "+basic.assists()+"抢断 "+basic.steals()+"盖帽 "+basic.blocks()
				+"失误 "+basic.turnovers()+"犯规 "+basic.personalFouls()+"得分 "+basic.points());
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
		System.out.println(adv.trueScorePercent());
	}
	public static void main(String[] args){
		PlayerDataInMatchesService playcal=new MatchesBL();
		ArrayList<PlayerStatsForCalculation> player;
		try {
			player = playcal.getPlayerStatsForCalculation("Andrew Nicholson");
			for(PlayerStatsForCalculation cal:player){
				BasicPlayerStats basic=cal.player();
				//printP(basic);
			}
			PlayerCalculator calcu=new PlayerCalculator(player);
			AdvancedPlayerStats adv=calcu.getAdvancedStatsTotal();
			printA(adv);
		} catch (PlayerNotFound e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
