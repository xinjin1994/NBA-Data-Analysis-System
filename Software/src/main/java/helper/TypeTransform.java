package helper;

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
		int m = (int)min;
		int s = (int)((min - m) * 60);
		return String.valueOf(m) + ":" + String.valueOf(s);
	}
}
