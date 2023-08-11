package com.example.backend.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.backend.models.EmployeeMaster;

@Repository
public interface EmployeeMasterRepository extends JpaRepository <EmployeeMaster, String>  {
	
	
}
