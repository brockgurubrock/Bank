package com.bank.controllerTest;

import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.ResponseEntity;

import com.bank.dto.AccountCreate;
import com.bank.dto.AccountCreateResponseDto;
import com.bank.dto.AccountNumDto;
import com.bank.dto.ResponseDto;
import com.bank.dto.UpdateAccount;
import com.bank.entity.Account;
import com.bank.entity.Customer;
import com.bank.service.AccountService;

import com.bank.web.controller.AccountController;

@RunWith(MockitoJUnitRunner.class)
public class TestController {
	@Mock
	private AccountService accountService;
	@InjectMocks
	private AccountController accountController;
	private Account account = null;
	private Customer customer = null;
	private AccountCreate accountCreate = null;
	private UpdateAccount updateAccount = null;
	private AccountNumDto accountNumDto = null;

	@Before
	public void setup() {
		account = new Account();
		account.setAccountno(1234L);
		account.setIfsc("afc123");
		account.setAccountType("saving");
		account.setBalance(1000);
		account.setAccountStatus(true);
		customer = new Customer();
		customer.setName("guru");
		customer.setAddress("btm");
		customer.setContactno("9843082528");
		customer.setEmail("guru@gmail.com");
		customer.setIsEligible(true);

		accountCreate = new AccountCreate();
		accountCreate.setIfsc("afc123");
		accountCreate.setAccountType("saving");
		accountCreate.setBalance(1000);
		accountCreate.setAccountStatus(true);
		accountCreate.setName("guru");
		accountCreate.setAddress("btm");
		accountCreate.setContactno("9843082528");
		accountCreate.setEmail("guru@gmail.com");
		accountCreate.setIsEligible(true);

		updateAccount = new UpdateAccount();
		updateAccount.setAccountNumber(1000L);
		updateAccount.setAccountStatus(true);
		updateAccount.setAccountType("saving");
		accountNumDto = new AccountNumDto();
		accountNumDto.setAccountNum(1234L);
	}

	@Test
	public void testAddAcccount() {
		AccountCreateResponseDto createResponseDto = new AccountCreateResponseDto();
		Mockito.when(accountService.addAccount(accountCreate)).thenReturn(createResponseDto);
		ResponseEntity<AccountCreateResponseDto> response = accountController.addAccount(accountCreate);
		assertEquals(response.getBody().getMessage(), "Account Created Successfully");
	}

	@Test
	public void testUpdateAccount() {
		ResponseDto responseDto = new ResponseDto();
		Mockito.when(accountService.updateAccount(updateAccount)).thenReturn(responseDto);
		ResponseEntity<ResponseDto> response = accountController.updateAccount(updateAccount);
		assertEquals(response.getBody().getMessage(), "Account Updated Successfully");

	}

	@Test
	public void testDeleteAccount() {
		ResponseDto responseDto = new ResponseDto();
		Mockito.when(accountService.deleteAccount(accountNumDto)).thenReturn(responseDto);
		ResponseEntity<ResponseDto> response = accountController.deleteAccount(accountNumDto);
		assertEquals(response.getBody().getMessage(), "Account Deleted Successfully");

	}

	@Test
	public void testRetriveAccount() {

		Mockito.when(accountService.retrieveAccount(accountNumDto)).thenReturn(account);
		ResponseEntity<Account> response = accountController.RetriveAccount(accountNumDto);
		assertEquals(response.getBody().getAccountno(), account.getAccountno());

	}

}
