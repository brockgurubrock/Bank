package com.bank.demo.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Account_table")
public class Account {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long accountno;
	private String ifsc;
	private AccountType accountType;
	private double balance;
	private Boolean accountStatus;

	public Account(String ifsc, AccountType accountType, double balance, Boolean accountStatus) {
		super();
		this.ifsc = ifsc;
		this.accountType = accountType;
		this.balance = balance;
		this.accountStatus = accountStatus;
	}

	public Long getAccountno() {
		return accountno;
	}

	public void setAccountno(Long accountno) {
		this.accountno = accountno;
	}

	public String getIfsc() {
		return ifsc;
	}

	public void setIfsc(String ifsc) {
		this.ifsc = ifsc;
	}

	@Override
	public String toString() {
		return "Account [accountno=" + accountno + ", ifsc=" + ifsc + ", accountType=" + accountType + ", balance="
				+ balance + ", accountStatus=" + accountStatus + "]";
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

	public Account() {

	}

}
