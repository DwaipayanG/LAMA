import { useEffect, useState } from "react";
import axios from "axios";
import Card from 'react-bootstrap/Card';
import Header from "./Header";

export default function EmployeeDasboard(){

    const [user,setUser]=useState(null);

    useEffect(()=>{
        const url="http://localhost:8080/getUser"
        const id=sessionStorage.getItem("employeeId");
        axios
        .get(url)
        .then((response) => {
            alert(response.data);
        })
        .catch((error) => {
            alert(error);
        });
    });

    return (
        <div>
            <Header></Header>
        <div style={{width:"70%",margin:"auto"}} className="d-flex justify-content-center my-2">
            Welcome <b>{sessionStorage.getItem("employeeName")}</b>
            <br/>
            <Card style={{ width: '18rem' }}>
            <Card.Body>
                <Card.Title>Show Loans</Card.Title>
                <Card.Text>
                Some quick example text to build on the card title and make up the
                bulk of the card's content.
                </Card.Text>
                <Card.Link href="/viewLoans">Card Link</Card.Link>
            </Card.Body>
            </Card>
            <Card style={{ width: '18rem' }}>
            <Card.Body>
                <Card.Title>Apply for loans</Card.Title>
                <Card.Text>
                Some quick example text to build on the card title and make up the
                bulk of the card's content.
                </Card.Text>
                <Card.Link href="/applyLoan">Apply Loan</Card.Link>
            </Card.Body>
            </Card>
            <Card style={{ width: '18rem' }}>
            <Card.Body>
                <Card.Title>Purchased Items</Card.Title>
                <Card.Text>
                Some quick example text to build on the card title and make up the
                bulk of the card's content.
                </Card.Text>
                <Card.Link href="#">Card Link</Card.Link>
            </Card.Body>
            </Card>
        </div>
        </div>
    );
}