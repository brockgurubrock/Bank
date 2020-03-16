package com.bank.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;


@Entity

public class Account {
	@Id
	@SequenceGenerator(name = "seq", initialValue = 50001, allocationSize = 1000)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
	private Long accountno;
	private String ifsc;
	
	private AccountType accountType;
	private double balance;
	private Boolean accountStatus;
	

	public AccountType getAccountType() {
		return accountType;
	}

	public void setAccountType(AccountType accountType) {
		this.accountType = accountType;
	}

	@ManyToOne
	private Customer customer;

	public Account(String ifsc, AccountType accountType, double balance, Boolean accountStatus) {

		this.ifsc = ifsc;
		this.accountType = accountType;
		this.balance = balance;
		this.accountStatus = accountStatus;
	}

	public Account() {

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

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

}
