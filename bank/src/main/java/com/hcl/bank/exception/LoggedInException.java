package com.hcl.bank.exception;

public class LoggedInException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	private static final Integer STATUS_CODE = 765;

	public LoggedInException(Long customerId) {
		super("Customer is already loggedin with customer Id"+customerId);
	}

	public Integer getStatusCode() {
		return STATUS_CODE;
	}
}
