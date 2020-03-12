package com.bank.demo.entities;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "Customer_table")
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long customerId;
	private String name;
	private String address;
	private String contactno;
	private String email;
	private LocalDate localDate;
	private Boolean isEligible;

	

	public Customer(Long customerId, String name, String address, String contactno, String email, LocalDate localDate,
			Boolean isEligible) {
		
	
		this.name = name;
		this.address = address;
		this.contactno = contactno;
		this.email = email;
		this.localDate = localDate;
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

	public LocalDate getLocalDate() {
		return localDate;
	}

	public void setLocalDate(LocalDate localDate) {
		this.localDate = localDate;
	}

	public Boolean getIsEligible() {
		return isEligible;
	}

	public void setIsEligible(Boolean isEligible) {
		this.isEligible = isEligible;
	}

	public Customer() {

	}

}
