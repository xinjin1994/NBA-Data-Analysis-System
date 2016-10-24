package vo;

import javax.swing.ImageIcon;

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
	ImageIcon image;                       //队标
	
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
	
	public void setImage(ImageIcon img){
		this.image = img;
	}
	
	public ImageIcon getImage(){
		return image;
	}

	public Teams getTeam() {
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
	
	
	public void print(){
		System.out.println(this.name + "\n" +
		this.abbreviationOfName + "\n" +
		this.location + "\n" +
		this.conference + "\n" +
		this.division + "\n" +
		this.homeCourt + "\n" +
		this.yearOfEstablishment);
	}
	
	public boolean equals(TeamVO vo){
		if(this.name == vo.name &&
				this.abbreviationOfName.equals(vo.abbreviationOfName) &&
				this.location.equals(vo.location) &&
				this.conference == vo.conference &&
				this.division == vo.division &&
				this.homeCourt.equals(vo.homeCourt) &&
				this.yearOfEstablishment.equals(vo.yearOfEstablishment)){
			return true;
		}else{
			return false;
		}
	}
	
}
