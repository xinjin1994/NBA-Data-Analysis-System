package enums;

public enum Division {
	//分区
	ATLANTIC("Atlantic"), CENTRAL("Central"), SOUTHEAST("Southeast"),                 //东部
	SOUTHWEST("Southwest"), NORTHWEST("Northwest"), PACIFIC("Pacific");              //西部
	
	String division;
	
	Division(String d){
		division = d;
	}
	
	public String toString(){
		return division;
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
}
