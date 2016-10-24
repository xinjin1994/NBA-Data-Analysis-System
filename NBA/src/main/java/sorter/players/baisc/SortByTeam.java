package sorter.players.baisc;

import java.util.Comparator;

import vo.PlayerBasicStatsVO;

public class SortByTeam implements Comparator<PlayerBasicStatsVO> {

	@Override
	public int compare(PlayerBasicStatsVO o1, PlayerBasicStatsVO o2) {
		return o1.getTeam().compareTo(o2.getTeam());
	}

}
