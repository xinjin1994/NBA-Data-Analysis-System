package sorter.players.advanced;

import java.util.Comparator;

import vo.PlayerAdvancedStatsVO;

public class SortByTurnoversPercent implements Comparator<PlayerAdvancedStatsVO> {

    @Override
    public int compare(PlayerAdvancedStatsVO o1, PlayerAdvancedStatsVO o2) {
        if(o1.getTurnoversPercent() > o2.getTurnoversPercent()){
            return 1;
        }else if(o1.getTurnoversPercent() == o2.getTurnoversPercent()){
            return 0;
        }else{
            return -1;
        }
    }
}
