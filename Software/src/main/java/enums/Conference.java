package enums;

public enum Conference {
	//赛区
	ESTERN("Eastern", "东部"), WESTERN("Western", "西部");
	
	String conference;
	String conference_CHN;
	
	Conference(String c, String cc){
		conference = c;
		conference_CHN = cc;
	}
	
	public String toString(){
		return conference;
	}
	
	public String toString_CHN(){
		return conference_CHN;
	}
	
	public static Conference toEnum(String c){
		switch(c){
		case "E": return ESTERN;
		case "W": return WESTERN;
		default: return null;
		}
	}
}
