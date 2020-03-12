package com.bank.demo.dto;

import com.bank.demo.entities.AccountType;

public class AccountReq {
	private String ifsc;
	private AccountType accountType;
	private double balance;
	private Boolean accountStatus;

	public String getIfsc() {
		return ifsc;
	}

	public void setIfsc(String ifsc) {
		this.ifsc = ifsc;
	}

	public AccountType getAccountType() {
		return accountType;
	}

	public void setAccountType(AccountType accountType) {
		this.accountType = accountType;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public Boolean getAccountStatus() {
		return accountStatus;
	}

	public void setAccountStatus(Boolean accountStatus) {
		this.accountStatus = accountStatus;
	}

}
