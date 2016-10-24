package sorter.teams.defensiveFouls;

import java.util.Comparator;

import vo.TeamDefensiveFoulsVO;

public class SortByFouls implements Comparator<TeamDefensiveFoulsVO> {

    @Override
    public int compare(TeamDefensiveFoulsVO o1, TeamDefensiveFoulsVO o2) {
        if(o1.getFouls() > o2.getFouls()){
            return 1;
        }else if(o1.getFouls() == o2.getFouls()){
            return 0;
        }else{
            return -1;
        }
    }
}
