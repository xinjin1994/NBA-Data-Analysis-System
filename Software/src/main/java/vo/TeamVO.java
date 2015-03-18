package vo;

import enums.Conference;
import enums.Division;
import enums.Teams;

public class TeamVO {
	Teams name;                            //队名
	String abbreviationOfName;             //队名缩写
	String location;                       //所在地
	Conference conference;                 //赛区
	Division division;                     //分区
	String homeCourt;                      //主场
	String yearOfEstablishment;            //建立时间（年）
	
	public TeamVO(Teams name, String abbr, String loc, Conference con, Division div, 
			String homeCourt, String year){
		this.name = name;
		this.abbreviationOfName = abbr;
		this.location = loc;
		this.conference = con;
		this.division = div;
		this.homeCourt = homeCourt;
		this.yearOfEstablishment = year;
	}

	public Teams getName() {
		return name;
	}

	public String getAbbreviationOfName() {
		return abbreviationOfName;
	}

	public String getLocation() {
		return location;
	}

	public Conference getConference() {
		return conference;
	}

	public Division getDivision() {
		return division;
	}

	public String getHomeCourt() {
		return homeCourt;
	}

	public String getYearOfEstablishment() {
		return yearOfEstablishment;
	}
	
	
	
}
