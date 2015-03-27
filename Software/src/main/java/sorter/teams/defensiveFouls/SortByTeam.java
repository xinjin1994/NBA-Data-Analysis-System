package sorter.teams.defensiveFouls;

import java.util.Comparator;

import vo.TeamDefensiveFoulsVO;

public class SortByTeam implements Comparator<TeamDefensiveFoulsVO>{

	@Override
	public int compare(TeamDefensiveFoulsVO o1, TeamDefensiveFoulsVO o2) {
		return o1.getTeam().compareTo(o2.getTeam());
	}

}
