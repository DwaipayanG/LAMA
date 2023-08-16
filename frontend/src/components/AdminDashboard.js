import { useEffect, useState } from "react";
import axios from "axios";
import Card from 'react-bootstrap/Card';
import Header from "./Header";

export default function AdminDashboard(){

    const [user,setUser]=useState(null);
    
    return (
        <div>
            <Header></Header>
        
        <div style={{width:"70%",margin:"auto"}} className="d-flex justify-content-center my-2">
            Welcome <b>{sessionStorage.getItem("adminUsername")}</b>
            <br/>
            <Card style={{ width: '18rem' }}>
            <Card.Body>
                <Card.Title>Customer Data Management</Card.Title>
                <Card.Text>
                Some quick example text to build on the card title and make up the
                bulk of the card's content.
                </Card.Text>
                <Card.Link href="/addEmployee">Add employee</Card.Link>
            </Card.Body>
            </Card>
            <Card style={{ width: '18rem' }}>
            <Card.Body>
                <Card.Title>Loan Card Management</Card.Title>
                <Card.Text>
                Some quick example text to build on the card title and make up the
                bulk of the card's content.
                </Card.Text>
                <Card.Link href="#">Loan cards</Card.Link>
            </Card.Body>
            </Card>
            <Card style={{ width: '18rem' }}>
            <Card.Body>
                <Card.Title>Items Master Data</Card.Title>
                <Card.Text>
                Some quick example text to build on the card title and make up the
                bulk of the card's content.
                </Card.Text>
                <Card.Link href="#">Items master</Card.Link>
            </Card.Body>
            </Card>
        </div>
        </div>
    );
}