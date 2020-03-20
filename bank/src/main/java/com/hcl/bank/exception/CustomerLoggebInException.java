package com.hcl.bank.exception;

public class CustomerLoggebInException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	private static final Integer STATUS_CODE = 9;

	public CustomerLoggebInException() {
		super("Sorry,Login please!");
	}

	public Integer getStatusCode() {
		return STATUS_CODE;
	}

}
