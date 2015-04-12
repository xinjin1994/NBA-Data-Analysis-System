package vo;

import java.io.Serializable;

public class TeamHotInfo implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -5738284908094902896L;
	private String	teamName;                      //球队名称（缩写）
	private String	league;                        //球队所在联盟 
	private String	field;                         //热门球队的热门属性
	private double	value;                         //热门属性具体的值
	
	public TeamHotInfo() {
		
	}

	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

	public String getLeague() {
		return league;
	}

	public void setLeague(String league) {
		this.league = league;
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
