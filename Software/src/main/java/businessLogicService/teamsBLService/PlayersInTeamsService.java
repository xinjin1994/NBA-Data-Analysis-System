package businessLogicService.teamsBLService;

import java.util.ArrayList;
import enums.Conference;
import enums.Division;

public interface PlayersInTeamsService {
	//根据赛区获取球员，用于Players模块中根据赛区，队内位置搜索球员
	public ArrayList<String> getPlayers(String season, Conference conference, Division division);
		/*后续方法DataInMatchesService.getPlaysers(season, team)
		 * 
		 */
}
