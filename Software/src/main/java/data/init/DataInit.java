package data.init;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

import po.MatchPO;
import po.PlayerPO;
import po.TeamPO;
import data.matchesData.MatchesData_new;
import data.matchesData.Matches_new;
import data.playersData.PlayerStats_new;
import data.playersData.PlayersData_new;
import data.playersData.Players_new;
import data.teamsData.TeamStats_new;
import data.teamsData.TeamsData_new;
import data.teamsData.Teams_new;
import enums.Teams;

public class DataInit {
	HashMap<String, Players_new> playerMap;
	HashMap<Teams, Teams_new> teamMap;
	ArrayList<Matches_new> matchList;
	
	Calculator calculator;
	
	String path;
	
	public DataInit(){
		path = null;
		playerMap = new HashMap<String, Players_new>();
		teamMap = new HashMap<Teams, Teams_new>();
		matchList = new ArrayList<Matches_new>();
	}
	
	public DataInit(String filepath){
		path = filepath;
		playerMap = new HashMap<String, Players_new>();
		teamMap = new HashMap<Teams, Teams_new>();
		matchList = new ArrayList<Matches_new>();
	}
	
	public void init(){
		initHashMap();
		distributeData();
		
		setupData();
	}
	
	private void initHashMap(){
		ArrayList<PlayerPO> players = new data.playersData.ReadFromTxt().readAllPlayers(path);
		for(PlayerPO player: players){
			Players_new p = new Players_new(player.name(), player);
			playerMap.put(player.name(), p);
		}
		
		ArrayList<TeamPO> teams = new data.teamsData.ReadFromTxt().readAllTeams(path);
		for(TeamPO team: teams){
			Teams_new t = new Teams_new(team.name(), team);
			teamMap.put(team.name(), t);
		}
		
	}
	
	private void distributeData(){
		ArrayList<MatchPO> matches = new data.matchesData.ReadFromTxt().readAllMatches(path);
		Collections.sort(matches, new sorter.data.SortByDate());
		for(MatchPO match: matches){
			calculator = new Calculator(match);
			ArrayList<PlayerStats_new> players = calculator.getPlayerStats();
			for(PlayerStats_new player: players){
				Players_new p = playerMap.get(player.getName());
				if(p == null){
					playerMap.put(player.getName(), new Players_new(player.getName(), null));
				}
				playerMap.get(player.getName()).addStats(player);
			}
			
			ArrayList<TeamStats_new> teams = calculator.getTeamStats();
			for(TeamStats_new team: teams){
				Teams team_enum;
				if(team.getTeam().equals(Teams.NOH)){
					team_enum = Teams.NOP;
				}else{
					team_enum = team.getTeam();
				}
				teamMap.get(team_enum).addStats(team);
			}
			
			matchList.add(calculator.getMatchStats());
		}
	}
	
	private void setupData(){
		ArrayList<Players_new> players = new ArrayList<Players_new>();
		for(Players_new player: playerMap.values()){
			players.add(player);
		}
		new PlayersData_new(players);
		
		ArrayList<Teams_new> teams = new ArrayList<Teams_new>();
		for(Teams_new team: teamMap.values()){
			teams.add(team);
		}
		new TeamsData_new(teams);
		
		new MatchesData_new(matchList);
	}
	
}
