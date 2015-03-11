package businessLogic.playesBL;

import enums.Position;
import po.PlayerPO;

public class Player {
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
	
	public Player(PlayerPO po){
		
	}
}
