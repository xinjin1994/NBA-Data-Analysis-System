package helper;

public class ReaderHelper {
	//此类用于从文件读写数据时，将不能转化为数字的数据记为null
	
	public Integer str_to_int(String num){
		Integer result;
		try{
			result = Integer.parseInt(num);
		}catch(NumberFormatException e){
			result = null;
		}
		
		return result;
	}
	
	public Double str_to_double(String num){
		Double result;
		try{
			result = Double.parseDouble(num);
		}catch(NumberFormatException e){
			result = null;
		}
		
		return result;
	}
}
