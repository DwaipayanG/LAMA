import { useEffect, useState } from "react";
import axios from "axios";
import Card from 'react-bootstrap/Card';
import Header from "./Header";
import "../style/Card.css"

export default function AdminDashboard(){

    const [user,setUser]=useState(null);
    
    return (
        <div>
            <Header></Header>
        
            <p className="welcomeText"> Welcome <b>{sessionStorage.getItem("adminUsername")}</b> </p>
            <div style={{width:"70%",margin:"auto"}} className="d-flex justify-content-center m-2">
        
            <Card className="bgCard bg1 col-sm-6 col-lg-3">

            <Card.Body>
                <Card.Title>Customer Data Management</Card.Title>
                {/* <Card.Text>
                Some quick example text to build on the card title and make up the
                bulk of the card's content.
                </Card.Text>
                <Card.Link href="/addEmployee">Add</Card.Link>
                <Card.Link href="/viewAllEmployees">Edit</Card.Link>
            </Card.Body>
            </Card>
           <Card className="bgCard bg2 col-sm-6 col-lg-3">

            <Card.Body>
                <Card.Title>Loan Card Management</Card.Title>
                {/* <Card.Text>
                Some quick example text to build on the card title and make up the
                bulk of the card's content.
                </Card.Text> */}
                <Card.Link href="/addEmployee">Add</Card.Link>
                <Card.Link href="/viewAllEmployees">Edit</Card.Link>
            </Card.Body>
            </Card>
            <Card className="bgCard bg3 col-sm-6 col-lg-3">

            <Card.Body>
                <Card.Title>Items Master Data</Card.Title>
                {/* <Card.Text>
                Some quick example text to build on the card title and make up the
                bulk of the card's content.
                </Card.Text>
                <Card.Link href="/addItem">Add</Card.Link>
                <Card.Link href="/viewAllItems">Edit</Card.Link>
            </Card.Body>
            </Card>
            <Card className="bgCard bg4 col-sm-6 col-lg-3">
            <Card.Body>
                <Card.Title>All items</Card.Title>
                {/* <Card.Text>
                Some quick example text to build on the card title and make up the
                bulk of the card's content.
                </Card.Text> */}
                <Card.Link href="/addItem">Add</Card.Link>
                <Card.Link href="/viewAllItems">Edit</Card.Link>
            </Card.Body>
            </Card>
            <Card style={{ width: '10rem' }}>
            <Card.Body>
                <Card.Title>Loan Card Data</Card.Title>
                {/* <Card.Text>
                Some quick example text to build on the card title and make up the
                bulk of the card's content.
                </Card.Text>
                <Card.Link href="/addItem">Add</Card.Link>
                <Card.Link href="/viewAllItems">Edit</Card.Link>
            </Card.Body>
            </Card>
            <Card style={{ width: '10rem' }}>
            <Card.Body>
                <Card.Title>All items</Card.Title>
                {/* <Card.Text>
                Some quick example text to build on the card title and make up the
                bulk of the card's content.
                </Card.Text> */}
                <Card.Link href="/addLoanCard">Add</Card.Link>
                <Card.Link href="/viewAllLoanCards">Edit</Card.Link>
            </Card.Body>
            </Card>
        </div>
        </div>
    );
}