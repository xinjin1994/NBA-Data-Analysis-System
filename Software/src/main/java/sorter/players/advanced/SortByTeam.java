package sorter.players.advanced;

import java.util.Comparator;

import vo.PlayerAdvancedStatsVO;

public class SortByTeam implements Comparator<PlayerAdvancedStatsVO>{
	
	@Override
	public int compare(PlayerAdvancedStatsVO o1, PlayerAdvancedStatsVO o2){
		return o1.getTeam().compareTo(o2.getTeam());
	}

}
