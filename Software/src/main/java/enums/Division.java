package enums;

public enum Division {
	//分区
	NATIONAL("National","全部"),
	ATLANTIC("Atlantic","大西洋"), CENTRAL("Central","中部"), SOUTHEAST("Southeast","东南"),                 //东部
	SOUTHWEST("Southwest","西南"), NORTHWEST("Northwest","西北"), PACIFIC("Pacific","太平洋");              //西部
	
	String division;
	private String chinese;
	
	Division(String d,String str){
		division = d;
		chinese = str;
	}
	
	public String toString(){
		return chinese;
	}
	
	public static Division toEnum(String d){
		switch(d){
		case "Atlantic": return ATLANTIC;
		case "Central": return CENTRAL;
		case "Southeast": return SOUTHEAST;
		case "Southwest": return SOUTHWEST;
		case "Northwest": return NORTHWEST;
		case "Pacific": return PACIFIC;
		default: return null;
		}
	}
	
	static public Division[] getEasternDivision(){
		return new Division[]{NATIONAL, ATLANTIC, CENTRAL, SOUTHEAST};
	}
	static public Division[] getWestternDivision(){
		return new Division[]{NATIONAL, SOUTHWEST, NORTHWEST, PACIFIC};
	}
}
