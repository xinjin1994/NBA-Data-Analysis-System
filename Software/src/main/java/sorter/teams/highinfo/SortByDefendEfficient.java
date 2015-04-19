package sorter.teams.highinfo;

import java.util.Comparator;

import vo.TeamHighInfo;

public class SortByDefendEfficient implements Comparator<TeamHighInfo> {

	@Override
	public int compare(TeamHighInfo o1, TeamHighInfo o2) {
		if(o1.getDefendEfficient()>o2.getDefendEfficient()){
			return 1;
		}else if(o1.getDefendEfficient()==o2.getDefendEfficient()){
			return 0;
		}else{
			return -1;
		}
	}

}
