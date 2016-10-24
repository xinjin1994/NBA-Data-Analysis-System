package exceptions;

public class MyException extends Throwable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6884149684905444604L;
	//所有自定义异常的父类
	String errorMessage;
	
	public String getErrorMessage(){
		return errorMessage;
	}
}
