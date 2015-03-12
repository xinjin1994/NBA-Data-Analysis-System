package exceptions;

public class MatchNotFound extends MyException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 8333397467609676946L;

	public MatchNotFound(String match){
		this.errorMessage = "比赛 " + match + "不存在";
	}
}
