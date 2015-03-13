package data.teamsData;

import java.util.ArrayList;
import po.TeamPO;
import dataService.teamsDataService.TeamsDataService;
import enums.Conference;
import enums.Division;
import enums.Teams;
import factory.ObjectCreater;
import exceptions.TeamNotFound;

public class TeamsData implements TeamsDataService {
	ReadTeams reader;
	
	ArrayList<TeamPO> teamList;
	
	public TeamsData(){
		reader = new ObjectCreater().teamsReader();
		teamList = reader.readAllTeams();
	}

	@Override
	public TeamPO getTeam(Teams team) throws TeamNotFound {
		for(int i=0; i<teamList.size(); i++){
			TeamPO temp = teamList.get(i);
			if(temp.name() == team){
				return temp;
			}
		}
		
		throw new TeamNotFound(team.toString());
	}

	@Override
	public ArrayList<TeamPO> getTeams(Conference conference, Division division) throws TeamNotFound {
		ArrayList<TeamPO> list = new ArrayList<TeamPO>();
		for(int i=0; i<teamList.size(); i++){
			TeamPO team = teamList.get(i);
			if(team.conference() == conference && team.division() == division){
				list.add(team);
			}
		}
		
		if(list.size() != 0){
			return list;
		}else{
			throw new TeamNotFound("");
		}
	}
	
	@Override
	public ArrayList<TeamPO> getAllTeams() throws TeamNotFound {
		if(teamList.size() != 0){
			return teamList;
		}else{
			throw new TeamNotFound("");
		}
	}

}
