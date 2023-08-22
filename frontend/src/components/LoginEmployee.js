import axios from "axios";
import { useState } from "react";
import Button from 'react-bootstrap/Button';
import Form from 'react-bootstrap/Form';
import { useNavigate } from "react-router-dom";
import Header from "./Header";

function LoginEmployee() {
    const baseURL = "http://localhost:8080/api/employee/login";
    const navigate = useNavigate();

    const [employeeId, setEmployeeId] = useState('');
    const [password, setPassword] = useState("");

    const employeeIdChangeHandler = (event) => {
        setEmployeeId(event.target.value)
    }
    const passwordChangeHandler = (event) => {
        setPassword(event.target.value)
    }

    const submitActionHandler = (event) => {
        event.preventDefault();
        axios
        .post(baseURL, {
            "employeeId": employeeId,
            "password": password
        })
        .then((response) => {
            //alert(response.data);
            if(response.data==="Invalid employee ID"){
              alert(response.data)
            }else if(response.data ==="Wrong password"){
              alert(response.data)
            }else{
              sessionStorage.setItem("employeeId", response.data.employeeId);
              sessionStorage.setItem("employeeName",response.data.employeeName);
              navigate("/employeeDashboard");
            }
        })
        .catch((error) => {
            alert(error);
        })
    }


    return (
        <div>
            <Header></Header>
        <div style={{width:"70%",margin:"auto"}}>
        <Form onSubmit={submitActionHandler}>
        <Form.Group className="mb-3" controlId="formBasicEmail">
            <Form.Label>Employee ID</Form.Label>
            <Form.Control type="text" value={employeeId} onChange={employeeIdChangeHandler} placeholder="Enter employee ID" />
            <Form.Text className="text-muted">
            We'll never share your email with anyone else.
            </Form.Text>
        </Form.Group>

        <Form.Group className="mb-3" controlId="formBasicPassword">
            <Form.Label>Password</Form.Label>
            <Form.Control type="password" value={password} onChange={passwordChangeHandler} placeholder="Password" />
        </Form.Group>
        <Button variant="primary" type="submit">
            Submit
        </Button>
        </Form>
        </div>
        </div>
    );
}

export default LoginEmployee;