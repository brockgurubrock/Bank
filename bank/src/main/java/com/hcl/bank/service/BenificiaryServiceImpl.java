
package com.hcl.bank.service;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hcl.bank.dto.BenificiaryDTO;
import com.hcl.bank.dto.BenificiaryRequest;
import com.hcl.bank.entity.Account;
import com.hcl.bank.entity.Benificiary;
import com.hcl.bank.entity.Customer;
import com.hcl.bank.exception.AccountNotFoundException;
import com.hcl.bank.exception.BenficiaryAlreadyExcistException;
import com.hcl.bank.exception.BenificiaryNotFoundException;
import com.hcl.bank.exception.CustomerNotLoggedInException;
import com.hcl.bank.exception.UserNotFoundException;
import com.hcl.bank.repository.AccountRepository;
import com.hcl.bank.repository.BenificiaryRepository;
import com.hcl.bank.repository.CustomerRepository;

@Service
public class BenificiaryServiceImpl implements BenificiaryService {

	@Autowired
	BenificiaryRepository benificiaryRepository;

	@Autowired
	AccountRepository accountRepository;

	@Autowired
	CustomerRepository customerRepository;

	@Autowired
	CustomerService customerService;

	Logger log = LoggerFactory.getLogger(BenificiaryService.class);

	@Transactional
	public String addBenificiary(BenificiaryRequest benificiaryRequest) throws BenificiaryNotFoundException {

		if (!customerService.checkLoggingStatus(benificiaryRequest.getCustomerId())) {
			throw new CustomerNotLoggedInException(benificiaryRequest.getCustomerId());
		}

		Optional<Account> account = accountRepository.findByAccountNumber(benificiaryRequest.getAccountNumber());

		if (!account.isPresent()) {
			throw new AccountNotFoundException(benificiaryRequest.getAccountNumber());
		}

		Optional<Customer> customer = customerRepository.findById(benificiaryRequest.getCustomerId());

		if (!customer.isPresent()) {
			throw new UserNotFoundException(benificiaryRequest.getCustomerId());
		}

		Optional<Benificiary> checKBenificiary = benificiaryRepository.findByUserIdAndAccountNumber(
				benificiaryRequest.getAccountNumber(), benificiaryRequest.getCustomerId());

		if (checKBenificiary.isPresent()) {
			throw new BenficiaryAlreadyExcistException(checKBenificiary.get().getBenificiaryId());
		}

		Benificiary benificiary = new Benificiary();

		benificiary.setBenificiaryAccountNumber(benificiaryRequest.getAccountNumber());
		benificiary.setBenificiaryName(benificiaryRequest.getName());

		benificiary.setCustomer(customer.get());

		benificiaryRepository.save(benificiary);

		log.info("Benificiary added successfully.");

		return "Benificiary added successfully.";

	}

	@Transactional
	public String updatedBenificiary(BenificiaryDTO benificiaryRequest) throws BenificiaryNotFoundException {

		if (!customerService.checkLoggingStatus(benificiaryRequest.getCustomerId())) {
			throw new CustomerNotLoggedInException(benificiaryRequest.getCustomerId());
		}

		Customer customer = customerRepository.findById(benificiaryRequest.getCustomerId()).get();

		if (customer == null) {
			throw new UserNotFoundException(benificiaryRequest.getCustomerId());
		}

		Optional<Account> account = accountRepository
				.findByAccountNumber(benificiaryRequest.getBenificiaryAccountNumber());

		if (!account.isPresent()) {
			throw new AccountNotFoundException(benificiaryRequest.getBenificiaryAccountNumber());
		}

		Optional<Benificiary> benificiaryAccount = benificiaryRepository.findByUserIdAndAccountNumber(
			 customer.getCustomerId(),	benificiaryRequest.getBenificiaryAccountNumber());
		if (!benificiaryAccount.isPresent()) {
			throw new BenificiaryNotFoundException(customer.getCustomerId());
		}

		benificiaryAccount.get().setBenificiaryAccountNumber(benificiaryRequest.getBenificiaryAccountNumber());

		benificiaryAccount.get().setBenificiaryName(benificiaryRequest.getBenificiaryName());

		benificiaryRepository.save(benificiaryAccount.get());

		log.info("Benificiary added successfully.");

		return "Benificiary updated successfully.";

	}

	@Transactional
	public String deleteBenificiary(Long benificiaryId) throws BenificiaryNotFoundException {

		Optional<Benificiary> benificiary = benificiaryRepository.findById(benificiaryId);
		if (benificiary.isPresent()) {

			if (!customerService.checkLoggingStatus(benificiary.get().getCustomer().getCustomerId())) {

				throw new CustomerNotLoggedInException(benificiary.get().getCustomer().getCustomerId());
			}

			benificiaryRepository.deleteById(benificiary.get().getBenificiaryId());

			return "Benificiar Deleted Successfully";
		} else {

			throw new BenificiaryNotFoundException(benificiaryId);
		}

	}

	@Transactional
	public BenificiaryDTO getBenificiaryByBenificiaryId(Long benificiaryId) throws BenificiaryNotFoundException {

		Optional<Benificiary> benificiary = benificiaryRepository.findById(benificiaryId);

		if (benificiary.isPresent()) {
			if (!customerService.checkLoggingStatus(benificiary.get().getCustomer().getCustomerId())) {

				throw new CustomerNotLoggedInException(benificiary.get().getCustomer().getCustomerId());
			}
			BenificiaryDTO benificiaryDto = new BenificiaryDTO();
			benificiaryDto.setBenificiaryAccountNumber(benificiary.get().getBenificiaryAccountNumber());
			benificiaryDto.setBenificiaryName(benificiary.get().getBenificiaryName());
			benificiaryDto.setCustomerId(benificiary.get().getCustomer().getCustomerId());
			return benificiaryDto;

		} else {
			throw new BenificiaryNotFoundException(benificiaryId);
		}
	}

}
