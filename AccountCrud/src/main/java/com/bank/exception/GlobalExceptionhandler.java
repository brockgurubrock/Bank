package com.bank.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.bank.constant.Constant;
import com.bank.dto.ExceptionResponseDto;

@ControllerAdvice
public class GlobalExceptionhandler {
	@ExceptionHandler(value = FundTransferLimitExceededException.class)
	public ResponseEntity<Object>fundTransferLimitExceededException()
	{
		ExceptionResponseDto responseDto=new ExceptionResponseDto();
		responseDto.setMessge(Constant.TransferAmountExceeded);
		responseDto.setStatusCode(Constant.TransferAmountExceededStatus_Code);
		
		return new ResponseEntity<>(responseDto,HttpStatus.NOT_FOUND);
		
	}
	@ExceptionHandler(value = AccountNotfoundException.class)
	public ResponseEntity<Object>accountNotoundException()
	{
		ExceptionResponseDto responseDto=new ExceptionResponseDto();
		responseDto.setMessge(Constant.AccountNotFound);
		responseDto.setStatusCode(Constant.AmountNotFound_Status_Code);
		
		return new ResponseEntity<>(responseDto,HttpStatus.NOT_FOUND);
		
	}

}
