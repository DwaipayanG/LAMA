package com.example.backend;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


import java.util.ArrayList;
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
	
		
	
	@Test
	public void testgetAllItems() throws Exception{
		ItemsMaster itemsMaster = new ItemsMaster();
		itemsMaster.setItemId("116732");
		itemsMaster.setItemDescription("loan");
		itemsMaster.setItemStatus('y');
		itemsMaster.setItemMake("car");
		itemsMaster.setItemCategory("personal");
		itemsMaster.setItemValuation(22000);
		List<ItemsMaster> getAllItems = new ArrayList<>();
		getAllItems.add(itemsMaster);
		
		Mockito.when(itemsMasterService.getAllItems()).thenReturn(getAllItems);
		System.out.println("testing getting all items");
		
		mvc.perform(get("/getAllItem").contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
		.andExpect(jsonPath("$", Matchers.hasSize(1))).andExpect(jsonPath("$[0].itemId", Matchers.equalTo(itemsMaster.getItemId())));
	}	
	

	@Test
	public void testgetDistinctMakesByCategory() throws Exception{
		ItemsMaster itemsMaster = new ItemsMaster();
		itemsMaster.setItemId("116732");
		itemsMaster.setItemDescription("loan");
		itemsMaster.setItemStatus('y');
		itemsMaster.setItemMake("car");
		itemsMaster.setItemCategory("personal");
		itemsMaster.setItemValuation(22000);
		List<String> getDistinctMakesByCategory = new ArrayList<>();
		getDistinctMakesByCategory.add(itemsMaster.getItemMake());
		
		Mockito.when(itemsMasterService.getDistinctMakesByCategory(itemsMaster.getItemCategory())).thenReturn(getDistinctMakesByCategory);
		System.out.println("testing getting distict make by categories.");
		
		mvc.perform(post("/getDistinctMakesByCategory").contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
		.andExpect(jsonPath("$", Matchers.hasSize(1))).andExpect(jsonPath("$[0]", Matchers.equalTo(itemsMaster.getItemMake())));
	} 
	
	@Test
	public void testaddItem() throws Exception{
		ItemsMaster itemsMaster = new ItemsMaster();
		itemsMaster.setItemId("116732");
		itemsMaster.setItemDescription("loan");
		itemsMaster.setItemStatus('y');
		itemsMaster.setItemMake("car");
		itemsMaster.setItemCategory("personal");
		itemsMaster.setItemValuation(22000);
		
		Mockito.when(itemsMasterService.addItem(ArgumentMatchers.any())).thenReturn(itemsMaster);
		String json = mapper.writeValueAsString(itemsMaster);	
		MvcResult requestResult = mvc.perform(post("/addItem").contentType(MediaType.APPLICATION_JSON).characterEncoding("utf-8").content(json).accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk()).andReturn();
		String result = requestResult.getResponse().getContentAsString();
		System.out.print(result);
		assertEquals(result,result);
	}
	
	
	@Test
	public void testgetItem() throws Exception{
		ItemsMaster itemsMaster = new ItemsMaster();
		itemsMaster.setItemId("116732");
		itemsMaster.setItemDescription("loan");
		itemsMaster.setItemStatus('y');
		itemsMaster.setItemMake("car");
		itemsMaster.setItemCategory("personal");
		itemsMaster.setItemValuation(22000);
		Mockito.when(itemsMasterService.getItemByMakeAndCategory(itemsMaster.getItemMake(), itemsMaster.getItemCategory())).thenReturn(itemsMaster);
		String json = mapper.writeValueAsString(itemsMaster);	
		MvcResult requestResult = mvc.perform(post("/getItem").contentType(MediaType.APPLICATION_JSON).characterEncoding("utf-8").content(json).accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk()).andReturn();
		String result = requestResult.getResponse().getContentAsString();
		System.out.print(result);
		assertEquals(result,result);	
	} 

 
	

}
