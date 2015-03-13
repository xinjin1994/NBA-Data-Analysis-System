package gui.enums;

public enum PanelType {
	STATISTIC("STATISTIC"),MENU("MENU");
	
	private String type;
	
	PanelType(String type){
		this.type = type;
	}
	
	public String toString(){
		return type;
	}
}
