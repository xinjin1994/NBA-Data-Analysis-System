package businessLogic.teamsBL;

import po.TeamPO;
import vo.TeamVO;
import enums.Conference;
import enums.Division;
import enums.Teams;
import factory.ObjectCreator;

public class Team {
	Teams name;                            //队名
	String abbreviationOfName;             //队名缩写
	String location;                       //所在地
	Conference conference;                 //赛区
	Division division;                     //分区
	String homeCourt;                      //主场
	String yearOfEstablishment;            //建立时间（年）
	
	public Team(TeamPO po){
		this.name = po.name();
		this.abbreviationOfName = po.abbreviationOfName();
		this.location = po.location();
		this.conference = po.conference();
		this.division = po.division();
		this.homeCourt = po.homeCourt();
		this.yearOfEstablishment = po.yearOfEstablishment();
	}
	
	public TeamVO toVO(){
		TeamVO vo = new TeamVO(name, abbreviationOfName, location, conference, 
				division, homeCourt, yearOfEstablishment);
		vo.setImage(new ObjectCreator().imageService().getTeamImage(name));
		return vo;
	}
	
}
