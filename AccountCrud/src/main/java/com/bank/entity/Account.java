package com.bank.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

@Entity

public class Account {
	@Id
	@SequenceGenerator(name = "seq", initialValue = 50001, allocationSize = 1000)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
	private Long accountno;
	private String ifsc;

	private String AccountType;
	private double balance;
	private Boolean accountStatus;

	@ManyToOne
	private Customer customer;
	@OneToMany(mappedBy = "account", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<Transaction> transactions = new ArrayList<Transaction>();

	public Account(String ifsc, String accountType, double balance, Boolean accountStatus) {

		this.ifsc = ifsc;
		AccountType = accountType;
		this.balance = balance;
		this.accountStatus = accountStatus;

	}

	public List<Transaction> getTransactions() {
		return transactions;
	}

	public void setTransactions(List<Transaction> transactions) {
		this.transactions = transactions;
	}

	public String getAccountType() {
		return AccountType;
	}

	public void setAccountType(String accountType) {
		AccountType = accountType;
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

	@Override
	public String toString() {
		return "Account [accountno=" + accountno + ", ifsc=" + ifsc + ", AccountType=" + AccountType + ", balance="
				+ balance + ", accountStatus=" + accountStatus + ", customer=" + customer + "]";
	}

	

}
