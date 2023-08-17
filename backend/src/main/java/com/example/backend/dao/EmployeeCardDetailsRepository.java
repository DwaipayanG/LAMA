
package com.example.backend.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.backend.models.EmployeeCardDetails;
import com.example.backend.models.ViewLoans;

public interface EmployeeCardDetailsRepository extends JpaRepository <EmployeeCardDetails, String>  {
	
	@Query(value="SELECT loan.loan_id, loan.loan_type, loan.duration_in_years, employee.card_issue_date FROM employee_card_details AS employee JOIN loan_card_master AS loan ON employee.loan_id=loan.loan_id WHERE employee.employee_id=:employeeId", nativeQuery=true)
	public List<Object[]> getLoansByEmployeeId(String employeeId);
}

