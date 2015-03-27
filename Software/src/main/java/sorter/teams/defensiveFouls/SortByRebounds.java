package sorter.teams.defensiveFouls;

import java.util.Comparator;

import vo.TeamDefensiveFoulsVO;

public class SortByRebounds implements Comparator<TeamDefensiveFoulsVO> {

    @Override
    public int compare(TeamDefensiveFoulsVO o1, TeamDefensiveFoulsVO o2) {
        if(o1.getRebounds() > o2.getRebounds()){
            return 1;
        }else if(o1.getRebounds() == o2.getRebounds()){
            return 0;
        }else{
            return -1;
        }
    }
}
