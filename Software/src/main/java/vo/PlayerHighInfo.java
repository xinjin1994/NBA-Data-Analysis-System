package vo;

import java.io.Serializable;

public class PlayerHighInfo implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2992600109763294955L;
	private String	name;                                     //球员姓名（全称）
	private String	teamName;                                 //球员所在球队名称 （缩写）
	private String	position;                                 //球员位置信息
	private String	league;                                   //球员所属联盟
	private double	offendReboundEfficient;                   //进攻篮板率
	private double	defendReboundEfficient;                   //防守篮板率
	private double	gmSc;                                     //GmSc效率值
	private double	shotEfficient;                            //投篮效率
	private double	realShot;                                 //真实命中率
	private double	reboundEfficient;                         //篮板率
	private double	assistEfficient;                          //助攻率
	private double	blockShotEfficient;                       //盖帽率
	private double	stealEfficient;                           //抢断率
	private double	faultEfficient;                           //失误率
	private double	frequency;                                //使用率
	
	public PlayerHighInfo() {
		
	}

	public double getAssistEfficient() {
		return assistEfficient;
	}

	public void setAssistEfficient(double assistEfficient) {
		this.assistEfficient = assistEfficient;
	}

	public double getBlockShotEfficient() {
		return blockShotEfficient;
	}

	public void setBlockShotEfficient(double blockShotEfficient) {
		this.blockShotEfficient = blockShotEfficient;
	}

	public double getDefendReboundEfficient() {
		return defendReboundEfficient;
	}

	public void setDefendReboundEfficient(double defendReboundEfficient) {
		this.defendReboundEfficient = defendReboundEfficient;
	}

	public double getFaultEfficient() {
		return faultEfficient;
	}

	public void setFaultEfficient(double faultEfficient) {
		this.faultEfficient = faultEfficient;
	}

	public double getFrequency() {
		return frequency;
	}

	public void setFrequency(double frequency) {
		this.frequency = frequency;
	}

	public double getGmSc() {
		return gmSc;
	}

	public void setGmSc(double gmSc) {
		this.gmSc = gmSc;
	}

	public String getLeague() {
		return league;
	}

	public void setLeague(String league) {
		this.league = league;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getOffendReboundEfficient() {
		return offendReboundEfficient;
	}

	public void setOffendReboundEfficient(double offendReboundEfficient) {
		this.offendReboundEfficient = offendReboundEfficient;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public double getRealShot() {
		return realShot;
	}

	public void setRealShot(double realShot) {
		this.realShot = realShot;
	}

	public double getReboundEfficient() {
		return reboundEfficient;
	}

	public void setReboundEfficient(double reboundEfficient) {
		this.reboundEfficient = reboundEfficient;
	}

	public double getShotEfficient() {
		return shotEfficient;
	}

	public void setShotEfficient(double shotEfficient) {
		this.shotEfficient = shotEfficient;
	}

	public double getStealEfficient() {
		return stealEfficient;
	}

	public void setStealEfficient(double stealEfficient) {
		this.stealEfficient = stealEfficient;
	}

	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

}
