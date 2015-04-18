package gui.match;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ShortDate {
	public Date date;
	
	public ShortDate(Date date) {
		this.date = date;
	}
	
	@Override
	public String toString(){
		return new SimpleDateFormat("MM月dd日").format(date);
	}

}
