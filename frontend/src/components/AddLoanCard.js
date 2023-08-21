import axios from "axios";
import { useState } from "react";
import Button from 'react-bootstrap/Button';
import Form from 'react-bootstrap/Form';
import "../style/AddLoanCard.css";
import Header from "./Header";

export default function AddLoanCard(){
    const baseURL = "http://localhost:8080/addLoanCard";

    const [loanId, setLoanId] = useState("");
    const [loanType, setLoanType] = useState("");
    const [duration, setDuration] = useState("");

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
        
        axios
            .post(baseURL, {
                "loanId": loanId,
                "loanType": loanType,
                "durationInYears": duration
            })
            .then((response) => {
                console.log(response.data)
            })
            .catch((error) => {
                alert(error);
            })
    }
    
    return (
        <div>
            <Header></Header>
        
        <div className="addLoanCardBox">
            <h3> Add loan Card </h3>             
            <Form onSubmit={submitActionHandler}>
                <Form.Group className="mb-3">
                    <Form.Label className="addLoanCardColumn">Loan Id</Form.Label>
                    <Form.Control className="addLoanCardValue" type="text" value={loanId} onChange={loanIdChangeHandler} id="employeeId" />
                </Form.Group>
                <Form.Group className="mb-3">
                    <Form.Label className="addLoanCardColumn">Loan Type</Form.Label>
                    <Form.Control className="addLoanCardValue" type="text" value={loanType} onChange={loanTypeChangeHandler} id="password" />
                </Form.Group>
                <Form.Group className="mb-3">
                    <Form.Label className="addLoanCardColumn">Duration</Form.Label>
                    <Form.Control className="addLoanCardValue" type="text" value={duration} onChange={durationChangeHandler} id="employeeName" />
                </Form.Group>
                <Button variant="primary" type="submit">
                    Submit
                </Button>
            </Form>
        </div>
        </div>
    );
}