package com.bank.demo.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bank.demo.constants.ExceptionMsg;
import com.bank.demo.dto.AccountReq;
import com.bank.demo.dto.UpdateAccount;
import com.bank.demo.entities.Account;
import com.bank.demo.exception.AccountNotFoundException;
import com.bank.demo.service.AccountService;

@RestController
@RequestMapping(value ="/bank")
public class AccountController {
	
	@Autowired
	private AccountService accountService;

	@PostMapping(path = "/createAccount")
	public ResponseEntity<Account> createAccount(@RequestBody AccountReq req) {
		Account account = new Account(req.getIfsc(), req.getAccountType(), req.getBalance(), req.getAccountStatus());
		return new ResponseEntity<Account>(accountService.createAccount(account), HttpStatus.OK);
	}

	@PutMapping(path = "/updateAccount")
	public ResponseEntity<Account> updateAccount(@RequestBody UpdateAccount account) {
		Account updatedAccount = accountService.UpdateAccount(account);
		return new ResponseEntity<Account>(updatedAccount, HttpStatus.OK);
	}

	@DeleteMapping(path = "/deleteAccount/{accountno}")
	public ResponseEntity<Account> deleteAccount(@PathVariable(name = "accountno") Long accountno) {
		accountService.deleteAccount(accountno);
		return new ResponseEntity<Account>(HttpStatus.OK);

	}

	@GetMapping(path = "/getAccountByAccnNo/{accountno}")
	public ResponseEntity<Account> getAccountByAccountNumber(@PathVariable(name = "accountno") Long accountno) {
		Account account = (Account) accountService.AccountretriveAccountUsingAccountNo(accountno);
		System.out.println(account.toString());
		return new ResponseEntity<Account>(account, HttpStatus.OK);

	}

	@GetMapping(path = "/getAccountByIfsc/{ifsc}")
	public ResponseEntity<List<Account>> getAccountsByIfsc(@PathVariable(name = "ifsc") String ifsc) {
		List<Account> accounts = accountService.retriveAccount(ifsc);
		return new ResponseEntity<List<Account>>(accounts, HttpStatus.OK);

	}

	@ExceptionHandler(value = AccountNotFoundException.class)
	public ResponseEntity<String> exception(AccountNotFoundException ex) {
		return new ResponseEntity<>(ExceptionMsg.Account_Not_Found, HttpStatus.NOT_FOUND);
	}

}
