package com.hcl.bank.exception;

public class InsuffiecientFundException extends Exception {

	private static final long serialVersionUID = 1L;

	private static final Integer STATUS_CODE = 765;

	public InsuffiecientFundException(Long benificiaryId) {
		super("insufficien fund with this account :" + benificiaryId + " d");
	}

	public Integer getStatusCode() {
		return STATUS_CODE;
	}

}
