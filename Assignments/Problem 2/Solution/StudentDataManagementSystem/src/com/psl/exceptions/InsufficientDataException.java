package com.psl.exceptions;

public class InsufficientDataException extends Exception {
	
	private static final long serialVersionUID = 1L;

	public InsufficientDataException() {
		super(" Insuffiecient Data Exception ");
	}

	public InsufficientDataException(String string) {
		super(string);
	}
}
