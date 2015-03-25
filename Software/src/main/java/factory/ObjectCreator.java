package factory;


import businessLogic.matchesBL.MatchesBL;
import businessLogic.teamsBL.TeamsBL;
import businessLogic.teamsBL.TeamsBL_new;
import businessLogicService.matchesBLService.PlayerDataInMatchesService;
import businessLogicService.matchesBLService.TeamDataInMatchesService;
import businessLogicService.teamsBLService.PlayersInTeamsService;
import businessLogicService.teamsBLService.TeamInfoService;
import data.imageData.ImageData;
import data.matchesData.MatchesData;
import data.matchesData.MatchesData_new;
import data.playersData.PlayersData;
import data.playersData.PlayersData_new;
import data.teamsData.TeamsData;
import data.teamsData.ReadTeams;
import data.teamsData.TeamsData_new;
import data.playersData.ReadPlayers;
import data.matchesData.ReadMatches;
import dataService.imageService.ImageService;
import dataService.matchesDataService.MatchesDataService;
import dataService.matchesDataService.MatchesDataService_new;
import dataService.playersDataService.PlayersDataService;
import dataService.playersDataService.PlayersDataService_new;
import dataService.teamsDataService.TeamsDataService;
import dataService.teamsDataService.TeamsDataService_new;

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

	
	
	
	
	
	
	
	
	
	
	
	
	
	//用于*_new
	public MatchesDataService_new matchesDataService_new(){
		return new MatchesData_new();
	}
	
	public PlayersDataService_new playersDataService_new(){
		return new PlayersData_new();
	}
	
	public TeamsDataService_new teamsDataService_new(){
		return new TeamsData_new();
	}
	
	public PlayersInTeamsService playersInTeamsService(){
		return new TeamsBL_new();
	}
	
	
}
