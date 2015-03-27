package sorter.teams.ratioGeneral;

import java.util.Comparator;

import vo.TeamRatioGeneralVO;

public class SortByTeam implements Comparator<TeamRatioGeneralVO>{

	@Override
	public int compare(TeamRatioGeneralVO o1, TeamRatioGeneralVO o2) {
		return o1.getTeam().compareTo(o2.getTeam());
	}

}
