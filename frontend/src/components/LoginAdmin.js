import axios from "axios";
import { useState } from "react";
import Button from 'react-bootstrap/Button';
import Form from 'react-bootstrap/Form';
import '../style/LoginAdmin.css';
import { useNavigate } from "react-router-dom";

function LoginAdmin() {
    const baseURL = "http://localhost:8080/loginAdmin";
    const navigate = useNavigate();

    const [adminUsername, setAdminUsername] = useState('');
    const [password, setPassword] = useState("");

    const adminUsernameChangeHandler = (event) => {
        setAdminUsername(event.target.value)
    }
    const passwordChangeHandler = (event) => {
        setPassword(event.target.value)
    }


    const submitActionHandler = (event) => {
        event.preventDefault();
        axios
        .post(baseURL, {
            "adminUsername": adminUsername,
            "password": password
        })
        .then((response) => {
            if(response.data==="Invalid admin ID"){
              alert(response.data)
            }else if(response.data ==="Wrong password"){
              alert(response.data)
            }else{
              sessionStorage.setItem("adminUsername", response.data);
              navigate("/adminDashboard");
            }
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
            <Form.Control type="text" value={adminUsername} onChange={adminUsernameChangeHandler} placeholder="Admin ID" className="textInput" />
        </Form.Group>

        <Form.Group className="mb-3" controlId="formBasicPassword">
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