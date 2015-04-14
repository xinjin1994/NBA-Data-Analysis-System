package gui.season;

public class Season {
	public String season;

	public Season(String season) {
		this.season = season;
	}

	public String toString(){
		return season+"赛季";
	}
	
	public boolean equals(Object o){
		if(o instanceof String)
			return season.equals(o);
		else if(o instanceof Season)
			return season.equals(((Season)o).season);
		return false;
	}
}
