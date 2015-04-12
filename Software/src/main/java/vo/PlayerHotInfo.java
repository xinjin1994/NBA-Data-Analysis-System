package vo;

import java.io.Serializable;

public class PlayerHotInfo implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4770104723010689846L;
	private String	name;                               //球员姓名（全名）
	private String	teamName;                           //球员所在球队名称
	private String	position;                           //球员位置信息
	private String	field;                              //热门球员的热门属性名
	private double	value;                              //热门属性的具体值
	private double	upgradeRate;                        //近5场比赛的提升率
	
	public PlayerHotInfo() {
		
	}

	public String getField() {
		return field;
	}

	public void setField(String field) {
		this.field = field;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

	public double getUpgradeRate() {
		return upgradeRate;
	}

	public void setUpgradeRate(double upgradeRate) {
		this.upgradeRate = upgradeRate;
	}

	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
	}
	
}
