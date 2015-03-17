package helper;

public class TypeTransform {
	public static Double str_to_minutes(String min){
		String[] arr = min.split(":");
		Double minutes = Double.parseDouble(arr[0]) + Double.parseDouble(arr[1])/60;
		return minutes;
	}
	
	public static String minutes_to_str(double min){
		int m = (int)min;
		int s = (int)((min - m) * 60);
		return String.valueOf(m) + ":" + String.valueOf(s);
	}
}
