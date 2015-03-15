package data.matchesData;

import java.util.ArrayList;

import po.MatchPO;
import po.PlayerStatsPO;
import dataService.matchesDataService.MatchesDataService;
import enums.Teams;
import exceptions.MatchNotFound;
import factory.ObjectCreater;

public class MatchesData implements MatchesDataService {
	ReadMatches reader;
	
	ArrayList<MatchPO> matchList;
	
	public MatchesData(){
		reader = new ObjectCreater().matchesReader();
		matchList = reader.readAllMatches();
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
			boolean homeTeamOK = (team1 == null || match.homeTeam() == team1 || match.guestTeam() == team1);
			boolean guestTeamOK = (team2 == null || match.guestTeam() == team2 || match.guestTeam() == team2);
			
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

}
