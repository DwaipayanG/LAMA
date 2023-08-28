import { useEffect, useState } from "react";
import Card from 'react-bootstrap/Card';
import {Row,Col} from 'react-bootstrap';
import Header from "../../components/Header";
import AdminNavigation from "../../components/AdminNavigation";
import "../../style/Card.css";
import { AiOutlineFileAdd,AiOutlineEye } from "react-icons/ai";
import  loan from "../../assets/loan.png";
import  employee from "../../assets/employee.png";
import item from "../../assets/item.png";
import loanCard from "../../assets/Loan-Card.png"


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
                
            <Card.Img style={{width: "clamp(100px, 80%, 200px)",  margin: "0 auto"}} variant="top" src={employee} />  
            <Card.Body>
                <Card.Title>Employee Data </Card.Title>
                
                <Card.Link href="/addEmployee"><AiOutlineFileAdd/>Add</Card.Link>
                <Card.Link href="/viewAllEmployees"><AiOutlineEye/>View</Card.Link>
            </Card.Body>
            </Card>
            </Col>
            <Col lg="4" md="4" sm="6" xs="12" >
            <Card className="bgCard bg2 ">
            <Card.Img variant="top" style={{width: "clamp(100px, 80%, 200px)", margin: "0 auto"}} src={item} />  

            <Card.Body>
                <Card.Title>Items Data</Card.Title>
                
                <Card.Link href="/addItem"><AiOutlineFileAdd/>Add</Card.Link>
                <Card.Link href="/viewAllItems"><AiOutlineEye/>View</Card.Link>
            </Card.Body>
            </Card>
            </Col>
            <Col lg="4" md="4" sm="6" xs="12">
            <Card className="bgCard bg3">
            <Card.Img variant="top" style={{width: "clamp(100px, 80%, 200px)", margin: "0 auto"}} src={loanCard} />  

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