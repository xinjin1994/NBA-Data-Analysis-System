package sorter.teams.highinfo;

import java.util.Comparator;

import vo.TeamHighInfo;

public class SortByStealEfficient implements Comparator<TeamHighInfo> {

	@Override
	public int compare(TeamHighInfo o1, TeamHighInfo o2) {
		if(o1.getStealEfficient()>o2.getStealEfficient()){
			return 1;
		}else if(o1.getStealEfficient()==o2.getStealEfficient()){
			return 0;
		}else{
			return -1;
		}
	}

}
