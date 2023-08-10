package com.example.backend.controller;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.backend.models.EmployeeMaster;
import com.example.backend.services.EmployeeMasterService;


@RestController
@CrossOrigin("http://localhost:3000")

public class EmployeeMasterController {
	@Autowired
	private EmployeeMasterService employeeMasterService;
	
	@PostMapping("/addEmployeeMaster")
	public EmployeeMaster addEmployeeMaster(@RequestBody EmployeeMaster emp)
	{
		EmployeeMaster e = employeeMasterService.addEmployeeMaster(emp);
		return e;
	}

}
