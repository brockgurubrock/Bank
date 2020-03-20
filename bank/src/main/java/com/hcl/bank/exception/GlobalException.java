
package com.hcl.bank.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.hcl.bank.dto.ExceptionDetailsDto;

@ControllerAdvice
public class GlobalException {

	@ExceptionHandler(AccountNotFoundException.class)
	public ResponseEntity<Object> accountNotFoundExceptionHandler(AccountNotFoundException accountNotFoundException) {
		ExceptionDetailsDto errorDetails = new ExceptionDetailsDto(accountNotFoundException.getMessage(),
				accountNotFoundException.getStatusCode());
		return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(BenficiaryAlreadyExcistException.class)
	public ResponseEntity<Object> benficiaryAlreadyExcistException(
			BenficiaryAlreadyExcistException benficiaryAlreadyExcistException) {
		ExceptionDetailsDto errorDetails = new ExceptionDetailsDto(benficiaryAlreadyExcistException.getMessage(),
				benficiaryAlreadyExcistException.getStatusCode());
		return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(LoggedInException.class)
	public ResponseEntity<Object> loggedInException(LoggedInException loggedInException) {
		ExceptionDetailsDto errorDetails = new ExceptionDetailsDto(loggedInException.getMessage(),
				loggedInException.getStatusCode());
		return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(CustomerLoggebInException.class)
	public ResponseEntity<Object> customerLoggebInException(CustomerLoggebInException customerLoggebInException) {
		ExceptionDetailsDto errorDetails = new ExceptionDetailsDto(customerLoggebInException.getMessage(),
				customerLoggebInException.getStatusCode());
		return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(InvalidBenificiaryAddingException.class)
	public ResponseEntity<Object> invalidBenificiaryAddingException(
			InvalidBenificiaryAddingException invalidBenificiaryAddingException) {
		ExceptionDetailsDto errorDetails = new ExceptionDetailsDto(invalidBenificiaryAddingException.getMessage(),
				invalidBenificiaryAddingException.getStatusCode());
		return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(LoggedOutCustomerException.class)
	public ResponseEntity<Object> loggedOutCustomerException(LoggedOutCustomerException loggedOutCustomerException) {
		ExceptionDetailsDto errorDetails = new ExceptionDetailsDto(loggedOutCustomerException.getMessage(),
				loggedOutCustomerException.getStatusCode());
		return new ResponseEntity<>(errorDetails, HttpStatus.OK);
	}

	@ExceptionHandler(LoginCustomerFoundException.class)
	public ResponseEntity<Object> loginCustomerFoundException(LoginCustomerFoundException loginCustomerFoundException) {
		ExceptionDetailsDto errorDetails = new ExceptionDetailsDto(loginCustomerFoundException.getMessage(),
				loginCustomerFoundException.getStatusCode());
		return new ResponseEntity<>(errorDetails, HttpStatus.OK);
	}

	@ExceptionHandler(BenificiaryNotFoundException.class)
	public ResponseEntity<Object> accountNotFoundExceptionHandler(
			BenificiaryNotFoundException benificiaryNotFoundException) {
		ExceptionDetailsDto errorDetails = new ExceptionDetailsDto(benificiaryNotFoundException.getMessage(),
				benificiaryNotFoundException.getStatusCode());
		return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(CustomerNotLoggedInException.class)
	public ResponseEntity<Object> customerNotLoggedInExceptionHandler(
			CustomerNotLoggedInException customerNotLoggedInException) {
		ExceptionDetailsDto errorDetails = new ExceptionDetailsDto(customerNotLoggedInException.getMessage(),
				customerNotLoggedInException.getStatusCode());
		return new ResponseEntity<>(errorDetails, HttpStatus.FORBIDDEN);
	}

	@ExceptionHandler(InsuffiecientFundException.class)
	public ResponseEntity<Object> insuffiecientFundExceptionHandler(
			InsuffiecientFundException insuffiecientFundException) {
		ExceptionDetailsDto errorDetails = new ExceptionDetailsDto(insuffiecientFundException.getMessage(),
				insuffiecientFundException.getStatusCode());
		return new ResponseEntity<>(errorDetails, HttpStatus.FORBIDDEN);
	}

	@ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity<Object> userNotFoundExceptionHandler(UserNotFoundException userNotFoundException) {
		ExceptionDetailsDto errorDetails = new ExceptionDetailsDto(userNotFoundException.getMessage(),
				userNotFoundException.getStatusCode());
		return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(IncorrectEmailIdAndPasswordException.class)
	public ResponseEntity<Object> customerNotRegisteredExceptionHandler(
			IncorrectEmailIdAndPasswordException customerNotRegisteredException) {
		ExceptionDetailsDto errorDetails = new ExceptionDetailsDto(customerNotRegisteredException.getMessage(),
				customerNotRegisteredException.getStatusCode());
		return new ResponseEntity<>(errorDetails, HttpStatus.FORBIDDEN);
	}

	@ExceptionHandler(TransactionNotFoundException.class)
	public ResponseEntity<Object> transactionNotFoundException(
			TransactionNotFoundException transactionNotFoundException) {
		ExceptionDetailsDto errorDetails = new ExceptionDetailsDto(transactionNotFoundException.getMessage(),
				transactionNotFoundException.getStatusCode());
		return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
	}

}
