package com.bank.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bank.constant.Constant;

import com.bank.dto.AccountCreate;
import com.bank.dto.AccountCreateResponseDto;
import com.bank.dto.AccountNumDto;
import com.bank.dto.ResponseDto;
import com.bank.dto.RetriveAccountDto;
import com.bank.dto.UpdateAccount;
import com.bank.entity.Account;
import com.bank.service.AccountService;

@RestController
@RequestMapping(value = "/bank")
public class AccountController {
	@Autowired
	private AccountService accountService;
	
	
	@GetMapping(value = "/bank/account/account")
	public ResponseEntity<Account> RetriveAccount(@RequestBody AccountNumDto accountNumDto) {
		

		return new ResponseEntity<>(accountService.retrieveAccount(accountNumDto), HttpStatus.OK);

	}


	@PostMapping(value = "/bank/account")
	public ResponseEntity<AccountCreateResponseDto> addAccount(@RequestBody AccountCreate accountCreate) {
		AccountCreateResponseDto responseDto = new AccountCreateResponseDto();
		accountService.addAccount(accountCreate);
		responseDto.setMessage(Constant.Account_Created);
		responseDto.setStatus_code(Constant.Status_Code);
		return new ResponseEntity<>(responseDto, HttpStatus.OK);

	}

	@PostMapping(value = "/bank/account/account")
	public ResponseEntity<ResponseDto> updateAccount(@RequestBody UpdateAccount updateAccount) {
		ResponseDto responseDto = new ResponseDto();
		accountService.updateAccount(updateAccount);
		responseDto.setMessage(Constant.Account_Updated);
		responseDto.setStatuscode(Constant.Status_Code);
		return new ResponseEntity<>(responseDto, HttpStatus.OK);

	}

	@DeleteMapping(value = "/bank/account/account")
	public ResponseEntity<ResponseDto> deleteAccount(@RequestBody AccountNumDto deleteAccountDto) {
		ResponseDto responseDto = new ResponseDto();
		accountService.deleteAccount(deleteAccountDto);
		responseDto.setMessage(Constant.Account_Deleted);
		responseDto.setStatuscode(Constant.Delete_Status_Code);

		return new ResponseEntity<>(responseDto, HttpStatus.OK);

	}

	
}
