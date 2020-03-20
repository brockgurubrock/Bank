package com.hcl.bank.dto;

import javax.validation.constraints.NotNull;

public class BenificiaryDTO {

	@NotNull
	private Long benificiaryAccountNumber;

	@NotNull
	private String benificiaryName;

	@NotNull
	private Long customerId;

	public Long getBenificiaryAccountNumber() {
		return benificiaryAccountNumber;
	}

	public void setBenificiaryAccountNumber(Long benificiaryAccountNumber) {
		this.benificiaryAccountNumber = benificiaryAccountNumber;
	}

	public String getBenificiaryName() {
		return benificiaryName;
	}

	public void setBenificiaryName(String benificiaryName) {
		this.benificiaryName = benificiaryName;
	}

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

}
