package com.webwork.studyonline.exception;

public class BusinessException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String msg;

	BusinessException(String msg) {
		this.msg = msg;
	}

	public String toString() {
		return "Exception Occured: "+msg;
	}
	
}