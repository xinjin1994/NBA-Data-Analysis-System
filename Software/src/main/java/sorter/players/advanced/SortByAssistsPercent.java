package sorter.players.advanced;

import java.util.Comparator;

import vo.PlayerAdvancedStatsVO;

public class SortByAssistsPercent implements Comparator<PlayerAdvancedStatsVO> {

    @Override
    public int compare(PlayerAdvancedStatsVO o1, PlayerAdvancedStatsVO o2) {
        if(o1.getAssistsPercent() > o2.getAssistsPercent()){
            return 1;
        }else if(o1.getAssistsPercent() == o2.getAssistsPercent()){
            return 0;
        }else{
            return -1;
        }
    }
}
