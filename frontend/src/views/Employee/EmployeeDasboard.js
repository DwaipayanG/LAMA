import { useEffect, useState } from "react";
import Card from 'react-bootstrap/Card';
import Header from "../../components/Header";
import {Row,Col} from 'react-bootstrap';
import "../../style/Card.css"
import EmployeeNavigation from "../../components/EmployeeNavaigation";


export default function EmployeeDasboard(){

    const [user,setUser]=useState(null);
    

    return (
        <div>
            <Header></Header>
            <EmployeeNavigation/>
                    
        <p className="welcomeText" style={{fontSize: "2em"}}> Welcome <b>{sessionStorage.getItem("employeeId")}</b> </p>

        <Row style={{width:"70%",margin:"auto"}} > 
             
                <div>
                  <div style={{ display: "flex", flexWrap: "wrap" }}>
                    
                      <Col lg="4" md="4" sm="6" xs="12">
                <Card className="bgCard bg1">
            <Card.Body>
                <Card.Title>Show Loans</Card.Title>
                <Card.Link href="/viewLoans">View Loans</Card.Link>
            </Card.Body>
            </Card>
            </Col>

            
            <Col lg="4" md="4" sm="6" xs="12" >
            <Card className="bgCard bg2 ">
            <Card.Body>
                <Card.Title>Apply for loans</Card.Title>
                <Card.Link href="/applyLoan">Apply Loan</Card.Link>
            </Card.Body>
            </Card>
            </Col>
            <Col lg="4" md="4" sm="6" xs="12" >
            <Card className="bgCard bg3 ">
            <Card.Body>
                <Card.Title>Purchased Items</Card.Title>
                <Card.Link href="/viewitems">Items Purchased</Card.Link>
            </Card.Body>
            </Card>
            </Col>
            </div>
            </div>
            </Row>
        
        </div>
    );
}