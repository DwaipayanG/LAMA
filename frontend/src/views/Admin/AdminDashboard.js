import { useState } from "react";
import Card from 'react-bootstrap/Card';
import {Row,Col} from 'react-bootstrap';
import Header from "../../components/Header";
import AdminNavigation from "../../components/AdminNavigation";
import "../../style/Card.css";
import { AiOutlineFileAdd,AiOutlineEye } from "react-icons/ai";
import  employee from "../../assets/employee.png";
import item from "../../assets/item.png";
import loanCard from "../../assets/Loan-Card.png"


export default function AdminDashboard(){
    
    return (
        <div>
            <Header></Header>
            <AdminNavigation/>
        
            <p className="welcomeText" style={{fontSize: "2em"}}> Welcome <b>{sessionStorage.getItem("adminUsername")}</b> </p>
            <Row style={{width:"70%",margin:"auto"}} > 
             
                <div>
                  <div style={{ display: "flex", flexWrap: "wrap" }}>
                    
                      <Col lg="4" md="4" sm="6" xs="12">
        
            <Card className="bgCard bg1">
                
            <Card.Img style={{width: "clamp(100px, 80%, 200px)",  margin: "0 auto"}} variant="top" src={employee} />  
            <Card.Body>
                <Card.Title>Employee Data </Card.Title>
                
                <Card.Link href="/admin/employees/add"><AiOutlineFileAdd/>Add</Card.Link>
                <Card.Link href="/admin/employees/view"><AiOutlineEye/>View</Card.Link>
            </Card.Body>
            </Card>
            </Col>
            <Col lg="4" md="4" sm="6" xs="12" >
            <Card className="bgCard bg2 ">
            <Card.Img variant="top" style={{width: "clamp(100px, 80%, 200px)", margin: "0 auto"}} src={item} />  

            <Card.Body>
                <Card.Title>Items Data</Card.Title>
                
                <Card.Link href="/admin/items/add"><AiOutlineFileAdd/>Add</Card.Link>
                <Card.Link href="/admin/items/view"><AiOutlineEye/>View</Card.Link>
            </Card.Body>
            </Card>
            </Col>
            <Col lg="4" md="4" sm="6" xs="12">
            <Card className="bgCard bg3">
            <Card.Img variant="top" style={{width: "clamp(100px, 80%, 200px)", margin: "0 auto"}} src={loanCard} />  

            <Card.Body>
                <Card.Title>Loan Card Data</Card.Title>
               
                <Card.Link href="/admin/loan-cards/add"><AiOutlineFileAdd/>Add</Card.Link>
                <Card.Link href="/admin/loan-cards/view"><AiOutlineEye/>View</Card.Link>
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