package com.bank.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long customerId;
	private String name;
	private String address;
	private String contactno;
	private String email;
	private Boolean isEligible;
	@OneToMany(mappedBy = "customer",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	private List<Account> accountList=new ArrayList<Account>();
	public void addAccountList(Account account)
	{
		accountList.add(account);
		account.setCustomer(this);
	}
	public Customer(String name, String address, String contactno, String email, Boolean isEligible) {

		this.name = name;
		this.address = address;
		this.contactno = contactno;
		this.email = email;
		this.isEligible = isEligible;
	}
	public Long getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getContactno() {
		return contactno;
	}
	public void setContactno(String contactno) {
		this.contactno = contactno;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Boolean getIsEligible() {
		return isEligible;
	}
	public void setIsEligible(Boolean isEligible) {
		this.isEligible = isEligible;
	}
	public Customer() {
		
	}
	public List<Account> getAccountList() {
		return accountList;
	}
	public void setAccountList(List<Account> accountList) {
		this.accountList = accountList;
	}
	

}
