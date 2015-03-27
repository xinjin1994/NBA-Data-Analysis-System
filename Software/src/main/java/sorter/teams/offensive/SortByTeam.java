package sorter.teams.offensive;

import java.util.Comparator;

import vo.TeamOffensiveStatsVO;

public class SortByTeam implements Comparator<TeamOffensiveStatsVO>{

	@Override
	public int compare(TeamOffensiveStatsVO o1, TeamOffensiveStatsVO o2) {
		return o1.getTeam().compareTo(o2.getTeam());
	}

}
