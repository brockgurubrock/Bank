package com.hcl.bank.exception;

public class LoginCustomerFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	private static final Integer STATUS_CODE = 765;

	public LoginCustomerFoundException(Long userId) {
		super("Customer is already logged in with customer id "+userId);
	}

	public Integer getStatusCode() {
		return STATUS_CODE;
	}
}
