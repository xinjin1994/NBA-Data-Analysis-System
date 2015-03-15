package vo;

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
	
	public PlayerVO(){
		
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
	
	
	
}
