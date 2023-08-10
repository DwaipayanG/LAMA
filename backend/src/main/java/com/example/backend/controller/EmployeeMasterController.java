package com.example.backend.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.example.backend.models.EmployeeMaster;


@RestController
@CrossOrigin("http://localhost:3000")
public class EmployeeMasterController {
	@Autowired
	EmployeeMasterService employeeMasterService;
	
	@PostMapping("/saveEmployeeMaster")
	public EmployeeMaster saveEmployeeMaster(@RequestBody EmployeeMaster emp)
	{
		EmployeeMaster e = employeeMasterService.saveEmployeeMaster(emp);
		return e;
	}

}
