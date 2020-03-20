package com.hcl.bank.exception;

public class AccountNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	private static final Integer STATUS_CODE = 12;

	public AccountNotFoundException(Long accountNumber) {
		super("Account number :" + accountNumber + " does not exists.");
	}

	public Integer getStatusCode() {
		return STATUS_CODE;
	}

}