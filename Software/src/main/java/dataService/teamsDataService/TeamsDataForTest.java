package dataService.teamsDataService;

import java.util.ArrayList;
import test.data.*;

public interface TeamsDataForTest {
	public ArrayList<TeamNormalInfo> getTeamNormalInfo_avg();
	public ArrayList<TeamNormalInfo> getTeamNormalInfo_total();
	public ArrayList<TeamHighInfo> getTeamHighInfo();
}
