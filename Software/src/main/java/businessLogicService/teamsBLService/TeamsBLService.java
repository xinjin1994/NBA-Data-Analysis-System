package businessLogicService.teamsBLService;

import java.util.ArrayList;

import enums.Conference;
import enums.Division;
import enums.Teams;
import exceptions.TeamNotFound;
import vo.TeamVO;
import vo.TeamGeneralStatsVO;
import vo.TeamOffensiveStatsVO;
import vo.TeamDefensiveStatsVO;
import vo.TeamFoulsStatsVO;
import vo.TeamRatioStatsVO;

public interface TeamsBLService {
	//获取球队基本信息
	public TeamVO getTeamInfo(Teams team) throws TeamNotFound;
	public ArrayList<TeamVO> getAllTeamsInfo();
	public ArrayList<TeamVO> getTeamsInfo(Conference conference, Division division) throws TeamNotFound;
	
	
	//获取球队具体统计数据
	//总数
	public ArrayList<TeamGeneralStatsVO> getTeamsGeneralStatsTotal(Conference conference, Division division) throws TeamNotFound;
	public ArrayList<TeamOffensiveStatsVO> getTeamsOffensiveStatsTotal(Conference conference, Division division) throws TeamNotFound;
	public ArrayList<TeamDefensiveStatsVO> getTeamsDefensiveStatsTotal(Conference conference, Division division) throws TeamNotFound;
	public ArrayList<TeamFoulsStatsVO> getTeamsFoulsStatsTotal(Conference conference, Division division) throws TeamNotFound;
	public ArrayList<TeamRatioStatsVO> getTeamsRatioStatsTotal(Conference conference, Division division) throws TeamNotFound;
	
	//场均
	public ArrayList<TeamGeneralStatsVO> getTeamsGeneralStatsAverage(Conference conference, Division division) throws TeamNotFound;
	public ArrayList<TeamOffensiveStatsVO> getTeamsOffensiveStatsAverage(Conference conference, Division division) throws TeamNotFound;
	public ArrayList<TeamDefensiveStatsVO> getTeamsDefensiveStatsAverage(Conference conference, Division division) throws TeamNotFound;
	public ArrayList<TeamFoulsStatsVO> getTeamsFoulsStatsAverage(Conference conference, Division division) throws TeamNotFound;
	public ArrayList<TeamRatioStatsVO> getTeamsRatioStatsAverage(Conference conference, Division division) throws TeamNotFound;
	
	//迭代一不需要
	public TeamGeneralStatsVO getTeamStats(Teams team);
}
