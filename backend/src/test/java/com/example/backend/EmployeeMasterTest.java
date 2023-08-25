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
import org.json.JSONObject;
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
import com.example.backend.dto.EmployeeMasterLoginDTO;
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

import net.minidev.json.JSONValue;

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
		
		mvc.perform(get("/api/employee/all-employees")
				.contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
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

	
	@Test
	public void testupdateEmployee() throws Exception{
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
		
		Mockito.when(employeeMasterService.updateEmployee(employeeMaster, employeeMaster)).thenReturn(employeeMaster);
		
		String json = mapper.writeValueAsString(employeeMaster);
		mvc.perform(put("/api/employee?employeeId=12345").contentType(MediaType.APPLICATION_JSON).content(json).accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
	}		

	
	@Test
	public void testdeleteEmployee() throws Exception{
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
		String del = "deleted";
		
		Mockito.when(employeeMasterController.deleteEmployeeById(employeeMaster.getEmployeeId())).thenReturn(del);
		System.out.println("testing deleting employee by id");
		
		mvc.perform(delete("/api/employee?employeeId=12345").contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
	}
	
	@Test
	public void testaddEmployeeMaster() throws Exception{
		String d1="1987-05-21";
		String d2="2020-06-01";
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		Date dob=sdf.parse(d1);
		Date doj=sdf.parse(d2);
		
		EmployeeMasterDTO dto = new EmployeeMasterDTO();
		dto.setEmployeeId("12345");
		dto.setDateOfBirth(dob);
		dto.setDateOfJoining(doj);
		dto.setDepartment("tco");
		dto.setDesignation("head");
		dto.setEmployeeName("jasmine");
		dto.setGender('f');
		dto.setPassword("password");
		
		
		Mockito.when(employeeMasterController.addEmployeeMaster(ArgumentMatchers.any())).thenReturn(dto);
		String json = mapper.writeValueAsString(dto);	
		mvc.perform(post("/api/employee?", dto)
				.contentType(MediaType.APPLICATION_JSON).characterEncoding("utf-8")
				.content(json).accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk()).andReturn();
		
	}
	
	
	@Test
	public void testloginEmployeeMaster() throws Exception{
		
		EmployeeMasterLoginDTO dto = new EmployeeMasterLoginDTO();
		dto.setEmployeeId("12345");
		dto.setPassword("password");
		
		String obj = new String("loggedIn");
		
		Mockito.when(employeeMasterController.loginEmployeeMaster(dto)).thenReturn(obj);
		
		String json2 = mapper.writeValueAsString(dto);
		mvc.perform(post("/api/employee/login").contentType(MediaType.APPLICATION_JSON).characterEncoding("utf-8")
				.content(json2).accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk()).andReturn();
		
	}
	
	
	@Test
	public void testapplyLoan() throws Exception{
		
		String d2="2020-06-01";
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		Date dob=sdf.parse(d2);
		ApplyLoanData emp = new ApplyLoanData();
		emp.setEmployeeId("3342");
		emp.setItemId("3398");
		emp.setLoanId("5532");
		emp.setLoanIssueDate(dob);
		
		String obj = new String("Loan applied");
		
		Mockito.when(employeeMasterController.applyLoan(emp)).thenReturn(obj);
		String json = mapper.writeValueAsString(emp);	
		mvc.perform(post("/api/employee/apply-loan").contentType(MediaType.APPLICATION_JSON).characterEncoding("utf-8").content(json).accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk()).andReturn();
		
	}
	
	
	}
