package sorter.teams.ratioGeneral;

import java.util.Comparator;

import vo.TeamRatioGeneralVO;

public class SortByWinningRating implements Comparator<TeamRatioGeneralVO> {

    @Override
    public int compare(TeamRatioGeneralVO o1, TeamRatioGeneralVO o2) {
        if(o1.getWinningRating() > o2.getWinningRating()){
            return 1;
        }else if(o1.getWinningRating() == o2.getWinningRating()){
            return 0;
        }else{
            return -1;
        }
    }
}
