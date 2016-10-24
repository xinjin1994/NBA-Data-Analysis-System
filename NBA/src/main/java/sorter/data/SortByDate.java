package sorter.data;

import java.util.Comparator;

public class SortByDate implements Comparator<DataSortByDate> {

	@Override
	public int compare(DataSortByDate o1, DataSortByDate o2) {
		//降序排列
		return cmp(o2, o1);
	}
	
	public int cmp(DataSortByDate o1, DataSortByDate o2){
		//升序
		//先比较赛季
		if(o1.getSeason().compareTo(o2.getSeason()) > 0){
			return 1;
		}else if(o1.getSeason().compareTo(o2.getSeason()) < 0){
			return -1;
		}else{
			//比较日期
			String sep = "05-01";
			if(o1.getDate().compareTo(sep) < 0 &&
					o2.getDate().compareTo(sep) > 0){
				return 1;
			}else if(o1.getDate().compareTo(sep) > 0 &&
					o2.getDate().compareTo(sep) < 0){
				return -1;
			}else{
				return o1.getDate().compareTo(o2.getDate());
			}
		}
	}

}
