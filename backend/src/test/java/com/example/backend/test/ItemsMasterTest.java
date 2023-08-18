package com.example.backend.test;


import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.example.backend.dao.ItemsMasterRepository;
import com.example.backend.models.EmployeeIssueDetails;
import com.example.backend.models.ItemsMaster;
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
	
	ObjectMapper mapper = new ObjectMapper()
			.findAndRegisterModules()
			.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
			
	@Test
	public void testsaveItemsMaster() throws Exception{
		ItemsMaster itemsMaster = new ItemsMaster();
		itemsMaster.setItemId("116732");
		itemsMaster.setItemDescription("loan");
		itemsMaster.setItemStatus('y');
		itemsMaster.setItemMake("car");
		itemsMaster.setItemCategory("personal");
		itemsMaster.setItemValuation(22000);
		List<ItemsMaster> itemList = new ArrayList<>();
		itemList.add(itemsMaster);
		
		Mockito.when(itemsMasterService.getAllCategory()).andReturn();
		
		System.out.println("test method for saving all ");
		mvc.perform(get("/"))
		
		
		
	}
			
	
	
	

}
