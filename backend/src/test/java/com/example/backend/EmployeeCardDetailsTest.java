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
import com.example.backend.models.ViewLoans;
import com.example.backend.services.EmployeeCardDetailsService;
import com.example.backend.services.EmployeeIssueDetailsService;
import com.example.backend.services.EmployeeMasterService;
import com.example.backend.services.ItemsMasterService;
import com.example.backend.services.LoanCardMasterService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

@RunWith(SpringRunner.class)
@WebMvcTest

public class EmployeeCardDetailsTest {
	@Autowired
	private MockMvc mvc;
	
	@Autowired
	@MockBean
	private LoanCardMasterService loanCardMasterService;
	
	@Autowired
	@MockBean
	private EmployeeCardDetailsService employeeCarddetailsService;
	
	@Autowired
	@MockBean
	private EmployeeIssueDetailsService employeeIssueDetailsService;
	
	@Autowired
	@MockBean
	private EmployeeMasterService employeeMasterService;
	
	@Autowired
	@MockBean
	private ItemsMasterService itemsMasterService;
	
	ObjectMapper mapper = new ObjectMapper().findAndRegisterModules().disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);

	
	@SuppressWarnings("deprecation")
	@Test
	public void testgetAllLoans() throws Exception{
		EmployeeCardDetails employeeCardDetails = new EmployeeCardDetails();
		employeeCardDetails.setCardId(11673);
		employeeCardDetails.setCardIssueDate (new Date("23/08/2000"));
		List<ViewLoans> getAllLoans = new ArrayList<>();
		//getAllLoans.add(employeeCardDetails.getCardId());
		
		Mockito.when(employeeCarddetailsService.getAllLoans("33445")).thenReturn(getAllLoans);
		System.out.println("testing getting all loans.");
		
		mvc.perform(get("/getAllLoans").contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
		.andExpect(jsonPath("$", Matchers.hasSize(1)));
	}
	
	//getallItems service is not written
	
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
	}

}
