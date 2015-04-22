package businessLogicService.teamsBLService;

import java.util.ArrayList;

import enums.Terminology;
import test.data.*;

public interface TeamsBLForTest {
	public ArrayList<TeamNormalInfo> getTeamNormalInfo_avg(Terminology[] sortField,
			boolean[] asc, int n);
	
	public ArrayList<TeamNormalInfo> getTeamNormalInfo_total(Terminology[] sortField, 
			boolean[] asc, int n);
	
	public ArrayList<TeamHighInfo> getTeamHighInfo(Terminology[] sortField, 
			boolean[] asc, int n);
	
	public ArrayList<TeamHotInfo> getTeamHotInfo(String hotField, int n);
}
