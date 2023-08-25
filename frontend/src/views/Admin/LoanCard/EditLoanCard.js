import axios from "axios";
import { useState, useEffect } from "react";
import Button from 'react-bootstrap/Button';
import Form from 'react-bootstrap/Form';
import Header from "../../../components/Header";
import AdminNavigation from "../../../components/AdminNavigation";
import { useLocation } from "react-router-dom";

export default function EditLoanCard(){
    const location = useLocation();

    const [loanId, setLoanId] = useState(location.state.loanId);
    const [loanType, setLoanType] = useState("");
    const [duration, setDuration] = useState("");
    const [message, setMessage] = useState(null);

    const getURL="http://localhost:8080/api/loan-card/by-loan-id";
    const editURL="http://localhost:8080/api/loan-card";

     useEffect(()=>{
       
        axios
        .get(getURL, {params: {"loanId" : loanId}})
        .then((response) => {
            console.log(response.data);
            setLoanId(response.data.loanId);
            setLoanType(response.data.loanType);
            setDuration(response.data.durationInYears)
        })
        .catch((error) => {
            console.log(error);
        });
    },[]);

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
            .put(editURL, {
                "loanId": loanId,
                "loanType": loanType,
                "durationInYears": duration
            },
            {
                params:{"loanId": loanId}
            })
            .then((response) => {
                setMessage("Loan card edited successfully!");
            })
            .catch((error) => {
                alert(error);
            })
    }
    
    return (
        <div>
            <Header></Header>
            <AdminNavigation/>
        
        <div className="addLoanCardBox">
            <h3> Edit loan Card </h3>             
            <Form onSubmit={submitActionHandler}>
                <Form.Group className="mb-3">
                    <Form.Label className="addLoanCardColumn">Loan Id</Form.Label>
                    <Form.Control className="addLoanCardValue" type="text" value={loanId} onChange={loanIdChangeHandler} id="loanId" disabled />
                </Form.Group>
                <Form.Group className="mb-3">
                    <Form.Label className="addLoanCardColumn">Loan Type</Form.Label>
                    <Form.Control className="addLoanCardValue" type="text" value={loanType} onChange={loanTypeChangeHandler} id="loanType" />
                </Form.Group>
                <Form.Group className="mb-3">
                    <Form.Label className="addLoanCardColumn">Duration</Form.Label>
                    <Form.Control className="addLoanCardValue" type="text" value={duration} onChange={durationChangeHandler} id="duration" />
                </Form.Group>
                <Button variant="primary" type="submit">
                    Submit
                </Button>
            </Form>
            {message && <div style={{color:"green"}}><b>{message}</b></div>}
        </div>
        </div>
    );
}