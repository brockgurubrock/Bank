package com.hcl.bank.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.hcl.bank.entity.Benificiary;

@Repository
public interface BenificiaryRepository extends JpaRepository<Benificiary, Long> {

	@Query(value = "select * from benificiary where customer_customer_id=?1 and benificiary_account_number=?2", nativeQuery = true)
	Optional<Benificiary> findByUserIdAndAccountNumber(Long customerId, Long accountNumber);

	@Query(value = "select * from benificiary where customer_customer_id=?1", nativeQuery = true)
	Benificiary findByCustomerId(Long customerId);

}
