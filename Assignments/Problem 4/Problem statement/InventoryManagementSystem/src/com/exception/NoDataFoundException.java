package com.exception;

public class NoDataFoundException extends Exception {
	
	private static final long serialVersionUID = 1L;
	
	public NoDataFoundException() {
		super(" No Data Found Exception");
	}
}
