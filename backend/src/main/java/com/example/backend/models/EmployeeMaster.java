package com.example.backend.models;

import java.util.Date;

import java.util.List;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;


@Entity
@Table(name="employee_master")
public class EmployeeMaster {
	@Id
	@Column(name="employee_id", nullable=false, length=6)
	private String employeeId;
	
	@Valid
	
	
	@Column(name="employee_name", length=20)
	@NotBlank(message = "cannot be blank")
	private String employeeName;
	
	@NotNull
	@NotBlank(message ="designation cannot be empty")
	@Column(name="designation", length=25)
	private String designation;
	
	
	@Column(name="department", length=25)
	@NotBlank(message ="department cannot be empty")
	private String department;
	
	
	@Column
	private char gender;
	
	@NotNull
	@Column(name="date_of_birth")
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date dateOfBirth;
	
	@NotNull
	@Column(name="date_of_joining")
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date dateOfJoining;
	
	@OnDelete(action=OnDeleteAction.CASCADE)
	@OneToMany(mappedBy="employeeMaster",cascade = CascadeType.ALL,orphanRemoval = true)
	@JsonManagedReference
	private List<EmployeeCardDetails> employeeCardDetails;
		
	public List<EmployeeCardDetails> getEmployeeCardDetails() {
		return employeeCardDetails;
	}

	public void setEmployeeCardDetails(List<EmployeeCardDetails> employeeCardDetails) {
		this.employeeCardDetails = employeeCardDetails;
	}

	@OnDelete(action=OnDeleteAction.CASCADE)
	@OneToMany(mappedBy="employeeMaster",cascade = CascadeType.ALL,orphanRemoval = true)
	@JsonManagedReference
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
