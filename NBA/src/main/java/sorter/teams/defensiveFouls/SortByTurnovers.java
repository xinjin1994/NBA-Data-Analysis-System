package sorter.teams.defensiveFouls;

import java.util.Comparator;

import vo.TeamDefensiveFoulsVO;

public class SortByTurnovers implements Comparator<TeamDefensiveFoulsVO> {

    @Override
    public int compare(TeamDefensiveFoulsVO o1, TeamDefensiveFoulsVO o2) {
        if(o1.getTurnovers() > o2.getTurnovers()){
            return 1;
        }else if(o1.getTurnovers() == o2.getTurnovers()){
            return 0;
        }else{
            return -1;
        }
    }
}
