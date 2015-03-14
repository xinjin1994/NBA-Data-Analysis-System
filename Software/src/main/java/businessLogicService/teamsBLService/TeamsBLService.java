package businessLogicService.teamsBLService;

import java.util.ArrayList;
import enums.Conference;
import enums.Division;
import enums.Teams;
import vo.TeamVO;
import vo.TeamGeneralStatsVO;
import vo.TeamOffensiveStatsVO;
import vo.TeamDefensiveStatsVO;
import vo.TeamFoulsStatsVO;
import vo.TeamRatioStatsVO;

public interface TeamsBLService {
	//获取球队基本信息
	public TeamVO getTeamInfo(Teams team);
	public ArrayList<TeamVO> getTeamsInfo(Conference conference, Division division);
	
	
	//获取球队具体统计数据
	public TeamGeneralStatsVO getTeamStats(Teams team);            //目前不用
	public ArrayList<TeamGeneralStatsVO> getTeamsStats(Conference conference, Division division);
	public ArrayList<TeamOffensiveStatsVO> getTeamsOffensiveStats(Conference conference, Division division);
	public ArrayList<TeamDefensiveStatsVO> getTeamsDefensiveStats(Conference conference, Division division);
	public ArrayList<TeamFoulsStatsVO> getTeamsFoulsStats(Conference conference, Division division);
	public ArrayList<TeamRatioStatsVO> getTeamsRatioStats(Conference conference, Division division);
}
