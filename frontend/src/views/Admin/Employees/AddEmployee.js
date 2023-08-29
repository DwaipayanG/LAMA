import axios from "axios";
import { useState } from "react";
import Button from 'react-bootstrap/Button';
import Form from 'react-bootstrap/Form';
import "../../../style/AddEmployee.css";
import Header from "../../../components/Header";
import AdminNavigation from "../../../components/AdminNavigation";
import { useNavigate } from "react-router-dom";

export default function AddEmployee(){
    const baseURL = "http://localhost:8080/api/employee";

    const [employeeId, setEmployeeId] = useState('');
    const [employeeName, setEmployeeName] = useState('');
    const [department, setDepartment] = useState('');
    const [designation, setDesignation] = useState('');
    const [gender, setGender] = useState('');
    const [password, setPassword] = useState("");
    const [dateOfBirth, setDateOfBirth] = useState(null);
    const [dateOfJoining, setDateOfJoining] = useState(null);
    const [error, setError] = useState(null);

    const navigate = useNavigate();

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
                const data=response.data;
                if(data["statusCode"]&&data["statusCode"]==400)
                    setError(data["message"]);
                else
                    navigate("/admin/employees/view");
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
            <h3> Add Employee </h3>             
            <Form onSubmit={submitActionHandler}>
                <Form.Group className="mb-3">
                    <Form.Label className="addEmployeeColumn">Employee Id</Form.Label>
                    <Form.Control className="addEmployeeValue" type="text" value={employeeId} onChange={employeeIdChangeHandler} id="employeeId" required/>
                </Form.Group>
                <Form.Group className="mb-3">
                    <Form.Label className="addEmployeeColumn">Password</Form.Label>
                    <Form.Control className="addEmployeeValue" type="password" value={password} onChange={passwordChangeHandler} id="password" pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{6,}" title="Must contain at least one number and one uppercase and lowercase letter, and at least 6 or more characters" required />
                </Form.Group>
                <Form.Group className="mb-3">
                    <Form.Label className="addEmployeeColumn">Employee Name</Form.Label>
                    <Form.Control className="addEmployeeValue" type="text" value={employeeName} onChange={employeeNameChangeHandler} id="employeeName" required />
                </Form.Group>
                <Form.Group className="mb-3">
                    <Form.Label className="addEmployeeColumn"> Department</Form.Label>
                    <Form.Control className="addEmployeeValue" type="text" value={department} onChange={departmentChangeHandler} id="department" required />
                </Form.Group>
                <Form.Group className="mb-3">
                    <Form.Label className="addEmployeeColumn">Designation</Form.Label>
                    <Form.Control className="addEmployeeValue" type="text" value={designation} onChange={designationChangeHandler} id="designation" required />
                </Form.Group>
                <Form.Group className="mb-3">
                    <Form.Label className="addEmployeeColumn">Gender</Form.Label>
                    <Form.Control className="addEmployeeValue" type="text" value={gender} onChange={genderChangeHandler} id="gender" required />
                </Form.Group>
                <Form.Group className="mb-3">
                    <Form.Label className="addEmployeeColumn">Date of Joining</Form.Label>
                    <Form.Control className="addEmployeeValue" type="date" value={dateOfJoining} onChange={dateOfJoiningChangeHandler} id="dateOfJoining" required />
                </Form.Group>
                <Form.Group className="mb-3">
                    <Form.Label className="addEmployeeColumn">Date of Birth</Form.Label>
                    <Form.Control className="addEmployeeValue" type="date" value={dateOfBirth} onChange={dateOfBirthChangeHandler} id="dateOfJoining" required />
                </Form.Group>
                <Button variant="primary" type="submit">
                    Submit
                </Button>
            </Form>
            {error && <div style={{color:"red"}}><b>{error}</b></div>}
        </div>
        </div>
    );
};