import axios from "axios";
import { useState } from "react";
import Button from 'react-bootstrap/Button';
import Form from 'react-bootstrap/Form';

function LoginAdmin() {
    const baseURL = "http://localhost:8080/addEmployee";

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
            "employee_id": employeeId,
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
        <Form>
        <Form.Group className="mb-3" controlId="formBasicEmail">
            <Form.Label>Email address</Form.Label>
            <Form.Control type="email" placeholder="Enter email" />
            <Form.Text className="text-muted">
            We'll never share your email with anyone else.
            </Form.Text>
        </Form.Group>

        <Form.Group className="mb-3" controlId="formBasicPassword">
            <Form.Label>Password</Form.Label>
            <Form.Control type="password" placeholder="Password" />
        </Form.Group>
        <Button variant="primary" type="submit">
            Submit
        </Button>
        </Form>

        </div>
    );
}

export default LoginAdmin;