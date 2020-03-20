package com.hcl.bank.exception;

public class CustomerNotLoggedInException extends RuntimeException {

private static final long serialVersionUID = 1L;
	
	private static final Integer STATUS_CODE=9;

	public CustomerNotLoggedInException(Long customerId) {
		super("Customer with id : "+customerId+" does not logged in.");
	}
	public Integer getStatusCode()
	{
		return STATUS_CODE;
	}
	
	

}
