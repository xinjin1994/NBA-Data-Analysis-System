package businessLogic.matchesBL;

import helper.TypeTransform;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import po.MatchPO_new;
import dataService.matchesDataService.MatchesDataService_new;
import vo.MatchVO;
import enums.Teams;
import exceptions.MatchNotFound;
import exceptions.StatsNotFound;
import exceptions.TeamNotFound;
import factory.ObjectCreator;
import businessLogicService.matchesBLService.MatchesBLService;

public class MatchesBL_new implements MatchesBLService {
	
	MatchesDataService_new matchService;
	
	public MatchesBL_new(){
		matchService = new ObjectCreator().matchesDataService_new();
	}

	@Override
	public MatchVO getMatchVO(String season, String date, Teams team1,
			Teams team2) throws TeamNotFound, MatchNotFound {
		MatchPO_new po = matchService.getMatch(season, date, team1, team2);
		MatchVO vo = new MatchVO(po.getSeason(), po.getDate(), po.getHomeTeam(), po.getGuestTeam(),
				po.getScore(), po.getScore1(), po.getScore2(), po.getScore3(),
				po.getScore4(), po.getScoreExtra(), po.getHomeTeamPlayers(), po.getGuestTeamPlayers());
		return vo;
	}

	@Override
	public ArrayList<MatchVO> getMatchesVO(String season, String date,
			Teams team1, Teams team2) throws TeamNotFound, MatchNotFound {
		ArrayList<MatchVO> voList = new ArrayList<MatchVO>();
		ArrayList<MatchPO_new> poList = matchService.getMatches(season, date, team1, team2);
		for(MatchPO_new po: poList){
			MatchVO vo = new MatchVO(po.getSeason(), po.getDate(), po.getHomeTeam(), po.getGuestTeam(),
					po.getScore(), po.getScore1(), po.getScore2(), po.getScore3(),
					po.getScore4(), po.getScoreExtra(), po.getHomeTeamPlayers(), po.getGuestTeamPlayers());
			voList.add(vo);
		}
		
		return voList;
	}
	
	
	
	
	//迭代二

	@Override
	public ArrayList<String> getAvailableSeasons() throws StatsNotFound {
		ArrayList<String> seasons=matchService.getAvailableSeasons();
		
		return seasons;
	}

	@Override
	public ArrayList<Date> getAvailableDays(String season) throws StatsNotFound {
		ArrayList<String> days=matchService.getAvailableDays(season);
		ArrayList<Date> result = new ArrayList<Date>();
		for(String d: days){
			result.add(TypeTransform.str_to_date(d));
		}
		
		return result;
	}

	@Override
	public MatchVO getMatch(String season, Date date, String player) throws MatchNotFound {
		MatchPO_new po = matchService.getMatches(season, TypeTransform.date_to_str(date), player);
		MatchVO vo = new MatchVO(po.getSeason(), po.getDate(), po.getHomeTeam(), po.getGuestTeam(),
				po.getScore(), po.getScore1(), po.getScore2(), po.getScore3(),
				po.getScore4(), po.getScoreExtra(), po.getHomeTeamPlayers(), po.getGuestTeamPlayers());
		
		return vo;
	}

	@Override
	public MatchVO getMatch(String season, Date date, Teams team) throws MatchNotFound {
		MatchPO_new po = matchService.getMatches(season, TypeTransform.date_to_str(date), team);
		MatchVO vo = new MatchVO(po.getSeason(), po.getDate(), po.getHomeTeam(), po.getGuestTeam(),
				po.getScore(), po.getScore1(), po.getScore2(), po.getScore3(),
				po.getScore4(), po.getScoreExtra(), po.getHomeTeamPlayers(), po.getGuestTeamPlayers());
		
		return vo;
	}

	@Override
	public ArrayList<MatchVO> getMatch(Teams team, int num) throws MatchNotFound {
		ArrayList<MatchPO_new> polist = matchService.getMatches(team, num);
		ArrayList<MatchVO> volist = new ArrayList<MatchVO>();
		for(MatchPO_new po: polist){
			MatchVO vo = new MatchVO(po.getSeason(), po.getDate(), po.getHomeTeam(), po.getGuestTeam(),
					po.getScore(), po.getScore1(), po.getScore2(), po.getScore3(),
					po.getScore4(), po.getScoreExtra(), po.getHomeTeamPlayers(), po.getGuestTeamPlayers());
			volist.add(vo);
		}
		
		return volist;
	}

