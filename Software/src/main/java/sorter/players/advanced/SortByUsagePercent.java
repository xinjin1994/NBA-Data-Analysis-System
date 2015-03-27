package sorter.players.advanced;

import java.util.Comparator;

import vo.PlayerAdvancedStatsVO;

public class SortByUsagePercent implements Comparator<PlayerAdvancedStatsVO> {

    @Override
    public int compare(PlayerAdvancedStatsVO o1, PlayerAdvancedStatsVO o2) {
        if(o1.getUsagePercent() > o2.getUsagePercent()){
            return 1;
        }else if(o1.getUsagePercent() == o2.getUsagePercent()){
            return 0;
        }else{
            return -1;
        }
    }
}
