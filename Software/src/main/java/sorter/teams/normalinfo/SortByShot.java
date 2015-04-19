package sorter.teams.normalinfo;

import java.util.Comparator;

import vo.TeamNormalInfo;

public class SortByShot implements Comparator<TeamNormalInfo>  {

	@Override
	public int compare(TeamNormalInfo o1, TeamNormalInfo o2) {
		if(o1.getShot()>o2.getShot()){
			return 1;
		}else if(o1.getShot()==o2.getShot()) {
			return 0;
		}else{
			return -1;
		}
	}

}
