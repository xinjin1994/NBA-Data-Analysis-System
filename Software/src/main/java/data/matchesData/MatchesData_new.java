package data.matchesData;

import java.util.ArrayList;

import po.MatchPO_new;
import dataService.matchesDataService.MatchesDataService_new;
import enums.Teams;
import exceptions.MatchNotFound;

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
	
}
