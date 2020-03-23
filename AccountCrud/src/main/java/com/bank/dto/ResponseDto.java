package com.bank.dto;

public class ResponseDto {
	private String message;
	private Integer Statuscode;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Integer getStatuscode() {
		return Statuscode;
	}

	public void setStatuscode(Integer statuscode) {
		Statuscode = statuscode;
	}

}
