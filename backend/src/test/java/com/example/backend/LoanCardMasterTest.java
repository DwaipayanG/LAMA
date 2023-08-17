package com.example.backend;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

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

import com.example.backend.models.LoanCardMaster;
import com.example.backend.services.EmployeeCardDetailsService;
import com.example.backend.services.EmployeeIssueDetailsService;
import com.example.backend.services.EmployeeMasterService;
import com.example.backend.services.ItemsMasterService;
import com.example.backend.services.LoanCardMasterService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

@RunWith(SpringRunner.class)
@WebMvcTest
public class LoanCardMasterTest {
	
	@Autowired
	private MockMvc mvc;
	
	@MockBean
	private LoanCardMasterService loanCardMasterService;
	
	@MockBean
	private EmployeeCardDetailsService employeeCarddetailsService;
	
	@MockBean
	private EmployeeIssueDetailsService employeeIssueDetailsService;
	
	@MockBean
	private EmployeeMasterService employeeMasterService;
	
	@MockBean
	private ItemsMasterService itemsMasterService;
	
	
	ObjectMapper mapper= new ObjectMapper().findAndRegisterModules().disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
	
	@Test
	public void testAddLoanCard() throws Exception {
		LoanCardMaster loanCardMaster= new LoanCardMaster();
		loanCardMaster.setLoanId("123456");
		loanCardMaster.setLoanType("furniture");
		loanCardMaster.setDurationInYears(15);
		Mockito.when(loanCardMasterService.addLoanCard(ArgumentMatchers.any())).thenReturn(loanCardMaster);
		String json=mapper.writeValueAsString(loanCardMaster);
		MvcResult requestResult= mvc.perform(post("/addLoanCard").contentType(MediaType.APPLICATION_JSON).characterEncoding("utf-8").content(json).accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk()).andReturn();
		String result= requestResult.getResponse().getContentAsString();
		System.out.print(result);
		assertEquals(result,result);
	}
}
