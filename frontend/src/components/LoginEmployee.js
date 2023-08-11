import axios from "axios";
import { useState } from "react";
import Button from 'react-bootstrap/Button';
import Form from 'react-bootstrap/Form';
import { Link } from "react-router-dom";

function LoginEmployee() {
    const baseURL = "http://localhost:8080/loginEmployee";

    const [employeeId, setEmployeeId] = useState('');
    const [password, setPassword] = useState("");

    const employeeIdChangeHandler = (event) => {
        setEmployeeId(event.target.value)
    }
    const passwordChangeHandler = (event) => {
        setPassword(event.target.value)
    }

    const submitActionHandler = (event) => {
        axios
        .post(baseURL, {
            "employeeId": employeeId,
            "password": password
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
        <br></br>
        <Link to="/addEmployee">Sign Up</Link>
        </div>
    );
}

export default LoginEmployee;