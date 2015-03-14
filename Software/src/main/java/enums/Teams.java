package enums;

public enum Teams {
	ALL("All","ALL","全部"),
	ATL("Hawks", "ATL","老鹰"), BKN("Nets", "BKN","篮网"), BOS("Celtics", "BOS","凯尔特人"), CHA("Hornets", "CHA","黄蜂"), 
	CHI("Bulls", "CHI","公牛"), CLE("Cavaliers", "CLE","骑士"), DAL("Mavericks", "DAL","小牛"), 
	DEN("Nuggets", "DEN","掘金"), DET("Pistons", "DET","活塞"), GSW("Warriors", "GSW,","勇士"), 
	HOU("Rockets", "HOU","火箭"), IND("Pacers", "IND","步行者"), LAC("Clippers", "LAC","快船"), 
	LAL("Lakers", "LAL","湖人"), MEM("Grizzlies", "MEM","鹈鹕"), MIA("Heat", "MIA","热火"), MIL("Bucks", "MIL","雄鹿"), 
	MIN("Timberwolves", "MIN","森林狼"), NOP("Pelicans", "NOP","灰熊"), NYK("Knicks", "NYK","尼克斯"), 
	OKC("Thunder", "OKC","雷霆"), ORL("Magic", "ORL","魔术"), PHI("76ers", "PHI","76人"), PHX("Suns", "PHX","太阳"), 
	POR("Trail Blazers", "POR","开拓者"), SAC("Kings", "SAC","国王"), SAS("Spurs", "SAS","马刺"), 
	TOR("Raptors", "TOR","猛龙"), UTA("Jazz", "UTA","爵士"), WAS("Wizards", "WAS","奇才");
	
	String name;
	String abbreviation;
	String chinese;
	
	Teams(String n, String a, String c){
		name = n;
		abbreviation = a;
		chinese = c;
	}
	
	public String toString(){           //返回缩写
		return chinese;
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
