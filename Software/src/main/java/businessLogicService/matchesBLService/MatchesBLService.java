package businessLogicService.matchesBLService;

import java.util.ArrayList;

import enums.Teams;
import exceptions.MatchNotFound;
import exceptions.TeamNotFound;
import vo.MatchVO;

public interface MatchesBLService {
	//获取比赛基本数据
	//详细数据从球队、球员模块获取
	public MatchVO getMatchVO(String season, String date, Teams team1, Teams team2) throws TeamNotFound, MatchNotFound;
	public ArrayList<MatchVO> getMatchesVO(String season, String date, Teams team1, Teams team2) throws TeamNotFound, MatchNotFound;
}
