package data.matchesData;

import java.util.ArrayList;
import po.MatchPO;

public interface ReadMatches {
	ArrayList<MatchPO> readAllMatches(String path);
}
