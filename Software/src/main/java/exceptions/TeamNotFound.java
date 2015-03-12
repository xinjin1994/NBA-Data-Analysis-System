package exceptions;

public class TeamNotFound extends MyException {
	/**
	 * 
	 */
	private static final long serialVersionUID = -5486793299455407030L;

	public TeamNotFound(String team){
		this.errorMessage = "未找到 " + team + " 相关信息";
	}
}
