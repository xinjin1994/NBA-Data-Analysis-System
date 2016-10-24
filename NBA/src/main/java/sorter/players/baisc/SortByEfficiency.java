package sorter.players.baisc;

import java.util.Comparator;

import vo.PlayerBasicStatsVO;

public class SortByEfficiency implements Comparator<PlayerBasicStatsVO>{
	
	@Override
    public int compare(PlayerBasicStatsVO o1, PlayerBasicStatsVO o2) {
        if(o1.getEfficiency() > o2.getEfficiency()){
            return 1;
        }else if(o1.getEfficiency() == o2.getEfficiency()){
            return 0;
        }else{
            return -1;
        }
    }
}
