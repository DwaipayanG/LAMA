import axios from "axios";
import { useState } from "react";
import Button from 'react-bootstrap/Button';
import Form from 'react-bootstrap/Form';
import "../style/AddEmployee.css"

export default function AddEmployee(){
    const baseURL = "http://localhost:8080/addEmployee";

    const [employeeId, setEmployeeId] = useState('');
    const [employeeName, setEmployeeName] = useState('');
    const [department, setDepartment] = useState('');
    const [designation, setDesignation] = useState('');
    const [gender, setGender] = useState('');
    const [password, setPassword] = useState("");
    const [dateOfBirth, setDateOfBirth] = useState(null);
    const [dateOfJoining, setDateOfJoining] = useState(null);

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
        axios
            .post(baseURL, {
                "employeeId": employeeId,
                "employeeName": employeeName,
                "department": department,
                "designation": designation,
                "gender": gender,
                "dateOfBirth": dateOfBirth,
                "dateOfJoining": dateOfJoining,
                "password":password
            })
            .then((response) => {
                alert(response.data);
            })
            .catch((error) => {
                alert(error);
            })
    }

    return (
        <div className="addEmployeeBox">
            <h3> Add Employee </h3>             
            <Form onSubmit={submitActionHandler}>
                <Form.Group className="mb-3">
                    <Form.Label className="addEmployeeColumn">Employee Id</Form.Label>
                    <Form.Control className="addEmployeeValue" type="text" value={employeeId} onChange={employeeIdChangeHandler} id="employeeId" />
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
    );
};