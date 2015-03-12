package exceptions;

public class FileNotFound extends MyException {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6230242129880780263L;

	public FileNotFound(String file) {
		this.errorMessage = "文件 " + file + " 不存在";
	}

}
