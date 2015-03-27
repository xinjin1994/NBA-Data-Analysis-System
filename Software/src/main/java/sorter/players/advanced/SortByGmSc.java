package sorter.players.advanced;

import java.util.Comparator;

import vo.PlayerAdvancedStatsVO;

public class SortByGmSc implements Comparator<PlayerAdvancedStatsVO> {

    @Override
    public int compare(PlayerAdvancedStatsVO o1, PlayerAdvancedStatsVO o2) {
        if(o1.getGmSc() > o2.getGmSc()){
            return 1;
        }else if(o1.getGmSc() == o2.getGmSc()){
            return 0;
        }else{
            return -1;
        }
    }
}
