package com.bank.controllerTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.ResponseEntity;

import com.bank.entity.*;
import com.bank.exception.FundTransferLimitExceededException;
import com.bank.dto.FundTransfer;
import com.bank.dto.ResponseDto;
import com.bank.service.AccountService;
import com.bank.web.controller.FundController;

@RunWith(MockitoJUnitRunner.class)
public class TestFundTransfer {
	@Mock
	private AccountService accountService;
	@InjectMocks
	private FundController fundController;
	private FundTransfer fundTransfer = null;
	private Account fromAccount = null;
	private Account toAccount = null;
	private ResponseDto responseDto = null;

	@Before
	public void setup() {
		fromAccount = new Account();
		fundTransfer = new FundTransfer();
		fundTransfer.setAmount(30000);
		fundTransfer.setToAccountNumber(1000L);
		fundTransfer.setFromAccountNumber(2000L);
	}

	@Test
	public void testFundTransfer() throws FundTransferLimitExceededException {
		responseDto = new ResponseDto();
		Mockito.when(accountService.fundTransfer(1000L, 2000L, 500)).thenReturn(responseDto);
		ResponseEntity<ResponseDto> response = fundController.FundTransfer(fundTransfer);
		assertEquals(response.getBody().getMessage(), "Amount is transfer Successfully");

	}
	/*
	 * @Test public void testFundTransferLimitExceededException() throws
	 * FundTransferLimitExceededException { responseDto = new ResponseDto();
	 * Mockito.when(accountService.fundTransfer(1000L, 2000L,
	 * 30000.0)).thenReturn(responseDto); fundController.FundTransfer(fundTransfer);
	 * ResponseEntity<ResponseDto>response=fundController.FundTransfer(fundTransfer)
	 * ; assertEquals("sorry your transfer limit is exceeded",response.getBody().
	 * getMessage()); }
	 */

}
