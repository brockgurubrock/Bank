package com.bank.web.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bank.dto.AccountCreate;
import com.bank.service.AccountService;

@RestController
@RequestMapping(value = "/bank")
public class AccountController {
	@Autowired
	private AccountService accountService;
	
	@PostMapping(value = "/bank/account")
	public ResponseEntity<Void>addAccount(@RequestBody AccountCreate accountCreate )
	{
		accountService.addAccount(accountCreate);
		return new ResponseEntity<Void>(HttpStatus.OK);
		
	}
	

}
