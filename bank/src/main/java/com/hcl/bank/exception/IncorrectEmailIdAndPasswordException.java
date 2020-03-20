package com.hcl.bank.exception;

public class IncorrectEmailIdAndPasswordException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	private static final Integer STATUS_CODE=6;

	public IncorrectEmailIdAndPasswordException(String email) {
		
		super("Incorrect email or password ,Please provide valid email and password");
	}
	public Integer getStatusCode()
	{
		return STATUS_CODE;
	}

}
