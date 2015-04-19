package sorter.teams.normalinfo;

import java.util.Comparator;

import vo.TeamNormalInfo;

public class SortBySteal implements Comparator<TeamNormalInfo> {

	@Override
	public int compare(TeamNormalInfo o1, TeamNormalInfo o2) {
		if(o1.getSteal()>o2.getSteal()){
			return 1;
		}else if(o1.getSteal()==o2.getSteal()) {
			return 0;
		}else{
			return -1;
		}
	}

}
