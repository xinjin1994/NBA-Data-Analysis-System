package sorter.teams.offensive;

import java.util.Comparator;

import vo.TeamOffensiveStatsVO;

public class SortByThreePointFieldGoalsMade implements Comparator<TeamOffensiveStatsVO> {

    @Override
    public int compare(TeamOffensiveStatsVO o1, TeamOffensiveStatsVO o2) {
        if(o1.getThreePointFieldGoalsMade() > o2.getThreePointFieldGoalsMade()){
            return 1;
        }else if(o1.getThreePointFieldGoalsMade() == o2.getThreePointFieldGoalsMade()){
            return 0;
        }else{
            return -1;
        }
    }
}
