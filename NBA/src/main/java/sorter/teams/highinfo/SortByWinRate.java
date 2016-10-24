package sorter.teams.highinfo;

import java.util.Comparator;

import test.data.*;

public class SortByWinRate implements Comparator<TeamHighInfo> {

	@Override
	public int compare(TeamHighInfo o1, TeamHighInfo o2) {
		if(o1.getWinRate()>o2.getWinRate()){
			return 1;
		}else if(o1.getWinRate()==o2.getWinRate()){
			return 0;
		}else{
			return -1;
		}
	}

}
