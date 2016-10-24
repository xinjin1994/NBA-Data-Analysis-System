package sorter.players.advanced;

import java.util.ArrayList;
import java.util.Collections;

import enums.Terminology;
import vo.PlayerAdvancedStatsVO;

public class AdvancedSorter {
	public static ArrayList<PlayerAdvancedStatsVO> playerAdvanced_asc(
			ArrayList<PlayerAdvancedStatsVO> list, Terminology term) {
		switch(term){
		case NAME: Collections.sort(list, new SortByName()); break;
		case ASTP: Collections.sort(list, new SortByAssistsPercent()); break;
		case BLKP: Collections.sort(list, new SortByBlocksPercent()); break;
		case DREBP: Collections.sort(list, new SortByDefensiveReboundsPercent()); break;
		case PER: Collections.sort(list, new SortByEfficiency()); break;
		case FGE: Collections.sort(list, new SortByFieldGoalEfficiency()); break;
		case GMSC: Collections.sort(list, new SortByGmSc()); break;
		case OREBP: Collections.sort(list, new SortByOffensiveReboundsPercent()); break;
		case REBP: Collections.sort(list, new SortByReboundsPercent()); break;
		case STLP: Collections.sort(list, new SortByStealsPercent()); break;
		case TEAM: Collections.sort(list, new SortByTeam()); break;
		case TSP: Collections.sort(list, new SortByTrueScorePercent()); break;
		case TOVP: Collections.sort(list, new SortByTurnoversPercent()); break;
		case USGP: Collections.sort(list, new SortByUsagePercent()); break;
		default: ;
		}
		
		return list;
	}
	
	public static ArrayList<PlayerAdvancedStatsVO> playerAdvanced_desc(
			ArrayList<PlayerAdvancedStatsVO> list, Terminology term) {
		switch(term){
		case NAME: Collections.sort(list, Collections.reverseOrder(new SortByName())); break;
		case ASTP: Collections.sort(list, Collections.reverseOrder(new SortByAssistsPercent())); break;
		case BLKP: Collections.sort(list, Collections.reverseOrder(new SortByBlocksPercent())); break;
		case DREBP: Collections.sort(list, Collections.reverseOrder(new SortByDefensiveReboundsPercent())); break;
		case PER: Collections.sort(list, Collections.reverseOrder(new SortByEfficiency())); break;
		case FGE: Collections.sort(list, Collections.reverseOrder(new SortByFieldGoalEfficiency())); break;
		case GMSC: Collections.sort(list, Collections.reverseOrder(new SortByGmSc())); break;
		case OREBP: Collections.sort(list, Collections.reverseOrder(new SortByOffensiveReboundsPercent())); break;
		case REBP: Collections.sort(list, Collections.reverseOrder(new SortByReboundsPercent())); break;
		case STLP: Collections.sort(list, Collections.reverseOrder(new SortByStealsPercent())); break;
		case TEAM: Collections.sort(list, Collections.reverseOrder(new SortByTeam())); break;
		case TSP: Collections.sort(list, Collections.reverseOrder(new SortByTrueScorePercent())); break;
		case TOVP: Collections.sort(list, Collections.reverseOrder(new SortByTurnoversPercent())); break;
		case USGP: Collections.sort(list, Collections.reverseOrder(new SortByUsagePercent())); break;
		default: ;
		}
		
		return list;
	}
}