	@Override
	public ArrayList<MatchVO> getMatch(String player, int num) throws MatchNotFound {
		ArrayList<MatchPO_new> polist = matchService.getMatches(player, num);
		ArrayList<MatchVO> volist = new ArrayList<MatchVO>();
		for(MatchPO_new po: polist){
			MatchVO vo = new MatchVO(po.getSeason(), po.getDate(), po.getHomeTeam(), po.getGuestTeam(),
					po.getScore(), po.getScore1(), po.getScore2(), po.getScore3(),
					po.getScore4(), po.getScoreExtra(), po.getHomeTeamPlayers(), po.getGuestTeamPlayers());
			volist.add(vo);
		}
		
		return volist;
	}

	@Override
	public ArrayList<MatchVO> getMatchByDate() throws MatchNotFound {
		Calendar cal = Calendar.getInstance();
		Date now = cal.getTime();
		String date= TypeTransform.date_to_str(now);
		int year = cal.get(Calendar.YEAR)%100;
		int nextyear = (year+1)%100;
		String season = Integer.toString(year)+"-"+Integer.toString(nextyear);
		ArrayList<MatchPO_new> polist = matchService.getMatches(season, date);
		ArrayList<MatchVO> volist = new ArrayList<MatchVO>();
		for(MatchPO_new po: polist){
			MatchVO vo = new MatchVO(po.getSeason(), po.getDate(), po.getHomeTeam(), po.getGuestTeam(),
					po.getScore(), po.getScore1(), po.getScore2(), po.getScore3(),
					po.getScore4(), po.getScoreExtra(), po.getHomeTeamPlayers(), po.getGuestTeamPlayers());
			volist.add(vo);
		}
		
		return volist;
	}

	@Override
	public ArrayList<MatchVO> getMatchByDate(String season, Date date) throws MatchNotFound {
		ArrayList<MatchPO_new> polist = matchService.getMatches(season, TypeTransform.date_to_str(date));
		ArrayList<MatchVO> volist = new ArrayList<MatchVO>();
		for(MatchPO_new po: polist){
			MatchVO vo = new MatchVO(po.getSeason(), po.getDate(), po.getHomeTeam(), po.getGuestTeam(),
					po.getScore(), po.getScore1(), po.getScore2(), po.getScore3(),
					po.getScore4(), po.getScoreExtra(), po.getHomeTeamPlayers(), po.getGuestTeamPlayers());
			volist.add(vo);
		}
		
		return volist;
	}

	@Override
	public ArrayList<MatchVO> getMatchBySeason() throws MatchNotFound {
		Calendar cal = Calendar.getInstance();
		int year = cal.get(Calendar.YEAR)%100;
		int nextyear = (year+1)%100;
		String season = Integer.toString(year)+"-"+Integer.toString(nextyear);
		ArrayList<MatchPO_new> polist = matchService.getMatches(season);
		ArrayList<MatchVO> volist = new ArrayList<MatchVO>();
		for(MatchPO_new po: polist){
			MatchVO vo = new MatchVO(po.getSeason(), po.getDate(), po.getHomeTeam(), po.getGuestTeam(),
					po.getScore(), po.getScore1(), po.getScore2(), po.getScore3(),
					po.getScore4(), po.getScoreExtra(), po.getHomeTeamPlayers(), po.getGuestTeamPlayers());
			volist.add(vo);
		}
		
		return volist;
	}

	@Override
	public ArrayList<MatchVO> getMatchBySeason(String season) throws MatchNotFound {
		ArrayList<MatchPO_new> polist = matchService.getMatches(season);
		ArrayList<MatchVO> volist = new ArrayList<MatchVO>();
		for(MatchPO_new po: polist){
			MatchVO vo = new MatchVO(po.getSeason(), po.getDate(), po.getHomeTeam(), po.getGuestTeam(),
					po.getScore(), po.getScore1(), po.getScore2(), po.getScore3(),
					po.getScore4(), po.getScoreExtra(), po.getHomeTeamPlayers(), po.getGuestTeamPlayers());
			volist.add(vo);
		}
		
		return volist;
	}

}
