package enums;

public enum Position {
	//球员位置
	ALL("全部"),
	FORWARD("前锋"), SF("小前锋"), PF("大前锋"),
	CENTER("中锋"),
	GUARD("后卫"), SG("得分后卫"), PG("控球后卫"),
	ALTERNATE("替补");
	
	String position;
	
	Position(String p){
		position = p;
	}
	
	public static Position toEnum(String p){
		switch(p){
		case "F": return FORWARD;
		case "C": return CENTER;
		case "G": return GUARD;
		default: return ALTERNATE;
		}
	}
	
	public String toString(){
		return position;
	}
}