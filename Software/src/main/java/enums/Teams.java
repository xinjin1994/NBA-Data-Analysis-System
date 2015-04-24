package enums;

public enum Teams {
	ALL("All","ALL","全部"),
	ATL("Hawks", "ATL","老鹰"), BKN("Nets", "BKN","篮网"), BOS("Celtics", "BOS","凯尔特人"), CHA("Hornets", "CHA","黄蜂"), 
	CHI("Bulls", "CHI","公牛"), CLE("Cavaliers", "CLE","骑士"), DAL("Mavericks", "DAL","小牛"), 
	DEN("Nuggets", "DEN","掘金"), DET("Pistons", "DET","活塞"), GSW("Warriors", "GSW","勇士"), 
	HOU("Rockets", "HOU","火箭"), IND("Pacers", "IND","步行者"), LAC("Clippers", "LAC","快船"), 
	LAL("Lakers", "LAL","湖人"), MEM("Grizzlies", "MEM","灰熊"), MIA("Heat", "MIA","热火"), MIL("Bucks", "MIL","雄鹿"), 
	MIN("Timberwolves", "MIN","森林狼"), NOP("Pelicans", "NOP","鹈鹕"), NYK("Knicks", "NYK","尼克斯"), 
	OKC("Thunder", "OKC","雷霆"), ORL("Magic", "ORL","魔术"), PHI("76ers", "PHI","76人"), PHX("Suns", "PHX","太阳"), 
	POR("Trail Blazers", "POR","开拓者"), SAC("Kings", "SAC","国王"), SAS("Spurs", "SAS","马刺"), 
	TOR("Raptors", "TOR","猛龙"), UTA("Jazz", "UTA","爵士"), WAS("Wizards", "WAS","奇才"),
	NOH("Pelicans", "NOH", "黄蜂");
	
	String name;
	String abbreviation;
	String chinese;
	
	Teams(String n, String a, String c){
		name = n;
		abbreviation = a;
		chinese = c;
	}
	
	public String toString(){
		return chinese;
	}
	
	public String toAbbr(){             //返回缩写
		return abbreviation;
	}
	
	public String toEnglish(){
		return name;
	}
	
	public boolean equals(Teams team){
		if(this == team){
			return true;
		}else if(this == NOH && team == NOP || this== NOP && team == NOH){
			return true;
		}else{
			return false;
		}
	}
	
	public static Teams toEnum(String n){
		if(n.equals("NOH")){
			return NOP;
		}
		for(Teams t : values())
			if(n.equals(t.toAbbr()) || n.equals(t.toEnglish()))
				return t;
		return null;
	}
	
	static public Teams[] getEasternTeams(){
		return new Teams[]{BOS,BKN,NYK,PHI,TOR,ATL,MIA,ORL,CHA,WAS,CHI,CLE,DET,IND,MIL};
	}
	static public Teams[] getAtlanticTeams(){
		return new Teams[]{BOS,BKN,NYK,PHI,TOR};
	}
	static public Teams[] getSouthEastTeams(){
		return new Teams[]{ATL,MIA,ORL,CHA,WAS};
	}
	static public Teams[] getCentralTeams(){
		return new Teams[]{CHI,CLE,DET,IND,MIL};
	}
	
	static public Teams[] getWesternTeams(){
		return new Teams[]{DAL,HOU,MEM,NOP,SAS,DEN,MIN,OKC,POR,UTA,GSW,LAC,LAL,PHX,SAC};
	}
	static public Teams[] getSouthWestTeams(){
		return new Teams[]{DAL,HOU,MEM,NOP,SAS};
	}
	static public Teams[] getNouthWestTeams(){
		return new Teams[]{DEN,MIN,OKC,POR,UTA};
	}
	static public Teams[] getPacificTeams(){
		return new Teams[]{GSW,LAC,LAL,PHX,SAC};
	}
}
