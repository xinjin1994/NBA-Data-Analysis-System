package gui.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class ShortDate {
	public Date date;
	private boolean isToday = false;
	
	public ShortDate(){
		date = Calendar.getInstance().getTime();
		isToday = true;
	}
	public ShortDate(Date date) {
		this.date = date;
	}
	
	@Override
	public boolean equals(Object o){
		if(o instanceof Date)
			return equals(new ShortDate((Date)o));
		else if(o instanceof ShortDate)
			return toString().equals(o.toString());
		return false;
	}
	
	@Override
	public String toString(){
		String result = new SimpleDateFormat("MM月dd日").format(date);
		if(isToday)
			result += "（今天）";
		return result;
	}

}
