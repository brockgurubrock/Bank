package com.bank.demo.serviceImplementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.bank.demo.constants.ExceptionMsg;
import com.bank.demo.dto.*;
import com.bank.demo.entities.Account;
import com.bank.demo.exception.AccountNotFoundException;
import com.bank.demo.repository.AccountRepository;
import com.bank.demo.service.AccountService;
@Service
@Transactional
public class AccountServiceImpl implements AccountService{
	@Autowired
	private AccountRepository accountRepository;
	@Override
	public Account createAccount(Account account) {
		
		return accountRepository.save(account);
	}

	@Override
	public Account UpdateAccount(UpdateAccount req) {
		
		Account account=accountRepository.findById(req.getAccNo()).orElseThrow(AccountNotFoundException::new);
		account.setAccountStatus(req.getAccountStatus());
		accountRepository.save(account);
		return account;
	}

	@Override
	public void deleteAccount(Long Accno) {
		Account account=accountRepository.findById(Accno).orElseThrow(AccountNotFoundException::new);
		accountRepository.delete(account);
	}

	@Override
	public List<Account> retriveAccount(String ifsc) {
		@SuppressWarnings("unchecked")
		List<Account> account=accountRepository.findByIfsc(ifsc);
		return account;
	}

	@Override
	public Account AccountretriveAccountUsingAccountNo(Long accno) {
		Account accounts=accountRepository.findById(accno).orElseThrow(AccountNotFoundException::new);
		return accounts;
	}
	
	



}
