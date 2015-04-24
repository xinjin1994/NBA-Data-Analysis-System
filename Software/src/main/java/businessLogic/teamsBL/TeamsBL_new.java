package businessLogic.teamsBL;

import helper.TypeTransform;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import po.TeamDefensiveFoulsStatsPO;
import po.TeamHotStatsPO;
import po.TeamOffensiveStatsPO;
import po.TeamPO;
import po.TeamRatioGeneralStatsPO;
import sorter.teams.highinfo.HighInfoSorter;
import sorter.teams.normalinfo.NormalInfoSorter;
import data.imageData.ImageData;
import data.matchesData.MatchesData_new;
import data.teamsData.TeamsData_new;
import dataService.imageService.ImageService;
import dataService.teamsDataService.TeamsDataForTest;
import dataService.teamsDataService.TeamsDataService_new;
import vo.TeamDefensiveFoulsVO;
import vo.TeamHotStatsVO;
import vo.TeamOffensiveStatsVO;
import vo.TeamRatioGeneralVO;
import vo.TeamVO;
import enums.Conference;
import enums.Division;
import enums.Teams;
import enums.Terminology;
import exceptions.TeamNotFound;
import factory.ObjectCreator;
import businessLogicService.teamsBLService.PlayersInTeamsService;
import businessLogicService.teamsBLService.TeamsBLForTest;
import businessLogicService.teamsBLService.TeamsBLService_new;
import test.data.*;

public class TeamsBL_new implements TeamsBLService_new, PlayersInTeamsService, TeamsBLForTest{
	TeamsDataService_new teamService;
	ImageService imageService;
	TeamsDataForTest teamForTest;
	
	public TeamsBL_new(){
		teamService = new ObjectCreator().teamsDataService_new();
		imageService = new ImageData();
		teamForTest = new TeamsData_new();
	}

	@Override
	public TeamVO getTeamInfo(Teams team) throws TeamNotFound {
		TeamPO po = teamService.getTeam(team);
		TeamVO vo = new TeamVO(po.name(), team.toAbbr(), po.location(), po.conference(),
				po.division(), po.homeCourt(), po.yearOfEstablishment());
		vo.setImage(imageService.getTeamImage(team));
		return vo;
	}

	@Override
	public ArrayList<TeamVO> getAllTeamsInfo() {
		ArrayList<TeamVO> voList = new ArrayList<TeamVO>();
		ArrayList<TeamPO> poList = teamService.getAllTeams();
		for(TeamPO po: poList){
			TeamVO vo = new TeamVO(po.name(), po.abbreviationOfName(), po.location(), po.conference(),
					po.division(), po.homeCourt(), po.yearOfEstablishment());
			vo.setImage(imageService.getTeamImage(po.name()));
			voList.add(vo);
		}
		
		return voList;
	}

	@Override
	public ArrayList<TeamVO> getTeamsInfo(Conference conference,
			Division division) throws TeamNotFound {
		ArrayList<TeamVO> voList = new ArrayList<TeamVO>();
		ArrayList<TeamPO> poList = teamService.getTeams(conference, division);
		for(TeamPO po: poList){
			TeamVO vo = new TeamVO(po.name(), po.abbreviationOfName(), po.location(), po.conference(),
					po.division(), po.homeCourt(), po.yearOfEstablishment());
			vo.setImage(imageService.getTeamImage(po.name()));
			voList.add(vo);
		}
		
		return voList;
	}

	@Override
	public ArrayList<TeamOffensiveStatsVO> getTeamOffensiveStatsTotal(String season,
			Conference conference, Division division) throws TeamNotFound {
		ArrayList<Teams> teamNames = teamService.getTeamNames(conference, division);
		ArrayList<TeamOffensiveStatsVO> voList = new ArrayList<TeamOffensiveStatsVO>();
		for(Teams team: teamNames){
			ArrayList<TeamOffensiveStatsPO> poList = teamService.getOffensiveStats(season, team);
			TeamOffensiveStatsVO vo = this.sum_offensive(poList);
			voList.add(vo);
		}
		
		return voList;
	}

