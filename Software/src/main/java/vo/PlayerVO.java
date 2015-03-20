package vo;

import javax.swing.ImageIcon;

import enums.Position;

public class PlayerVO {
	//球员基本信息
	//不包含具体比赛数据
	String name;                        //姓名
	String number;                      //球衣号码
	Position position;                  //位置
	Double height_Foot;                 //身高（英尺）
	Double height_Inch;                 //身高（英寸）
	Double weight_Pounds;               //体重（磅）
	String birthday;                    //生日
	Integer age;                        //年龄
	Integer exp;                        //球龄
	String school;                      //毕业学校
	ImageIcon portrait;                 //头像
	ImageIcon action;                   //动作
	
	public PlayerVO(String name, String number, Position position, Double height_foot,
			Double height_inch, Double weight_pounds, String birthday, Integer age, 
			Integer exp, String school){
		this.name = name;
		this.number = number;
		this.position = position;
		this.height_Foot = height_foot;
		this.height_Inch = height_inch;
		this.weight_Pounds = weight_pounds;
		this.birthday = birthday;
		this.age = age;
		this.exp = exp;
		this.school = school;
	}
	
	public void addImage(ImageIcon portrait, ImageIcon action){
		this.portrait = portrait;
		this.action = action;
	}
	
	public ImageIcon getPortrait(){
		return portrait;
	}
	
	public ImageIcon getAction(){
		return action;
	}
	
	public String getName() {
		return name;
	}

	public String getNumber() {
		return number;
	}

	public Position getPosition() {
		return position;
	}

	public Double getHeight_Foot() {
		return height_Foot;
	}

	public Double getHeight_Inch() {
		return height_Inch;
	}

	public Double getWeight_Pounds() {
		return weight_Pounds;
	}

	public String getBirthday() {
		return birthday;
	}

	public Integer getAge() {
		return age;
	}

	public Integer getExp() {
		return exp;
	}

	public String getSchool() {
		return school;
	}
	
	
	public boolean equals(PlayerVO player){
		if(this.name.equals(player.name) &&
				this.number.equals(player.number) &&
				this.position == player.position &&
				Math.abs(this.height_Foot - player.height_Foot) < 0.001 &&
				Math.abs(this.height_Inch - player.height_Inch) < 0.001 &&
				Math.abs(this.weight_Pounds - player.weight_Pounds) < 0.001 &&
				this.birthday.equals(player.birthday) &&
				this.age == player.age &&
				this.exp == player.exp &&
				this.school.equals(player.school)){
			return true;
		}else{
			return false;
		}
	}
	
}
