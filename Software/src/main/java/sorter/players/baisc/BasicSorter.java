package sorter.players.baisc;

import java.util.ArrayList;
import java.util.Collections;
import vo.PlayerBasicStatsVO;
import enums.Terminology;

public class BasicSorter {
	public static ArrayList<PlayerBasicStatsVO> playerBasic_asc(ArrayList<PlayerBasicStatsVO> list, 
			Terminology term) {
		switch(term){
		case NAME: Collections.sort(list, new SortByName()); break;
		case AST: Collections.sort(list, new SortByAssists()); break;
		case BLK: Collections.sort(list, new SortByBlocks()); break;
		case DREB: Collections.sort(list, new SortByDefensiveRebounds()); break;
		case PER: Collections.sort(list, new SortByEfficiency()); break;
		case FGP: Collections.sort(list, new SortByFieldGoalPercentage()); break;
		case FTP: Collections.sort(list, new SortByFreeThrowPercentage()); break;
		case GM: Collections.sort(list, new SortByGames()); break;
		case GMSTR: Collections.sort(list, new SortByGamesStarting()); break;
		case MIN: Collections.sort(list, new SortByMinutes()); break;
		case OREB: Collections.sort(list, new SortByOffensiveRebounds()); break;
		case PF: Collections.sort(list, new SortByPersonalFouls()); break;
		case PTS: Collections.sort(list, new SortByPoints()); break;
		case REB: Collections.sort(list, new SortByRebounds()); break;
		case STL: Collections.sort(list, new SortBySteals()); break;
		case TEAM: Collections.sort(list, new SortByTeam()); break;
		case TPP: Collections.sort(list, new SortByThreePointFieldGoalPercentage()); break;
		case TOV: Collections.sort(list, new SortByTurnovers()); break;
		default: ;
		}
		
		return list;
	}
	
	public static ArrayList<PlayerBasicStatsVO> playerBasic_desc(ArrayList<PlayerBasicStatsVO> list, 
			Terminology term) {
		switch(term){
		case AST: Collections.sort(list, Collections.reverseOrder(new SortByAssists())); break;
		case BLK: Collections.sort(list, Collections.reverseOrder(new SortByBlocks())); break;
		case DREB: Collections.sort(list, Collections.reverseOrder(new SortByDefensiveRebounds())); break;
		case PER: Collections.sort(list, Collections.reverseOrder(new SortByEfficiency())); break;
		case FGP: Collections.sort(list, Collections.reverseOrder(new SortByFieldGoalPercentage())); break;
		case FTP: Collections.sort(list, Collections.reverseOrder(new SortByFreeThrowPercentage())); break;
		case GM: Collections.sort(list, Collections.reverseOrder(new SortByGames())); break;
		case GMSTR: Collections.sort(list, Collections.reverseOrder(new SortByGamesStarting())); break;
		case MIN: Collections.sort(list, Collections.reverseOrder(new SortByMinutes())); break;
		case NAME: Collections.sort(list, Collections.reverseOrder(new SortByName())); break;
		case OREB: Collections.sort(list, Collections.reverseOrder(new SortByOffensiveRebounds())); break;
		case PF: Collections.sort(list, Collections.reverseOrder(new SortByPersonalFouls())); break;
		case PTS: Collections.sort(list, Collections.reverseOrder(new SortByPoints())); break;
		case REB: Collections.sort(list, Collections.reverseOrder(new SortByRebounds())); break;
		case STL: Collections.sort(list, Collections.reverseOrder(new SortBySteals())); break;
		case TEAM: Collections.sort(list, Collections.reverseOrder(new SortByTeam())); break;
		case TPP: Collections.sort(list, Collections.reverseOrder(new SortByThreePointFieldGoalPercentage())); break;
		case TOV: Collections.sort(list, Collections.reverseOrder(new SortByTurnovers())); break;
		default: ;
		}
		
		return list;
	}
}
