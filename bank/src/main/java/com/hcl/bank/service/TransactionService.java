package com.hcl.bank.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.hcl.bank.dto.Transactiondto;
import com.hcl.bank.entity.Transaction;
import com.hcl.bank.exception.TransactionNotFoundException;
import com.hcl.bank.repository.TransactionRepository;
import com.hcl.bank.response.TransactionResponse;

@Service
public class TransactionService {

	@Autowired
	private TransactionRepository transactionRepository;

	@Transactional
	public TransactionResponse getTransactionsStatement(Long accountId) throws TransactionNotFoundException {

		List<Transaction> transactions = transactionRepository.findByAccounts(accountId);

		if (CollectionUtils.isEmpty(transactions)) {

			throw new TransactionNotFoundException(accountId);
		}

		List<Transactiondto> transactiondtos = transactions.stream().map(transactionObj -> {

			Transactiondto transactiondto = new Transactiondto();
			BeanUtils.copyProperties(transactionObj, transactiondto);
			return transactiondto;

		}).collect(Collectors.toList());

		TransactionResponse transactionResponse = new TransactionResponse();
		transactionResponse.setFundTransfer(transactiondtos);
		transactionResponse.setSizeOfList(transactiondtos.size());

		return transactionResponse;

	}

}
