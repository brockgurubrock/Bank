package com.hcl.bank.exception;

public class InvalidBenificiaryAddingException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	private static final Integer STATUS_CODE = 765;

	public InvalidBenificiaryAddingException(Long userId) {
		super("No benificieries found " + userId);
	}

	public Integer getStatusCode() {
		return STATUS_CODE;
	}
}
