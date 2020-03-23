package com.bank.serviceImpl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bank.constant.Constant;
import com.bank.dto.AccountCreate;
import com.bank.dto.AccountCreateResponseDto;
import com.bank.dto.AccountNumDto;
import com.bank.dto.ResponseDto;
import com.bank.dto.RetriveAccountDto;
import com.bank.dto.UpdateAccount;
import com.bank.entity.Account;
import com.bank.entity.Customer;
import com.bank.entity.Transaction;
import com.bank.exception.AccountNotfoundException;
import com.bank.exception.FundTransferLimitExceededException;

import com.bank.repository.AccountRepository;
import com.bank.repository.CustomerRepository;

import com.bank.service.AccountService;

import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;
@Service
@Transactional
@Slf4j
public class AccountServiceImpl implements AccountService {
	

	@Autowired
	private AccountRepository accountRepository;
	@Autowired
	private CustomerRepository customerRepository;
	private static final Logger logger=LoggerFactory.getLogger(AccountServiceImpl.class);

	

	@Override
	public AccountCreateResponseDto addAccount(AccountCreate accountreq) {
		AccountCreateResponseDto responseDto = new AccountCreateResponseDto();
		Account account = new Account(accountreq.getIfsc(), accountreq.getAccountType(), accountreq.getBalance(),
				accountreq.getAccountStatus());
		Customer customer = new Customer(accountreq.getName(), accountreq.getAddress(), accountreq.getContactno(),
				accountreq.getEmail(), accountreq.getIsEligible());
		customer.addAccountList(account);
		customerRepository.save(customer);
		logger.info("Account added SuccessFully");
		BeanUtils.copyProperties(account, responseDto);

		return responseDto;
	}

	@Override
	public ResponseDto updateAccount(UpdateAccount accountreq) {

		Optional<Account> account1 = accountRepository.findById(accountreq.getAccountNumber());
		account1.get().setAccountStatus(accountreq.getAccountStatus());
		account1.get().setAccountType(accountreq.getAccountType());
		accountRepository.save(account1.get());
		logger.info("Account Updated SuccessFully");
		ResponseDto responseDto = new ResponseDto();
		BeanUtils.copyProperties(account1, responseDto);

		return responseDto;
	}

	@Override
	public ResponseDto deleteAccount(AccountNumDto deleteAccountDto) {
		ResponseDto responseDto = new ResponseDto();
		Optional<Account> account = accountRepository.findById(deleteAccountDto.getAccountNum());
		accountRepository.delete(account.get());
		logger.info("Account deleted Sucessfully");
		BeanUtils.copyProperties(account, responseDto);
		return responseDto;
	}

	@Override
	public Account retrieveAccount(AccountNumDto accountNumDto) {
		//RetriveAccountDto retriveAccountDto = new RetriveAccountDto();
		Optional<Account> account = accountRepository.findById(accountNumDto.getAccountNum());

		return account.get();
	}

