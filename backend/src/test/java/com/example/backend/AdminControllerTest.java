package com.example.backend;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hamcrest.Matchers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import com.example.backend.controller.AdminController;
import com.example.backend.controller.LoanCardMasterController;
import com.example.backend.dto.AdminLoginDTO;
import com.example.backend.dto.EmployeeMasterDTO;
import com.example.backend.models.AdminLogin;
import com.example.backend.models.EmployeeMaster;
import com.example.backend.models.LoanCardMaster;
import com.example.backend.services.EmployeeCardDetailsServiceImpl;
import com.example.backend.services.EmployeeIssueDetailsServiceImpl;
import com.example.backend.services.EmployeeMasterServiceImpl;
import com.example.backend.services.ItemsMasterServiceImpl;
import com.example.backend.services.LoanCardMasterServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

@RunWith(SpringRunner.class)
@WebMvcTest

public class AdminControllerTest {

	@Autowired
	private MockMvc mvc;
	
	@MockBean
	private LoanCardMasterServiceImpl loanCardMasterService;
	
	@MockBean
	private EmployeeCardDetailsServiceImpl employeeCarddetailsService;
	
	@MockBean
	private LoanCardMasterController loanCardMasterController;
	
	@MockBean
	private EmployeeIssueDetailsServiceImpl employeeIssueDetailsService;
	
	@MockBean
	private EmployeeMasterServiceImpl employeeMasterService;
	
	@MockBean
	private ItemsMasterServiceImpl itemsMasterService;
	
	@MockBean
	private AdminController adminController;
	
	
	ObjectMapper mapper= new ObjectMapper().findAndRegisterModules().disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
	
	@Test
	public void testloginAdmin() throws Exception{
		AdminLoginDTO adminLogin= new AdminLoginDTO();
		adminLogin.setAdminUsername("admin");
		adminLogin.setPassword("password");
		
		String sr = new String("authorized"); 
					
		System.out.println("Testing admin login");
		Mockito.when(adminController.loginAdmin(adminLogin)).thenReturn(sr);
		String json = mapper.writeValueAsString(adminLogin);	
		mvc.perform(post("/api/admin/login")
				.contentType(MediaType.APPLICATION_JSON).characterEncoding("utf-8")
				.content(json).accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk()).andReturn();
		
		
	}

}
