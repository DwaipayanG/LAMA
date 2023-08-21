import { useEffect, useState } from "react";
import axios from "axios";
import Card from 'react-bootstrap/Card';
import {Row,Col} from 'react-bootstrap';
import Header from "./Header";
import "../style/Card.css"

export default function AdminDashboard(){

    const [user,setUser]=useState(null);
    
    return (
        <div>
            <Header></Header>
        
            <p className="welcomeText" style={{fontSize: "2em"}}> Welcome <b>{sessionStorage.getItem("adminUsername")}</b> </p>
            {/* <div style={{width:"70%",margin:"auto"}} className="d-flex justify-content-center m-2"> */}
            <Row style={{width:"70%",margin:"auto"}} > 
             
                <div>
                  <div style={{ display: "flex", flexWrap: "wrap" }}>
                    
                      <Col lg="4" md="4" sm="6" xs="12">
        
            <Card className="bgCard bg1">
                

            <Card.Body>
                <Card.Title>Customer Data Management</Card.Title>
                
                <Card.Link href="/addEmployee">Add</Card.Link>
                <Card.Link href="/viewAllEmployees">Edit</Card.Link>
            </Card.Body>
            </Card>
            </Col>
            <Col lg="4" md="4" sm="6" xs="12" >
            <Card className="bgCard bg2 ">

            <Card.Body>
                <Card.Title>Items Master Data</Card.Title>
                
                <Card.Link href="/addItem">Add</Card.Link>
                <Card.Link href="/viewAllItems">Edit</Card.Link>
            </Card.Body>
            </Card>
            </Col>
            <Col lg="4" md="4" sm="6" xs="12">
            <Card className="bgCard bg3">
            <Card.Body>
                <Card.Title>Loan Card Data</Card.Title>
               
                <Card.Link href="/addLoanCard">Add</Card.Link>
                <Card.Link href="/viewAllLoanCards">Edit</Card.Link>
            </Card.Body>
            </Card>
            </Col>
          
            </div>
            </div>
            </Row>
        </div>
        // </div>
    );
}