package com.hcl.bank.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.hcl.bank.exception.UserNotFoundException;
import com.hcl.bank.service.CustomerService;

@RestController
@RequestMapping("/customers")
public class CustomerController {

	private Logger logger = LoggerFactory.getLogger(CustomerController.class);

	@Autowired
	private CustomerService customerService;

	/**
	 * 
	 * @param emailId
	 * @param password
	 * @return login successful message
	 */
	@PostMapping("")
	public ResponseEntity<String> customerLogin(@RequestParam(required = true) String emailId,
			@RequestParam(required = true) String password) {

		logger.info("user login");

		String customerLogin = customerService.customerLogin(emailId, password);

		return new ResponseEntity<String>(customerLogin, HttpStatus.OK);
	}

	/**
	 * 
	 * @param emailId
	 * @return logout successful message
	 * @throws UserNotFoundException
	 */
	@PutMapping("")
	public ResponseEntity<String> customerLogout(@RequestParam(required = true) String emailId)
			throws UserNotFoundException {

		logger.info("user logout");

		String customerLogin = customerService.customerLogout(emailId);

		return new ResponseEntity<String>(customerLogin, HttpStatus.OK);
	}

}
