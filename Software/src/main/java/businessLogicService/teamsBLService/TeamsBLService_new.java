package businessLogicService.teamsBLService;

import java.util.ArrayList;
import java.util.Date;

import vo.TeamDefensiveFoulsVO;
import vo.TeamHotStatsVO;
import vo.TeamOffensiveStatsVO;
import vo.TeamRatioGeneralVO;
import vo.TeamVO;
import enums.Conference;
import enums.Division;
import enums.Teams;
import enums.Terminology;
import exceptions.TeamNotFound;

public interface TeamsBLService_new {
	//获取球队基本信息
	public TeamVO getTeamInfo(Teams team) throws TeamNotFound;
	public ArrayList<TeamVO> getAllTeamsInfo();
	public ArrayList<TeamVO> getTeamsInfo(Conference conference, Division division) throws TeamNotFound;
	
	
	//获取球队数据
	//总数
	//进攻数据
	public ArrayList<TeamOffensiveStatsVO> getTeamOffensiveStatsTotal(String season, Conference conference, Division division) throws TeamNotFound;
	//比率、总和数据
	public ArrayList<TeamRatioGeneralVO> getTeamRatioGeneralStatsTotal(String season, Conference conference, Division division) throws TeamNotFound;
	//防守犯规数据
	public ArrayList<TeamDefensiveFoulsVO> getTeamDefensiveFoulsStatsTotal(String season, Conference conference, Division division) throws TeamNotFound;
	
	//场均
	//进攻数据
	public ArrayList<TeamOffensiveStatsVO> getTeamOffensiveStatsAverage(String season, Conference conference, Division division) throws TeamNotFound;
	//比率、总和数据
	public ArrayList<TeamRatioGeneralVO> getTeamRatioGeneralStatsAverage(String season, Conference conference, Division division) throws TeamNotFound;
	//防守犯规数据
	public ArrayList<TeamDefensiveFoulsVO> getTeamDefensiveFoulsStatsAverage(String season, Conference conference, Division division) throws TeamNotFound;
	
	
	//迭代二
	public ArrayList<Date> getAvailableDays(String season, Teams team);
	public ArrayList<TeamHotStatsVO> getHotTeams(String season, Terminology term, int num);
	
	
	public TeamOffensiveStatsVO getOffensiveStats(String season, Date date, Teams team) throws TeamNotFound;
	public TeamDefensiveFoulsVO getDefensiveStats(String season, Date date, Teams team) throws TeamNotFound;
	public TeamRatioGeneralVO getRatioStats(String season, Date date, Teams team) throws TeamNotFound;
	
	//某球队单个赛季数据
	public TeamOffensiveStatsVO getTeamOffensiveStatsAverage(String season, Teams team) throws TeamNotFound;
	public TeamRatioGeneralVO getTeamRatioGeneralStatsAverage(String season, Teams team) throws TeamNotFound;
	public TeamDefensiveFoulsVO getTeamDefensiveFoulsStatsAverage(String season, Teams team) throws TeamNotFound;
	public TeamOffensiveStatsVO getTeamOffensiveStatsTotal(String season, Teams team) throws TeamNotFound;
	public TeamRatioGeneralVO getTeamRatioGeneralStatsTotal(String season, Teams team) throws TeamNotFound;
	public TeamDefensiveFoulsVO getTeamDefensiveFoulsStatsTotal(String season, Teams team) throws TeamNotFound;

}
