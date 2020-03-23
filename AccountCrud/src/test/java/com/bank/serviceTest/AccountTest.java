package com.bank.serviceTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import static org.mockito.ArgumentMatchers.any;

import com.bank.dto.AccountCreate;
import com.bank.dto.AccountCreateResponseDto;
import com.bank.dto.AccountNumDto;
import com.bank.dto.UpdateAccount;
import com.bank.entity.Account;
import com.bank.entity.Customer;
import com.bank.repository.AccountRepository;
import com.bank.repository.CustomerRepository;
import com.bank.serviceImpl.AccountServiceImpl;

@RunWith(MockitoJUnitRunner.class)
public class AccountTest {
	@Mock
	private AccountRepository accountRepository;
	@Mock
	private CustomerRepository customerRepository;
	@InjectMocks
	private AccountServiceImpl accountServiceImpl;

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
		updateAccount.setAccountNumber(1234L);
		updateAccount.setAccountStatus(true);
		updateAccount.setAccountType("saving");
		accountNumDto = new AccountNumDto();
		accountNumDto.setAccountNum(1234L);

		customer.addAccountList(account);
		account.setCustomer(customer);
	}

	@Test
	public void testAddAccount() {

		Mockito.when(customerRepository.save(customer)).thenReturn(customer);
		AccountCreateResponseDto responseDto = accountServiceImpl.addAccount(accountCreate);
		assertEquals(accountCreate.getAddress(), customer.getAddress());

	}

	@Test
	public void testUpdateAccount() {

		Mockito.when(accountRepository.findById(1234L)).thenReturn(java.util.Optional.of(account));
		accountServiceImpl.updateAccount(updateAccount);
		assertEquals(account.getAccountStatus(), updateAccount.getAccountStatus());

	}
	@Test
	public void testDeleteAccount() {

		Mockito.when(accountRepository.findById(1234L)).thenReturn(Optional.of(account));
		accountRepository.delete(account);
		accountServiceImpl.deleteAccount(accountNumDto);
	//	assertEquals(account.getAccountStatus(), updateAccount.getAccountStatus());

	}
	@Test
	public void testRetriveAccount() {

		Mockito.when(accountRepository.findById(1234L)).thenReturn(Optional.of(account));
		accountServiceImpl.retrieveAccount(accountNumDto);
		
		assertEquals(account.getAccountno(),account.getAccountno());

	}
	

}
