import axios from "axios";
import { useState } from "react";
import Button from 'react-bootstrap/Button';
import Form from 'react-bootstrap/Form';
import '../style/LoginAdmin.css';

function LoginAdmin() {
    const baseURL = "http://localhost:8080/loginAdmin";

    const [adminId, setAdminId] = useState('');
    const [password, setPassword] = useState("");

    const adminIdChangeHandler = (event) => {
        setAdminId(event.target.value)
    }
    const passwordChangeHandler = (event) => {
        setPassword(event.target.value)
    }

    const submitActionHandler = (event) => {
        axios
        .post(baseURL, {
            "adminId": adminId,
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
        <div id="loginAdminForm">
            <h1>Admin Login Page</h1>
        <Form onSubmit={submitActionHandler}>
        <Form.Group className="mb-3" controlId="formBasicEmail">
            {/* <Form.Label className="textField">Admin ID</Form.Label> */}
            <Form.Control type="text" value={adminId} onChange={adminIdChangeHandler} placeholder="Admin ID" className="textInput" />
        </Form.Group>

        <Form.Group className="mb-3" controlId="formBasicPassword">
            {/* <Form.Label className="textField">Password</Form.Label> */}
            <Form.Control type="password" value={password} onChange={passwordChangeHandler} placeholder="Password" className="textInput" />
        </Form.Group>
        <Button variant="primary" type="submit">
            Submit
        </Button>
        </Form>

        </div>
    );
}

export default LoginAdmin;