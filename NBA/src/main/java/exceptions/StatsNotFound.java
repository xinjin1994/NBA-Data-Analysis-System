package exceptions;

public class StatsNotFound extends MyException{
	/**
	 * 
	 */
	private static final long serialVersionUID = 6533804091821231644L;

	public String getErrorMessage(){
		return "未找到相关数据";
	}
}
