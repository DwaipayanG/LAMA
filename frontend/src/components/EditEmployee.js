import axios from "axios";
import { useState, useEffect } from "react";
import Button from 'react-bootstrap/Button';
import Form from 'react-bootstrap/Form';
import "../style/AddEmployee.css";
import Header from "./Header";
import AdminNavigation from "./AdminNavigation";
import { useLocation } from "react-router-dom";

export default function EditEmployee(){
    const location = useLocation();

    const [employeeId, setEmployeeId] = useState(location.state.employeeId);
    const [employeeName, setEmployeeName] = useState('');
    const [department, setDepartment] = useState('');
    const [designation, setDesignation] = useState('');
    const [gender, setGender] = useState('');
    const [password, setPassword] = useState("");
    const [dateOfBirth, setDateOfBirth] = useState(null);
    const [dateOfJoining, setDateOfJoining] = useState(null);

    const getURL="http://localhost:8080/api/employee/by-employee-id";
    const editURL="http://localhost:8080/api/employee";

     useEffect(()=>{
       
        axios
        .get(getURL, {params: {"employeeId" : employeeId}})
        .then((response) => {
            console.log(response.data);
            setEmployeeId(response.data.employeeId);
            setEmployeeName(response.data.employeeName);
            setDepartment(response.data.department);
            setDesignation(response.data.designation);
            setGender(response.data.gender);
            setDateOfBirth(response.data.dateOfBirth);
            setDateOfJoining(response.data.dateOfJoining);
            setPassword(response.data.password);
        })
        .catch((error) => {
            console.log(error);
        });
    },[]);

    const employeeIdChangeHandler = (event) => {
        setEmployeeId(event.target.value)
    }

    const employeeNameChangeHandler = (event) => {
        setEmployeeName(event.target.value)
    }

    const departmentChangeHandler = (event) => {
        setDepartment(event.target.value)
    }
    const passwordChangeHandler = (event) => {
        setPassword(event.target.value)
    }

    const designationChangeHandler = (event) => {
        setDesignation(event.target.value)
    }

    const genderChangeHandler = (event) => {
        setGender(event.target.value);
    }

    const dateOfBirthChangeHandler = (event) => {
        setDateOfBirth(event.target.value);
    }

    const dateOfJoiningChangeHandler = (event) => {
        setDateOfJoining(event.target.value);
    }

    const submitActionHandler = (event) => {
        event.preventDefault();
        axios
            .put(editURL, {
                    "employeeId": employeeId,
                    "employeeName": employeeName,
                    "department": department,
                    "designation": designation,
                    "gender": gender,
                    "dateOfBirth": dateOfBirth,
                    "dateOfJoining": dateOfJoining,
                    "password": password
                }
            ,{params:{
                "employeeId": employeeId
            }})
            .then((response) => {
                alert(response.data);
            })
            .catch((error) => {
                alert(error);
            })
    }

    return (
        <div>
            <Header></Header>
            <AdminNavigation/>
        
        <div className="addEmployeeBox">
            <h3> Edit Employee </h3>             
            <Form onSubmit={submitActionHandler}>
                <Form.Group className="mb-3">
                    <Form.Label className="addEmployeeColumn">Employee Id</Form.Label>
                    <Form.Control className="addEmployeeValue" type="text" value={employeeId} onChange={employeeIdChangeHandler} id="employeeId" disabled/>
                </Form.Group>
                <Form.Group className="mb-3">
                    <Form.Label className="addEmployeeColumn">Password</Form.Label>
                    <Form.Control className="addEmployeeValue" type="password" value={password} onChange={passwordChangeHandler} id="password" />
                </Form.Group>
                <Form.Group className="mb-3">
                    <Form.Label className="addEmployeeColumn">Employee Name</Form.Label>
                    <Form.Control className="addEmployeeValue" type="text" value={employeeName} onChange={employeeNameChangeHandler} id="employeeName" />
                </Form.Group>
                <Form.Group className="mb-3">
                    <Form.Label className="addEmployeeColumn"> Department</Form.Label>
                    <Form.Control className="addEmployeeValue" type="text" value={department} onChange={departmentChangeHandler} id="department" />
                </Form.Group>
                <Form.Group className="mb-3">
                    <Form.Label className="addEmployeeColumn">Designation</Form.Label>
                    <Form.Control className="addEmployeeValue" type="text" value={designation} onChange={designationChangeHandler} id="designation" />
                </Form.Group>
                <Form.Group className="mb-3">
                    <Form.Label className="addEmployeeColumn">Gender</Form.Label>
                    <Form.Control className="addEmployeeValue" type="text" value={gender} onChange={genderChangeHandler} id="gender" />
                </Form.Group>
                <Form.Group className="mb-3">
                    <Form.Label className="addEmployeeColumn">Date of Joining</Form.Label>
                    <Form.Control className="addEmployeeValue" type="date" value={dateOfJoining} onChange={dateOfJoiningChangeHandler} id="dateOfJoining" />
                </Form.Group>
                <Form.Group className="mb-3">
                    <Form.Label className="addEmployeeColumn">Date of Birth</Form.Label>
                    <Form.Control className="addEmployeeValue" type="date" value={dateOfBirth} onChange={dateOfBirthChangeHandler} id="dateOfJoining" />
                </Form.Group>
                <Button variant="primary" type="submit">
                    Submit
                </Button>
            </Form>
        </div>
        </div>
    );
};