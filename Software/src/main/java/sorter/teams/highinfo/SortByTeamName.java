package sorter.teams.highinfo;

import java.util.Comparator;

import vo.TeamHighInfo;

public class SortByTeamName implements Comparator<TeamHighInfo> {

	@Override
	public int compare(TeamHighInfo o1, TeamHighInfo o2) {
		return o1.getTeamName().compareTo(o2.getTeamName());
	}

}
