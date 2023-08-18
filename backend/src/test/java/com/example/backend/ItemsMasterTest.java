package com.example.backend;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

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

import com.example.backend.dao.ItemsMasterRepository;
import com.example.backend.models.EmployeeIssueDetails;
import com.example.backend.models.ItemsMaster;
import com.example.backend.models.LoanCardMaster;
import com.example.backend.services.ItemsMasterService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

@RunWith(SpringRunner.class)
@WebMvcTest
		
public class ItemsMasterTest {
	@Autowired
	private MockMvc mvc;
	
	@MockBean
	private ItemsMasterService itemsMasterService;
	
	@MockBean
	private ItemsMasterRepository itemsMasterRepository;
	
	@MockBean
	EmployeeIssueDetails employeeIssueDetails;
	
	ObjectMapper mapper = new ObjectMapper().findAndRegisterModules().disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
	

	
	@Test
	public void testsaveItemsMaster() throws Exception{
		ItemsMaster itemsMaster = new ItemsMaster();
		itemsMaster.setItemId("116732");
		itemsMaster.setItemDescription("loan");
		itemsMaster.setItemStatus('y');
		itemsMaster.setItemMake("car");
		itemsMaster.setItemCategory("personal");
		itemsMaster.setItemValuation(22000);
		Mockito.when(itemsMasterService.saveItemsMaster(ArgumentMatchers.any())).thenReturn(itemsMaster));
		String json=mapper.writeValueAsString(itemsMaster);
		MvcResult requestResult= mvc.perform(post("/saveItemsMaster").contentType(MediaType.APPLICATION_JSON).characterEncoding("utf-8").content(json).accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk()).andReturn();
		String result= requestResult.getResponse().getContentAsString();
		System.out.print(result);
		assertEquals(result,result);
	}			

	
	

}
