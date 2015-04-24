package gui.enums;

public enum PanelType {
	STATISTIC("STATISTIC"),MENU("MENU"),PLAYER("PLAYER"),TEAM("TEAM"),
	PLAYER_STATISTIC("PLAYER_STATISTIC"),TEAM_STATISTIC("TEAM_STATISTIC"),HOT("HOT"),MATCH("MATCH");
	
	private String type;
	
	PanelType(String type){
		this.type = type;
	}
	
	public String toString(){
		return type;
	}
}
