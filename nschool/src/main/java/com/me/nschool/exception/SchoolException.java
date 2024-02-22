package com.me.nschool.exception;

public class SchoolException extends Exception {

	public SchoolException(String message)
	{
		super(message);
	}
	
	public SchoolException(String message, Throwable cause)
	{
		super(message,cause);
	}
}
