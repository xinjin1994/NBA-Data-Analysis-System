package businessLogicService.teamsBLService;

import java.util.ArrayList;
import enums.Conference;
import enums.Division;
import enums.Teams;
import vo.TeamVO;
import vo.TeamStatsVO;

public interface TeamsBLService {
	//获取球队基本信息
	public TeamVO getTeamInfo(Teams team);
	public ArrayList<TeamVO> getTeamsInfo(Conference conference, Division division);
	
	
	//获取球队具体统计数据
	public TeamStatsVO getTeamStats(Teams team);
	public ArrayList<TeamStatsVO> getTeamsStats();
	
}
