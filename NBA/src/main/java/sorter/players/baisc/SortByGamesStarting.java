package sorter.players.baisc;

import java.util.Comparator;

import vo.PlayerBasicStatsVO;

public class SortByGamesStarting implements Comparator<PlayerBasicStatsVO> {

    @Override
    public int compare(PlayerBasicStatsVO o1, PlayerBasicStatsVO o2) {
        if(o1.getGamesStarting() > o2.getGamesStarting()){
            return 1;
        }else if(o1.getGamesStarting() == o2.getGamesStarting()){
            return 0;
        }else{
            return -1;
        }
    }

}
