package gui.match;

import java.util.Date;

import businessLogicService.matchesBLService.MatchesBLService;
import exceptions.MatchNotFound;
import vo.MatchVO;

public interface MatchChangeable {

	public void setMatch(String season, Date date);
	public void noMatch();
	public MatchVO getMatch(MatchesBLService matchbl,String season, Date date) throws MatchNotFound;
	}
