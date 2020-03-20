package com.hcl.bank.exception;

public class LoggedOutCustomerException  extends RuntimeException{
	private static final long serialVersionUID = 1L;

	private static final Integer STATUS_CODE = 765;

	public LoggedOutCustomerException() {
		super("Sorry,please login first");
	}

	public Integer getStatusCode() {
		return STATUS_CODE;
	}

}
