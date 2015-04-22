package data.matchesData;

import java.util.ArrayList;

import po.MatchPO_new;
import dataService.matchesDataService.MatchesDataService_new;
import enums.Teams;
import exceptions.MatchNotFound;
import exceptions.StatsNotFound;

public class MatchesData_new implements MatchesDataService_new {
	static ArrayList<Matches_new> matches;
	
	public MatchesData_new(ArrayList<Matches_new> matches) {
		//仅用于数据初始化
		if(MatchesData_new.matches == null){
			MatchesData_new.matches = matches;
		}
	}
	
	public MatchesData_new() {
		//do nothing
	}
	
	public static void addData(Matches_new match){
		matches.add(0, match);
	}
	
	public ArrayList<Matches_new> getData(){
		//测试用
		return matches;
	}

	@Override
	public MatchPO_new getMatch(String season, String date, Teams team1,
			Teams team2) throws MatchNotFound {
		for(Matches_new match: matches){
			boolean seasonOK = match.season.equals(season);
			boolean dateOK = match.date.equals(date);
			boolean teamOK = (match.homeTeam == team1 && match.guestTeam == team2)
					      || (match.homeTeam == team2 && match.guestTeam == team1);
			
			if(seasonOK && dateOK && teamOK){
				return match.toPO();
			}
		}
		
		throw new MatchNotFound("比赛不存在");
	}

	@Override
	public ArrayList<MatchPO_new> getMatches(String season, String date,
			Teams team1, Teams team2) throws MatchNotFound {
		ArrayList<MatchPO_new> list = new ArrayList<MatchPO_new>();
		for(Matches_new match: matches){
			boolean seasonOK = season == null ||match.season.equals(season);
			boolean dateOK = date == null || match.date.equals(date);
			boolean teamOK;
			if(team1 == Teams.ALL){
				teamOK = team2 == Teams.ALL || team2 == match.homeTeam 
						                    || team2 == match.guestTeam;
			}else if(team2 == Teams.ALL){
				teamOK = team1 == Teams.ALL || team1 == match.homeTeam 
						                    || team1 == match.guestTeam;
			}else{
				teamOK = (match.homeTeam == team1 && match.guestTeam == team2)
						  || (match.homeTeam == team2 && match.guestTeam == team1);
			}
			
			if(seasonOK && dateOK && teamOK){
				list.add(match.toPO());
			}
		}
		
		if(list.size() != 0){
			return list;
		}else{
			throw new MatchNotFound("比赛不存在");
		}
	}

	@Override
	public ArrayList<String> getAvailableSeasons() throws StatsNotFound {
		ArrayList<String> seasons = new ArrayList<String>();
		for(Matches_new match: matches){
			if(!seasons.contains(match.season)){
				seasons.add(match.season);
			}
			if(match.season.equals(matches.get(matches.size()-1)))
				break;
		}
		
		if(seasons.size()!=0){
			return seasons;
		}else{
		    throw new StatsNotFound();
		}
	}

	@Override
	public ArrayList<String> getAvailableDays(String season) throws StatsNotFound {
		ArrayList<String> days = new ArrayList<String>();
		for(Matches_new match: matches){
			if(match.season.equals(season) && !days.contains(match.date)){
				days.add(match.date);
			}
		}
		
		if(days.size()!=0){
			return days;
		}else{
		    throw new StatsNotFound();
		}
	}

	@Override
	public MatchPO_new getMatches(String season, String date,
			String player) throws MatchNotFound {
		MatchPO_new po = new MatchPO_new();
		int test = 0;
		for(Matches_new match: matches){
			if(match.getSeason().equals(season)&&match.getDate().equals(date)){
				if(match.getHomeTeamPlayers().contains(player)||match.getGuestTeamPlayers().contains(player)){
					po=match.toPO();
					test=1;
				}
			}
		}
		
		if(test==1){
		   return po;
		}else{
			throw new MatchNotFound("比赛未找到");
		}
	}

	@Override
	public MatchPO_new getMatches(String season, String date,
			Teams team) throws MatchNotFound {
		MatchPO_new po = new MatchPO_new();
		int test = 0;
		for(Matches_new match: matches){
			if(match.getHomeTeam()==team||match.getGuestTeam()==team){
				if(match.getSeason().equals(season)&&match.getDate().equals(date)){
				    po = match.toPO();
				    test = 1;
				}
			}
		}
		
		if(test==1){
			return po;
		}else{
			throw new MatchNotFound("比赛未找到");
		}
	}

	@Override
	public ArrayList<MatchPO_new> getMatches(Teams team, int num) throws MatchNotFound {
		ArrayList<MatchPO_new> list = new ArrayList<MatchPO_new>();
		int count=0;
		if(num==0){
			return list;
		}
		for(Matches_new match: matches) {
			if(match.getHomeTeam()==team||match.getGuestTeam()==team){
				list.add(match.toPO());
				count++;
			}
			if(count==num)
				break;
		}
		
		if(list.size()!=0){
			return list;
		}else{
			throw new MatchNotFound("比赛未找到");
		}
	}

	@Override
	public ArrayList<MatchPO_new> getMatches(String player, int num) throws MatchNotFound {
		ArrayList<MatchPO_new> list = new ArrayList<MatchPO_new>();
		if(num==0){
			return list;
		}
		int count=0;
		for(Matches_new match: matches) {
			if(match.getHomeTeamPlayers().contains(player)||match.getGuestTeamPlayers().contains(player)){
				list.add(match.toPO());
				count++;
			}
			if(count==num)
				break;
		}
		
		if(list.size()!=0){
			return list;
		}else{
			throw new MatchNotFound("比赛未找到");
		}
	}

	@Override
	public ArrayList<MatchPO_new> getMatches(String season, String date) throws MatchNotFound {
		ArrayList<MatchPO_new> list = new ArrayList<MatchPO_new>();
		for(Matches_new match: matches) {
			if(match.getSeason().equals(season)&&match.getDate().equals(date)){
				list.add(match.toPO());
			}
		}
		
		if(list.size()!=0){
			return list;
		}else{
			throw new MatchNotFound("比赛未找到");
		}
	}
	
	@Override
	public ArrayList<MatchPO_new> getMatches (String season) throws MatchNotFound {
		ArrayList<MatchPO_new> list = new ArrayList<MatchPO_new>();
		for(Matches_new match: matches) {
			if(match.getSeason().equals(season)){
				list.add(match.toPO());
			}
		}
		
		if(list.size()!=0){
			return list;
		}else{
			throw new MatchNotFound("比赛未找到");
		}
	}
	
}
