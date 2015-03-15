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
	//总数
	public ArrayList<TeamGeneralStatsVO> getTeamsStatsTotal(Conference conference, Division division);
	public ArrayList<TeamOffensiveStatsVO> getTeamsOffensiveStatsTotal(Conference conference, Division division);
	public ArrayList<TeamDefensiveStatsVO> getTeamsDefensiveStatsTotal(Conference conference, Division division);
	public ArrayList<TeamFoulsStatsVO> getTeamsFoulsStatsTotal(Conference conference, Division division);
	public ArrayList<TeamRatioStatsVO> getTeamsRatioStatsTotal(Conference conference, Division division);
	
	//场均
	public ArrayList<TeamGeneralStatsVO> getTeamsStatsAverage(Conference conference, Division division);
	public ArrayList<TeamOffensiveStatsVO> getTeamsOffensiveStatsAverage(Conference conference, Division division);
	public ArrayList<TeamDefensiveStatsVO> getTeamsDefensiveStatsAverage(Conference conference, Division division);
	public ArrayList<TeamFoulsStatsVO> getTeamsFoulsStatsAverage(Conference conference, Division division);
	public ArrayList<TeamRatioStatsVO> getTeamsRatioStatsAverage(Conference conference, Division division);
	
	//迭代一不需要
	public TeamGeneralStatsVO getTeamStats(Teams team);
}
