package com.bank.exception;

public class FundTransferLimitExceededException extends Exception {
	private static final long serialVersionUID = 1L;

	public FundTransferLimitExceededException(String message) {
		super(message);
		
	}
	

}
