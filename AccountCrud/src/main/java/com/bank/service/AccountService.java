package com.bank.service;

import com.bank.dto.AccountCreate;
import com.bank.dto.AccountCreateResponseDto;
import com.bank.dto.AccountNumDto;
import com.bank.dto.ResponseDto;

import com.bank.dto.UpdateAccount;
import com.bank.entity.Account;
import com.bank.exception.FundTransferLimitExceededException;


public interface AccountService {

	public AccountCreateResponseDto addAccount(AccountCreate account);

	public ResponseDto updateAccount(UpdateAccount account);

	public ResponseDto deleteAccount(AccountNumDto deleteAccountDto);

	public Account retrieveAccount(AccountNumDto accountNumDto);

	public ResponseDto fundTransfer(Long fromAccountNumber, Long toAccountNumber, double amount)throws FundTransferLimitExceededException;
	

}
