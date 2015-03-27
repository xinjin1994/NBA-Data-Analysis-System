package sorter.players.baisc;

import java.util.Comparator;

import vo.PlayerBasicStatsVO;

public class SortBySteals implements Comparator<PlayerBasicStatsVO> {

    @Override
    public int compare(PlayerBasicStatsVO o1, PlayerBasicStatsVO o2) {
        if(o1.getSteals() > o2.getSteals()){
            return 1;
        }else if(o1.getSteals() == o2.getSteals()){
            return 0;
        }else{
            return -1;
        }
    }

}