	@Override
	public ArrayList<TeamRatioGeneralVO> getTeamRatioGeneralStatsTotal(String season,
			Conference conference, Division division) throws TeamNotFound {
		ArrayList<Teams> teamNames = teamService.getTeamNames(conference, division);
		ArrayList<TeamRatioGeneralVO> voList = new ArrayList<TeamRatioGeneralVO>();
		for(Teams team: teamNames){
			ArrayList<TeamRatioGeneralStatsPO> poList = teamService.getRatioGeneralStats(season, team);
			TeamRatioGeneralVO vo = this.sum_ratio(poList);
			voList.add(vo);
		}
		
		return voList;
	}

	@Override
	public ArrayList<TeamDefensiveFoulsVO> getTeamDefensiveFoulsStatsTotal(String season,
			Conference conference, Division division) throws TeamNotFound {
		ArrayList<Teams> teamNames = teamService.getTeamNames(conference, division);
		ArrayList<TeamDefensiveFoulsVO> voList = new ArrayList<TeamDefensiveFoulsVO>();
		for(Teams team: teamNames){
			ArrayList<TeamDefensiveFoulsStatsPO> poList = teamService.getDefensiveFoulsStats(season, team);
			TeamDefensiveFoulsVO vo = this.sum_defensive(poList);
			voList.add(vo);
		}
		
		return voList;
	}

	@Override
	public ArrayList<TeamOffensiveStatsVO> getTeamOffensiveStatsAverage(String season,
			Conference conference, Division division) throws TeamNotFound {
		ArrayList<TeamOffensiveStatsVO> voList = this.getTeamOffensiveStatsTotal(season, conference, division);
		for(TeamOffensiveStatsVO vo: voList){
			vo.average();
		}
		
		return voList;
	}

	@Override
	public ArrayList<TeamRatioGeneralVO> getTeamRatioGeneralStatsAverage(String season,
			Conference conference, Division division) throws TeamNotFound {
		ArrayList<TeamRatioGeneralVO> list = this.getTeamRatioGeneralStatsTotal(season, conference, division);
		for(TeamRatioGeneralVO vo: list){
			vo.average();
		}
		return list;
	}

	@Override
	public ArrayList<TeamDefensiveFoulsVO> getTeamDefensiveFoulsStatsAverage(String season,
			Conference conference, Division division) throws TeamNotFound {
		ArrayList<TeamDefensiveFoulsVO> voList = this.getTeamDefensiveFoulsStatsTotal(season, 
				conference, division);
		for(TeamDefensiveFoulsVO vo: voList){
			vo.average();
		}
		
		return voList;
	}

