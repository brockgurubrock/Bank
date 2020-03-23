package com.bank.serviceTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.bank.dto.AccountCreate;
import com.bank.dto.AccountNumDto;
import com.bank.dto.UpdateAccount;
import com.bank.entity.Account;
import com.bank.entity.Customer;
import com.bank.exception.FundTransferLimitExceededException;
import com.bank.repository.AccountRepository;
import com.bank.serviceImpl.AccountServiceImpl;

@RunWith(MockitoJUnitRunner.Silent.class)
public class TestFundTransfer {
	@Mock
	private AccountRepository accountRepository;
	@InjectMocks
	private AccountServiceImpl accountServiceImpl;
	private Account fromaccount = null;
	private Account toaccount = null;
	private Customer customer = null;
	private AccountCreate accountCreate = null;
	private UpdateAccount updateAccount = null;
	private AccountNumDto accountNumDto = null;

	@Before
	public void setup() {
		fromaccount = new Account();
		fromaccount.setAccountno(1234L);
		fromaccount.setIfsc("afc123");
		fromaccount.setAccountType("saving");
		fromaccount.setBalance(1000);
		fromaccount.setAccountStatus(true);

		toaccount = new Account();
		toaccount.setAccountno(5678L);
		toaccount.setIfsc("afc123");
		toaccount.setAccountType("saving");
		toaccount.setBalance(1000);
		toaccount.setAccountStatus(true);

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

		customer.addAccountList(fromaccount);
		fromaccount.setCustomer(customer);
	}

	@Test
	public void testFundTransfer() throws FundTransferLimitExceededException {
		Mockito.when(accountRepository.findById(1234L)).thenReturn(Optional.of(fromaccount));
		Mockito.when(accountRepository.save(fromaccount)).thenReturn(fromaccount);
		Mockito.when(accountRepository.findById(5678L)).thenReturn(Optional.of(toaccount));
		Mockito.when(accountRepository.save(fromaccount)).thenReturn(toaccount);
		accountServiceImpl.fundTransfer(1234L, 5678L, 500);
		assertEquals(fromaccount.getBalance(), 500);

	}

	@Test
	public void testFundTransferLimitExceededException() throws FundTransferLimitExceededException {
		Mockito.when(accountRepository.findById(1234L)).thenReturn(Optional.of(fromaccount));
		Mockito.when(accountRepository.save(fromaccount)).thenReturn(fromaccount);
		Mockito.when(accountRepository.findById(5678L)).thenReturn(Optional.of(toaccount));
		Mockito.when(accountRepository.save(fromaccount)).thenReturn(toaccount);
		assertThrows(FundTransferLimitExceededException.class, () -> {
			accountServiceImpl.fundTransfer(1234L, 5678L, 500000);
		});

	}

}
