package com.bank.dto;

public class AccountCreateResponseDto {
	private String message;
	private Integer status_code;

	

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Integer getStatus_code() {
		return status_code;
	}

	public void setStatus_code(Integer statusCode) {
		this.status_code = statusCode;
	}

}
