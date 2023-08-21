package com.example.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.backend.exception.AuthenticationException;
import com.example.backend.exception.ResourceNotFoundException;
import com.example.backend.models.AdminLogin;

@RestController
@CrossOrigin("http://localhost:3000")
public class AdminController {
	
	@Autowired
	private Environment environment;
	
	@PostMapping("/loginAdmin")
	public String loginAdmin(@RequestBody AdminLogin adminLogin) throws AuthenticationException, ResourceNotFoundException {
		String response = "";
		if(adminLogin.getAdminUsername().equals(environment.getProperty("ADMIN_USERNAME"))) {
			if(adminLogin.getPassword().equals(environment.getProperty("ADMIN_PASSWORD"))) {
				response = environment.getProperty("ADMIN_USERNAME");
			}else {
				throw new AuthenticationException("Authentication Error!");
			}
		}else {
			throw new ResourceNotFoundException("Admin not found!");
		}
		return response;
	}
}
