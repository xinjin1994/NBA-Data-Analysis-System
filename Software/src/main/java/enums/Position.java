package enums;

public enum Position {
	//球员位置
	ALL("全部"),
	FORWARD("前锋"), //SF("小前锋"), PF("大前锋"),
	CENTER("中锋"),
	GUARD("后卫"), //SG("得分后卫"), PG("控球后卫"),
	CF("前锋、中锋"),
	CG("中锋、后卫"),
	FG("前锋、后卫"),
	ALTERNATE("替补"),
	NOTFIXED("不固定"),
	UNKNOWN("未知");
	
	String position;
	
	Position(String p){
		position = p;
	}
	
	public static Position toEnum(String p){
		switch(p){
		case "F": return FORWARD;
		case "C": return CENTER;
		case "G": return GUARD;
		case "C-F": return CF;
		case "F-C": return CF;
		case "C-G": return CG;
		case "G-C": return CG;
		case "F-G": return FG;
		case "G-F": return FG;
		default: if(p.contains("-")){
			         return NOTFIXED;
		         }else{
			         return ALTERNATE;
		         }
		}
	}
	
	public String toString(){
		return position;
	}
	
	public String toAbbr() {
		switch(this){
		case FORWARD: return "F";
		case GUARD: return "G";
		case CENTER: return "C";
		default: return "?";
		}
	}
}