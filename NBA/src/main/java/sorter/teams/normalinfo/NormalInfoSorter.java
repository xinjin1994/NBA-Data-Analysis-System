package sorter.teams.normalinfo;

import java.util.ArrayList;
import java.util.Collections;
import enums.Terminology;
import test.data.*;

public class NormalInfoSorter {
	public static ArrayList<TeamNormalInfo> teamNormalInfo_asc(ArrayList<TeamNormalInfo> list,
			Terminology term){
		switch(term){
		case TEAM: Collections.sort(list, new SortByTeamName()); break;
		case AST: Collections.sort(list, new SortByAssist()); break;
		case BLK: Collections.sort(list, new SortByBlockShot()); break;
		case DREB: Collections.sort(list, new SortByDefendRebound()); break;
		case TOV: Collections.sort(list, new SortByFault()); break;
		case PF: Collections.sort(list, new SortByFoul()); break;
		case GM: Collections.sort(list, new SortByNumOfGame()); break;
		case OREB: Collections.sort(list, new SortByOffendRebound()); break;
		case FTP: Collections.sort(list, new SortByPenalty()); break;
		case PTS: Collections.sort(list, new SortByPoint()); break;
		case REB: Collections.sort(list, new SortByRebound()); break;
		case FGP: Collections.sort(list, new SortByShot()); break;
		case STL: Collections.sort(list, new SortBySteal()); break;
		case TPP: Collections.sort(list, new SortByThree()); break;
		default: ;
		}
		return list;
	}
	
	public static ArrayList<TeamNormalInfo> teamNormalInfo_desc(ArrayList<TeamNormalInfo> list,
			Terminology term){
		switch(term){
		case TEAM: Collections.sort(list, Collections.reverseOrder(new SortByTeamName())); break;
		case AST: Collections.sort(list, Collections.reverseOrder(new SortByAssist())); break;
		case BLK: Collections.sort(list, Collections.reverseOrder(new SortByBlockShot())); break;
		case DREB: Collections.sort(list, Collections.reverseOrder(new SortByDefendRebound())); break;
		case TOV: Collections.sort(list, Collections.reverseOrder(new SortByFault())); break;
		case PF: Collections.sort(list, Collections.reverseOrder(new SortByFoul())); break;
		case GM: Collections.sort(list, Collections.reverseOrder(new SortByNumOfGame())); break;
		case OREB: Collections.sort(list, Collections.reverseOrder(new SortByOffendRebound())); break;
		case FTP: Collections.sort(list, Collections.reverseOrder(new SortByPenalty())); break;
		case PTS: Collections.sort(list, Collections.reverseOrder(new SortByPoint())); break;
		case REB: Collections.sort(list, Collections.reverseOrder(new SortByRebound())); break;
		case FGP: Collections.sort(list, Collections.reverseOrder(new SortByShot())); break;
		case STL: Collections.sort(list, Collections.reverseOrder(new SortBySteal())); break;
		case TPP: Collections.sort(list, Collections.reverseOrder(new SortByThree())); break;
		default: ;
		}
		return list;
	}
}
