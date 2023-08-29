import axios from "axios";
import { useState, useEffect } from "react";
import Button from 'react-bootstrap/Button';
import Form from 'react-bootstrap/Form';
import "../../style/AddEmployee.css";
import Header from "../../components/Header";
import { useLocation } from "react-router-dom";
import EmployeeNavigation from "../../components/EmployeeNavaigation";

export default function ChangePassword(){
    const location = useLocation();

    const [employeeId, setEmployeeId] = useState(sessionStorage.getItem("employeeId"));
    const [employeeName, setEmployeeName] = useState('');
    const [department, setDepartment] = useState('');
    const [designation, setDesignation] = useState('');
    const [gender, setGender] = useState('');
    const [password, setPassword] = useState("");
    const [dateOfBirth, setDateOfBirth] = useState(null);
    const [dateOfJoining, setDateOfJoining] = useState(null);
    const [message, setMessage] = useState(null);

    const getURL="http://localhost:8080/api/employee/by-employee-id";
    const editURL="http://localhost:8080/api/employee";

     useEffect(()=>{
    
        axios.get(getURL, {params: {"employeeId": employeeId}})
        .then((response) => {
            console.log(response.data);
            setEmployeeId(response.data.employeeId);
            setEmployeeName(response.data.employeeName);
            setDepartment(response.data.department);
            setDesignation(response.data.designation);
            setGender(response.data.gender);
            setDateOfBirth(response.data.dateOfBirth.substr(0, 10));
            setDateOfJoining(response.data.dateOfJoining.substr(0, 10));
            
        })
        .catch((error) => {
            console.log(error);
        });
    },[]);

    
    const passwordChangeHandler = (event) => {
        setPassword(event.target.value)
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
                setMessage("Employee edited!");
            })
            .catch((error) => {
                alert(error);
            })
    }

    return (
        <div>
            <Header></Header>
            <EmployeeNavigation/>
        
        <div className="addEmployeeBox">
            <h3> Change Password </h3>             
            <Form onSubmit={submitActionHandler}>
                <Form.Group className="mb-3">
                    <Form.Label className="addEmployeeColumn">Employee Id</Form.Label>
                    <Form.Control className="addEmployeeValue" type="text" value={employeeId} id="employeeId" disabled/>
                </Form.Group>
                
                <Form.Group className="mb-3">
                    <Form.Label className="addEmployeeColumn">Employee Name</Form.Label>
                    <Form.Control className="addEmployeeValue" type="text" value={employeeName} disabled id="employeeName" />
                </Form.Group>

                <Form.Group className="mb-3">
                    <Form.Label className="addEmployeeColumn">Password</Form.Label>
                    <Form.Control className="addEmployeeValue" type="password" value={password} onChange={passwordChangeHandler} id="password" />
                </Form.Group>

                
                <Button variant="primary" type="submit">
                    Submit
                </Button>
            </Form>
            {message && <div style={{color:"green"}}><b>{message}</b></div>}
        </div>
        </div>
    );
};