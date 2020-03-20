package com.hcl.bank.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.bank.entity.Customer;
import com.hcl.bank.exception.IncorrectEmailIdAndPasswordException;
import com.hcl.bank.exception.LoggedOutCustomerException;
import com.hcl.bank.exception.LoginCustomerFoundException;
import com.hcl.bank.exception.UserNotFoundException;
import com.hcl.bank.repository.CustomerRepository;

@Service
public class CustomerService {

	@Autowired
	private CustomerRepository customerRepository;

	@Transactional
	public String customerLogin(String emailId, String password) {

		Optional<Customer> customer = customerRepository.findByCustomerEmailIdAndPassword(emailId, password);

		if (!customer.isPresent()) {
			throw new IncorrectEmailIdAndPasswordException(emailId);
		}

		if (customer.get().getIsLoggedIn()) {
			throw new LoginCustomerFoundException(customer.get().getCustomerId());
		}

		customer.get().setIsLoggedIn(true);

		customerRepository.save(customer.get());

		return "login successfull";
	}

	@Transactional
	public String customerLogout(String emailId) {

		Optional<Customer> checkCustomer = customerRepository.findByCustomerEmailId(emailId);

		if (!checkCustomer.isPresent()) {
			throw new UserNotFoundException(0l);
		}

		boolean status = checkCustomer.get().getIsLoggedIn();
		if (status) {

			checkCustomer.get().setIsLoggedIn(false);

			customerRepository.save(checkCustomer.get());
			return "Logout sccessful";
		}
		throw new LoggedOutCustomerException();

	}

	public Boolean checkLoggingStatus(Long customerId) {

		Customer customer = customerRepository.findByCustomerId(customerId);
		if (customer == null) {
			throw new UserNotFoundException(customerId);
		} else {
			return customer.getIsLoggedIn();
		}
	}

}
