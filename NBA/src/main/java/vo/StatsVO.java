package vo;

import enums.Terminology;
import exceptions.TermNotFound;

public interface StatsVO {
	
	public String getProperty(Terminology term) throws TermNotFound;
}
