package com.bank.dto;

import com.bank.entity.AccountType;

public class UpdateAccount {
	private AccountType accountType;
	private Boolean accountStatus;
	public AccountType getAccountType() {
		return accountType;
	}
	public void setAccountType(AccountType accountType) {
		this.accountType = accountType;
	}
	public Boolean getAccountStatus() {
		return accountStatus;
	}
	public void setAccountStatus(Boolean accountStatus) {
		this.accountStatus = accountStatus;
	}
	
}
