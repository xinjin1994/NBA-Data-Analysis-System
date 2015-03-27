package sorter.teams.ratioGeneral;

import java.util.Comparator;

import vo.TeamRatioGeneralVO;

public class SortByAssistsEfficiency implements Comparator<TeamRatioGeneralVO> {

    @Override
    public int compare(TeamRatioGeneralVO o1, TeamRatioGeneralVO o2) {
        if(o1.getAssistsEfficiency() > o2.getAssistsEfficiency()){
            return 1;
        }else if(o1.getAssistsEfficiency() == o2.getAssistsEfficiency()){
            return 0;
        }else{
            return -1;
        }
    }
}
