package com.hcl.bank.exception;

public class UserNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	private static final Integer STATUS_CODE = 322;

	public UserNotFoundException(Long customerId) {
		super("Customer with id :" + customerId + " mot found.");
	}

	public Integer getStatusCode() {
		return STATUS_CODE;
	}

}
