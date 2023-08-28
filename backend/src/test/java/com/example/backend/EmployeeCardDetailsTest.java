package com.example.backend;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
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

import com.example.backend.controller.EmployeeCardDetailsController;
import com.example.backend.models.EmployeeCardDetails;
import com.example.backend.models.EmployeeMaster;
import com.example.backend.models.ItemsMaster;
import com.example.backend.models.LoanCardMaster;
import com.example.backend.models.ViewItems;
import com.example.backend.models.ViewLoans;
import com.example.backend.services.EmployeeCardDetailsServiceImpl;
import com.example.backend.services.EmployeeIssueDetailsServiceImpl;
import com.example.backend.services.EmployeeMasterServiceImpl;
import com.example.backend.services.ItemsMasterServiceImpl;
import com.example.backend.services.LoanCardMasterServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

@RunWith(SpringRunner.class)
@WebMvcTest

public class EmployeeCardDetailsTest {
	@Autowired
	private MockMvc mvc;
	
	@Autowired
	@MockBean
	private LoanCardMasterServiceImpl loanCardMasterService;
	
	@Autowired
	@MockBean
	private EmployeeCardDetailsController employeeCardDetailsController;
	@Autowired
	@MockBean
	private EmployeeCardDetailsServiceImpl employeeCarddetailsService;
	
	@Autowired
	@MockBean
	private EmployeeIssueDetailsServiceImpl employeeIssueDetailsService;
	
	@Autowired
	@MockBean
	private EmployeeMasterServiceImpl employeeMasterService;
	
	@Autowired
	@MockBean
	private ItemsMasterServiceImpl itemsMasterService;
	
	ObjectMapper mapper = new ObjectMapper().findAndRegisterModules().disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);

	
	@Test
	public void testgetAllLoans() throws Exception{
		String emp = new String("2345");
		List<ViewLoans> vl= new ArrayList<>();
		System.out.println("Testing getting all loans for employee");
		Mockito.when(employeeCarddetailsService.getAllLoans(emp)).thenReturn(vl);
		System.out.println("testing getting all loan for employee.");
		
		mvc.perform(get("/api/employee-card/all-loans-by-employee-id?employeeId=",emp)
				.contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
	}
	
	@Test
	public void testgetAllItems() throws Exception{
		String emp = new String("2345");
		List<ViewItems> vl= new ArrayList<>();
		System.out.println("Testing getting all items for employee");
		Mockito.when(employeeCardDetailsController.getAllItems(emp)).thenReturn(vl);
		System.out.println("testing getting all loan for employee.");
		
		mvc.perform(get("/api/employee-card/all-items-by-employee-id?employeeId=",emp)
				.contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
	}
	
}
