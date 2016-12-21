package com.lgd.ssh.spider.Common;

public class SpiderException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5660151176076378472L;

	public SpiderException(String resultCode, Throwable cause) {
		super(resultCode, cause);
	}

	public SpiderException(String resultCode) {
		super(resultCode);
	}
	
	public SpiderException(String resultCode , String message) {
		super(resultCode + "|" + message);
	}
}
