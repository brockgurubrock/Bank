package com.hcl.bank.exception;

public class BenificiaryNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	private static final Integer STATUS_CODE = 33;

	public BenificiaryNotFoundException(Long customerId) {
		super("Benificiary with is not associated with customer:" + customerId);
	}

	public Integer getStatusCode() {
		return STATUS_CODE;
	}

}
