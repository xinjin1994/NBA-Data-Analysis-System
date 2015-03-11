package enums;

public enum Teams {
	ATL("Hawks", "ATL"), BKN("Nets", "BKN"), BOS("Celtics", "BOS"), CHA("Hornets", "CHA"), 
	CHI("Bulls", "CHI"), CLE("Cavaliers", "CLE"), DAL("Mavericks", "DAL"), 
	DEN("Nuggets", "DEN"), DET("Pistons", "DET"), GSW("Warriors", "GSW"), 
	HOU("Rockets", "HOU"), IND("Pacers", "IND"), LAC("Clippers", "LAC"), 
	LAL("Lakers", "LAL"), MEM("Grizzlies", "MEM"), MIA("Heat", "MIA"), MIL("Bucks", "MIL"), 
	MIN("Timberwolves", "MIN"), NOP("Pelicans", "NOP"), NYK("Knicks", "NYK"), 
	OKC("Thunder", "OKC"), ORL("Magic", "ORL"), PHI("76ers", "PHI"), PHX("Suns", "PHX"), 
	POR("Trail Blazers", "POR"), SAC("Kings", "SAC"), SAS("Spurs", "SAS"), 
	TOR("Raptors", "TOR"), UTA("Jazz", "UTA"), WAS("Wizards", "WAS");
	
	String name;
	String abbreviation;
	
	Teams(String n, String a){
		name = n;
		abbreviation = a;
	}
	
	public String toString(){           //返回缩写
		return name;
	}
	
	public String toAbbr(){             //返回全名
		return abbreviation;
	}
	
	public static Teams toEnum(String n){
		switch(n){
		case "Hawks": return ATL;
		case "Nets": return BKN;
		case "Celtics": return BOS;
		case "Hornets": return CHA;
		case "Bulls": return CHI;
		case "Cavaliers": return CLE;
		case "Mavericks": return DAL;
		case "Nuggets": return DEN;
		case "Pistons": return DET;
		case "Warriors": return GSW;
		case "Rockets": return HOU;
		case "Pacers": return IND;
		case "Clippers": return LAC;
		case "Lakers": return LAL;
		case "Grizzlies": return MEM;
		case "Heat": return MIA;
		case "Bucks": return MIL;
		case "Timberwolves": return MIN;
		case "Pelicans": return NOP;
		case "Knicks": return NYK;
		case "Thunder": return OKC;
		case "Magic": return ORL;
		case "76ers": return PHI;
		case "Suns": return PHX;
		case "Trail Blazers": return POR;
		case "Kings": return SAC;
		case "Spurs": return SAS;
		case "Raptors": return TOR;
		case "Jazz": return UTA;
		case "Wizards": return WAS;
		default: return null;
		}
	}
}
