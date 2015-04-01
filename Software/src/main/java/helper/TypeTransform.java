package helper;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TypeTransform {
	public static Double str_to_minutes(String min){
		if(min == null || min.equals("")){
			return 0.0;
		}
		
		String[] arr = min.split(":");
		if(arr.length == 1){
			return 0.0;
		}
		Double minutes = Double.parseDouble(arr[0]) + Double.parseDouble(arr[1])/60;
		
		return minutes;
	}
	
	public static String minutes_to_str(double min){
		if(Math.abs(min) < 0.001){
			return "0";
		}

		DecimalFormat format = new DecimalFormat("00");
		int m = (int)min;
		int s = (int)((min - m) * 60);
		return format.format(m) + ":" + format.format(s);
	}
	
	public static Date str_to_date(String s){
		SimpleDateFormat sdf = new SimpleDateFormat("MM-dd");
		try {
			Date date = sdf.parse(s);
			return date;
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	public static String date_to_str(Date d){
		SimpleDateFormat sdf = new SimpleDateFormat("MM-dd");
		String s = sdf.format(d);
		return s;
	}
}
