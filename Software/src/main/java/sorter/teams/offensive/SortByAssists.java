package sorter.teams.offensive;

import java.util.Comparator;

import vo.TeamOffensiveStatsVO;

public class SortByAssists implements Comparator<TeamOffensiveStatsVO> {

    @Override
    public int compare(TeamOffensiveStatsVO o1, TeamOffensiveStatsVO o2) {
        if(o1.getAssists() > o2.getAssists()){
            return 1;
        }else if(o1.getAssists() == o2.getAssists()){
            return 0;
        }else{
            return -1;
        }
    }
}
