package com.example.backend;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


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

import com.example.backend.models.EmployeeCardDetails;
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

	
	@SuppressWarnings("deprecation")
	@Test
	public void testgetAllLoans() throws Exception{
		EmployeeCardDetails employeeCardDetails = new EmployeeCardDetails();
		employeeCardDetails.setCardId(11673);
		employeeCardDetails.setCardIssueDate (new Date("23/08/2000"));
		
		ViewLoans vl = new ViewLoans();
		vl.setCardIssueDate(new Date("23/08/2000"));
		vl.setDurationInYears(4);
		vl.setLoanId("2281");
		vl.setLoanType("personal");
		
		List<ViewLoans> getAllLoans = new ArrayList<>();
		getAllLoans.add(vl);
		
		Mockito.when(employeeCarddetailsService.getAllLoans("33445")).thenReturn(getAllLoans);
		System.out.println("testing getting all loans.");
		
		mvc.perform(get("/api/employee-card/all-loans-by-employee-id").contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
		.andExpect(jsonPath("$", Matchers.hasSize(1))).andExpect(jsonPath("$[0].cardIssueDate",  Matchers.equalTo(employeeCardDetails.getCardIssueDate())));
	}
	

	@SuppressWarnings("deprecation")
	@Test
	public void testgetAllItems() throws Exception{
		EmployeeCardDetails employeeCardDetails = new EmployeeCardDetails();
		employeeCardDetails.setCardId(11673);
		employeeCardDetails.setCardIssueDate (new Date("23/08/2000"));
		ViewItems vl = new ViewItems();
		vl.setIssueId(5);
		vl.setItemCategory("furniture");
		vl.setItemDescription("table");
		vl.setItemMake("wooden");
		vl.setItemValuation(5000);
		
		List<ViewItems> getAllItems = new ArrayList<>();
		getAllItems.add(vl);
		
		Mockito.when(employeeIssueDetailsService.getAllItems("33445")).thenReturn(getAllItems);
		System.out.println("testing getting all loans.");
		
		mvc.perform(get("/api/employee-card/all-loans-by-employee-id").contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
		.andExpect(jsonPath("$", Matchers.hasSize(1)));
	}
	
	
	
	/*
	@SuppressWarnings("deprecation")
	@Test
	public void testaddEmployeeCardDetails() throws Exception{
		EmployeeCardDetails employeeCardDetails = new EmployeeCardDetails();
		employeeCardDetails.setCardId(11673);
		employeeCardDetails.setCardIssueDate (new Date("23/08/2000"));
		
		Mockito.when(employeeCarddetailsService.addEmployeeCardDetails(employeeCardDetails)).thenReturn(employeeCardDetails);
		String json = mapper.writeValueAsString(employeeCardDetails);	
		MvcResult requestResult = mvc.perform(post("/addEmployeeCardDetails").contentType(MediaType.APPLICATION_JSON).characterEncoding("utf-8").content(json).accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk()).andReturn();
		String result = requestResult.getResponse().getContentAsString();
		System.out.print(result);
		assertEquals(result,result);
	}*/

}
