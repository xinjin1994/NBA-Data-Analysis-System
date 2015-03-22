package enums;

public enum Terminology {
	//各种NBA中的专业术语
	MIN("在场时间"), 
	FGM("投篮命中数"), FGA("投篮出手数"), FGP("投篮命中率"), 
	TPM("三分命中数"), TPA("三分出手数"), TPP("三分命中率"), 
	FTM("罚球命中数"), FTA("罚球出手数"), FTP("罚球命中率"), 
	OREB("进攻篮板数"), DREB("防守篮板数"), REB("总篮板数"), 
	AST("助攻数"), STL("抢断数"),  BLK("盖帽数"), 
	TOV("失误数"), PF("犯规数"), PTS("个人得分"), 
	PER("效率"), IMP("近五场提升率"), GMSC("GmSc"), 
	TSP("真实投篮命中率"), FGE("投篮效率"), 
	REBP("篮板率"), OREBP("进攻篮板率"), DREBP("防守篮板率"), 
	ASTP("助攻率"), STLP("抢断率"), BLKP("盖帽率"), TOVP("失误率"), 
	USGP("使用率"), 
	WINR("胜率"), 
	OFR("进攻回合"), DFR("防守回合"), 
	OFE("进攻效率"), DFE("防守效率"), 
	OREBDE("进攻篮板效率"), DREBDE("防守篮板效率"), 
	STLE("抢断效率"), ASTE("助攻效率"),
	
	ATTENDED("参赛场数"),PREMIERE("先发场数");
	
	String terminology;
	
	private Terminology(String s){
		this.terminology = s;
	}
	
	public String toString(){
		return terminology;
	}
	
	static public Terminology[] getPlayerBasic(){
		//参赛场数、先发场数、篮板数、助攻数、在场时间、投篮命中率、三分命中率、罚球命中率、进攻数、防守数、抢断数、盖帽数、犯规数、失误数、得分
		return new Terminology[]{ATTENDED,PREMIERE,REB,AST,MIN,FGP,TPP,FTM,OFR,DFR,STL,BLK,TOV,PF,PTS};
	}
	static public Terminology[] getPlayerAdvanced(){
		//效率、GmSc效率值、真实命中率、投篮效率、篮板率、进攻篮板率、防守篮板率、助攻率、抢断率、盖帽率、失误率、使用率
		return new Terminology[]{PER,GMSC,TSP,FGE,REBP,OREBP,DREBP,ASTP,STLP,BLKP,TOVP,USGP};
	}
	
	static public Terminology[] getTeamOffence(){
		return null;//TODO
	}
}
