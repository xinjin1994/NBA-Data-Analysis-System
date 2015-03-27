package sorter.players.advanced;

import java.util.Comparator;

import vo.PlayerAdvancedStatsVO;

public class SortByFieldGoalEfficiency implements Comparator<PlayerAdvancedStatsVO> {

    @Override
    public int compare(PlayerAdvancedStatsVO o1, PlayerAdvancedStatsVO o2) {
        if(o1.getFieldGoalEfficiency() > o2.getFieldGoalEfficiency()){
            return 1;
        }else if(o1.getFieldGoalEfficiency() == o2.getFieldGoalEfficiency()){
            return 0;
        }else{
            return -1;
        }
    }
}
