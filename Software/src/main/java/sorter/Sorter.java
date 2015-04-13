package sorter;

import java.util.ArrayList;

import sorter.players.advanced.AdvancedSorter;
import sorter.players.baisc.BasicSorter;
import vo.PlayerAdvancedStatsVO;
import vo.PlayerBasicStatsVO;
import enums.Terminology;

public class Sorter {
	public static ArrayList<PlayerBasicStatsVO> playerBasic(ArrayList<PlayerBasicStatsVO> list, 
			Terminology term, boolean asc) {
		if(asc){
			return BasicSorter.playerBasic_asc(list, term);
		}else{
			return BasicSorter.playerBasic_desc(list, term);
		}
	}
	
	public static ArrayList<PlayerAdvancedStatsVO> playerAdvanced(
			ArrayList<PlayerAdvancedStatsVO> list, Terminology term, boolean asc) {
		if(asc){
			return AdvancedSorter.playerAdvanced_asc(list, term);
		}else{
			return AdvancedSorter.playerAdvanced_desc(list, term);
		}
	}
}
