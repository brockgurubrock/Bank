package com.hcl.bank.exception;

public class BenficiaryAlreadyExcistException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	private static final Integer STATUS_CODE = 21;

	public BenficiaryAlreadyExcistException(Long benificiaryId) {
		super("Benificiary with id :" + benificiaryId + " is already  exists.");
	}

	public Integer getStatusCode() {
		return STATUS_CODE;
	}

}