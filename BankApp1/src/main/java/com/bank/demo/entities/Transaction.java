package com.bank.demo.entities;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="Transaction_tabel")
public class Transaction {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long transrefno;
	private Long benificiaryAccno;
	private String transactionType;
	private LocalDate transaction_Date;
	private double updatedAccountBalance;
	private Long fromAccountNo; 
	private boolean transactionStatus;
	public Transaction(Long benificiaryAccno, String transactionType, LocalDate transaction_Date,
			double updatedAccountBalance, Long fromAccountNo, boolean transactionStatus) {
		
		this.benificiaryAccno = benificiaryAccno;
		this.transactionType = transactionType;
		this.transaction_Date = transaction_Date;
		this.updatedAccountBalance = updatedAccountBalance;
		this.fromAccountNo = fromAccountNo;
		this.transactionStatus = transactionStatus;
	}
	public Long getTransrefno() {
		return transrefno;
	}
	public void setTransrefno(Long transrefno) {
		this.transrefno = transrefno;
	}
	public Long getBenificiaryAccno() {
		return benificiaryAccno;
	}
	public void setBenificiaryAccno(Long benificiaryAccno) {
		this.benificiaryAccno = benificiaryAccno;
	}
	public String getTransactionType() {
		return transactionType;
	}
	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}
	public LocalDate getTransaction_Date() {
		return transaction_Date;
	}
	public void setTransaction_Date(LocalDate transaction_Date) {
		this.transaction_Date = transaction_Date;
	}
	public double getUpdatedAccountBalance() {
		return updatedAccountBalance;
	}
	public void setUpdatedAccountBalance(double updatedAccountBalance) {
		this.updatedAccountBalance = updatedAccountBalance;
	}
	public Long getFromAccountNo() {
		return fromAccountNo;
	}
	public void setFromAccountNo(Long fromAccountNo) {
		this.fromAccountNo = fromAccountNo;
	}
	public boolean isTransactionStatus() {
		return transactionStatus;
	}
	public void setTransactionStatus(boolean transactionStatus) {
		this.transactionStatus = transactionStatus;
	}
	public Transaction() {
		
	}
	
	

}
