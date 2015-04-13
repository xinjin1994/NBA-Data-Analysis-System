package sorter.players.advanced;

import java.util.ArrayList;
import java.util.Collections;

import enums.Terminology;
import vo.PlayerAdvancedStatsVO;

public class AdvancedSorter {
	public static ArrayList<PlayerAdvancedStatsVO> playerAdvanced_asc(
			ArrayList<PlayerAdvancedStatsVO> list, Terminology term) {
		switch(term){
		case NAME: Collections.sort(list, new SortByAssistsPercent()); break;
		case ASTP: Collections.sort(list, new SortByAssistsPercent()); break;
		case BLKP: Collections.sort(list, new SortByAssistsPercent()); break;
		case DREBP: Collections.sort(list, new SortByAssistsPercent()); break;
		case PER: Collections.sort(list, new SortByAssistsPercent()); break;
		case FGE: Collections.sort(list, new SortByAssistsPercent()); break;
		case GMSC: Collections.sort(list, new SortByAssistsPercent()); break;
		case OREBP: Collections.sort(list, new SortByAssistsPercent()); break;
		case REBP: Collections.sort(list, new SortByAssistsPercent()); break;
		case STLP: Collections.sort(list, new SortByAssistsPercent()); break;
		case TEAM: Collections.sort(list, new SortByAssistsPercent()); break;
		case TSP: Collections.sort(list, new SortByAssistsPercent()); break;
		case TOVP: Collections.sort(list, new SortByAssistsPercent()); break;
		case USGP: Collections.sort(list, new SortByAssistsPercent()); break;
		default: ;
		}
		
		return list;
	}
	
	public static ArrayList<PlayerAdvancedStatsVO> playerAdvanced_desc(
			ArrayList<PlayerAdvancedStatsVO> list, Terminology term) {
		switch(term){
		case ASTP: Collections.sort(list, Collections.reverseOrder(new SortByAssistsPercent())); break;
		case BLKP: Collections.sort(list, Collections.reverseOrder(new SortByAssistsPercent())); break;
		case DREBP: Collections.sort(list, Collections.reverseOrder(new SortByAssistsPercent())); break;
		case PER: Collections.sort(list, Collections.reverseOrder(new SortByAssistsPercent())); break;
		case FGE: Collections.sort(list, Collections.reverseOrder(new SortByAssistsPercent())); break;
		case GMSC: Collections.sort(list, Collections.reverseOrder(new SortByAssistsPercent())); break;
		case NAME: Collections.sort(list, Collections.reverseOrder(new SortByAssistsPercent())); break;
		case OREBP: Collections.sort(list, Collections.reverseOrder(new SortByAssistsPercent())); break;
		case REBP: Collections.sort(list, Collections.reverseOrder(new SortByAssistsPercent())); break;
		case STLP: Collections.sort(list, Collections.reverseOrder(new SortByAssistsPercent())); break;
		case TEAM: Collections.sort(list, Collections.reverseOrder(new SortByAssistsPercent())); break;
		case TSP: Collections.sort(list, Collections.reverseOrder(new SortByAssistsPercent())); break;
		case TOVP: Collections.sort(list, Collections.reverseOrder(new SortByAssistsPercent())); break;
		case USGP: Collections.sort(list, Collections.reverseOrder(new SortByAssistsPercent())); break;
		default: ;
		}
		
		return list;
	}
}
