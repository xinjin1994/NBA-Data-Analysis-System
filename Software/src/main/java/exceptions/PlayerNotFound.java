package exceptions;

public class PlayerNotFound extends MyException {
	/**
	 * 
	 */
	private static final long serialVersionUID = -5172679035740262401L;

	public PlayerNotFound(String player){
		this.errorMessage = "未找到 " + player + " 相关信息";
	}
}
