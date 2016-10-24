package businessLogicService.matchesBLService;

import java.util.ArrayList;
import java.util.Date;

import enums.Teams;
import exceptions.MatchNotFound;
import exceptions.StatsNotFound;
import exceptions.TeamNotFound;
import vo.MatchVO;

public interface MatchesBLService {
	//获取比赛基本数据
	//详细数据从球队、球员模块获取
	public MatchVO getMatchVO(String season, String date, Teams team1, Teams team2) throws TeamNotFound, MatchNotFound;
	public ArrayList<MatchVO> getMatchesVO(String season, String date, Teams team1, Teams team2) throws TeamNotFound, MatchNotFound;
	
	//迭代二
	public ArrayList<String> getAvailableSeasons() throws StatsNotFound;
	public ArrayList<Date> getAvailableDays(String season) throws StatsNotFound;
	
	//获取单场比赛
	public MatchVO getMatch(String season, Date date, String player) throws MatchNotFound;
	public MatchVO getMatch(String season, Date date, Teams team) throws MatchNotFound;
	
	//获取最近num场比赛
	public ArrayList<MatchVO> getMatch(Teams team, int num) throws MatchNotFound;
	public ArrayList<MatchVO> getMatch(String player, int num) throws MatchNotFound;
	
	//获取某日/赛季比赛
	public ArrayList<MatchVO> getMatchByDate() throws MatchNotFound;                      //当天
	public ArrayList<MatchVO> getMatchByDate(String season, Date date) throws MatchNotFound;
	public ArrayList<MatchVO> getMatchBySeason() throws MatchNotFound;                    //最后一个赛季
	public ArrayList<MatchVO> getMatchBySeason(String season) throws MatchNotFound;
}
