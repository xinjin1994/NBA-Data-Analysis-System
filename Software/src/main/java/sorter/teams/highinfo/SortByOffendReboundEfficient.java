package sorter.teams.highinfo;

import java.util.Comparator;

import test.data.*;

public class SortByOffendReboundEfficient implements Comparator<TeamHighInfo> {

	@Override
	public int compare(TeamHighInfo o1, TeamHighInfo o2) {
		if(o1.getOffendReboundEfficient()>o2.getOffendReboundEfficient()){
			return 1;
		}else if(o1.getOffendReboundEfficient()==o2.getOffendReboundEfficient()){
			return 0;
		}else{
			return -1;
		}
	}

}
