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
		case "ATL": return ATL;
		case "Nets": return BKN;
		case "BKN": return BKN;
		case "Celtics": return BOS;
		case "BOS": return BOS;
		case "Hornets": return CHA;
		case "CHA": return CHA;
		case "Bulls": return CHI;
		case "CHI": return CHI;
		case "Cavaliers": return CLE;
		case "CLE": return CLE;
		case "Mavericks": return DAL;
		case "DAL": return DAL;
		case "Nuggets": return DEN;
		case "DEN": return DEN;
		case "Pistons": return DET;
		case "DET": return DET;
		case "Warriors": return GSW;
		case "GSW": return GSW;
		case "Rockets": return HOU;
		case "HOU": return HOU;
		case "Pacers": return IND;
		case "IND": return IND;
		case "Clippers": return LAC;
		case "LAC": return LAC;
		case "Lakers": return LAL;
		case "LAL": return LAL;
		case "Grizzlies": return MEM;
		case "MEM": return MEM;
		case "Heat": return MIA;
		case "MIA": return MIA;
		case "Bucks": return MIL;
		case "MIL": return MIL;
		case "Timberwolves": return MIN;
		case "MIN": return MIN;
		case "Pelicans": return NOP;
		case "NOP": return NOP;
		case "Knicks": return NYK;
		case "NYK": return NYK;
		case "Thunder": return OKC;
		case "OKC": return OKC;
		case "Magic": return ORL;
		case "ORL": return ORL;
		case "76ers": return PHI;
		case "PHI": return PHI;
		case "Suns": return PHX;
		case "PHX": return PHX;
		case "Trail Blazers": return POR;
		case "POR": return POR;
		case "Kings": return SAC;
		case "SAC": return SAC;
		case "Spurs": return SAS;
		case "SAS": return SAS;
		case "Raptors": return TOR;
		case "TOR": return TOR;
		case "Jazz": return UTA;
		case "UTA": return UTA;
		case "Wizards": return WAS;
		case "WAS": return WAS;
		default: return null;
		}
	}
}
