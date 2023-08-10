package com.example.backend.dao;

import org.springframework.data.jpa.repository.JpaRepository;


import com.example.backend.models.EmployeeIssueDetails;

public interface EmployeeIssueDetailsRepository extends JpaRepository <EmployeeIssueDetails, String>  {
	
	
}


