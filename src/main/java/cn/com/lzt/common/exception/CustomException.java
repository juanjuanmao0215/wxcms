package cn.com.lzt.common.exception;

public class CustomException extends Exception {

	private static final long serialVersionUID = 1L;

	/**
	 * 异常信息
	 */
	public String errormsg;

	public CustomException(String errormsg) {
		super();
		this.errormsg = errormsg;
	}

	public String getErrormsg() {
		return errormsg;
	}

	public void setErrormsg(String errormsg) {
		this.errormsg = errormsg;
	}

}
