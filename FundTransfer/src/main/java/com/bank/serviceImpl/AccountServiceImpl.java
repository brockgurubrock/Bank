package com.bank.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bank.constant.Constant;
import com.bank.dto.AccountCreate;
import com.bank.dto.UpdateAccount;
import com.bank.entity.Account;
import com.bank.entity.Customer;
import com.bank.exception.AccountNotfoundException;
import com.bank.exception.FundTransferLimitExceededException;
import com.bank.exception.InsufficientAmountException;
import com.bank.repository.AccountRepository;
import com.bank.repository.CustomerRepository;
import com.bank.service.AccountService;

@Service
@Transactional
public class AccountServiceImpl implements AccountService {

	@Autowired
	private AccountRepository accountRepository;
	@Autowired
	private CustomerRepository customerRepository;

	@Override
	public Account updateAccount(Long accountNumber, UpdateAccount req) {

		Account account = accountRepository.findById(accountNumber).orElseThrow(AccountNotfoundException::new);
		account.setAccountStatus(req.getAccountStatus());
		account.setAccountType(req.getAccountType());
		return account;
	}
	@Override
	public void deleteAccount(Long accountNumber) {
		Account account = accountRepository.findById(accountNumber).orElseThrow(AccountNotfoundException::new);
		accountRepository.delete(account);
	}

	@Override
	public Account retrieveAccount(Long accountNumber) {
		Account accountList = accountRepository.findById(accountNumber).orElseThrow(AccountNotfoundException::new);
		return accountList;
	}

	@Override
	public void addAccount(AccountCreate accountreq) {
		Account account = new Account(accountreq.getIfsc(), accountreq.getAccountType(), accountreq.getBalance(),
				accountreq.getAccountStatus());
		Customer customer = new Customer(accountreq.getName(), accountreq.getAddress(), accountreq.getContactno(),
				accountreq.getEmail(), accountreq.getIsEligible());
		customer.addAccountList(account);
		customerRepository.save(customer);
	}
	@Override
	public void withdraw(Long accountNumber, double amount) throws InsufficientAmountException {
		Account account=accountRepository.findById(accountNumber).orElseThrow(AccountNotfoundException::new);
		if((account.getBalance()-amount)>=Constant.Minimum_Fund)
		{
		account.setBalance(account.getBalance()-amount);
		accountRepository.save(account);
		}
		else
		{
			throw new InsufficientAmountException(Constant.Amount_Low);
		}
	}
	@Override
	public void deposit(Long accountNumber, double amount) {
		Account account=accountRepository.findById(accountNumber).orElseThrow(AccountNotfoundException::new);
		account.setBalance(account.getBalance()+amount);
		accountRepository.save(account);
	}
	@Override
	public void fundTransfer(Long fromAccountNumber, Long toAccountNumber, double amount) throws FundTransferLimitExceededException {
		if(amount<=Constant.Transfer_Amount)
		{
		Account account=accountRepository.findById(fromAccountNumber).orElseThrow(AccountNotfoundException::new);
		account.setBalance(account.getBalance()-amount);
		accountRepository.save(account);
		Account account1=accountRepository.findById(toAccountNumber).orElseThrow(AccountNotfoundException::new);
		account1.setBalance(account1.getBalance()+amount);
		accountRepository.save(account1);
		}
		else
		{
			throw new FundTransferLimitExceededException(Constant.TransferAmountExceeded);
		}
	}

}
