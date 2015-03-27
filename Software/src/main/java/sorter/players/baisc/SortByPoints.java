package sorter.players.baisc;

import java.util.Comparator;

import vo.PlayerBasicStatsVO;

public class SortByPoints implements Comparator<PlayerBasicStatsVO> {

    @Override
    public int compare(PlayerBasicStatsVO o1, PlayerBasicStatsVO o2) {
        if(o1.getPoints() > o2.getPoints()){
            return 1;
        }else if(o1.getPoints() == o2.getPoints()){
            return 0;
        }else{
            return -1;
        }
    }

}
