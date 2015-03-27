package sorter.teams.offensive;

import java.util.Comparator;

import vo.TeamOffensiveStatsVO;

public class SortByPoints implements Comparator<TeamOffensiveStatsVO> {

    @Override
    public int compare(TeamOffensiveStatsVO o1, TeamOffensiveStatsVO o2) {
        if(o1.getPoints() > o2.getPoints()){
            return 1;
        }else if(o1.getPoints() == o2.getPoints()){
            return 0;
        }else{
            return -1;
        }
    }
}
