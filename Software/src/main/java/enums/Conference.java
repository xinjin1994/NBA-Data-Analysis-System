package enums;

public enum Conference {
	//赛区
	NATIONAL("National","全国"),EASTERN("Eastern", "东部"), WESTERN("Western", "西部");
	
	String conference;
	String conference_CHN;
	
	Conference(String c, String cc){
		conference = c;
		conference_CHN = cc;
	}
	
	public String toString(){
		return conference_CHN;
	}
	
	public String toString_CHN(){
		return conference_CHN;
	}
	
	public String toString_ENG() {
		switch(this){
		case EASTERN: return "East";
		case WESTERN: return "West";
		default: return "?";
		}
	}
	
	public static Conference toEnum(String c){
		switch(c){
		case "E": return EASTERN;
		case "W": return WESTERN;
		default: return null;
		}
	}
	
	public static Conference toEnum_test(String c){
		switch(c){
		case "West": return WESTERN;
		case "East": return EASTERN;
		default: return null;
		}
	}
}
