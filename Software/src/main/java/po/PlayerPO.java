package po;

import enums.Position;

public class PlayerPO {
	//球员基本信息
	//不包含具体比赛数据
	String name;                        //姓名
	String number;                      //球衣号码
	Position position;                  //位置
	double height_Foot;                 //身高（英尺）
	double height_Inch;                 //身高（英寸）
	double weight_Pounds;               //体重（磅）
	String birthday;                    //生日
	int age;                            //年龄
	int exp;                            //球龄
	String school;                      //毕业学校
		
	public PlayerPO(String[] arr){
		//arr内容依次为此类成员变量，其中arr[3]即身高格式为foot-inch
		this.name = arr[0];
		this.number = arr[1];
		this.position = Position.toEnum(arr[2]);
		String[] height = arr[3].split("-");
		this.height_Foot = Double.parseDouble(height[0]);
		this.height_Inch = Double.parseDouble(height[1]);
		this.weight_Pounds = Double.parseDouble(arr[4]);
		this.birthday = arr[5];
		this.age = Integer.parseInt(arr[6]);
		try{                                      //文件中记录为R，记为0
			this.exp = Integer.parseInt(arr[7]);
		}catch(Exception e){
			this.exp = 0;
		}
		this.school = arr[8];
	}
	
	
	
	public String name() {
		return name;
	}

	public String number() {
		return number;
	}

	public Position position() {
		return position;
	}

	public double height_Foot() {
		return height_Foot;
	}

	public double height_Inch() {
		return height_Inch;
	}

	public double weight_Pounds() {
		return weight_Pounds;
	}

	public String birthday() {
		return birthday;
	}
	
	public int age() {
		return age;
	}

	public int exp() {
		return exp;
	}

	public String school() {
		return school;
	}

	public void print(){
		System.out.println(name + '\n' +
				           number + '\n' +
				           position + '\n' +
				           height_Foot + '\n' +
				           height_Inch + '\n' +
				           weight_Pounds + '\n' +
				           birthday + '\n' +
				           age + '\n' +
				           exp +'\n' + 
				           school);
	}
}
