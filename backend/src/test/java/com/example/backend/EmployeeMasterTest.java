package com.example.backend;


import static org.junit.jupiter.api.Assertions.assertEquals;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.text.SimpleDateFormat;
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

import com.example.backend.controller.EmployeeMasterController;
import com.example.backend.dto.EmployeeMasterDTO;
import com.example.backend.models.ApplyLoanData;
import com.example.backend.models.EmployeeMaster;
import com.example.backend.models.EmployeeMasterLogin;
import com.example.backend.models.ItemsMaster;
import com.example.backend.services.EmployeeCardDetailsServiceImpl;
import com.example.backend.services.EmployeeIssueDetailsServiceImpl;
import com.example.backend.services.EmployeeMasterServiceImpl;
import com.example.backend.services.ItemsMasterServiceImpl;
import com.example.backend.services.LoanCardMasterServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

@SuppressWarnings("deprecation")
@RunWith(SpringRunner.class)
@WebMvcTest
		
public class EmployeeMasterTest {
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
	
	@MockBean
	private EmployeeMasterController employeeMasterController;
	
	ObjectMapper mapper = new ObjectMapper().findAndRegisterModules().disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);

	
	@Test
	public void testgetAllEmployees() throws Exception{
		
		String d1="1987-05-21";
		String d2="2020-06-01";
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		Date dob=sdf.parse(d1);
		Date doj=sdf.parse(d2);
		
		EmployeeMaster employeeMaster = new EmployeeMaster();
		employeeMaster.setEmployeeId("12345");
		employeeMaster.setDateOfBirth(dob);
		employeeMaster.setDateOfJoining(doj);
		employeeMaster.setDepartment("tco");
		employeeMaster.setDesignation("head");
		employeeMaster.setEmployeeCardDetails(null);
		employeeMaster.setEmployeeName("jasmine");
		employeeMaster.setGender('f');
		employeeMaster.setPassword("password");
		List<EmployeeMaster> getAllEmployees = new ArrayList<>();
		getAllEmployees.add(employeeMaster);
		
		Mockito.when(employeeMasterService.getAllEmployees()).thenReturn(getAllEmployees);
		System.out.println("testing getting all employee.");
		
		mvc.perform(get("/api/employee/all-employees").contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
	}
	
	@Test
	public void testgetEmployeeMaster() throws Exception{
		String d1="1987-05-21";
		String d2="2020-06-01";
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		Date dob=sdf.parse(d1);
		Date doj=sdf.parse(d2);
		
		EmployeeMaster employeeMaster = new EmployeeMaster();
		employeeMaster.setEmployeeId("12345");
		employeeMaster.setDateOfBirth(dob);
		employeeMaster.setDateOfJoining(doj);
		employeeMaster.setDepartment("tco");
		employeeMaster.setDesignation("head");
		employeeMaster.setEmployeeCardDetails(null);
		employeeMaster.setEmployeeName("jasmine");
		employeeMaster.setGender('f');
		employeeMaster.setPassword("password");
		
		EmployeeMasterDTO emp = new EmployeeMasterDTO();
		
		
		
		Mockito.when(employeeMasterController.getEmployeeMaster(employeeMaster.getEmployeeId())).thenReturn(emp);
		System.out.println("testing getting employee by id");
		
		mvc.perform(get("/api/employee/by-employee-id?employeeId=12345").contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
		
	}

	/*
	@Test
	public void testupdateEmployee() throws Exception{
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
		
		Mockito.when(employeeMasterService.updateEmployee(employeeMaster, employeeMaster)).thenReturn(employeeMaster);
		
		String json = mapper.writeValueAsString(employeeMaster);
		mvc.perform(put("/api/employee").contentType(MediaType.APPLICATION_JSON).content(json).accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
	}
			

	
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
		String del = "deleted";
		
		Mockito.when(employeeMasterController.deleteEmployeeById(employeeMaster.getEmployeeId())).thenReturn(del);
		System.out.println("testing deleting employee by id");
		
		mvc.perform(delete("/api/employee").contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
	}
	
	@Test
	public void testaddEmployeeMaster() throws Exception{
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
		
		Mockito.when(employeeMasterService.addEmployeeMaster(ArgumentMatchers.any())).thenReturn(employeeMaster);
		String json = mapper.writeValueAsString(employeeMaster);	
		MvcResult requestResult = mvc.perform(post("/api/employee").contentType(MediaType.APPLICATION_JSON).characterEncoding("utf-8").content(json).accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk()).andReturn();
		String result = requestResult.getResponse().getContentAsString();
		System.out.print(result);
		assertEquals(result,result);
	}
	
	
	@Test
	public void testloginEmployeeMaster() throws Exception{
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
		
		EmployeeMasterLogin emp = new EmployeeMasterLogin();
		emp.setEmployeeId("3342");
		emp.setPassword("password");
		
		Object obj = new Object();
		
		
		Mockito.when(employeeMasterController.loginEmployeeMaster(ArgumentMatchers.any())).thenReturn(obj);
		//String json = mapper.writeValueAsString(obj);	
		//mvc.perform(post("/api/employee/login").contentType(MediaType.APPLICATION_JSON).characterEncoding("utf-8").content(json).accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk()).andReturn();
		mvc.perform(post("/api/employee/login").contentType(MediaType.APPLICATION_JSON).characterEncoding("utf-8").accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk()).andReturn();
		//String result = requestResult.getResponse().getContentAsString();
		//System.out.print(result);
		//assertEquals(result,result);
	}
	
	@Test
	public void testapplyLoan() throws Exception{
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
		
		ApplyLoanData emp = new ApplyLoanData();
		emp.setEmployeeId("3342");
		emp.setItemId("3398");
		emp.setLoanId("5532");
		emp.setLoanIssueDate(new Date("24/07/2023"));
		
		Object obj = new Object();
		
		Mockito.when(employeeMasterController.applyLoan(ArgumentMatchers.any())).thenReturn(obj);
		//String json = mapper.writeValueAsString(obj);	
		//MvcResult requestResult = mvc.perform(post("/api/employee/apply-loan").contentType(MediaType.APPLICATION_JSON).characterEncoding("utf-8").content(json).accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk()).andReturn();
		mvc.perform(post("/api/employee/apply-loan").contentType(MediaType.APPLICATION_JSON).characterEncoding("utf-8").accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk()).andReturn();
		//String result = requestResult.getResponse().getContentAsString();
		//System.out.print(result);
		//assertEquals(result,result);
	}
	*/
	
	}