	@Override
	public ResponseDto fundTransfer(Long fromAccountNumber, Long toAccountNumber, double amount)
			throws FundTransferLimitExceededException {
		ResponseDto responseDto = new ResponseDto();
		List<Transaction> fromtransactionList = new ArrayList<Transaction>();
		List<Transaction> toTransactionList = new ArrayList<Transaction>();

		{
			if (amount <= Constant.Transfer_Amount) {
				Optional<Account> account = accountRepository.findById(fromAccountNumber);
				if (!account.isPresent()) {
					throw new AccountNotfoundException();
				}

				account.get().setBalance(account.get().getBalance() - amount);
				Transaction fromAccounttransaction = new Transaction();
				fromAccounttransaction.setBenificiaryAccno(toAccountNumber);
				fromAccounttransaction.setFromAccountNo(fromAccountNumber);
				fromAccounttransaction.setTranferAmount(amount);
				fromAccounttransaction.setTransaction_Date(LocalDate.now());
				fromAccounttransaction.setTransactionType(Constant.Debit);
				fromtransactionList.add(fromAccounttransaction);
				fromAccounttransaction.setAccount(account.get());
				account.get().setTransactions(fromtransactionList);
				// transactionRepository.save(fromAccounttransaction);
				accountRepository.save(account.get());
				Optional<Account> account1 = accountRepository.findById(toAccountNumber);

				account1.get().setBalance(account1.get().getBalance() + amount);
				Transaction toAccountTransaction = new Transaction();
				toAccountTransaction.setBenificiaryAccno(toAccountNumber);
				toAccountTransaction.setFromAccountNo(fromAccountNumber);
				toAccountTransaction.setTranferAmount(amount);
				toAccountTransaction.setTransaction_Date(LocalDate.now());
				toAccountTransaction.setTransactionType(Constant.Credit);
				toTransactionList.add(toAccountTransaction);
				toAccountTransaction.setAccount(account1.get());
				account1.get().setTransactions(toTransactionList);
				accountRepository.save(account1.get());
			} else {
				throw new FundTransferLimitExceededException(Constant.TransferAmountExceeded);
			}
		}

		return responseDto;

	}

}

/*
 * public Account updateAccount(Long accountNumber, UpdateAccount req) {
 * 
 * Account account = accountRepository.findById(accountNumber).orElseThrow(
 * AccountNotfoundException::new);
 * account.setAccountStatus(req.getAccountStatus());
 * account.setAccountType(req.getAccountType()); return account; }
 * 
 * @Override public void deleteAccount(Long accountNumber) { Account account =
 * accountRepository.findById(accountNumber).orElseThrow(
 * AccountNotfoundException::new); accountRepository.delete(account); }
 * 
 * @Override public Account retrieveAccount(Long accountNumber) { Account
 * accountList = accountRepository.findById(accountNumber).orElseThrow(
 * AccountNotfoundException::new); return accountList; }
 * 
 * @Override public void addAccount(AccountCreate accountreq) { Account account
 * = new Account(accountreq.getIfsc(), accountreq.getAccountType(),
 * accountreq.getBalance(), accountreq.getAccountStatus()); Customer customer =
 * new Customer(accountreq.getName(), accountreq.getAddress(),
 * accountreq.getContactno(), accountreq.getEmail(),
 * accountreq.getIsEligible()); customer.addAccountList(account);
 * customerRepository.save(customer); }
 * 
 * @Override public void withdraw(Long accountNumber, double amount) throws
 * InsufficientAmountException { Account
 * account=accountRepository.findById(accountNumber).orElseThrow(
 * AccountNotfoundException::new);
 * if((account.getBalance()-amount)>=Constant.Minimum_Fund) {
 * account.setBalance(account.getBalance()-amount);
 * accountRepository.save(account); } else { throw new
 * InsufficientAmountException(Constant.Amount_Low); } }
 * 
 * @Override public void deposit(Long accountNumber, double amount) { Account
 * account=accountRepository.findById(accountNumber).orElseThrow(
 * AccountNotfoundException::new);
 * account.setBalance(account.getBalance()+amount);
 * accountRepository.save(account); }
 * 
 * @Override public void fundTransfer(Long fromAccountNumber, Long
 * toAccountNumber, double amount) throws FundTransferLimitExceededException {
 * if(amount<=Constant.Transfer_Amount) { Account
 * account=accountRepository.findById(fromAccountNumber).orElseThrow(
 * AccountNotfoundException::new);
 * account.setBalance(account.getBalance()-amount);
 * accountRepository.save(account); Account
 * account1=accountRepository.findById(toAccountNumber).orElseThrow(
 * AccountNotfoundException::new);
 * account1.setBalance(account1.getBalance()+amount);
 * accountRepository.save(account1); } else { throw new
 * FundTransferLimitExceededException(Constant.TransferAmountExceeded); } }
 */
