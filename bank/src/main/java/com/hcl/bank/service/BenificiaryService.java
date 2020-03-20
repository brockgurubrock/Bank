
package com.hcl.bank.service;

import org.springframework.stereotype.Service;

import com.hcl.bank.dto.BenificiaryDTO;
import com.hcl.bank.dto.BenificiaryRequest;
import com.hcl.bank.exception.BenificiaryNotFoundException;

@Service
public interface BenificiaryService {

	public String addBenificiary(BenificiaryRequest benificiaryRequest) throws BenificiaryNotFoundException;

	public String updatedBenificiary(BenificiaryDTO benificiaryRequest) throws BenificiaryNotFoundException;

	public String deleteBenificiary(Long benificiaryId) throws BenificiaryNotFoundException;

	public BenificiaryDTO getBenificiaryByBenificiaryId(Long benificiaryId) throws BenificiaryNotFoundException;

}
