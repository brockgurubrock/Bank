package com.bank.service;



import com.bank.dto.AccountCreate;
import com.bank.dto.UpdateAccount;
import com.bank.entity.Account;
import com.bank.exception.FundTransferLimitExceededException;
import com.bank.exception.InsufficientAmountException;

public interface AccountService {
	
	public void addAccount(AccountCreate account);
	Account updateAccount (Long accountNumber,UpdateAccount account);
	public void deleteAccount (Long accountNumber);
	Account retrieveAccount(Long accountNumber);
	public void withdraw(Long accountNumber,double amount)throws InsufficientAmountException;
	public void deposit(Long accountNumber,double amount);
	public void fundTransfer(Long fromAccountNumber,Long toAccountNumber, double amount)throws FundTransferLimitExceededException;
	
	
	

}
