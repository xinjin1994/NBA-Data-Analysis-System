package vo;

import java.io.Serializable;

public class TeamHighInfo implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6372142487416004188L;
	private String	teamName;                               //球队名称（缩写）
	private double	winRate;                                //胜率
	private double	offendRebound;                            //进攻回合数
	private double	offendEfficient;                        //进攻效率
	private double	defendEfficient;                        //防守效率
	private double	offendReboundEfficient;                 //进攻篮板效率
	private double	defendReboundEfficient;                 //防守篮板效率
	private double	assistEfficient;                        //助攻效率
	private double	stealEfficient;                         //抢断效率
	
	public TeamHighInfo() {
		winRate=0.0;
		offendRebound=0.0;
		offendEfficient=0.0;
		defendEfficient=0.0;
		offendReboundEfficient=0.0;
		defendReboundEfficient=0.0;
		assistEfficient=0.0;
		stealEfficient=0.0;
	}

	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

	public double getWinRate() {
		return winRate;
	}

	public void setWinRate(double winRate) {
		this.winRate = winRate;
	}

	public double getOffendRebound() {
		return offendRebound;
	}

	public void setOffendRound(double offendRebound) {
		this.offendRebound = offendRebound;
	}

	public double getOffendEfficient() {
		return offendEfficient;
	}

	public void setOffendEfficient(double offendEfficient) {
		this.offendEfficient = offendEfficient;
	}

	public double getDefendEfficient() {
		return defendEfficient;
	}

	public void setDefendEfficient(double defendEfficient) {
		this.defendEfficient = defendEfficient;
	}

	public double getOffendReboundEfficient() {
		return offendReboundEfficient;
	}

	public void setOffendReboundEfficient(double offendReboundEfficient) {
		this.offendReboundEfficient = offendReboundEfficient;
	}

	public double getDefendReboundEfficient() {
		return defendReboundEfficient;
	}

	public void setDefendReboundEfficient(double defendReboundEfficient) {
		this.defendReboundEfficient = defendReboundEfficient;
	}

	public double getAssistEfficient() {
		return assistEfficient;
	}

	public void setAssistEfficient(double assistEfficient) {
		this.assistEfficient = assistEfficient;
	}

	public double getStealEfficient() {
		return stealEfficient;
	}

	public void setStealEfficient(double stealEfficient) {
		this.stealEfficient = stealEfficient;
	}
	
}
