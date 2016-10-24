package sorter.players.advanced;

import java.util.Comparator;

import vo.PlayerAdvancedStatsVO;

public class SortByBlocksPercent implements Comparator<PlayerAdvancedStatsVO> {

    @Override
    public int compare(PlayerAdvancedStatsVO o1, PlayerAdvancedStatsVO o2) {
        if(o1.getBlocksPercent() > o2.getBlocksPercent()){
            return 1;
        }else if(o1.getBlocksPercent() == o2.getBlocksPercent()){
            return 0;
        }else{
            return -1;
        }
    }
}
