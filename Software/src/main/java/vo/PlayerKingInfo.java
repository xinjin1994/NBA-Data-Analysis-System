package vo;

import java.io.Serializable;

public class PlayerKingInfo implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3947659781488859711L;
	private String	name;                      //球员姓名（全名）
	private String	teamName;                  //球员所在球队名称（缩写）
	private String	position;                  //球员位置信息
	private String	field;                     //数据王属性名
	private double	value;                     //数据王属性对应的具体的值
	
	public PlayerKingInfo() {
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getField() {
		return field;
	}

	public void setField(String field) {
		this.field = field;
	}

	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
	}
	
}
