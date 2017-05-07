package com.psl.exceptions;

/**
 * 
 * @author YOGESH SHINDE
 * @since October 2014
 *
 */

public class InvalidDateException extends Exception 
{
	private static final long serialVersionUID = 1L;

	public InvalidDateException()
	{
		super("Invalid Date Exception..!!! (Date Should be 'dd/MM/yyyy')");
	}
}
