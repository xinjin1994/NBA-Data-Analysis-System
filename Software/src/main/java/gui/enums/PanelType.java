package gui.enums;

public enum PanelType {
	STATISTIC("STATISTIC"),MENU("MENU"),PLAYER("PLAYER"),TEAM("TEAM"),GAME("GAME"),
	PLAYER_STATISTIC("PLAYER_STATISTIC"),TEAM_STATISTIC("TEAM_STATISTIC"),HOT("HOT");
	
	private String type;
	
	PanelType(String type){
		this.type = type;
	}
	
	public String toString(){
		return type;
	}
}
