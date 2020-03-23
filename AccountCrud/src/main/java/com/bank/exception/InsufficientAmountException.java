package com.bank.exception;

public class InsufficientAmountException extends Exception {

	private static final long serialVersionUID = 1L;

	public InsufficientAmountException(String message) {
		super(message);

	}

}
