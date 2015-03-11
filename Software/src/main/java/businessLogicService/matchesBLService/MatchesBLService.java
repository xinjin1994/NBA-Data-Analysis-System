package businessLogicService.matchesBLService;

import java.util.ArrayList;
import enums.Teams;
import vo.MatchVO;

public interface MatchesBLService {
	//获取比赛基本数据
	//详细数据从球队、球员模块获取
	public MatchVO getMatch(String season, String date, Teams team1, Teams team2);
	public ArrayList<MatchVO> getMatches(String season, String date, Teams team1, Teams team2);
}
