package data.playersData;

import java.util.ArrayList;
import po.PlayerPO;

public interface ReadPlayers {
	//读取players文件中的数据
	public ArrayList<PlayerPO> readAllPlayers();
}
