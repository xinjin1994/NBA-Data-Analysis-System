package sorter.teams.highinfo;

import java.util.ArrayList;
import java.util.Collections;

import enums.Terminology;
import test.data.*;

public class HighInfoSorter {
	public static ArrayList<TeamHighInfo> teamHighInfo_asc(ArrayList<TeamHighInfo> list,
			Terminology term){
		switch(term){
		case TEAM: Collections.sort(list, new SortByTeamName()); break;
		case ASTE: Collections.sort(list, new SortByAssistEfficient()); break;
		case DFE: Collections.sort(list, new SortByDefendEfficient()); break;
		case DREBDE: Collections.sort(list, new SortByDefendReboundEfficient()); break;
		case OFE: Collections.sort(list, new SortByOffendEfficient()); break;
		case OREBDE: Collections.sort(list, new SortByOffendReboundEfficient()); break;
		case OFR: Collections.sort(list, new SortByOffendRound()); break;
		case STLE: Collections.sort(list, new SortByStealEfficient()); break;
		case WINR: Collections.sort(list, new SortByWinRate()); break;
		default: ;
		}
		return list;
	}
	
	public static ArrayList<TeamHighInfo> teamHighInfo_desc(ArrayList<TeamHighInfo> list,
			Terminology term){
		switch(term){
		case TEAM: Collections.sort(list, Collections.reverseOrder(new SortByTeamName())); break;
		case ASTE: Collections.sort(list, Collections.reverseOrder(new SortByAssistEfficient())); break;
		case DFE: Collections.sort(list, Collections.reverseOrder(new SortByDefendEfficient())); break;
		case DREBDE: Collections.sort(list, Collections.reverseOrder(new SortByDefendReboundEfficient())); break;
		case OFE: Collections.sort(list, Collections.reverseOrder(new SortByOffendEfficient())); break;
		case OREBDE: Collections.sort(list, Collections.reverseOrder(new SortByOffendReboundEfficient())); break;
		case OFR: Collections.sort(list, Collections.reverseOrder(new SortByOffendRound())); break;
		case STLE: Collections.sort(list, Collections.reverseOrder(new SortByStealEfficient())); break;
		case WINR: Collections.sort(list, Collections.reverseOrder(new SortByWinRate())); break;
		default: ;
		}
		return list;
	}
}