	@Override
	public ArrayList<Teams> getTeams(Conference con, Division div)
			throws TeamNotFound {
		return teamService.getTeamNames(con, div);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	private TeamOffensiveStatsVO sum_offensive(ArrayList<TeamOffensiveStatsPO> poList){
		Teams team = poList.get(0).getTeam();
		int games = poList.size();
		double points = 0;
		double fieldGoalsMade = 0;
		double fieldGoalsAttempted = 0;
		double freeThrowsMade = 0;
		double freeThrowsAttempted = 0;
		double threePointFieldGoalsMade = 0;
		double threePointFieldGoalsAttempted = 0;
		double assists = 0;
		for(TeamOffensiveStatsPO po: poList){
			points += po.getPoints();
			fieldGoalsMade += po.getFieldGoalsMade();
			fieldGoalsAttempted += po.getFieldGoalsAttempted();
			freeThrowsMade += po.getFreeThrowsMade();
			freeThrowsAttempted += po.getFreeThrowsAttempted();
			threePointFieldGoalsMade += po.getThreePointFieldGoalsMade();
			threePointFieldGoalsAttempted += po.getThreePointFieldGoalsAttempted();
			assists += po.getAssists();
		}
		
		TeamOffensiveStatsVO vo = new TeamOffensiveStatsVO(team, games, points, fieldGoalsMade, 
				fieldGoalsAttempted, freeThrowsMade, freeThrowsAttempted, threePointFieldGoalsMade, 
				threePointFieldGoalsAttempted, assists);
		return vo;
	}
	
	private TeamDefensiveFoulsVO sum_defensive(ArrayList<TeamDefensiveFoulsStatsPO> poList){
		Teams team = poList.get(0).getTeam();
		int games = poList.size();
		double offensiveRebounds = 0;
		double defensiveRebounds = 0;
		double rebounds = 0;
		double steals = 0;
		double blocks = 0;
		double turnovers = 0;
		double fouls = 0;
		for(TeamDefensiveFoulsStatsPO po: poList){
			offensiveRebounds += po.getOffensiveRebounds();
			defensiveRebounds += po.getDefensiveRebounds();
			rebounds += po.getRebounds();
			steals += po.getSteals();
			blocks += po.getBlocks();
			turnovers += po.getTurnovers();
			fouls += po.getFouls();
		}
		
		TeamDefensiveFoulsVO vo = new TeamDefensiveFoulsVO(team, games, offensiveRebounds, 
				defensiveRebounds, rebounds, steals, blocks, turnovers, fouls);
		return vo;
		
	}
	
	private TeamRatioGeneralVO sum_ratio(ArrayList<TeamRatioGeneralStatsPO> poList){
		Teams team = poList.get(0).getTeam();
		int games = poList.size();
		int wins = poList.get(0).getWins();
		int fg_num = 0;
		int ft_num = 0;
		int tp_num = 0;
		double fieldGoalsPercentage = 0;
		double freeThrowsPercentage = 0;
		double threePointFieldGoalsPercentage = 0;
		double offensiveRounds = 0;
		double offensiveEfficiency = 0;
		double defensiveEfficiency = 0;
		double offensiveReboundsEfficiency = 0;
		double defensiveReboundsEfficiency = 0;
		double stealsEfficiency = 0;
		double assistsEfficiency = 0;
		for(TeamRatioGeneralStatsPO po: poList){
			fieldGoalsPercentage += po.getFieldGoalsPercentage();
			freeThrowsPercentage += po.getFreeThrowsPercentage();
			threePointFieldGoalsPercentage += po.getThreePointFieldGoalsPercentage();
		    offensiveRounds += po.getOffensiveRounds();
			offensiveEfficiency += po.getOffensiveEfficiency();
			defensiveEfficiency += po.getDefensiveEfficiency();
			offensiveReboundsEfficiency += po.getOffensiveReboundsEfficiency();
			defensiveReboundsEfficiency += po.getDefensiveReboundsEfficiency();
			stealsEfficiency += po.getStealsEfficiency();
			assistsEfficiency += po.getAssistsEfficiency();
			if(po.getFieldGoalsAttempted() != 0){
				fg_num++;
			}
			if(po.getFreeThrowsAttempted() != 0){
				ft_num++;
			}
			if(po.getThreePointFieldGoalsAttempted() != 0){
				tp_num++;
			}
		}
		
		TeamRatioGeneralVO vo = new TeamRatioGeneralVO(team, games, fieldGoalsPercentage/fg_num, 
				freeThrowsPercentage/ft_num, threePointFieldGoalsPercentage/tp_num, 
				offensiveRounds, offensiveEfficiency/games, 
				defensiveEfficiency/games, offensiveReboundsEfficiency/games, 
				defensiveReboundsEfficiency/games, stealsEfficiency/games, 
				assistsEfficiency/games, wins);
		return vo;
	}
	
	
	
	//迭代二

	@Override
	public ArrayList<Date> getAvailableDays(String season, Teams team) {
		ArrayList<String> days = teamService.getAvailableDays(season, team);
		ArrayList<Date> result = new ArrayList<Date>();
		for(String d: days){
			result.add(TypeTransform.str_to_date(d));
		}
		
		return result;
	}

	@Override
	public ArrayList<TeamHotStatsVO> getHotTeams(String season,
			Terminology term, int num) {
		ArrayList<TeamHotStatsPO> poList = teamService.getTeamHotStats(season, term);
		ArrayList<TeamHotStatsVO> voList = new ArrayList<TeamHotStatsVO>();
		for(TeamHotStatsPO po: poList){
			double stats = 0;
			for(double d: po.getStats()){
				stats += d;
			}
			stats /= po.getStats().size();
			TeamHotStatsVO vo = new TeamHotStatsVO(po.getTeam(), po.getConference(),
					po.getDivision(), stats);
			voList.add(vo);
		}
		
		ArrayList<TeamHotStatsVO> result = this.sort(voList, num);
		
		return result;
	}

	@Override
	public TeamOffensiveStatsVO getOffensiveStats(String season, Date date,
			Teams team) throws TeamNotFound {
		String d = TypeTransform.date_to_str(date);
		TeamOffensiveStatsPO po = teamService.getOffensiveStats(season, d, team);
		TeamOffensiveStatsVO vo = new TeamOffensiveStatsVO(po.getTeam(), 0, po.getPoints(), 
				po.getFieldGoalsMade(), po.getFieldGoalsAttempted(), 
				po.getFreeThrowsMade(), po.getFreeThrowsAttempted(), 
				po.getThreePointFieldGoalsMade(), po.getThreePointFieldGoalsAttempted(), 
				po.getAssists());
		
		return vo;
	}

	@Override
	public TeamDefensiveFoulsVO getDefensiveStats(String season, Date date,
			Teams team) throws TeamNotFound {
		String d = TypeTransform.date_to_str(date);
		TeamDefensiveFoulsStatsPO po = teamService.getDefensiveFoulsStats(season, d, team);
		TeamDefensiveFoulsVO vo = new TeamDefensiveFoulsVO(po.getTeam(), 0, po.getOffensiveRebounds(), 
				po.getDefensiveRebounds(), po.getRebounds(), po.getSteals(), po.getBlocks(), 
				po.getTurnovers(), po.getFouls());
		
		return vo;
	}

	@Override
	public TeamRatioGeneralVO getRatioStats(String season, Date date, Teams team) throws TeamNotFound {
		String d = TypeTransform.date_to_str(date);
		TeamRatioGeneralStatsPO po = teamService.getRatioGeneralStats(season, d, team);
		TeamRatioGeneralVO vo = new TeamRatioGeneralVO(po.getTeam(), 0, 
				po.getFieldGoalsPercentage(), po.getFreeThrowsPercentage(), 
				po.getThreePointFieldGoalsPercentage(), po.getOffensiveRounds(), 
				po.getOffensiveEfficiency(), po.getDefensiveEfficiency(), 
				po.getOffensiveReboundsEfficiency(), po.getDefensiveReboundsEfficiency(), 
				po.getStealsEfficiency(), po.getAssistsEfficiency(), po.getWins());
		
		return vo;
	}
	
	
	
	
	private ArrayList<TeamHotStatsVO> sort(ArrayList<TeamHotStatsVO> list, int num){
		ArrayList<TeamHotStatsVO> result = new ArrayList<TeamHotStatsVO>();
		Collections.sort(list, new CompareTeamHotStats());
		for(int i=list.size()-1; i>=list.size()-num; i--){
			result.add(list.get(i));
		}
		
		return result;
	}
	
	class CompareTeamHotStats implements Comparator<TeamHotStatsVO> {
		@Override
		public int compare(TeamHotStatsVO o1, TeamHotStatsVO o2) {
			if(o1.getStats() > o2.getStats()){
				return 1;
			}else if(o1.getStats() == o2.getStats()){
				return 0;
			}else{
				return -1;
			}
		}
		
	}

	@Override
	public ArrayList<TeamNormalInfo> getTeamNormalInfo_avg(
			Terminology[] sortField, boolean[] asc, int n) {
		ArrayList<TeamNormalInfo> list=teamForTest.getTeamNormalInfo_avg();
		ArrayList<TeamNormalInfo> result=new ArrayList<TeamNormalInfo>();
		for(int i=(sortField.length-1);i>=0;i--){
			if(asc[i]){
				NormalInfoSorter.teamNormalInfo_asc(list, sortField[i]);
			}else{
				NormalInfoSorter.teamNormalInfo_desc(list, sortField[i]);
			}
		}
		for(int i=0;i<n;i++){
			result.add(list.get(i));
		}
		return result;
	}

	@Override
	public ArrayList<TeamNormalInfo> getTeamNormalInfo_total(
			Terminology[] sortField, boolean[] asc, int n) {
		ArrayList<TeamNormalInfo> list=teamForTest.getTeamNormalInfo_total();
		ArrayList<TeamNormalInfo> result=new ArrayList<TeamNormalInfo>();
		for(int i=(sortField.length-1);i>=0;i--){
			if(asc[i]){
				NormalInfoSorter.teamNormalInfo_asc(list, sortField[i]);
			}else{
				NormalInfoSorter.teamNormalInfo_desc(list, sortField[i]);
			}
		}
		for(int i=0;i<n;i++){
			result.add(list.get(i));
		}
		return result;
	}

	@Override
	public ArrayList<TeamHighInfo> getTeamHighInfo(Terminology[] sortField,
			boolean[] asc, int n) {
		ArrayList<TeamHighInfo> list=teamForTest.getTeamHighInfo();
		ArrayList<TeamHighInfo> result=new ArrayList<TeamHighInfo>();
		for(int i=(sortField.length-1);i>=0;i--){
			if(asc[i]){
				HighInfoSorter.teamHighInfo_asc(list, sortField[i]);
			}else{
				HighInfoSorter.teamHighInfo_desc(list, sortField[i]);
			}
		}
		for(int i=0;i<n;i++){
			result.add(list.get(i));
		}
		return result;
	}

	@Override
	public ArrayList<TeamHotInfo> getTeamHotInfo(String hotField, int n) {
		String season = MatchesData_new.getLastSeason();
		ArrayList<TeamHotStatsVO> list=getHotTeams(season,Terminology.toEnum_team(hotField),n);
		ArrayList<TeamHotInfo> result=new ArrayList<TeamHotInfo>();
		for(TeamHotStatsVO stat:list){
			TeamHotInfo hot=new TeamHotInfo();
			hot.setTeamName(stat.getTeam().toEnglish());
			hot.setLeague(stat.getConference().toString());
			hot.setField(hotField);
			hot.setValue(stat.getStats());
			result.add(hot);
		}
		return result;		
	}

	
	//某球队某赛季的数据
	
	@Override
	public TeamOffensiveStatsVO getTeamOffensiveStatsAverage(String season, Teams team) throws TeamNotFound {
		ArrayList<TeamOffensiveStatsPO> poList = teamService.getOffensiveStats(season, team);
		TeamOffensiveStatsVO vo = this.sum_offensive(poList);
		vo.average();
		return vo;
	}

	@Override
	public TeamRatioGeneralVO getTeamRatioGeneralStatsAverage(String season, Teams team) throws TeamNotFound {
		ArrayList<TeamRatioGeneralStatsPO> poList = teamService.getRatioGeneralStats(season, team);
		TeamRatioGeneralVO vo = this.sum_ratio(poList);
		vo.average();
		return vo;
	}

	@Override
	public TeamDefensiveFoulsVO getTeamDefensiveFoulsStatsAverage(String season, Teams team) throws TeamNotFound {
		ArrayList<TeamDefensiveFoulsStatsPO> poList = teamService.getDefensiveFoulsStats(season, team);
		TeamDefensiveFoulsVO vo = this.sum_defensive(poList);
		vo.average();
		return vo;
	}

	@Override
	public TeamOffensiveStatsVO getTeamOffensiveStatsTotal(String season,
			Teams team) throws TeamNotFound {
		ArrayList<TeamOffensiveStatsPO> poList = teamService.getOffensiveStats(season, team);
		TeamOffensiveStatsVO vo = this.sum_offensive(poList);
		return vo;
	}

	@Override
	public TeamRatioGeneralVO getTeamRatioGeneralStatsTotal(String season,
			Teams team) throws TeamNotFound {
		ArrayList<TeamRatioGeneralStatsPO> poList = teamService.getRatioGeneralStats(season, team);
		TeamRatioGeneralVO vo = this.sum_ratio(poList);
		return vo;
	}

	@Override
	public TeamDefensiveFoulsVO getTeamDefensiveFoulsStatsTotal(String season,
			Teams team) throws TeamNotFound {
		ArrayList<TeamDefensiveFoulsStatsPO> poList = teamService.getDefensiveFoulsStats(season, team);
		TeamDefensiveFoulsVO vo = this.sum_defensive(poList);
		return vo;
	}

}
