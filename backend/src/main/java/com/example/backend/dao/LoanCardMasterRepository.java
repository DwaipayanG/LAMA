package com.example.backend.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.backend.models.LoanCardMaster;

public interface LoanCardMasterRepository extends JpaRepository <LoanCardMaster , String>  {

	@Query(value="SELECT * FROM loan_card_master WHERE loan_type = :loanType LIMIT 1", nativeQuery=true)
	public LoanCardMaster findLoanCardByLoanType(String loanType);
}
