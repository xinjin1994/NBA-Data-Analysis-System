package sorter.teams.normalinfo;

import java.util.Comparator;

import test.data.*;

public class SortByPenalty implements Comparator<TeamNormalInfo> {

	@Override
	public int compare(TeamNormalInfo o1, TeamNormalInfo o2) {
		if(o1.getPenalty()>o2.getPenalty()){
			return 1;
		}else if(o1.getPenalty()==o2.getPenalty()) {
			return 0;
		}else{
			return -1;
		}
	}

}
