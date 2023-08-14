import axios from "axios";
import { useState } from "react";
import Button from 'react-bootstrap/Button';
import Form from 'react-bootstrap/Form';

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
        <div style={{width:"70%",margin:"auto"}}>
            <h3> Add Employee </h3>             
            <Form onSubmit={submitActionHandler}>
                <Form.Group className="mb-3">
                    <Form.Label>Employee Id</Form.Label>
                    <Form.Control type="text" value={employeeId} onChange={employeeIdChangeHandler} id="employeeId" />
                </Form.Group>
                <Form.Group className="mb-3">
                    <Form.Label>Password</Form.Label>
                    <Form.Control type="password" value={password} onChange={passwordChangeHandler} id="password" />
                </Form.Group>
                <Form.Group className="mb-3">
                    <Form.Label>Employee Name</Form.Label>
                    <Form.Control type="text" value={employeeName} onChange={employeeNameChangeHandler} id="employeeName" />
                </Form.Group>
                <Form.Group className="mb-3">
                    <Form.Label>Department</Form.Label>
                    <Form.Control type="text" value={department} onChange={departmentChangeHandler} id="department" />
                </Form.Group>
                <Form.Group className="mb-3">
                    <Form.Label>Designation</Form.Label>
                    <Form.Control type="text" value={designation} onChange={designationChangeHandler} id="designation" />
                </Form.Group>
                <Form.Group className="mb-3">
                    <Form.Label>Gender</Form.Label>
                    <Form.Control type="text" value={gender} onChange={genderChangeHandler} id="gender" />
                </Form.Group>
                <Form.Group className="mb-3">
                    <Form.Label>Date of Joining</Form.Label>
                    <Form.Control type="date" value={dateOfJoining} onChange={dateOfJoiningChangeHandler} id="dateOfJoining" />
                </Form.Group>
                <Form.Group className="mb-3">
                    <Form.Label>Date of Birth</Form.Label>
                    <Form.Control type="date" value={dateOfBirth} onChange={dateOfBirthChangeHandler} id="dateOfJoining" />
                </Form.Group>
                <Button variant="primary" type="submit">
                    Submit
                </Button>
            </Form>
        </div>
    );
};