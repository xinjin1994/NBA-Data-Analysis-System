package businessLogic.playersBL;

import enums.Teams;

public class AdvancedPlayerStats {
	//球员的一些需要根据基础数据计算得到的高级统计数据
	String name;
	Teams team;
	Double doubleDouble;                              //两双数
	BasicPlayerStats average;                          //平均数据
	Double hitRate;                                    //命中率
	Double rebounds;                                   //总篮板数
	Double playerEfficiencyRating;                     //效率
	//Double                                           //近五场提升率
	Double Gmsc;                                       //game score
	Double trueScorePercent;                           //真实投篮命中率
	Double fieldGoalsPercent;                          //投篮效率
	Double reboundsPercent;                            //篮板率
	Double offensiveReboundsPercent;                   //进攻篮板率
	Double defensiveReboundsPercent;                   //防守篮板率
	Double assistsPercent;                             //助攻率
	Double stealsPercent;                              //抢断率
	Double blockPercent;                               //盖帽率
	Double turnoversPercent;                           //失误率
	Double usagePercent;                               //使用率

	public String name(){
		return name;
	}
	
	public Teams team(){
		return team;
	}
	
	public Double doubleDouble() {
		return doubleDouble;
	}

	public BasicPlayerStats average() {
		return average;
	}

	public Double hitRate() {
		return hitRate;
	}

	public Double rebounds() {
		return rebounds;
	}

	public Double playerEfficiencyRating() {
		return playerEfficiencyRating;
	}

	public Double Gmsc() {
		return Gmsc;
	}

	public Double trueScorePercent() {
		return trueScorePercent;
	}

	public Double fieldGoalsPercent() {
		return fieldGoalsPercent;
	}

	public Double reboundsPercent() {
		return reboundsPercent;
	}

	public Double offensiveReboundsPercent() {
		return offensiveReboundsPercent;
	}

	public Double defensiveReboundsPercent() {
		return defensiveReboundsPercent;
	}

	public Double assistsPercent() {
		return assistsPercent;
	}

	public Double stealsPercent() {
		return stealsPercent;
	}

	public Double blockPercent() {
		return blockPercent;
	}

	public Double turnoversPercent() {
		return turnoversPercent;
	}

	public Double usagePercent() {
		return usagePercent;
	}
	
	public void setName(String name){
		this.name = name;
	}
	
	public void setTeam(Teams team){
		this.team = team;
	}

	public void setDoubleDouble(Double doubleDouble) {
		this.doubleDouble = doubleDouble;
	}

	public void setAverage(BasicPlayerStats average) {
		this.average = average;
	}

	public void setHitRate(Double hitRate) {
		this.hitRate = hitRate;
	}

	public void setRebounds(Double rebounds) {
		this.rebounds = rebounds;
	}

	public void setPlayerEfficiencyRating(Double playerEfficiencyRating) {
		this.playerEfficiencyRating = playerEfficiencyRating;
	}

	public void setGmsc(Double gmsc) {
		Gmsc = gmsc;
	}

	public void setTrueScorePercent(Double trueScorePercent) {
		this.trueScorePercent = trueScorePercent;
	}

	public void setFieldGoalsPercent(Double fieldGoalsPercent) {
		this.fieldGoalsPercent = fieldGoalsPercent;
	}

	public void setReboundsPercent(Double reboundsPercent) {
		this.reboundsPercent = reboundsPercent;
	}

	public void setOffensiveReboundsPercent(Double offensiveReboundsPercent) {
		this.offensiveReboundsPercent = offensiveReboundsPercent;
	}

	public void setDefensiveReboundsPercent(Double defensiveReboundsPercent) {
		this.defensiveReboundsPercent = defensiveReboundsPercent;
	}

	public void setAssistsPercent(Double assistsPercent) {
		this.assistsPercent = assistsPercent;
	}

	public void setStealsPercent(Double stealsPercent) {
		this.stealsPercent = stealsPercent;
	}

	public void setBlockPercent(Double blockPercent) {
		this.blockPercent = blockPercent;
	}

	public void setTurnoversPercent(Double turnoversPercent) {
		this.turnoversPercent = turnoversPercent;
	}

	public void setUsagePercent(Double usagePercent) {
		this.usagePercent = usagePercent;
	}
	
	
	
	
}
