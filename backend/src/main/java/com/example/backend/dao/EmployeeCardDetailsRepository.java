
package com.example.backend.dao;

import org.springframework.data.jpa.repository.JpaRepository;


import com.example.backend.models.EmployeeCardDetails;

public interface EmployeeCardDetailsRepository extends JpaRepository <EmployeeCardDetails, String>  {
	
	
}

