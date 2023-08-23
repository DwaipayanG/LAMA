import { useEffect, useState } from "react";
import Card from 'react-bootstrap/Card';
import {Row,Col} from 'react-bootstrap';
import Header from "../../components/Header";
import AdminNavigation from "../../components/AdminNavigation";
import "../../style/Card.css";
import { AiOutlineFileAdd,AiOutlineEye } from "react-icons/ai";

export default function AdminDashboard(){

    const [user,setUser]=useState(null);
    
    return (
        <div>
            <Header></Header>
            <AdminNavigation/>
        
            <p className="welcomeText" style={{fontSize: "2em"}}> Welcome <b>{sessionStorage.getItem("adminUsername")}</b> </p>
            {/* <div style={{width:"70%",margin:"auto"}} className="d-flex justify-content-center m-2"> */}
            <Row style={{width:"70%",margin:"auto"}} > 
             
                <div>
                  <div style={{ display: "flex", flexWrap: "wrap" }}>
                    
                      <Col lg="4" md="4" sm="6" xs="12">
        
            <Card className="bgCard bg1">
                

            <Card.Body>
                <Card.Title>Employee Data </Card.Title>
                
                <Card.Link href="/addEmployee"><AiOutlineFileAdd/>Add</Card.Link>
                <Card.Link href="/viewAllEmployees"><AiOutlineEye/>View</Card.Link>
            </Card.Body>
            </Card>
            </Col>
            <Col lg="4" md="4" sm="6" xs="12" >
            <Card className="bgCard bg2 ">

            <Card.Body>
                <Card.Title>Items Data</Card.Title>
                
                <Card.Link href="/addItem"><AiOutlineFileAdd/>Add</Card.Link>
                <Card.Link href="/viewAllItems"><AiOutlineEye/>View</Card.Link>
            </Card.Body>
            </Card>
            </Col>
            <Col lg="4" md="4" sm="6" xs="12">
            <Card className="bgCard bg3">
            <Card.Body>
                <Card.Title>Loan Card Data</Card.Title>
               
                <Card.Link href="/addLoanCard"><AiOutlineFileAdd/>Add</Card.Link>
                <Card.Link href="/viewAllLoanCards"><AiOutlineEye/>View</Card.Link>
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