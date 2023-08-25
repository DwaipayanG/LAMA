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

import com.example.backend.controller.ItemsMasterController;
import com.example.backend.models.ItemsMaster;
import com.example.backend.services.EmployeeCardDetailsServiceImpl;
import com.example.backend.services.EmployeeIssueDetailsServiceImpl;
import com.example.backend.services.EmployeeMasterServiceImpl;
import com.example.backend.services.ItemsMasterServiceImpl;
import com.example.backend.services.LoanCardMasterServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

@RunWith(SpringRunner.class)
@WebMvcTest
		
public class ItemsMasterTest {
	@Autowired
	private MockMvc mvc;
	
	@Autowired
	@MockBean
	private LoanCardMasterServiceImpl loanCardMasterService;
	
	@Autowired
	@MockBean
	private ItemsMasterController itemsMasterController;
	
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
	public void testdeleteItemById() throws Exception{
		String del = new String("deleted");
		String id = new String("6643");
		
		Mockito.when(itemsMasterController.deleteItemById(id)).thenReturn(del);
		System.out.println("testing deleting item by id");
		
		mvc.perform(delete("/api/item?itemId=",id).contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
	}
	
	@Test
	public void testgetItemByMakeAndCategory() throws Exception{
		ItemsMaster itemsMaster = new ItemsMaster();
		itemsMaster.setItemId("116732");
		itemsMaster.setItemDescription("loan");
		itemsMaster.setItemStatus('y');
		itemsMaster.setItemMake("car");
		itemsMaster.setItemCategory("personal");
		itemsMaster.setItemValuation(22000);
		List<String> allCategoryList = new ArrayList<>();
		allCategoryList.add(itemsMaster.getItemCategory());
		
		Mockito.when(itemsMasterController.getItemByMakeAndCategory(itemsMaster.getItemCategory(), itemsMaster.getItemMake())).thenReturn(itemsMaster);
		System.out.println("testing getting item by make and categories.");
		
		mvc.perform(get("/api/item/by-make-and-category").param("itemCategory", itemsMaster.getItemCategory()).param("itemMake", itemsMaster.getItemMake()).contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
	
	}			
	
	@Test
	public void testgetItemById() throws Exception{
		ItemsMaster itemsMaster = new ItemsMaster();
		itemsMaster.setItemId("116732");
		itemsMaster.setItemDescription("loan");
		itemsMaster.setItemStatus('y');
		itemsMaster.setItemMake("car");
		itemsMaster.setItemCategory("personal");
		itemsMaster.setItemValuation(22000);

		
		Mockito.when(itemsMasterController.getItemById(itemsMaster.getItemId())).thenReturn(itemsMaster);
		System.out.println("testing getting item by make and categories.");
		
		mvc.perform(get("/api/item/by-item-id?itemId=",itemsMaster.getItemId()).contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
		
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
		
		mvc.perform(get("/api/item/all-items").contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
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
		
		mvc.perform(get("/api/item/makes-by-category?itemCategory=",itemsMaster.getItemCategory()).contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
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
		
		
		Mockito.when(itemsMasterController.addItem(itemsMaster)).thenReturn(itemsMaster);
		System.out.println("testing adding new item");
		String json = mapper.writeValueAsString(itemsMaster);
		mvc.perform(post("/api/item").contentType(MediaType.APPLICATION_JSON).content(json)).andExpect(status().isOk());
	} 

	@Test
	public void testupdateItem() throws Exception{
		ItemsMaster itemsMaster = new ItemsMaster();
		itemsMaster.setItemId("116732");
		itemsMaster.setItemDescription("loan");
		itemsMaster.setItemStatus('y');
		itemsMaster.setItemMake("car");
		itemsMaster.setItemCategory("personal");
		itemsMaster.setItemValuation(22000);
		
		Mockito.when(itemsMasterController.updateItem(itemsMaster.getItemId(), itemsMaster)).thenReturn(itemsMaster);
		
		String json = mapper.writeValueAsString(itemsMaster);
		mvc.perform(put("/api/item?itemId=",itemsMaster.getItemId()).contentType(MediaType.APPLICATION_JSON).content(json).accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
	}
}
	