import { useEffect, useState } from "react";
import Card from 'react-bootstrap/Card';
import Header from "../../components/Header";
import {Row,Col} from 'react-bootstrap';
import "../../style/Card.css"
import EmployeeNavigation from "../../components/EmployeeNavaigation";
import axios from "axios";
import loan from "../../assets/loan.png";
import showLoan from"../../assets/showLoan.png";
import purchasedItem from"../../assets/pruchasedItem.png";


export default function EmployeeDasboard(){


    const [user,setUser]=useState(null);
    const getURL="http://localhost:8080/api/employee/by-employee-id";



    useEffect(() => {
        axios.get(getURL, {params: {"employeeId": sessionStorage.getItem("employeeId")}})
        .then((response) =>{
            setUser(response.data.employeeName);

        })
        .catch((error)=>{
            console.log(error);
        });
    },[]);
    
    

    return (
        <div>
            <Header></Header>
            <EmployeeNavigation/>
                    
        <p className="welcomeText" style={{fontSize: "2em"}}> Welcome <b>{user}</b> </p>

        <Row style={{width:"70%",margin:"auto"}} > 
             
                <div>
                  <div style={{ display: "flex", flexWrap: "wrap" }}>
                    
                      <Col lg="4" md="4" sm="6" xs="12">
                <Card className="bgCard">
           

            
                <Card.Link href="/viewLoans" style ={{textDecoration: "none"}}>  
                <Card.Body>
                <Card.Img variant="top" style={{width: "clamp(100px, 80%, 200px)", margin: "0 auto"}} src={showLoan} />
                <Card.Title >Show Loans</Card.Title>
                </Card.Body>
                </Card.Link>
            </Card>
            </Col>

            
            <Col lg="4" md="4" sm="6" xs="12" >
            <Card className="bgCard">
           

            
                <Card.Link href="/applyLoan" style ={{textDecoration: "none"}}>  
                <Card.Body>
                <Card.Img variant="top" style={{width: "clamp(100px, 80%, 200px)", margin: "0 auto"}} src={loan} />
                <Card.Title >Apply Loan</Card.Title>
                </Card.Body>
                </Card.Link>
            </Card>
            </Col>
            <Col lg="4" md="4" sm="6" xs="12" >
            <Card className="bgCard">
           

            
           <Card.Link href="/viewItems" style ={{textDecoration: "none"}}>  
           <Card.Body>
           <Card.Img variant="top" style={{width: "clamp(100px, 80%, 200px)", margin: "0 auto"}} src={purchasedItem} />
           <Card.Title >Items Purchased</Card.Title>
           </Card.Body>
           </Card.Link>
       </Card>
            </Col>
            </div>
            </div>
            </Row>
        
        </div>
    );
}