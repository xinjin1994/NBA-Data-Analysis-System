package data.matchesData;

import java.util.ArrayList;

import po.MatchPO;
import po.PlayerStatsPO;
import dataService.matchesDataService.MatchesDataService;
import enums.Teams;
import exceptions.MatchNotFound;
import exceptions.TeamNotFound;
import factory.ObjectCreator;

public class MatchesData implements MatchesDataService {
	ReadMatches reader;
	
	static ArrayList<MatchPO> matchList;
	
	public MatchesData(){
		reader = new ObjectCreator().matchesReader();
		
		if(matchList == null){
			matchList = reader.readAllMatches();
		}
	}

	@Override
	public MatchPO getMatch(String season, String date, Teams homeTeam,
			Teams guestTeam) throws MatchNotFound {
		for(int i=0; i<matchList.size(); i++){
			MatchPO match = matchList.get(i);
			if(match.season().equals(season) && match.date().equals(date) && 
			        match.homeTeam() == homeTeam && match.guestTeam() == guestTeam){
				return match;
			}
		}
		
		throw new MatchNotFound("");
	}

	@Override
	public ArrayList<MatchPO> getMatches(String season, String date,
			Teams team1, Teams team2) throws MatchNotFound {
		ArrayList<MatchPO> list = new ArrayList<MatchPO>();
		
		for(int i=0; i<matchList.size(); i++){
			MatchPO match = matchList.get(i);
			boolean seasonOK = (season == null || match.season().equals(season));
			boolean dateOK = (date == null || match.date().equals(date));
			boolean homeTeamOK = (team1 == Teams.ALL || match.homeTeam() == team1 || match.guestTeam() == team1);
			boolean guestTeamOK = (team2 == null || team2 == Teams.ALL || match.guestTeam() == team2 || match.guestTeam() == team2);
			
			if(seasonOK && dateOK && homeTeamOK && guestTeamOK){
				list.add(match);
			}
		}
		
		if(list.size() != 0){
			return list;
		}else{
			throw new MatchNotFound("");
		}
	}

	@Override
	public ArrayList<MatchPO> getMatches(String name) throws MatchNotFound {
		ArrayList<MatchPO> list = new ArrayList<MatchPO>();
		for(int i=0; i<matchList.size(); i++){
			MatchPO match = matchList.get(i);
			if(hasPlayer(match, name)){
				list.add(match);
			}
		}
		
		if(list.size() != 0){
			return list;
		}else{
			throw new MatchNotFound("");
		}
	}
	
	private boolean hasPlayer(MatchPO match, String name){
		ArrayList<PlayerStatsPO> list = match.team1Players();
		for(int i=0; i<list.size(); i++){
			if(list.get(i).name().equals(name)){
				return true;
			}
		}
		
		list = match.team2Players();
		for(int i=0; i<list.size(); i++){
			if(list.get(i).name().equals(name)){
				return true;
			}
		}
		
		return false;
	}
	
	private Teams getTeam(MatchPO match, String player){
		ArrayList<PlayerStatsPO> list = match.team1Players();
		for(int i=0; i<list.size(); i++){
			if(list.get(i).name().equals(player)){
				return match.homeTeam();
			}
		}
		
		list = match.team2Players();
		for(int i=0; i<list.size(); i++){
			if(list.get(i).name().equals(player)){
				return match.guestTeam();
			}
		}
		
		return null;
	}

	@Override
	public Teams getTeam(String player) throws TeamNotFound {
		int n = 0;                          //寻找最后一场比赛的位置，即4月最后一场
		for(; n<matchList.size(); n++){
			if(matchList.get(n).date().compareTo("05-01") > 0){
				break;
			}
		}
		
		n--;
		
		for(int i=n; i>=0; i--){
			Teams team = getTeam(matchList.get(i), player);
			if(team != null){
				return team;
			}
		}
		
		for(int i=matchList.size()-1; i>n; i--){
			Teams team = getTeam(matchList.get(i), player);
			if(team != null){
				return team;
			}
		}
		
		throw new TeamNotFound("");
	}

}
