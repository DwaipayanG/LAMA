import axios from "axios";
import { useEffect, useState } from "react";
import Button from 'react-bootstrap/Button';
import Form from 'react-bootstrap/Form';
import '../../style/Login.css';
import { useNavigate } from "react-router-dom";
import Header from "../../components/Header";

function LoginAdmin() {
    const baseURL = "http://localhost:8080/api/admin/login";
    const navigate = useNavigate();

    const [adminUsername, setAdminUsername] = useState('');
    const [password, setPassword] = useState("");
    const [error, setError] = useState(null);

    const adminUsernameChangeHandler = (event) => {
        setAdminUsername(event.target.value)
    }
    const passwordChangeHandler = (event) => {
        setPassword(event.target.value)
    }

    useEffect(()=>{
        if(sessionStorage.getItem("adminUsername")){
            navigate("/admin/dashboard");
        }
    },[]);



    const submitActionHandler = (event) => {
        event.preventDefault();
        axios
        .post(baseURL, {
            "adminUsername": adminUsername,
            "password": password
        })
        .then((response) => {
            const data=response.data;
            if(data["statusCode"]&&(data["statusCode"]==400||data["statusCode"]==404)){
                setError(data["message"]);
            }else{
              sessionStorage.setItem("adminUsername", response.data);
              navigate("/admin/dashboard");
            }
        })
        .catch((error) => {
            alert(error);
        })
    }


    return (
        <div>
            <Header></Header>
        <div id="loginForm">
            <h1>Admin Login Page</h1>
        <Form onSubmit={submitActionHandler}>
        <Form.Group className="mb-3" controlId="formBasicEmail">
            <Form.Control type="text" value={adminUsername} onChange={adminUsernameChangeHandler} placeholder="Admin ID" className="textInput" required />
        </Form.Group>

        <Form.Group className="mb-3" controlId="formBasicPassword">
            <Form.Control type="password" value={password} onChange={passwordChangeHandler} placeholder="Password" className="textInput" required/>
        </Form.Group>
        <Button variant="primary" type="submit">
            Submit
        </Button>
        </Form>
            {error && 
                <div style={{color:"red"}}><b>{error}</b></div>
            }
        </div>
        </div>
    );
}

export default LoginAdmin;