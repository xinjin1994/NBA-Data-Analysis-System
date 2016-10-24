package businessLogicService.matchesBLService;

import java.util.ArrayList;

import businessLogic.teamsBL.BasicTeamStats;
import businessLogic.teamsBL.TeamStatsForCalculation;
import enums.Teams;
import exceptions.TeamNotFound;

public interface TeamDataInMatchesService {
	//获取比赛的详细数据
	//仅提供给球队模块的业务逻辑层
	
	public ArrayList<TeamStatsForCalculation> getTeamDataForCalculation(Teams team) throws TeamNotFound;
	public ArrayList<BasicTeamStats> getBasicTeamStats(Teams team) throws TeamNotFound;
}
