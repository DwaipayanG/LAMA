package com.example.backend.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.backend.models.EmployeeIssueDetails;

public interface EmployeeIssueDetailsRepository extends JpaRepository <EmployeeIssueDetails, Integer>  {
	
	@Query(value="SELECT issue.issue_id, item.item_description, item.item_make, item.item_category, item.item_valuation FROM employee_issue_details AS issue JOIN items_master AS item ON issue.item_id = item.item_id WHERE issue.employee_id=:employeeId", nativeQuery=true)
	public List<Object[]> getItemsByEmployeeId(String employeeId);
	
}


