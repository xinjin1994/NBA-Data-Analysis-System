package businessLogic.playersBL;

import po.PlayerPO;
import vo.PlayerVO;
import enums.Position;

public class Player {
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

	public Player(PlayerPO po){
		
	}
	
	public PlayerVO toVO(){
		return null;
	}
	
	
}
