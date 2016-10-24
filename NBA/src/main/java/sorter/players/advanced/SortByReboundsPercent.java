package sorter.players.advanced;

import java.util.Comparator;

import vo.PlayerAdvancedStatsVO;

public class SortByReboundsPercent implements Comparator<PlayerAdvancedStatsVO> {

    @Override
    public int compare(PlayerAdvancedStatsVO o1, PlayerAdvancedStatsVO o2) {
        if(o1.getReboundsPercent() > o2.getReboundsPercent()){
            return 1;
        }else if(o1.getReboundsPercent() == o2.getReboundsPercent()){
            return 0;
        }else{
            return -1;
        }
    }
}
