package vo;

import java.io.Serializable;

public class PlayerNormalInfo implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 8066515661873649066L;
	private String	name;                              //球员姓名（全名）
	private int	age;                                   //球员年龄
	private String	teamName;                          //球队名称（缩写）
	private int	numOfGame;                             //上场次数
	private int	start;                                 //首发次数
	private double	minute;                            //上场时间数（单位：分钟）
	private double	point;                             //得分
	private double	shot;                              //投篮命中率
	private double	three;                             //三分命中率
	private double	penalty;                           //罚球命中率
	private double	efficiency;                        //效率
	private double	offend;                            //进攻数
	private double	defend;                            //防守数
	private double	rebound;                           //篮板数
	private double	steal;                             //抢断数
	private double	assist;                            //助攻数
	private double	blockShot;                         //盖帽数
	private double	fault;                             //失误数
	private double	foul;                              //犯规数
	
	public PlayerNormalInfo() {
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
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

	public double getDefend() {
		return defend;
	}

	public void setDefend(double defend) {
		this.defend = defend;
	}

	public double getEfficiency() {
		return efficiency;
	}

	public void setEfficiency(double efficiency) {
		this.efficiency = efficiency;
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

	public double getMinute() {
		return minute;
	}

	public void setMinute(double minute) {
		this.minute = minute;
	}

	public int getNumOfGame() {
		return numOfGame;
	}

	public void setNumOfGame(int numOfGame) {
		this.numOfGame = numOfGame;
	}

	public double getOffend() {
		return offend;
	}

	public void setOffend(double offend) {
		this.offend = offend;
	}

	public double getPenalty() {
		return penalty;
	}

	public void setPenalty(double penalty) {
		this.penalty = penalty;
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

	public double getShot() {
		return shot;
	}

	public void setShot(double shot) {
		this.shot = shot;
	}

	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public double getSteal() {
		return steal;
	}

	public void setSteal(double steal) {
		this.steal = steal;
	}

	public double getThree() {
		return three;
	}

	public void setThree(double three) {
		this.three = three;
	}
	
}
