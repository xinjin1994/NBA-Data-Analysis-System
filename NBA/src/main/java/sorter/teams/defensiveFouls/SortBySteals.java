package sorter.teams.defensiveFouls;

import java.util.Comparator;

import vo.TeamDefensiveFoulsVO;

public class SortBySteals implements Comparator<TeamDefensiveFoulsVO> {

    @Override
    public int compare(TeamDefensiveFoulsVO o1, TeamDefensiveFoulsVO o2) {
        if(o1.getSteals() > o2.getSteals()){
            return 1;
        }else if(o1.getSteals() == o2.getSteals()){
            return 0;
        }else{
            return -1;
        }
    }
}
