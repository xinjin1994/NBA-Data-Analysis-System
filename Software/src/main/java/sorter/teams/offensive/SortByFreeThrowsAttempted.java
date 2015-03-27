package sorter.teams.offensive;

import java.util.Comparator;

import vo.TeamOffensiveStatsVO;

public class SortByFreeThrowsAttempted implements Comparator<TeamOffensiveStatsVO> {

    @Override
    public int compare(TeamOffensiveStatsVO o1, TeamOffensiveStatsVO o2) {
        if(o1.getFreeThrowsAttempted() > o2.getFreeThrowsAttempted()){
            return 1;
        }else if(o1.getFreeThrowsAttempted() == o2.getFreeThrowsAttempted()){
            return 0;
        }else{
            return -1;
        }
    }
}
