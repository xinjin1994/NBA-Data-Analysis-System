package businessLogicService.teamsBLService;

import java.util.ArrayList;

import vo.TeamDefensiveFoulsVO;
import vo.TeamOffensiveStatsVO;
import vo.TeamRatioGeneralVO;
import vo.TeamVO;
import enums.Conference;
import enums.Division;
import enums.Teams;
import exceptions.TeamNotFound;

public interface TeamsBLService_new {
	//获取球队基本信息
	public TeamVO getTeamInfo(Teams team) throws TeamNotFound;
	public ArrayList<TeamVO> getAllTeamsInfo();
	public ArrayList<TeamVO> getTeamsInfo(Conference conference, Division division) throws TeamNotFound;
	
	
	//获取球队数据
	//总数
	//进攻数据
	public ArrayList<TeamOffensiveStatsVO> getTeamsOffensiveStatsTotal(Conference conference, Division division) throws TeamNotFound;
	//比率、总和数据
	public ArrayList<TeamRatioGeneralVO> getTeamRatioGeneralStatsTotal(Conference conference, Division division) throws TeamNotFound;
	//防守犯规数据
	public ArrayList<TeamDefensiveFoulsVO> getTeamDefensiveFoulsStatsTotal(Conference conference, Division division) throws TeamNotFound;
	
	//场均
	//进攻数据
	public ArrayList<TeamOffensiveStatsVO> getTeamsOffensiveStatsAverage(Conference conference, Division division) throws TeamNotFound;
	//比率、总和数据
	public ArrayList<TeamRatioGeneralVO> getTeamRatioGeneralStatsAverage(Conference conference, Division division) throws TeamNotFound;
	//防守犯规数据
	public ArrayList<TeamDefensiveFoulsVO> getTeamDefensiveFoulsStatsAverage(Conference conference, Division division) throws TeamNotFound;

}
