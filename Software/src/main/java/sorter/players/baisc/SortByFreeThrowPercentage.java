package sorter.players.baisc;

import java.util.Comparator;

import vo.PlayerBasicStatsVO;

public class SortByFreeThrowPercentage implements Comparator<PlayerBasicStatsVO> {

    @Override
    public int compare(PlayerBasicStatsVO o1, PlayerBasicStatsVO o2) {
        if(o1.getFreeThrowPercentage() > o2.getFreeThrowPercentage()){
            return 1;
        }else if(o1.getFreeThrowPercentage() == o2.getFreeThrowPercentage()){
            return 0;
        }else{
            return -1;
        }
    }

}