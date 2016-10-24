package sorter.teams.normalinfo;

import java.util.Comparator;

import test.data.*;

public class SortByPoint implements Comparator<TeamNormalInfo> {

	@Override
	public int compare(TeamNormalInfo o1, TeamNormalInfo o2) {
		if(o1.getPoint()>o2.getPoint()){
			return 1;
		}else if(o1.getPoint()==o2.getPoint()) {
			return 0;
		}else{
			return -1;
		}
	}

}
