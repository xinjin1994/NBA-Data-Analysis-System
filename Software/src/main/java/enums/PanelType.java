package enums;

public enum PanelType {
	STATISTIC("数据统计"),MENU("主菜单"),PLAYER("球员列表"),TEAM("球队列表"),
	HOT("热点"),MATCH("球赛列表");
	
	private String type;
	
	PanelType(String type){
		this.type = type;
	}
	
	public String toString(){
		return type;
	}
}
