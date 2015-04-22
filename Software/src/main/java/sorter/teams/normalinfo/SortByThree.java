package sorter.teams.normalinfo;

import java.util.Comparator;

import test.data.*;

public class SortByThree implements Comparator<TeamNormalInfo> {

	@Override
	public int compare(TeamNormalInfo o1, TeamNormalInfo o2) {
		if(o1.getThree()>o2.getThree()){
			return 1;
		}else if(o1.getThree()==o2.getThree()) {
			return 0;
		}else{
			return -1;
		}
	}

}
