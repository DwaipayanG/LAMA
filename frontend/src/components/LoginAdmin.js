import axios from "axios";
import { useState } from "react";
import Button from 'react-bootstrap/Button';
import Form from 'react-bootstrap/Form';

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
        <div style={{width:"70%",margin:"auto"}}>
        <Form onSubmit={submitActionHandler}>
        <Form.Group className="mb-3" controlId="formBasicEmail">
            <Form.Label>Admin ID</Form.Label>
            <Form.Control type="text" value={adminId} onChange={adminIdChangeHandler} placeholder="Enter ID" />
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
    );
}

export default LoginAdmin;