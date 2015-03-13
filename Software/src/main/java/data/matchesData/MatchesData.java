package data.matchesData;

import java.util.ArrayList;
import po.MatchPO;
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
			Teams homeTeam, Teams guestTeam) throws MatchNotFound {
		ArrayList<MatchPO> list = new ArrayList<MatchPO>();
		
		for(int i=0; i<matchList.size(); i++){
			MatchPO match = matchList.get(i);
			boolean seasonOK = (season == null || match.season().equals(season));
			boolean dateOK = (date == null || match.date().equals(date));
			boolean homeTeamOK = (homeTeam == null || match.homeTeam() == homeTeam);
			boolean guestTeamOK = (guestTeam == null || match.guestTeam() == guestTeam);
			
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

}
