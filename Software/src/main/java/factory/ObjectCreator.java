package factory;

import businessLogic.matchesBL.MatchesBL;
import businessLogic.teamsBL.TeamsBL;
import businessLogicService.matchesBLService.PlayerDataInMatchesService;
import businessLogicService.matchesBLService.TeamDataInMatchesService;
import businessLogicService.teamsBLService.TeamInfoService;
import data.imageData.ImageData;
import data.matchesData.MatchesData;
import data.playersData.PlayersData;
import data.teamsData.TeamsData;
import data.teamsData.ReadTeams;
import data.playersData.ReadPlayers;
import data.matchesData.ReadMatches;
import dataService.imageService.ImageService;
import dataService.matchesDataService.MatchesDataService;
import dataService.playersDataService.PlayersDataService;
import dataService.teamsDataService.TeamsDataService;

public class ObjectCreator {
	
	public TeamInfoService teamInfoService(){
		return new TeamsBL();
	}
	
	public TeamDataInMatchesService teamDataInMatchesService(){
		return new MatchesBL();
	}
	
	public PlayerDataInMatchesService dataInMatchesService(){
		return new MatchesBL();
	}
	
	public MatchesDataService matchesDataService(){
		return new MatchesData();
	}
	
	public PlayersDataService playersDataService(){
		return new PlayersData();
	}
	
	public TeamsDataService teamsDataService(){
		return new TeamsData();
	}
	
	
	public ReadTeams teamsReader(){
		return new data.teamsData.ReadFromTxt();
	}
	
	public ReadPlayers playersReader(){
		return new data.playersData.ReadFromTxt();
	}
	
	public ReadMatches matchesReader(){
		return new data.matchesData.ReadFromTxt();
	}
	
	public ImageService imageService(){
		return new ImageData();
	}

}
