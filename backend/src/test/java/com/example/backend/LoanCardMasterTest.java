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

import com.example.backend.controller.LoanCardMasterController;
import com.example.backend.dto.EmployeeMasterDTO;
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
public class LoanCardMasterTest {
	
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
	
	
	ObjectMapper mapper= new ObjectMapper().findAndRegisterModules().disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
	
@Test
public void testgetAllLoanCard() throws Exception{

	LoanCardMaster loanCardMaster= new LoanCardMaster();
	loanCardMaster.setLoanId("123456");
	loanCardMaster.setLoanType("furniture");
	loanCardMaster.setDurationInYears(15);
	
	List<LoanCardMaster> getAllLoanCard = new ArrayList<>();
	getAllLoanCard.add(loanCardMaster);
	
	Mockito.when(loanCardMasterController.getAllLoanCard()).thenReturn(getAllLoanCard);
	System.out.println("testing getting all employee.");
		
	mvc.perform(get("/api/loan-card/all-loans")
			.contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
	}

@Test
public void testgetAllLoanTypes() throws Exception{

	LoanCardMaster loanCardMaster= new LoanCardMaster();
	loanCardMaster.setLoanId("123456");
	loanCardMaster.setLoanType("furniture");
	loanCardMaster.setDurationInYears(15);
	
	List<String> getAllLoanTypes = new ArrayList<>();
	//getAllLoanTypes.add(loanCardMaster);
	
	Mockito.when(loanCardMasterController.getAllLoanTypes()).thenReturn(getAllLoanTypes);
	System.out.println("testing getting all employee.");
		
	mvc.perform(get("/api/loan-card/all-loan-types")
			.contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
	}

@Test
public void testgetLoanCardByLoanType() throws Exception{

	LoanCardMaster loanCardMaster= new LoanCardMaster();
	loanCardMaster.setLoanId("123456");
	loanCardMaster.setLoanType("furniture");
	loanCardMaster.setDurationInYears(15);
	
	//List<String> getAllLoanTypes = new ArrayList<>();
	//getAllLoanTypes.add(loanCardMaster);
	
	Mockito.when(loanCardMasterController.getLoanCardByLoanType(loanCardMaster.getLoanType())).thenReturn(loanCardMaster);
	System.out.println("testing getting all employee.");
		
	mvc.perform(get("/api/loan-card/by-loan-type?loanType=",loanCardMaster.getLoanType())
			.contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
	}

@Test
public void testgetLoanCardById() throws Exception{

	LoanCardMaster loanCardMaster= new LoanCardMaster();
	loanCardMaster.setLoanId("123456");
	loanCardMaster.setLoanType("furniture");
	loanCardMaster.setDurationInYears(15);
	
	Mockito.when(loanCardMasterController.getLoanCardById(loanCardMaster.getLoanId())).thenReturn(loanCardMaster);
	System.out.println("testing getting all employee.");
		
	mvc.perform(get("/api/loan-card/by-loan-id?loanId=",loanCardMaster.getLoanId())
			.contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
	}


@Test
public void testdeleteLoanCard() throws Exception{
	LoanCardMaster loanCardMaster= new LoanCardMaster();
	loanCardMaster.setLoanId("123456");
	loanCardMaster.setLoanType("furniture");
	loanCardMaster.setDurationInYears(15);
	
	String del = "deleted";
	
	Mockito.when(loanCardMasterController.deleteLoanCard(loanCardMaster.getLoanId())).thenReturn(del);
	System.out.println("testing deleting employee by id");
	
	mvc.perform(delete("/api/loan-card?loanId=",loanCardMaster.getLoanId()).contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
}

@Test
public void testaddLoanCard() throws Exception{
	LoanCardMaster loanCardMaster= new LoanCardMaster();
	loanCardMaster.setLoanId("123456");
	loanCardMaster.setLoanType("furniture");
	loanCardMaster.setDurationInYears(15);
		
	
	Mockito.when(loanCardMasterController.addLoanCard(loanCardMaster)).thenReturn(loanCardMaster);
	String json = mapper.writeValueAsString(loanCardMaster);	
	mvc.perform(post("/api/loan-card")
			.contentType(MediaType.APPLICATION_JSON).characterEncoding("utf-8")
			.content(json).accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk()).andReturn();
	
}

@Test
public void testupdateLoanCard() throws Exception{
	LoanCardMaster loanCardMaster= new LoanCardMaster();
	loanCardMaster.setLoanId("123456");
	loanCardMaster.setLoanType("furniture");
	loanCardMaster.setDurationInYears(15);
	
	Mockito.when(loanCardMasterController.updateLoanCard(loanCardMaster.getLoanId(), loanCardMaster)).thenReturn(loanCardMaster);
	
	String json = mapper.writeValueAsString(loanCardMaster);
	mvc.perform(put("/api/loan-card?loanId=",loanCardMaster.getLoanId()).contentType(MediaType.APPLICATION_JSON).content(json).accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
}
		
}
