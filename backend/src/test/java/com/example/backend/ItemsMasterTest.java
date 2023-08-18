package com.example.backend;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.hamcrest.Matchers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.example.backend.models.ItemsMaster;
import com.example.backend.services.EmployeeCardDetailsService;
import com.example.backend.services.EmployeeIssueDetailsService;
import com.example.backend.services.EmployeeMasterService;
import com.example.backend.services.ItemsMasterService;
import com.example.backend.services.LoanCardMasterService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

@RunWith(SpringRunner.class)
@WebMvcTest
		
public class ItemsMasterTest {
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
	
	ObjectMapper mapper = new ObjectMapper().findAndRegisterModules().disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
	

	
	@Test
	public void testGetAllCategory() throws Exception{
		ItemsMaster itemsMaster = new ItemsMaster();
		itemsMaster.setItemId("116732");
		itemsMaster.setItemDescription("loan");
		itemsMaster.setItemStatus('y');
		itemsMaster.setItemMake("car");
		itemsMaster.setItemCategory("personal");
		itemsMaster.setItemValuation(22000);
		List<String> allCategoryList = new ArrayList<>();
		allCategoryList.add(itemsMaster.getItemCategory());
		
		Mockito.when(itemsMasterService.getAllCategory()).thenReturn(allCategoryList);
		System.out.println("testing getting all categories.");
		
		mvc.perform(get("/getAllCategory").contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
		.andExpect(jsonPath("$", Matchers.hasSize(1))).andExpect(jsonPath("$[0]", Matchers.equalTo(itemsMaster.getItemCategory())));
	}			

	
	

}
