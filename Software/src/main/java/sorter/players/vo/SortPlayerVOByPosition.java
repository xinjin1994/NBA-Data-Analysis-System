package sorter.players.vo;

import java.util.Comparator;

import vo.PlayerVO;

public class SortPlayerVOByPosition implements Comparator<PlayerVO> {

	@Override
	public int compare(PlayerVO o1, PlayerVO o2) {
		int cmp = o1.getPosition().compareTo(o2.getPosition());
		if(cmp != 0){
			return cmp;
		}else{
			String[] name1 = o1.getName().split(" ");
	    	String[] name2 = o2.getName().split(" ");
	    	return (name1[1] + name1[0]).compareTo(name2[1] + name2[0]);
		}
	}

}
