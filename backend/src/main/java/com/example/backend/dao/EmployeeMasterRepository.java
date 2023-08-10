package com.example.backend.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.backend.models.EmployeeMaster;

public interface EmployeeMasterRepository extends JpaRepository <EmployeeMaster, String>  {
	
	
}
