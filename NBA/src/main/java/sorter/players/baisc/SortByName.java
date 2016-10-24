package sorter.players.baisc;

import java.util.Comparator;

import vo.PlayerBasicStatsVO;

public class SortByName implements Comparator<PlayerBasicStatsVO> {

    @Override
    public int compare(PlayerBasicStatsVO o1, PlayerBasicStatsVO o2) {
    	String[] name1 = o1.getName().split(" ");
    	String[] name2 = o2.getName().split(" ");
    	return (name1[1] + name1[0]).compareTo(name2[1] + name2[0]);
        //return o1.getName().compareTo(o2.getName());
    }

}
