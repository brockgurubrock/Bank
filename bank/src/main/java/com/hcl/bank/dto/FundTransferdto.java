package com.hcl.bank.dto;

import javax.validation.constraints.NotNull;

public class FundTransferdto {

	@NotNull
	private Long fromAccount;
	@NotNull
	private String description;
	@NotNull
	private Long toAccount;
	@NotNull
	private Double amount;

	public Long getFromAccount() {
		return fromAccount;
	}

	public void setFromAccount(Long fromAccount) {
		this.fromAccount = fromAccount;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Long getToAccount() {
		return toAccount;
	}

	public void setToAccount(Long toAccount) {
		this.toAccount = toAccount;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

}
