package businessLogic.playersBL;

import po.PlayerPO;
import vo.PlayerVO;
import enums.Position;

public class PlayerInfoVO {
	//球员基本信息
	//不包含具体比赛数据
	public String name;                        //姓名
	public String number;                      //球衣号码
	public Position position;                  //位置
	public Double height_Foot;                 //身高（英尺）
	public Double height_Inch;                 //身高（英寸）
	public Double weight_Pounds;               //体重（磅）
	public String birthday;                    //生日
	public Integer age;                        //年龄
	public Integer exp;                        //球龄
	public String school;                      //毕业学校

	public PlayerInfoVO(PlayerPO po){
		
	}
	
	public PlayerVO toVO(){
		return null;
	}
}
