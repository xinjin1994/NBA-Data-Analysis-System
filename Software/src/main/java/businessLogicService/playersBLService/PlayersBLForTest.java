package businessLogicService.playersBLService;

import java.util.ArrayList;

import enums.Terminology;
import vo.PlayerHighInfo;
import vo.PlayerHotInfo;
import vo.PlayerKingInfo;
import vo.PlayerNormalInfo;

public interface PlayersBLForTest {
	public ArrayList<PlayerNormalInfo> getPlayerNormalInfo_avg(String[] filter, 
			Terminology[] sortField, boolean[] asc, int num);
	public ArrayList<PlayerNormalInfo> getPlayerNormalInfo_total(String[] filter, 
			Terminology[] sortField, boolean[] asc, int num);
	public ArrayList<PlayerHighInfo> getPlayerHighInfo(Terminology[] sortField, 
			 boolean[] asc, int num);
	public ArrayList<PlayerHotInfo> getPlayerHotInfo(Terminology hotField, int num);
	public ArrayList<PlayerKingInfo> getPlayerKingInfo_daily(Terminology kingField, int num);
	public ArrayList<PlayerKingInfo> getPlayerKingInfo_season(Terminology kingField, int num);
}
