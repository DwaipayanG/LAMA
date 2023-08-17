package com.example.backend.models;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="employee_master")
public class EmployeeMaster {
	@Id
	@Column(name="employee_id", nullable=false, length=6)
	private String employeeId;
	
	@Column(name="employee_name", length=20)
	private String employeeName;
	
	@Column(name="designation", length=25)
	private String designation;
	
	@Column(name="department", length=25)
	private String department;
	
	@Column
	private char gender;
	
	@Column(name="date_of_birth")
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date dateOfBirth;
	
	@Column(name="date_of_joining")
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date dateOfJoining;
	
	@OneToMany(mappedBy="employeeMaster")
	private List<EmployeeCardDetails> employeeCardDetails;
		
	public List<EmployeeCardDetails> getEmployeeCardDetails() {
		return employeeCardDetails;
	}

	public void setEmployeeCardDetails(List<EmployeeCardDetails> employeeCardDetails) {
		this.employeeCardDetails = employeeCardDetails;
	}

	@OneToMany(mappedBy="employeeMaster")
	private List<EmployeeIssueDetails> employeeIssueDetails;

	@Column
	private String password;

	public String getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public char getGender() {
		return gender;
	}

	public void setGender(char gender) {
		this.gender = gender;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public Date getDateOfJoining() {
		return dateOfJoining;
	}

	public void setDateOfJoining(Date dateOfJoining) {
		this.dateOfJoining = dateOfJoining;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
}
