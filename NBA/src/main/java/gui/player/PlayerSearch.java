package gui.player;

import enums.Conference;
import enums.Division;
import enums.Position;

public interface PlayerSearch {
	public void buildList(Conference c, Division d, Position p);
	public void filterList(String name);
}
