package com.example.backend.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.backend.dto.AdminLoginDTO;
import com.example.backend.exception.AuthenticationException;
import com.example.backend.exception.ResourceNotFoundException;
import com.example.backend.models.AdminLogin;

@RestController
@CrossOrigin("http://localhost:3000")
public class AdminController {
	
	@Autowired
	private Environment environment;
	
	@Autowired
	private ModelMapper ModelMap;
	
	@PostMapping("/api/admin/login")
	public String loginAdmin(@RequestBody AdminLoginDTO adminLoginDTO) throws AuthenticationException, ResourceNotFoundException {
		String response = "";
		AdminLogin adminLogin = ModelMap.map(adminLoginDTO, AdminLogin.class);
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
