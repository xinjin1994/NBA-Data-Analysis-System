package vo;

import java.io.Serializable;

public class TeamNormalInfo implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1292979228332780382L;
	private String	teamName;                                //球队名称
	private int	numOfGame;                                   //比赛场数
	private double	point;                                   //得分
	private double	shot;                                    //投篮命中率
	private double	three;                                   //三分命中率
	private double	penalty;                                 //罚球命中率
	private double	offendRebound;                           //进攻篮板数
	private double	defendRebound;                           //防守篮板数
	private double	rebound;                                 //篮板数
	private double	assist;                                  //助攻数
	private double	blockShot;                               //盖帽数
	private double	steal;                                   //抢断数
	private double	fault;                                   //失误数
	private double	foul;                                    //犯规数
	
	public TeamNormalInfo() {
		
	}

	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

	public int getNumOfGame() {
		return numOfGame;
	}

	public void setNumOfGame(int numOfGame) {
		this.numOfGame = numOfGame;
	}

	public double getShot() {
		return shot;
	}

	public void setShot(double shot) {
		this.shot = shot;
	}

	public double getThree() {
		return three;
	}

	public void setThree(double three) {
		this.three = three;
	}

	public double getPenalty() {
		return penalty;
	}

	public void setPenalty(double penalty) {
		this.penalty = penalty;
	}

	public double getOffendRebound() {
		return offendRebound;
	}

	public void setOffendRebound(double offendRebound) {
		this.offendRebound = offendRebound;
	}

	public double getDefendRebound() {
		return defendRebound;
	}

	public void setDefendRebound(double defendRebound) {
		this.defendRebound = defendRebound;
	}

	public double getPoint() {
		return point;
	}

	public void setPoint(double point) {
		this.point = point;
	}

	public double getRebound() {
		return rebound;
	}

	public void setRebound(double rebound) {
		this.rebound = rebound;
	}

	public double getAssist() {
		return assist;
	}

	public void setAssist(double assist) {
		this.assist = assist;
	}

	public double getBlockShot() {
		return blockShot;
	}

	public void setBlockShot(double blockShot) {
		this.blockShot = blockShot;
	}

	public double getSteal() {
		return steal;
	}

	public void setSteal(double steal) {
		this.steal = steal;
	}

	public double getFault() {
		return fault;
	}

	public void setFault(double fault) {
		this.fault = fault;
	}

	public double getFoul() {
		return foul;
	}

	public void setFoul(double foul) {
		this.foul = foul;
	}
	
}
