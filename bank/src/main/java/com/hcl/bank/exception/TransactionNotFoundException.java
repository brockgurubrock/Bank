package com.hcl.bank.exception;

public class TransactionNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	private static final Integer STATUS_CODE = 77;

	public TransactionNotFoundException(Long accountId) {
		super("There is no transaction available with  account :" + accountId + " ");
	}

	public Integer getStatusCode() {
		return STATUS_CODE;
	}

}
