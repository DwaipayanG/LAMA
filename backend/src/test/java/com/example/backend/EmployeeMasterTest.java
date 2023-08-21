package com.example.backend;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

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

import com.example.backend.models.EmployeeMaster;
import com.example.backend.services.EmployeeCardDetailsService;
import com.example.backend.services.EmployeeIssueDetailsService;
import com.example.backend.services.EmployeeMasterService;
import com.example.backend.services.ItemsMasterService;
import com.example.backend.services.LoanCardMasterService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

@RunWith(SpringRunner.class)
@WebMvcTest
		
public class EmployeeMasterTest {
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
	public void testGetAllCategory() throws Exception{
		EmployeeMaster employeeMaster = new EmployeeMaster();
		employeeMaster.setDateOfBirth(new Date("13/07/1989"));
		employeeMaster.setDateOfJoining(new Date("24/07/2023"));
		employeeMaster.setDepartment("tco");
		employeeMaster.setDesignation("head");
		employeeMaster.setEmployeeCardDetails(null);
		employeeMaster.setEmployeeId("3342");
		employeeMaster.setEmployeeName("jasmine");
		employeeMaster.setGender('f');
		employeeMaster.setPassword("password");
		List<EmployeeMaster> getAllEmployees = new ArrayList<>();
		getAllEmployees.add(employeeMaster);
		
		Mockito.when(employeeMasterService.getAllEmployees()).thenReturn(getAllEmployees);
		System.out.println("testing getting all employee.");
		
		mvc.perform(get("/getAllEmployees").contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
		.andExpect(jsonPath("$", Matchers.hasSize(1))).andExpect(jsonPath("$[0].department", Matchers.equalTo(employeeMaster.getDepartment())));
	}			
	
		
	
	@SuppressWarnings("deprecation")
	@Test
	public void testgetEmployeeById() throws Exception{
		EmployeeMaster employeeMaster = new EmployeeMaster();
		employeeMaster.setDateOfBirth(new Date("13/07/1989"));
		employeeMaster.setDateOfJoining(new Date("24/07/2023"));
		employeeMaster.setDepartment("tco");
		employeeMaster.setDesignation("head");
		employeeMaster.setEmployeeCardDetails(null);
		employeeMaster.setEmployeeId("3342");
		employeeMaster.setEmployeeName("jasmine");
		employeeMaster.setGender('f');
		employeeMaster.setPassword("password");
		Optional<EmployeeMaster> opt = Optional.of(employeeMaster);
		
		
		Mockito.when(employeeMasterService.getEmployeeMasterById(employeeMaster.getEmployeeId())).thenReturn(opt);
		System.out.println("testing getting employee by id");
		mvc.perform(get("/getEmployeeById").contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
		.andExpect(jsonPath("$", Matchers.hasSize(1))).andExpect(jsonPath("$[0].department", Matchers.equalTo(employeeMaster.getDepartment())));
	}
	
	@SuppressWarnings("deprecation")
	@Test
	public void testdeleteEmployee() throws Exception{
		EmployeeMaster employeeMaster = new EmployeeMaster();
		employeeMaster.setDateOfBirth(new Date("13/07/1989"));
		employeeMaster.setDateOfJoining(new Date("24/07/2023"));
		employeeMaster.setDepartment("tco");
		employeeMaster.setDesignation("head");
		employeeMaster.setEmployeeCardDetails(null);
		employeeMaster.setEmployeeId("3342");
		employeeMaster.setEmployeeName("jasmine");
		employeeMaster.setGender('f');
		employeeMaster.setPassword("password");
			
		
		Mockito.when(employeeMasterService.deleteEmployeeMasterById(employeeMaster.getEmployeeId())).thenReturn("deleted");
		System.out.println("testing getting employee by id");
		mvc.perform(get("/getEmployeeById").contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
		.andExpect(jsonPath("$", Matchers.hasSize(1))).andExpect(jsonPath("$[0].department", Matchers.equalTo(employeeMaster.getDepartment())));
	}
	
}
