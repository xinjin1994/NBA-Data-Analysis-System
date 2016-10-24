package sorter.players.advanced;

import java.util.Comparator;

import vo.PlayerAdvancedStatsVO;

public class SortByTrueScorePercent implements Comparator<PlayerAdvancedStatsVO> {

    @Override
    public int compare(PlayerAdvancedStatsVO o1, PlayerAdvancedStatsVO o2) {
        if(o1.getTrueScorePercent() > o2.getTrueScorePercent()){
            return 1;
        }else if(o1.getTrueScorePercent() == o2.getTrueScorePercent()){
            return 0;
        }else{
            return -1;
        }
    }
}
