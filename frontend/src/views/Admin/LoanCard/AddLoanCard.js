import axios from "axios";
import { useState } from "react";
import Button from 'react-bootstrap/Button';
import Form from 'react-bootstrap/Form';
import "../../../style/AddLoanCard.css";
import Header from "../../../components/Header";
import AdminNavigation from "../../../components/AdminNavigation";
import { useNavigate } from "react-router-dom";
export default function AddLoanCard(){

    const baseURL = "http://localhost:8080/api/loan-card";
    const navigation = useNavigate();

    const [loanId, setLoanId] = useState("");
    const [loanType, setLoanType] = useState("");
    const [duration, setDuration] = useState("");
    const [error, setError] = useState(null);

    const loanIdChangeHandler = (event) => {
        setLoanId(event.target.value)
    }

    const loanTypeChangeHandler = (event) => {
        setLoanType(event.target.value)
    }

    const durationChangeHandler = (event) => {
        setDuration(event.target.value)
    }

    const submitActionHandler = (event) => {
        event.preventDefault();
        axios
            .post(baseURL, {
                "loanId": loanId,
                "loanType": loanType,
                "durationInYears": duration
            })
            .then((response) => {
                console.log(response.data)
                const data=response.data;
                if(data["statusCode"]&&data["statusCode"]==400){
                    setError(data["message"]);
                }else
                    navigation("/admin/loan-cards/view");
            })
            .catch((error) => {
                alert(error);
            });
    }
    
    return (
        <div>
            <Header></Header>
            <AdminNavigation></AdminNavigation>
        
        <div className="addLoanCardBox">
            <h3> Add loan Card </h3>             
            <Form onSubmit={submitActionHandler}>
                <Form.Group className="mb-3">
                    <Form.Label className="addLoanCardColumn">Loan Id</Form.Label>
                    <Form.Control className="addLoanCardValue" type="text" value={loanId} onChange={loanIdChangeHandler} id="employeeId" maxLength="6" required/>
                </Form.Group>
                <Form.Group className="mb-3">
                    <Form.Label className="addLoanCardColumn">Loan Type</Form.Label>
                    <Form.Control className="addLoanCardValue" type="text" value={loanType} onChange={loanTypeChangeHandler} id="password" required/>
                </Form.Group>
                <Form.Group className="mb-3">
                    <Form.Label className="addLoanCardColumn">Duration</Form.Label>
                    <Form.Control className="addLoanCardValue" type="text" value={duration} onChange={durationChangeHandler} id="employeeName" required/>
                </Form.Group>
                <Button variant="primary" type="submit">
                    Submit
                </Button>
            </Form>
            {error && <div style={{color:"red"}}><b>{error}</b></div>}
        </div>
        </div>
    );
}